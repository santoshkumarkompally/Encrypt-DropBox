package test;

import java.io.File;

import decryption.DecryptFile;
import encryption.EncrptFile;

public class Test {

	
	public static void main(String[] args) throws Exception {
		
		
		EncrptFile e=new EncrptFile("aaaaaaaabbbbbbbb",128,"AES","AES");
		DecryptFile d=new DecryptFile("aaaaaaaabbbbbbbb",128,"AES","AES");
		File inputFile = new File("/Users/santoshkompally/Desktop/Santosh_Resume.docx");
        File encryptedFile = new File("/Users/santoshkompally/Desktop/test.txt");
        File decFile=new File("/Users/santoshkompally/Desktop/test_dec.docx");
        e.Encrypt(inputFile, encryptedFile);
		d.Decrypt(encryptedFile, decFile);
	}
	
}
 