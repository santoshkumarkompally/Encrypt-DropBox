package decryption;

import java.io.File;

import javax.crypto.Cipher;

import utility.Utils;

public class DecryptFile {

	static final int mode=Cipher.DECRYPT_MODE;
	byte[] key;
	int numberOfBits;
	String algorithm;
	String transformation;
	
	public DecryptFile(byte[] key, int numberOfBits, String algorithm,String transformation) {
		super();
		this.key = key;
		this.numberOfBits = numberOfBits;
		this.algorithm = algorithm;
		this.transformation=transformation;
	}

	
	public void Decrypt(File inputFile,File outputFile) throws Exception{
		
		Utils newObj = new Utils();
		newObj.encryptFile(transformation,mode, inputFile, outputFile, key);
	}
	
	
	
	
	
	
}
