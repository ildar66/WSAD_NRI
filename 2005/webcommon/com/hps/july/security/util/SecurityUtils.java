package com.hps.july.security.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.hps.july.security.util.passwd.RandomPassword;

/**
 * @author dkrivenko
 * 22.03.06
 */
public class SecurityUtils {

	protected static int DEFAULT_GENERATED_PASSWORD_SIZE = 8;

	/**
	 * Подпись строки алгоритмом md5 
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encryptToMD5(String text) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
	    
			algorithm.update(text.getBytes());
	    	byte messageDigest[] = algorithm.digest();
	    
        	StringBuffer hexString = new StringBuffer();
		    for (int i=0;i<messageDigest.length;i++) {
		    	String hex = Integer.toHexString(0xFF & messageDigest[i]);
		    	if (hex.length() == 1) hexString.append('0');
		    	hexString.append(hex);
		    }
	 
		    return hexString.toString();
		} catch (NoSuchAlgorithmException e){
			throw new RuntimeException("Exception while encrypt to md5: " + e.getMessage());
		}
	}
	
	public static String generatePassword(){
		return generatePassword(DEFAULT_GENERATED_PASSWORD_SIZE);
	}
	
	public static String generatePassword(int passwordLength){
		RandomPassword pass = new RandomPassword();
		return pass.getPass(passwordLength);
	}
	
}
