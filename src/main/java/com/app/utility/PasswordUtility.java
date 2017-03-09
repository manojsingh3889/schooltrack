package com.app.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public class PasswordUtility {
	public static String generateMD5(String passwordToHash){
		String generatedPassword = null;
		try {// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(passwordToHash.getBytes());
			//Get the hash's bytes
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return generatedPassword;
		}

	public static String generatePasswordSalt() {
		// TODO Auto-generated method stub
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
	    byte seed[] = random.generateSeed(20);
	    String z="";
	    for(byte ab :seed){
			z = z+ab;
		}
	    
		String x = String.valueOf(System.nanoTime());
		String y = UUID.randomUUID().toString();
		System.out.println(x+" "+y+" "+z);
		String result = generateMD5(x+y+z);
		return result;
	}
	
	
	public static void main(String[] args) {
		generatePasswordSalt();
	}
	
	}
