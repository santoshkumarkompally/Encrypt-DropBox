package test;

import java.io.File;

import decryption.DecryptFile;
import encryption.EncrptFile;


public class Test {

	
	public static void main(String[] args) throws Exception {
		
		
		EncrptFile e=new EncrptFile(128,"AES","AES","username","password");
	//	DecryptFile d= new DecryptFile(128,"AES","AES","username","password");
		
		//key is encrypted here using the master key which is generated in the same function.
		File inputFile = new File("/Users/santoshkompally/Desktop/7001462-google-wallpaper.jpg");
        File encryptedFile = new File("/Users/santoshkompally/Desktop/test.jpg");
        File decFile=new File("/Users/santoshkompally/Desktop/test_dec2.jpg");
             
        e.Encrypt(inputFile, encryptedFile);
     //     d.Decrypt(encryptedFile, decFile);
		
		
	}
	
}
 