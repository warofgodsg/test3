package com.example.demo.common;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import org.apache.commons.codec.binary.Base64;

import java.util.ResourceBundle;
 
public class AesClass {
// 
//	 private static volatile AesClass INSTANCE;
//	 
//	 public static AesClass getInstance(){
//	     if(INSTANCE==null){
//	         synchronized(AesClass.class){
//	             if(INSTANCE==null)
//	                 INSTANCE=new AesClass();
//	         }
//	     }
//	     return INSTANCE;
//	 }
//	 
//	 private AesClass(){
//	     
//	 }
// 
//	 //암호화
//	 public static String AES_Encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
//		 String enStr = "";
//		 if(!Utility.isNull(str)) {
//			 ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//			 String secretKey = resource.getString("LIMS.AES.KEY");
//			 String IV = resource.getString("LIMS.AES.IV");
//			 
//			 byte[] keyData = secretKey.getBytes();
//		 
//			 SecretKey secureKey = new SecretKeySpec(keyData, "AES");
//		 
//			 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//			 c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
//		 
//			 byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
//			 enStr = new String(Base64.encodeBase64(encrypted));
//		 }
//		 return enStr;
//	 }
// 
//	 //복호화
//	 public static String AES_Decode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
//		 ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//		 String secretKey = resource.getString("LIMS.AES.KEY");
//		 String IV = resource.getString("LIMS.AES.IV");
//		 
//		 byte[] keyData = secretKey.getBytes();
//		 SecretKey secureKey = new SecretKeySpec(keyData, "AES");
//		 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		 c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
//	 
//		 byte[] byteStr = Base64.decodeBase64(str.getBytes());
//	 
//		 return new String(c.doFinal(byteStr),"UTF-8");
//	 }

}
