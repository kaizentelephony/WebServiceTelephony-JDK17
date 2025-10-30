package com.call.func;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */

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

public class Encryption {
    String retResult = "";
    public String file_Encryption(String sourceFile,String destinationFile)
            {
            
	try {
				String keyString="abfb7c8e58d5c42fce86c92a449a8a25";
				String ivString="2d2fc2d67e2b4768";


				File inputfile = new File(sourceFile);
				
				File outputfile = new File(destinationFile);
				
				byte[] tdesKeyData = keyString.getBytes();
				Cipher c3des = Cipher.getInstance("AES/CBC/PKCS5Padding");
				SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
				IvParameterSpec ivspec = new IvParameterSpec(ivString.getBytes());
				c3des.init(Cipher.ENCRYPT_MODE, myKey, ivspec);
				
				FileInputStream inputStream = new FileInputStream(inputfile);
				FileOutputStream outputStream = new FileOutputStream(outputfile);
                                
				byte[] buffer = new byte[64];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					byte[] output = c3des.update(buffer, 0, bytesRead);
				if (output != null) {
					outputStream.write(output);
                           retResult = "OK";
					}
			}
			byte[] outputBytes = c3des.doFinal();
			if (outputBytes != null) {
				outputStream.write(outputBytes);
                                retResult = "OK";
			}
				inputStream.close();
				outputStream.close();
			} catch(Exception e) {
				retResult = e.getMessage();
				System.out.println("Error   :   " +e.getMessage());
			}

                     
            
  return retResult;  
            }
    public static void main(String args[])
    {
        Encryption e = new Encryption();
       String  encResult =  e.file_Encryption("D:\\123456.wav","D:\\123456.enc");
       
       
    }
}
