package com.call.func;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class decrypt{
    static String keyString="abfb7c8e58d5c42fce86c92a449a8a25";
    static String ivString="2d2fc2d67e2b4768";
public static void main(String [] args){

	try {
				String keyString="abfb7c8e58d5c42fce86c92a449a8a25";
				String ivString="2d2fc2d67e2b4768";
                                

			//	File inputfile = new File("D:\\VoiceFileSample.enc");
                              File inputfile = new File("D:\\AV\\1750914988141.enc");
				
				File outputfile = new File("D:\\AV\\decrypt123.wav");
				
				byte[] tdesKeyData = keyString.getBytes();
				Cipher c3des = Cipher.getInstance("AES/CBC/PKCS5Padding");
				SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
				IvParameterSpec ivspec = new IvParameterSpec(ivString.getBytes());
				c3des.init(Cipher.DECRYPT_MODE, myKey, ivspec);
				FileInputStream inputStream = new FileInputStream(inputfile);
				FileOutputStream outputStream = new FileOutputStream(outputfile);
				byte[] buffer = new byte[64];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					byte[] output = c3des.update(buffer, 0, bytesRead);
				if (output != null) {
					outputStream.write(output);
					}
			}
			byte[] outputBytes = c3des.doFinal();
			if (outputBytes != null) {
				outputStream.write(outputBytes);
			}
				inputStream.close();
				outputStream.close();
			} catch(Exception e) {                                                                                                       
				System.out.println("Error   :   " +e);
			}
			System.out.println("Successfully decrypted");
			
                decrypt d = new decrypt();
//d.fileDecrypt("", "");

}
public String fileDecrypt(String source, String dest)
{
    String returnResult = "";
    String fileType    =  "";
   
    
    
     fileType = fileExtension(source); 
     System.out.println("File type"+fileType);
     if(fileType.equals("enc"))
                {
                    try 
                            {
                               System.out.println(""+source + "dest" + dest);

				//File inputfile = new File("D:\\VoiceFileSample.enc");
                                File inputfile = new File(source);
                                File outputfile = new File(dest);
				
				//File outputfile = new File("D:\\decrypt.wav");
				
				byte[] tdesKeyData = keyString.getBytes();
				Cipher c3des = Cipher.getInstance("AES/CBC/PKCS5Padding");
				SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
				IvParameterSpec ivspec = new IvParameterSpec(ivString.getBytes());
				c3des.init(Cipher.DECRYPT_MODE, myKey, ivspec);
				FileInputStream inputStream = new FileInputStream(inputfile);
				FileOutputStream outputStream = new FileOutputStream(outputfile);
				byte[] buffer = new byte[64];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					byte[] output = c3des.update(buffer, 0, bytesRead);
				if (output != null) {
					outputStream.write(output);
					}
			}
			byte[] outputBytes = c3des.doFinal();
			if (outputBytes != null) {
                            
				outputStream.write(outputBytes);
                               returnResult = "OK";
			}
				inputStream.close();
				outputStream.close();
			} catch(Exception e) {                                                                                                       
				System.out.println("Error   :   " +e);
                                returnResult = e.getMessage();
			}
			System.out.println("Successfully decrypted");
                }
     else
     {
       System.out.println(fileType);
        returnResult = "INVALID FILE FORMAT";
     
     }

System.out.println(returnResult);
  return returnResult;
}
public String fileExtension(String filetype)
{
    String returnresult = "";
    
    File f = new File(filetype); 
  
        // If file exists 
        if (f.exists()) { 
            String fileType = "Undetermined"; 
            String fileName = f.getName(); 
            String extension = ""; 
            int i = fileName.lastIndexOf('.'); 
  
            if (i > 0) { 
                extension = fileName.substring(i + 1); 
            } 
            try { 
                fileType 
                    = Files.probeContentType(f.toPath()); 
            } 
            catch (IOException ioException) { 
                System.out.println( 
                    "Cannot determine file type of "
                    + f.getName() 
                    + " due to following exception: "
                    + ioException); 
                 returnresult = "Cannot determine file type!"+ioException;
            } 
  
            // Print Extension 
            System.out.println( 
                "Extension used for file is -> " + extension 
                + " and is probably " + fileType); 
            returnresult = extension;
        } 
        else { 
               returnresult = "File does not exist!";
            System.out.println("File does not exist!"); 
        } 
    
  return returnresult;
}
 public static String textDecrypt_HexStr(String content) {
        return new String(decrypt(
                parseHexStr2Byte(content)));
    }//from   w w w  . j ava2s  .c om
    
    public static byte[] decrypt(byte[] content) {
        try {
           /* KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES"); */
            byte[] tdesKeyData = keyString.getBytes("UTF-8");
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
			IvParameterSpec ivspec = new IvParameterSpec(ivString.getBytes());
           // Cipher cipher = Cipher.getInstance("AES"); 
            aesCipher.init(Cipher.DECRYPT_MODE, myKey, ivspec);
            byte[] result = aesCipher.doFinal(content);
            return result; //   
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1),
                    16);
            int low = Integer.parseInt(
                    hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
    public String textEncrypt(String result)
    {
         String encryptedText = "";
        try {
                       
			String keyString = "abfb7c8e58d5c42fce86c92a449a8a25";
			String ivString = "2d2fc2d67e2b4768";

			// String uploadPath =
			// "D:\\Dev\\Projects\\KVB-MB\\NewRequests\\Voice-BioMetric\\Encryption\\2222208349418112210333258865987000347.enc";
			// String uploadPath1 =
			// "D:\\Dev\\Projects\\KVB-MB\\NewRequests\\Voice-BioMetric\\Encryption\\2222208349418112210333258865987000347.wav";

//			File outputfile = new File(uploadPath);
//			File inputfile = new File(uploadPath1);
			
			//String customerIdPlainText = result;
			//String customerIdPlainText1 = "61A18B3ECC5EEE82B7B9EB845A8C9AC4";
                                                       //61A18B3ECC5EEE82B7B9EB845A8C9AC4
			byte[] tdesKeyData = keyString.getBytes("UTF-8");
			Cipher c3des = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
			IvParameterSpec ivspec = new IvParameterSpec(ivString.getBytes());
			c3des.init(Cipher.ENCRYPT_MODE, myKey, ivspec);
			byte[] cipherText = c3des.doFinal(result.getBytes("UTF8"));
                       encryptedText = DatatypeConverter.printHexBinary(cipherText);
			System.out.println("PlainText CustomerId : " + result);
			System.out.println("Encrypted CustomerId : " + encryptedText);
                        
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
        
        return encryptedText;
    }
}