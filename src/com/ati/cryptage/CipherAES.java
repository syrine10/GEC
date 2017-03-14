package com.ati.cryptage;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
/**
 * @author syrine tajouri
 *
 */
public class CipherAES {

	 static String IV = "AAAAAAAAAAAAAAAA";
	 public static String encryptionKey = "0123456789abcdef";
	  public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return cipher.doFinal(plainText.getBytes("UTF-8"));
	  }

	  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return new String(cipher.doFinal(cipherText),"UTF-8");
	  }
	 /*public static void main (String args[]){
		  try{
		  UserDAO u= new UserDAO();
		  User us=u.selectAll().get(0);
		  String t="test";
		  //String decrypted = TestCipherDESede.decrypt(us.getPwd().getBytes(), TestCipherDESede.encryptionKey);
		  System.out.println(" pour crypter : "+t+" : "+new String(CipherAES.encrypt(t, CipherAES.encryptionKey))+" dans "
		  		+ "la base : "+us.getPwd()+" , decrypter : "+CipherAES.decrypt(us.getPwd().getBytes(),CipherAES.encryptionKey ));
	      //System.out.println("decrypt: " + decrypted);
		  if(new String(CipherAES.encrypt(t, CipherAES.encryptionKey)).equals(us.getPwd())){
			  System.out.println("ouiiiiiiiiiiii");
		  }
		  }
		  catch(Exception e){
			  e.getStackTrace();
		  }

	  }*/
	  
	  public static String crypt(String pwd){
			try{
				
			
			byte[] cipher = CipherAES.encrypt(pwd,
					CipherAES.encryptionKey);
			// affichage pour le test
			System.out.print("cipher:  ");
			for (int i = 0; i < cipher.length; i++)
				System.out.print(new Integer(cipher[i]) + " ");
			System.out.println("");
			// tester la methode decrypt
			String decrypted = CipherAES.decrypt(cipher,
					CipherAES.encryptionKey);
			// affichage pour le test
			System.out.println("decrypt: " + decrypted);
			return new String(cipher);
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			
		}
	
}
