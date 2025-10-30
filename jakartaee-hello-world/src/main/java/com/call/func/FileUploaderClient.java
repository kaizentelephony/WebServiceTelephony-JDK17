package com.call.func;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KSV
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.eclipse.jakarta.hello.HelloWorldResource;



//import org.apache.commons.logging.Log;
//mport org.apache.commons.logging.LogFactory;
/**
 * This example shows how to upload files using POST requests 
 * with encoding type "multipart/form-data".
 * For more details please read the full tutorial
 * on https://javatutorial.net/java-file-upload-rest-service
 * @author javatutorial.net
 */
public class FileUploaderClient {
	String responseString ="";
	private static final Log logger = LogFactory.getLog(FileUploaderClient.class);
	public String sendHttp(String id, String filePath) {
		// the file we want to upload
				File inFile = new File(filePath);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(inFile);
					DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
				//	logger.debug("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz"+"Form Data "+filePath);
					
					//BENZ
				//	System.out.println("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz"+ "Form Data "+filePath);
					
					//NASSIT
					System.out.println("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/enrollment/954312/Test Form Data "+filePath);
												// server back-end URL
				//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
//		          HttpPost httppost = new  HttpPost("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz");         
					
					// BENZ
				//	HttpPost httppost = new  HttpPost("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz");
					 
					//NASSIT
					 HttpPost httppost = new  HttpPost("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/enrollment/"+id+"/NASSIT"); 
				//	http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/enrollment/954312/Test
					//  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
		                      MultipartEntity entity = new MultipartEntity();

					// set the file input stream and file name as arguments
					entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
					//entity.addPart("name", new InputStreamBody(fis,"heloo"));
					httppost.setEntity(entity);

					// execute the request
					HttpResponse response = httpclient.execute(httppost);
					
					int statusCode = response.getStatusLine().getStatusCode();
					HttpEntity responseEntity = response.getEntity();
					 responseString = EntityUtils.toString(responseEntity, "UTF-8");
					logger.debug("Status Code"+statusCode + "Response"+responseString);
					System.out.println("[" + statusCode + "] " + responseString);
					
				} catch (ClientProtocolException e) {
					System.err.println("Unable to make connection");
				//	logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					e.printStackTrace();
				} catch (IOException e) {
				//	logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					System.err.println("Unable to read file");
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (IOException e) {}
				}
			return responseString;
	}

	public String sendHttpver(String id, String filePath) {
		// the file we want to upload
				File inFile = new File(filePath);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(inFile);
					DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
				//	logger.debug("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz" + "Form Data "+filePath);
					// server back-end URL
				//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
			  //     Benz
				//	System.out.println("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/verification/\"+id+\"/benz  Form Data" +filePath);
					
					System.out.println("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/verification/"+id+"/Nassit  Form Data" +filePath);
			// http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/verification/954312/Test
		  //     HttpPost httppost = new  HttpPost("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");         
		        //BENZ
		//       HttpPost httppost = new  HttpPost("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");            
		     
		         //Nassit
		         
		         HttpPost httppost = new  HttpPost("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/verification/"+id+"/Nassit");
		         //  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
		                      MultipartEntity entity = new MultipartEntity();

					// set the file input stream and file name as arguments
					entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
					//entity.addPart("name", new InputStreamBody(fis,"heloo"));
					httppost.setEntity(entity);

					// execute the request
					HttpResponse response = httpclient.execute(httppost);
					
					int statusCode = response.getStatusLine().getStatusCode();
					HttpEntity responseEntity = response.getEntity();
					 responseString = EntityUtils.toString(responseEntity, "UTF-8");
					logger.debug("Status Code"+statusCode + "Response"+responseString);
					System.out.println("[" + statusCode + "] " + responseString);
					
				} catch (ClientProtocolException e) {
					System.err.println("Unable to make connection");
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					e.printStackTrace();
				} catch (IOException e) {
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					System.err.println("Unable to read file");
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (IOException e) {}
				}
			return responseString;
	}

	
	public String sendHttpver1(String id, String filePath) {
		// the file we want to upload
				File inFile = new File(filePath);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(inFile);
					DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
				//	logger.debug("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz" + "Form Data "+filePath);
					// server back-end URL
				//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
		         System.out.println("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"benz  Form Data" +filePath);
					HttpPost httppost = new  HttpPost("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");         
		                    //  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
		       //               MultipartEntity entity = new MultipartEntity();

					// set the file input stream and file name as arguments
			//		entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
					//entity.addPart("name", new InputStreamBody(fis,"heloo"));
		//			httppost.setEntity(entity);

					// execute the request
					HttpResponse response = httpclient.execute(httppost);
					
					int statusCode = response.getStatusLine().getStatusCode();
					HttpEntity responseEntity = response.getEntity();
					 responseString = EntityUtils.toString(responseEntity, "UTF-8");
					logger.debug("Status Code"+statusCode + "Response"+responseString);
					System.out.println("[" + statusCode + "] " + responseString);
					
				} catch (ClientProtocolException e) {
					System.err.println("Unable to make connection");
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					e.printStackTrace();
				} catch (IOException e) {
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					System.err.println("Unable to read file");
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (IOException e) {}
				}
			return responseString;
	}

	public String sendHttpDigit(String id, String filePath) {
		// the file we want to upload
				File inFile = new File(filePath);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(inFile);
					DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
				//	logger.debug("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz" + "Form Data "+filePath);
					// server back-end URL
				//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
		         System.out.println("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/analytics/526852/DIGIT  Form Data" +filePath);
		
		  //     HttpPost httppost = new  HttpPost("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");         
		// Benz         
		     //    HttpPost httppost = new  HttpPost("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");
		         //Nassit Internal
      HttpPost httppost = new  HttpPost("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/analytics/"+id+"/DIGIT");
		         //  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
		                      MultipartEntity entity = new MultipartEntity();

					// set the file input stream and file name as arguments
					entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
					//entity.addPart("name", new InputStreamBody(fis,"heloo"));
					httppost.setEntity(entity);

					// execute the request
					HttpResponse response = httpclient.execute(httppost);
					
					int statusCode = response.getStatusLine().getStatusCode();
					HttpEntity responseEntity = response.getEntity();
					 responseString = EntityUtils.toString(responseEntity, "UTF-8");
					logger.debug("Status Code"+statusCode + "Response"+responseString);
					System.out.println("[" + statusCode + "] " + responseString);
					
				} catch (ClientProtocolException e) {
					System.err.println("Unable to make connection");
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					e.printStackTrace();
				} catch (IOException e) {
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					System.err.println("Unable to read file");
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (IOException e) {}
				}
			return responseString;
	}


	public String sendHttpValidation(String id, String filePath) {
		// the file we want to upload
				File inFile = new File(filePath);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(inFile);
					DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
				//	logger.debug("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/enrollment/"+id+"/benz" + "Form Data "+filePath);
					// server back-end URL
				//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
		         System.out.println("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/shortverification/"+id+"/Nassit  Form Data" +filePath);
		
		  //     HttpPost httppost = new  HttpPost("http://127.0.0.1:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");         
		// Benz         
		     //    HttpPost httppost = new  HttpPost("http://53.137.131.69:8080/ksvvoiceservicenew/rest/service/api/verification/"+id+"/benz");
		         //Nassit Internal
      HttpPost httppost = new  HttpPost("http://216.48.180.183:8080/ksvvoiceservice/rest/service/api/shortverification/"+id+"/Nassit");
		         //  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
		                      MultipartEntity entity = new MultipartEntity();

					// set the file input stream and file name as arguments
					entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
					//entity.addPart("name", new InputStreamBody(fis,"heloo"));
					httppost.setEntity(entity);

					// execute the request
					HttpResponse response = httpclient.execute(httppost);
					
					int statusCode = response.getStatusLine().getStatusCode();
					HttpEntity responseEntity = response.getEntity();
					 responseString = EntityUtils.toString(responseEntity, "UTF-8");
					logger.debug("Status Code"+statusCode + "Response"+responseString);
					System.out.println("[" + statusCode + "] " + responseString);
					
				} catch (ClientProtocolException e) {
					System.err.println("Unable to make connection");
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					e.printStackTrace();
				} catch (IOException e) {
					logger.debug("Status Code"+e.getMessage() + "Response"+responseString);
					System.err.println("Unable to read file");
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) fis.close();
					} catch (IOException e) {}
				}
			return responseString;
	}


	
	
	
	
	public static void main(String[] args) {
	
		// the file we want to upload
		File inFile = new File("D:/temp1/7897720875.wav");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inFile);
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
			
			// server back-end URL
		//HttpPost httppost = new HttpPost("http://localhost:8080/app/rest/api/simple");
          HttpPost httppost = new  HttpPost("http://localhost:8080/app/rest/api/v2/enrollment/44444");         
                    //  HttpPost httppost = new HttpPost("http://54.226.185.18:8080/ksvvoiceservice/rest/service/genderidentity/12345/GEN");
                      MultipartEntity entity = new MultipartEntity();

			// set the file input stream and file name as arguments
			entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			//entity.addPart("name", new InputStreamBody(fis,"heloo"));
			httppost.setEntity(entity);

			// execute the request
			HttpResponse response = httpclient.execute(httppost);
			
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
			
			System.out.println("[" + statusCode + "] " + responseString);
			
		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {}
		}
	}
	
}
