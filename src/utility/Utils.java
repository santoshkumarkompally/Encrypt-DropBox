package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Utils {

	// This is the method for encrypting the file.
	public void encryptFile(String transformation,int cipherMode,File inputFile,File outputFile,byte[] key) throws Exception{
		
		try {
		Key secretKey = new SecretKeySpec(key, transformation);
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(cipherMode, secretKey);
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
         
        byte[] outputBytes = cipher.doFinal(inputBytes);
 
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
         
        
        inputStream.close();
        outputStream.close();
        
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	
	public byte[] generateKey(int length){
		
		SecureRandom random;
		byte bytes[]=null;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			bytes = new byte[length];
			byte[] seed = random.generateSeed(length);
			random.setSeed(seed);
		    random.nextBytes(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return bytes;   
	}
	
}
