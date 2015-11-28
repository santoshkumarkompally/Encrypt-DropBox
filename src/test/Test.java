package test;

import java.io.File;

import decryption.DecryptFile;
import encryption.EncrptFile;


public class Test {

	
	public static void main(String[] args) throws Exception {
		
		
		EncrptFile e=new EncrptFile(128,"AES","AES","username","password");
		//DecryptFile d= new DecryptFile(128,"AES","AES","username","password");
		
		//key is encrypted here using the master key which is generated in the same function.
		File inputFile = new File("/Users/snigdha/Desktop/dataproj/test.txt");
       //File encryptedFile = new File("/Users/snigdha/Desktop/dataproj/test.txt");
		File encryptedFile = new File("C:/Users/snigdha/Desktop/New folder/Encrypt-DropBox-latest/temp/lecture2.txt");
		//File decFile=new File("/Users/snigdha/Desktop/dataproj/test_dec_2.docx");
             
       e.Encrypt(inputFile, encryptedFile);
          //d.Decrypt(encryptedFile, decFile);
		
		
	}
	
}
 