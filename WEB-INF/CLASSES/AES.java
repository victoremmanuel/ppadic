package com;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
public class AES{
public static byte[] generateKey()throws Exception{
	KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	keyGen.init(128);
	SecretKey key = keyGen.generateKey();
	byte keys[] = key.getEncoded();
	return keys;
}
public static byte[] encrypt(byte[] unencrypted,byte keys[]){
	byte[] ciphertext = null;
	try{
		SecretKey key = new SecretKeySpec(keys,0,keys.length,"AES");
		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.ENCRYPT_MODE, key);
		ciphertext = aes.doFinal(unencrypted);
	}catch(Exception e){
		e.printStackTrace();
	}
	return ciphertext;
}
public static byte[] decrypt(byte[] encrypted,byte keys[]){
	byte[] decrypt = null;
	try{
		SecretKey key = new SecretKeySpec(keys,0,keys.length,"AES");
		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.DECRYPT_MODE, key);
		decrypt = aes.doFinal(encrypted);
	}catch(Exception e){
		e.printStackTrace();  
	}
	return decrypt;  
}  
}
 