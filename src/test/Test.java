package test;

import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import decryption.DecryptFile;
import encryption.EncrptFile;
import utility.Utils;

public class Test {

	
	public static void main(String[] args) throws Exception {
		
		Utils u=new Utils();
		byte[] b= new byte[20];
		b=u.generateKey(16); // key for encrypting the file.
		EncrptFile e=new EncrptFile(b,128,"AES","AES");
		System.out.println("Generated file enc key" + Arrays.toString(b));
		// generating some random master key this should be generated from the user password.
		SecureRandom s=SecureRandom.getInstance("SHA1PRNG");
		byte[] seed=s.generateSeed(16);
		byte[] key_master = new byte[16];
		s.setSeed(seed);
		s.nextBytes(key_master);// example key for encrypting the file encryption key.
		System.out.println("Generation of master key sample done" + Arrays.toString(key_master));

		//key is encrypted here using the master key.
		byte[] encryptedKey=u.keyEncryptAndDecrypt(b, 0,key_master);
		System.out.println("key encryption done" + Arrays.toString(encryptedKey) );
		// key is decrypted here using the master key.
		File inputFile = new File("/Users/santoshkompally/Desktop/7001462-google-wallpaper.jpg");
        File encryptedFile = new File("/Users/santoshkompally/Desktop/test.jpg");
        File decFile=new File("/Users/santoshkompally/Desktop/test_dec2.jpg");
        e.Encrypt(inputFile, encryptedFile);
		System.out.println("File encryption done using the generated key (b)" + Arrays.toString(b));	
		
		byte[] decryptedKey=u.keyEncryptAndDecrypt(encryptedKey, 1,key_master);
		System.out.println("key decyption done using the decrypted file key" + Arrays.toString(decryptedKey));
		
		// this value should be equal to b. In that case only file will be decrypted.
		DecryptFile d=new DecryptFile(decryptedKey,128,"AES","AES");
		d.Decrypt(encryptedFile, decFile);
		System.out.println("File Decrytion done using the decrypted key.");
		
	}
	
}
 