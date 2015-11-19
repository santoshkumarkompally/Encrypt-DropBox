package encryption;

import java.io.File;

import javax.crypto.Cipher;

import utility.Utils;


public class EncrptFile {

	static final int mode=Cipher.ENCRYPT_MODE;
	String key;
	int numberOfBits;
	String algorithm;
	String transformation;
	
	public EncrptFile(String key, int numberOfBits, String algorithm,String transformation) {
		super();
		this.key = key;
		this.numberOfBits = numberOfBits;
		this.algorithm = algorithm;
		this.transformation=transformation;
	}

	
	public void Encrypt(File inputFile,File outputFile) throws Exception{
		
		Utils newObj = new Utils();
		newObj.encryptFile(transformation,mode, inputFile, outputFile, key);
	}
	
	
	
	
	
}
