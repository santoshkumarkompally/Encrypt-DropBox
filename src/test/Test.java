package test;

import java.io.File;
import java.util.Arrays;


import decryption.DecryptFile;
import encryption.EncrptFile;
import utility.Utils;

public class Test {

	
	public static void main(String[] args) throws Exception {
		
		Utils u=new Utils();
		byte[] fileKey= new byte[20];
		byte[]hashKey=new byte[20];
		fileKey=u.generateKey(16); // key for encrypting the file.
		hashKey=u.generateKey(16);
		
		System.out.println("Hash key generated is:" + new String(hashKey));
		
		EncrptFile e=new EncrptFile(fileKey,128,"AES","AES");
		System.out.println("Generated file enc key" + Arrays.toString(fileKey));
		
		//key is encrypted here using the master key which is generated in the same function.
		byte[] encryptedKey=u.generateMasterKey_EncryptAndDecrypt("santosh", 0, fileKey);
		byte[] encryptedHash=u.generateMasterKey_EncryptAndDecrypt("santosh", 0, hashKey);
		System.out.println("Enc hash key is:" + encryptedHash);
		System.out.println("key encryption done" + Arrays.toString(encryptedKey) );
		// key is decrypted here using the master key.
		File inputFile = new File("/Users/santoshkompally/Desktop/7001462-google-wallpaper.jpg");
        File encryptedFile = new File("/Users/santoshkompally/Desktop/test.jpg");
        File decFile=new File("/Users/santoshkompally/Desktop/test_dec2.jpg");
        // generating hash of the input file.
        System.out.println("hash before encryption" + u.generateHash(inputFile, hashKey));        
        e.Encrypt(inputFile, encryptedFile);
		System.out.println("File encryption done using the generated key (b)" + Arrays.toString(fileKey));	
		byte[] decryptedKey=u.generateMasterKey_EncryptAndDecrypt("santosh", 1,encryptedKey);
		System.out.println("key decyption done using the decrypted file key" + Arrays.toString(decryptedKey));
		
		// this value should be equal to b. In that case only file will be decrypted.
		DecryptFile d=new DecryptFile(decryptedKey,128,"AES","AES");
		d.Decrypt(encryptedFile, decFile);
		byte[] decryptedHash=u.generateMasterKey_EncryptAndDecrypt("santosh", 1, encryptedHash);
		System.out.println("Enc hash key is:" + decryptedHash);
		System.out.println("File Decrytion done using the decrypted key.");
		System.out.println("hash after decryption" + u.generateHash(decFile, decryptedHash)); 
		
	}
	
}
 