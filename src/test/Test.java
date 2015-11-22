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
		b=u.generateKey(16);
		EncrptFile e=new EncrptFile(b,128,"AES","AES");
		DecryptFile d=new DecryptFile(b,128,"AES","AES");
		File inputFile = new File("/Users/santoshkompally/Desktop/7001462-google-wallpaper.jpg");
        File encryptedFile = new File("/Users/santoshkompally/Desktop/test.jpg");
        File decFile=new File("/Users/santoshkompally/Desktop/test_dec2.jpg");
        e.Encrypt(inputFile, encryptedFile);
		d.Decrypt(encryptedFile, decFile);
		
		
	}
	
}
 