package org.eclipse.jakarta.hello;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//import java.util.logging.*;
//import java.util.logging.FileHandler;
//import java.util.logging.Formatter;
//import java.util.logging.Level;
//import java.util.logging.LogRecord;

import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.bean.entity.CallRecord;
//import com.bean.entity.Callinfo;
import com.call.db.FetchData;
import com.call.func.CallFunction;
import com.call.func.Encryption;
import com.call.func.FileUploaderClient;
//import com.call.func.HelloManager;
import com.call.func.ManagerInfo;
import com.call.func.ServiceManager;
import com.logging.DirectIO;
//import com.nimbusds.oauth2.sdk.Scope;

//import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.EntityPart;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
@Path("api")
public class HelloWorldResource {
	FetchData f = new FetchData();
	CallFunction cf = new CallFunction();
	Encryption en = new Encryption();
	FileUploaderClient fc = new FileUploaderClient();
	static DirectIO dio = new DirectIO();
	ManagerInfo hm = new ManagerInfo();
	//ServiceManager sm = new ServiceManager();
	ServiceManager s = new ServiceManager();
	static String dirLogPath = "";
	String res = "";
	String result = "";
	//private static final Log logger = LogFactory.getLog(HelloWorldResource.class);
	//ObjectMapper mapper = new ObjectMapper();
    String jsonBody = "{\"message\": \"OK\"}";
  //  public static Logger logger;
    java.nio.file.Path uploadedPath;
 /*   static {
        try {
          boolean append = true;
          try {
        	 // dirLogPath = dio.directoryCreation();
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
          FileHandler fh = new FileHandler("C:/VoizBuzz/Logs/HTTP/HTTP.log", append);
        //  FileHandler fh = new FileHandler("D:/TestLog.log", append);
          
          fh.setFormatter(new Formatter() {
             public String format(LogRecord rec) {
                StringBuffer buf = new StringBuffer(1000);
                buf.append(new java.util.Date());
                buf.append(' ');
                buf.append(rec.getLevel());
                buf.append(' ');
                buf.append(formatMessage(rec));
                buf.append('\n');
                return buf.toString();
                }
              });
          logger = Logger.getLogger("App");
          logger.setLevel(Level.ALL);
          logger.addHandler(fh);
          //logger.info("Started");
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }*/
    @PostConstruct
    public void init() {
		/*
		 * try { uploadedPath = Files.createTempDirectory(Paths.get("E:/SipServer"),
		 * "uploads_"); } catch (IOException e) { throw new RuntimeException(e); }
		 */
    }
 /*
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Hello hello(@QueryParam("name") String name ) {
		if ((name == null) || name.trim().isEmpty())  {
			name = "world";
		}
 
		return new Hello(name);
	}*/
	//@PostMapping("/delete/{id}")
	@Path("/v2/logging/{table}/{operation}")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
    public Response create(@PathParam("table") String table,@PathParam("operation") String opr,CallRecord cr) {
        try
           {
        //	 logger.info("Req : "+table + " Operation -"+opr);
        	System.out.println(cr.getVAR_CALLERID());
        	 if((table.equals("t1")&& opr.equals("callinfo")))
             {
       // 		 logger.info("DATA"+cr.getVAR_CALLERID()+":"+cr.getVAR_CONTRACTNO()+":"+cr.getVAR_CALLED_DATE());
        		 res = f.TBL_CallLogging(cr);
        		 
      //  		 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             else  if((table.equals("t2")&& opr.equals("transferinfo")))
             // var_mob,String var_uniqueId,String var_filePath,String status
             {
             	   System.out.println("t2");
             	  res = f.TBL_TransferLogging(cr);
      //       	 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             else  if((table.equals("t3")&& opr.equals("updateinfo")))
             {
            	 System.out.println("t3");
            	 res =  f.tbl_updateinfo(cr);
    //        	 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             else  if((table.equals("t4")&& opr.equals("enrollinfo")))
             {
            	 System.out.println("t4");
            	 res =  f.TBL_Enrollinfo(cr);
        //    	 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             else  if((table.equals("t5")&& opr.equals("verifyinfo")))
             {
            	 System.out.println("t5");
            	 res =  f.TBL_Verifyinfo(cr);
           // 	 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             
             else  if((table.equals("t6")&& opr.equals("contractinfo")))
             {
            	 System.out.println("t6");
            	 res =  f.hexToTextCov(cr.getVAR_CONTRACTNO());
     //       	 logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             }
             else  if((table.equals("t7")&& opr.equals("calldisinfo")))
             {
            	 System.out.println("t7");
            	 res =  f.TBL_CALLDISCONNECT(cr);
             }
            else if(table.equals("t8") && opr.equals("transferinfo"))
            {
            	res = f.AsciiToHex(cr.getVAR_CONTRACTNO());
            }
             
            return Response.status(200).entity(res).build();
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
	
	 @Path("/v2/enrollment/{id}")
	 @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Co
	    public Response uploadFile(@PathParam("id") String id,@FormParam("file") EntityPart part) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz"), "uploads_");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	            
	        //    logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString());
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	  //          logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	       /*    
	        *   For Enc
	        *  String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	            logger.info("Tempname"+TempName);
	            encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	        */
	            String TempName = part.getFileName().orElse(name);
	            System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	 //           logger.info(encRes+"! Encrypted!");
	            res  = fc.sendHttp(id, uploadedPath.toString()+"\\"+TempName);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	  
	 //////////////////////////// Enrollment Encryption  ///////////////////////////////
	 
	 @Path("/v2/enrollment/en/{id}")
	 @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Co
	    public Response encUploadFile(@PathParam("id") String id,@FormParam("file") EntityPart part) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz/Enrollment"), "uploads_");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	     /*       Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );*/
	            
	        //    logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString());
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	  //          logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	       /*    
	        *   For Enc
	        *
	        *  ?
	        */
	            
	            try 
	            {
	            	Thread.sleep(2000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            
	            String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	        //    logger.info("Tempname"+TempName);
	            try 
	            {
	            	Thread.sleep(1000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	        
	      //      String TempName = part.getFileName().orElse(name);
	      //      System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	 //           logger.info(encRes+"! Encrypted!");
	            res  = fc.sendHttp(id, uploadedPath.toString()+"\\"+TempName);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	
	 
	 
	  //////////////////// Verification ////////////////////////////////////
	    
	    @Path("/v2/verification/{id}")
	    @POST
	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Consumes(MediaType.APPLICATION_JSON)
	    public Response uploadFileVerification(@PathParam("id") String id,@FormParam("file") EntityPart part,@FormParam("conid") String conid,@FormParam("uid") String uid,@FormParam("date") String date,@FormParam("time") String time,@FormParam("filecount") String fileCount,@FormParam("callerid") String Callerid,@FormParam("voiceprint") String voiceprint) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz/Verification"), "uploads_verification");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	            
	 //           logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString()+conid);
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	 //           logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	           // String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	            String TempName = part.getFileName().orElse(name);
	//            logger.info("Tempname"+TempName);
	           // encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	          //  logger.info(encRes+"! Encrypted!");
	            System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	            res  = fc.sendHttpver(id, uploadedPath.toString()+"\\"+TempName);
	 //           logger.info("Response : "+res);
	            //(String callerid,String uniqueid,String contractid,String date,String time,String score,String filePath)
	            f.TBL_verificationLogging(Callerid,uid,id,conid,date,time,res,uploadedPath.toString()+"\\"+TempName,fileCount,voiceprint);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	//        	logger.info(res);
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	 ///////////////////////////////////////////////////////////////////
	    
	    @Path("/v2/verification/en/{id}")
	    @POST
	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Consumes(MediaType.APPLICATION_JSON)
	    public Response uploadEncFileVerification(@PathParam("id") String id,@FormParam("file") EntityPart part) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz/Verification"), "uploads_verification");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	            
	            try 
	            {
	            	Thread.sleep(2000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	 //           logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString()+conid);
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	 //           logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	            String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	       //     String TempName = part.getFileName().orElse(name);
	//            logger.info("Tempname"+TempName);
	            try 
	            {
	            	Thread.sleep(1000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	          //  logger.info(encRes+"! Encrypted!");
	            
	            try 
	            {
	            	Thread.sleep(3000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	            res  = fc.sendHttpver(id, uploadedPath.toString()+"\\"+TempName);
	 //           logger.info("Response : "+res);
	            //(String callerid,String uniqueid,String contractid,String date,String time,String score,String filePath)
	        //    f.TBL_verificationLogging(Callerid,uid,id,conid,date,time,res,uploadedPath.toString()+"\\"+TempName,fileCount);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	//        	logger.info(res);
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	    
	/////////////////////////////// Short Verification Digit Validation /////////////////////
	    
	    @Path("/v2/digitvalidation/en/{id}")
	    @POST
	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Consumes(MediaType.APPLICATION_JSON)
	    public Response uploadEncFileDigitValidation(@PathParam("id") String id,@FormParam("file") EntityPart part) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz/Digit"), "uploads_verification");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	            
	            try 
	            {
	            	Thread.sleep(2000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	 //           logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString()+conid);
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	 //           logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	            String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	       //     String TempName = part.getFileName().orElse(name);
	//            logger.info("Tempname"+TempName);
	            try 
	            {
	            	Thread.sleep(1000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	          //  logger.info(encRes+"! Encrypted!");
	            
	            try 
	            {
	            	Thread.sleep(3000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	            res  = fc.sendHttpDigit(id, uploadedPath.toString()+"\\"+TempName);
	 //           logger.info("Response : "+res);
	            //(String callerid,String uniqueid,String contractid,String date,String time,String score,String filePath)
	        //    f.TBL_verificationLogging(Callerid,uid,id,conid,date,time,res,uploadedPath.toString()+"\\"+TempName,fileCount);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	//        	logger.info(res);
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	    
	//////////////////////////////  Short Verification ///////////////////////////////
	    
	    @Path("/v2/shortvalidation/en/{id}")
	    @POST
	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	   // @Consumes(MediaType.APPLICATION_JSON)
	    public Response uploadEncFileDigitShortValidation(@PathParam("id") String id,@FormParam("file") EntityPart part) {
			
			//logger.dDEBUG( "name: {0} ", name); 
			// Logger.DEBUG( "uploading file: {0},{1},{2},{3}", new Object[]{ part.getMediaType(),
			// part.getName(), part.getFileName(), part.getHeaders() } );
			 String name = "hello";
			 String encRes = "";
			 try 
			   {
		            uploadedPath = Files.createTempDirectory(Paths.get("C:/VoizBuzz/ShortValiadation"), "uploads_verification");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
	        try {
	            Files.copy(part.getContent(),
	                    Paths.get(uploadedPath.toString(), part.getFileName().orElse(generateFileName(UUID.randomUUID().toString(), mediaTypeToFileExtension(part.getMediaType())))),
	                    StandardCopyOption.REPLACE_EXISTING
	            );
	            
	            try 
	            {
	            	Thread.sleep(2000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	 //           logger.info("File path :"+uploadedPath.toString()+"ID"+UUID.randomUUID().toString()+"_"+part.getFileName().toString()+conid);
	          // System.out.println("name: {0} "+ name);
	         //  System.out.println("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() );
	  //          logger.info("uploading file: {0},{1},{2},{3}" +part.getName()+ part.getFileName() +part.getHeaders() +part.getFileName().orElse(name));
	 //           logger.info("File path :"+uploadedPath.toString()+"/"+part.getFileName().orElse(name));
	            String TempName = StringUtils.replace(part.getFileName().orElse(name), ".wav", ".enc");
	       //     String TempName = part.getFileName().orElse(name);
	//            logger.info("Tempname"+TempName);
	            try 
	            {
	            	Thread.sleep(1000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            encRes = en.file_Encryption(uploadedPath.toString()+"/"+part.getFileName().orElse(name), uploadedPath.toString()+"/"+TempName);
	          //  logger.info(encRes+"! Encrypted!");
	            
	            try 
	            {
	            	Thread.sleep(3000);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            System.out.println("Name "+TempName + " File path "+  uploadedPath.toString()+ id );
	            res  = fc.sendHttpValidation(id, uploadedPath.toString()+"\\"+TempName);
	 //           logger.info("Response : "+res);
	            //(String callerid,String uniqueid,String contractid,String date,String time,String score,String filePath)
	        //    f.TBL_verificationLogging(Callerid,uid,id,conid,date,time,res,uploadedPath.toString()+"\\"+TempName,fileCount);
	            
	        } catch (IOException e) {
	        	res = e.getMessage();
	//        	logger.info(res);
	            throw new RuntimeException(e);
	        }
	        return Response.status(200).entity(res).build();
	    }
	    
	
	    
	    
	   
	  //////////////////////////// Enrollment Pull //////////////////////////////
	    
  
	    @Path("/v2/enrollmentdata/{id}")
		@POST
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes({ MediaType.APPLICATION_JSON })
	    public Response enrollmentPull(@PathParam("id") String contID,CallRecord cr) {
	    	 Map<String, Object> object = new HashMap<>();
	        try
	           {
//	        	 logger.info("Req : "+contID);
	        	
	     		result = f.enrollmentstatus(contID);//.enrollmentstatus(contID);
//	     		 logger.info("result"+result);
	     		//String[] hexPairs1 = StringUtils.split(StringUtils.trim(result), ",");
	     		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
	     		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
	     		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
	     		
	     		  object.put("Contract_ID", contID);
	     		  object.put("BVP_Status", result);
	     		 
	     		  //object.put("TOTAL_CALLS", hexPairs1[2]);
	     		//  object.put("key2", "value2");
//	     		  logger.info("result"+object);
	     		   		  
	           }
	        catch (Exception ex)
	        {
	        	System.out.println("error"+ex.getMessage());
	           // logger.info("Error creating coffee " + coffee.getName());
	            throw new WebApplicationException(Response.Status.BAD_REQUEST);
	        }
	        return Response.status(200).header("Access-Control-Allow-Origin", "*")
   			      .header("Access-Control-Allow-Credentials", "true")
   			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
   			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();

	    }    
	
	    @Path("/v2/verificationdata/{id}")
	  		@POST
	  		@Produces({ MediaType.APPLICATION_JSON })
	  		@Consumes({ MediaType.APPLICATION_JSON })
	  	    public Response verificationPull(@PathParam("id") String convID,CallRecord cr) {
	  	    	// Map<String, Object> object = new HashMap<>();
	  	        try
	  	           {
	 // 	        	 logger.info("Req : "+convID);
	  	        	
	  	     		result = f.verificationstatus(convID);//.enrollmentstatus(contID);
	//  	     		 logger.info("result"+result);
	  	     		//String[] hexPairs1 = StringUtils.split(StringUtils.trim(result), ",");
	  	     		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
	  	     		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
	  	     		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
	  	     		 result = cf.JSONBulid1(result,convID);
	  	     		 // object.put("Contract_ID", convID);
	  	     		//  object.put("BVP_Status", result);
	  	     		 
	  	     		  //object.put("TOTAL_CALLS", hexPairs1[2]);
	  	     		//  object.put("key2", "value2");
//	  	     		  logger.info("result"+result);
	  	     		   		  
	  	           }
	  	        catch (Exception ex)
	  	        {
	  	        	System.out.println("error"+ex.getMessage());
	  	           // logger.info("Error creating coffee " + coffee.getName());
	  	            throw new WebApplicationException(Response.Status.BAD_REQUEST);
	  	        }
	  	        return Response.status(200).header("Access-Control-Allow-Origin", "*")
	     			      .header("Access-Control-Allow-Credentials", "true")
	     			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
	     			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(result).build();

	  	    }    
	  	
    
	    
	    
	    
	    
	    /////////////////////////////////////////////////////////////////////////
	    
	    
	    
	    
	 ///////////////////////////////////////////////////////////////////////
	    
	    
	    
	 private String generateFileName(String fileName, String extension) {
		  //  logger.debug(fileName+"."+extension);
	        return fileName + "." + extension;
	    }
	 private String mediaTypeToFileExtension(MediaType mediaType) {
	        return switch (mediaType.toString()) {
	            case "text/plain" -> "txt";
	            case "application/svg+xml" -> "svg";
	            case "audio/wav" -> "wav";
	            default -> "bin";
	        };
	    }
/*Path("/v2/logging/{table}/{operation}")
	@POST
	//@Produces({ MediaType.MULTIPART_FORM_DATA})
	@Consumes({ MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile( @PathParam("empNo") String empNo,
            @PathParam("appName") String AppName,
            
           @Form("file") InputStream uploadedInputStream,
@FormDataParam("file") FormDataContentDisposition fileDetail) {
	
		
		
	  return Response.status(200).entity(res).build();
	}
	*/
	
	@GET
	@Path("/v2/callinfo")
	
	//@CrossOrigin(origins = "http://localhost:8080,maxAge = 3600", allowedHeaders = "*")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response liveCall(@PathParam("count") String opr) {
		//if ((name == null) || name.trim().isEmpty())  {
		//	name = "world";
	//	}
		Map<String, Object> object = new HashMap<>();
		result = cf.calldetail(result);
//		 logger.info("result"+result);
		String[] hexPairs1 = StringUtils.split(StringUtils.trim(result), ",");
		
		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
		
		  object.put("ACTIVE_CHANNELS", hexPairs1[0]);
		  object.put("ACTIVE_CALLS", hexPairs1[0]);
		  object.put("TOTAL_CALLS", hexPairs1[2]);
		//  object.put("key2", "value2");
//		  logger.info("result"+object);
		  return Response.status(200).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();
		  
		//   return Response.status(200).entity(object).build();
		   
	}
	
	@GET
	@Path("/v2/activecallinfo")
	
	//@CrossOrigin(origins = "http://localhost:8080,maxAge = 3600", allowedHeaders = "*")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response liveActiveCall(@PathParam("count") String opr) {
		//if ((name == null) || name.trim().isEmpty())  {
		//	name = "world";
	//	}
		Map<String, Object> object = new HashMap<>();
		result = cf.calldetail(result);
//		 logger.info("result"+result);
		String[] hexPairs1 = StringUtils.split(StringUtils.trim(result), ",");
		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
		
		  object.put("ACTIVE_CHANNELS", hexPairs1[0]);
		  object.put("ACTIVE_CALLS", hexPairs1[0]);
		//  object.put("TOTAL_CALLS", hexPairs1[2]);
		//  object.put("key2", "value2");
//		  logger.info("result"+object);
		  return Response.status(200).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();
		  
		//   return Response.status(200).entity(object).build();
		   
	}
	
	
	
	@GET
	@Path("/v2/hoursbysix")
	
	//@CrossOrigin(origins = "http://localhost:8080,maxAge = 3600", allowedHeaders = "*")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response hoursbysix() {
		//if ((name == null) || name.trim().isEmpty())  {
		//	name = "world";
	//	}
		//Map<String, Object> object = new HashMap<>();
		//result = cf.calldetail(result);
//		 logger.info("Req : Last Six Hours");
//		 logger.info("Started");
		   res =  f.HoursBySix("");
		  result = cf.JSONBulid(res);
			/*
			 * String[] hexPairs1 = StringUtils.split(StringUtils.trim(res), "|");
			 * object.put("HOURS", hexPairs1[0]); object.put("COUNT", hexPairs1[1]);
			 * object.put("TOTAL_CALLS", hexPairs1[2]);
			 */
		//  object.put("key2", "value2");
	//	  logger.info("Res : Last Six Hours"+result);
		  return Response.status(200).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(result).build();
		  
		//   return Response.status(200).entity(object).build();
		   
	}
	/*----------------------------------------------------------------*/
	
	
	@Path("/v2/outdial/{anum}/{cnum}")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
    public Response createOutDial(@PathParam("anum") String anum,@PathParam("cnum") String cnum) {
        try
           {
    //    	 logger.info("Req : "+anum + " Operation -"+cnum);
        	//System.out.println(cr.getVAR_CALLERID());
        	 
        		// logger.info("DATA"+cr.getVAR_CALLERID()+":"+cr.getVAR_CONTRACTNO()+":"+cr.getVAR_CALLED_DATE());
        		result = cf.outDialCall(anum,cnum);
        		 
        		// logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             
            
             
            return Response.status(200).entity(res).build();
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

	
	/* ---------------------------------------------------------------------*/
	
	@Path("/v2/queuestatus")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
//	@Consumes({ MediaType.APPLICATION_JSON })
    public Response queuestatus() {
        try
           {
    //    	 logger.info("Req : "+anum + " Operation -"+cnum);
        	//System.out.println(cr.getVAR_CALLERID());
        	 
        		// logger.info("DATA"+cr.getVAR_CALLERID()+":"+cr.getVAR_CONTRACTNO()+":"+cr.getVAR_CALLED_DATE());
        	//	cf.QueueStatus("", "");
        	    Map<String, Object> object = new HashMap<>();
        		result = cf.QueueStatus("","");
        	//	String[] hexPairs1;
        	    String[] hexPairs1 = StringUtils.substringsBetween(result,"A001 has", "calls");
        	    object.put("Waiting", hexPairs1[0]);
        	    String[] hexPairs2 = StringUtils.substringsBetween(result,"C:", ",");
        	    object.put("Answered", hexPairs2[0]);
        	    
        	    String[] hexPairs3 = StringUtils.substringsBetween(result,"A:", ",");
        	    object.put("Missed", hexPairs3[0]);
        	    
        	    String[] hexPairs4 = StringUtils.substringsBetween(result,"SL:", ",");
        	    object.put("Average", hexPairs4[0]);
        		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
        		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
        		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
        		
        	//	  object.put("ACTIVE_CHANNELS", hexPairs1[0]);
        	//	  object.put("ACTIVE_CALLS", hexPairs1[0]);
        		// logger.info("Res : "+table + " Operation -"+opr+"-"+res);
             
        	    return Response.status(200).header("Access-Control-Allow-Origin", "*")
      			      .header("Access-Control-Allow-Credentials", "true")
      			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
      			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();
      		  
             
         //   return Response.status(200).entity(object).build();
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
	
	@GET
	@Path("/v2/agentibddata/{agentid}")
	
	//@CrossOrigin(origins = "http://localhost:8080,maxAge = 3600", allowedHeaders = "*")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response liveAgentData(@PathParam("agentid") String agentid) {
		//if ((name == null) || name.trim().isEmpty())  {
		//	name = "world";
	//	}
		Map<String, Object> object = new HashMap<>();
		result = cf.AgentData(result,agentid);
	//	StringUtils.remove(result, "Output: ");
		  System.out.println("result set for : "+agentid +" ---- "+result);
//		 logger.info("result"+result);

		  if(result.length() >= 5)
		   {
			  			  
			  String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "$");
			  System.out.println("1"+hexPairs0[0]); 
			//  System.out.println("2"+hexPairs0[1]); 
			  
			  String[] hexPairs1 = StringUtils.split(StringUtils.trim(hexPairs0[0]), "!");
			  
		 //     String[] hexPairs2 = StringUtils.split(StringUtils.trim(hexPairs0[1]), "!");
		      
		      if(StringUtils.substringBefore(hexPairs1[0], "-").equals("PJSIP/"+agentid))
		      {
		  	    System.out.println("yes 1");
		  	/*
		  	 * Ringing Data    
		  	 
		  	PJSIP/6003-0000006f!914469177636!Ringing!(Outgoing Line)!914469177636!00:00:01!1740061851.184
		  	PJSIP/out-0000006e!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^1740061850183^2025-02-20 20:00:51^00919840859543^0000006e^6003^/usr/Record/DAILER/February_2025/20/20hrs/1740061850183^PREDICTIVE DIALER)!00919840859543!00:00:03!1740061850.183
		  	*/
		  	    
		  	/*
		  	 * Connected Status 
		  	 * 
		  	 * PJSIP/6003-00000071!Up!(Outgoing Line)!914469177636!00:01:02!1740062220.188
			   PJSIP/out-00000070!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^1740062218187^2025-02-20 20:07:00^00919840859543^00000070^6003^/usr/Record/DAILER/February_2025/20/20hrs/1740062218187^PREDICTIVE DIALER)!00919840859543!00:01:03!1740062218.187

		  	 */
		  	   //  object.put("DATA", "Part 1");
		  	     
		  	     object.put("DATA", "Part 1");
		  	     object.put("ACTIVE_DATA_1", StringUtils.substringBetween(hexPairs1[0],"PJSIP/", "-"));
		  	     object.put("ACTIVE_DATA_2", hexPairs1[1]); // DDI
				 object.put("ACTIVE_DATA_3", hexPairs1[2]); // Ringing status
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[4]);
				 //object.put("ACTIVE_DATA_6", StringUtils.substringAfter(hexPairs1[5],":")    ); // DDI
			//	 object.put("ACTIVE_DATA_6", hexPairs1[5]); // DDI
				 object.put("ACTIVE_DATA_6", StringUtils.trim(StringUtils.substringAfter(hexPairs1[5],":"))); // DDI
				// if(hexPairs1[5].isEmpty())
				//	 System.out.println("Yes");
			//	 object.put("ACTIVE_DATA_7",f.FetchCallerID(StringUtils.substringBefore(hexPairs1[6],"."))); // DDI
				 object.put("ACTIVE_DATA_7",f.FetchCallerID(hexPairs1[6]));
				 object.put("ACTIVE_DATA_8", hexPairs1[0]); // DDI
		  	     
		  	  /*   object.put("ACTIVE_DATA_1", StringUtils.substringBetween(hexPairs1[0],"PJSIP/", "-"));
		  	     object.put("ACTIVE_DATA_2", hexPairs1[1]); // DDI
				 object.put("ACTIVE_DATA_3", hexPairs1[2]); // Ringing status
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[3]);
				 object.put("ACTIVE_DATA_6", hexPairs1[5]); // DDI
				 object.put("ACTIVE_DATA_7", hexPairs2[0]);
			     object.put("ACTIVE_DATA_8", hexPairs2[1]);
			     object.put("ACTIVE_DATA_9", hexPairs2[3]);
			     object.put("ACTIVE_DATA_10", hexPairs2[3]);
			     object.put("ACTIVE_DATA_11", hexPairs2[4]);
			     object.put("ACTIVE_DATA_12", hexPairs2[5]); */
			//     object.put("ACTIVE_DATA_13", hexPairs2[6]);
			      	
		      }
		      else if(StringUtils.substringBefore(hexPairs0[1], "-").equals("PJSIP/"+agentid))
		      {
		    	  System.out.println("yes 2");
		    	  
		    	  /*
		    	   * 
		    	   * Ringing Status
		    	   * 
		    	   
		    	    PJSIP/out-00000012!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174006519928^2025-02-20 20:56:40^00919840859543^00000012^6003^/usr/Record/DAILER/February_2025/20/20hrs/174006519928^PREDICTIVE DIALER)!00919840859543!00:00:05!1740065199.28
					PJSIP/6003-00000013!Ringing!(Outgoing Line)!914469177636!00:00:04!1740065200.29

					Connected Status
					
					PJSIP/out-00000014!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174006525031^2025-02-20 20:57:32^00919840859543^00000014^6003^/usr/Record/DAILER/February_2025/20/20hrs/174006525031^PREDICTIVE DIALER)!00919840859543!00:00:16!1740065250.31
					PJSIP/6003-00000015!Up!(Outgoing Line)!914469177636!00:00:15!1740065252.32

		    	   */
		    	  
		    	  System.out.println("0 - "+hexPairs1[0]+"\n"+"1 - "+hexPairs1[1]+"\n"+"2 - "+hexPairs1[2]+"\n"+"3 - "+hexPairs1[3]+"\n");
		 		 System.out.println("4 - "+hexPairs1[4]+"\n"+"5 - "+hexPairs1[5]+"\n"+"6 - "+hexPairs1[1]+"\n"+"7 - "+hexPairs1[2]+"\n");
		 		      object.put("DATA", "Part 2");
		    	/*     object.put("ACTIVE_DATA_7", hexPairs2[0]);
					 object.put("ACTIVE_DATA_8", hexPairs2[1]);
					 object.put("ACTIVE_DATA_9", hexPairs2[2]);
					 object.put("ACTIVE_DATA_10", hexPairs2[3]);
					 object.put("ACTIVE_DATA_11", hexPairs2[4]);
					 object.put("ACTIVE_DATA_12", hexPairs2[5]); */
				//	 object.put("ACTIVE_DATA_17", hexPairs2[6]);
				 
			//  object.put("ACTIVE_DATA_7", hexPairs2[6]);
			  
			    // object.put("ACTIVE_DATA_1", hexPairs1[0]);
					// StringUtils.substringBetween( hexPairs2[0],"PJSIP/", "-");
					// object.put("ACTIVE_DATA_1",StringUtils.substringBetween( hexPairs2[0],"PJSIP/", "-"));
				 object.put("ACTIVE_DATA_2", hexPairs1[1]);
				 object.put("ACTIVE_DATA_3", hexPairs1[2]);
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[4]);
			//	 object.put("ACTIVE_DATA_6", hexPairs1[5]);
			//	 object.put("ACTIVE_DATA_6", StringUtils.substringAfter(hexPairs1[5],":")    ); // DDI
				 
				 object.put("ACTIVE_DATA_6", StringUtils.trim(StringUtils.substringAfter(hexPairs1[5],":"))); // DDI
				 
				 object.put("ACTIVE_DATA_8", hexPairs0[1]);
			//	 object.put("ACTIVE_DATA_7", hexPairs1[6]);
		    	  
		      }
		      else
		      {
		    	  System.out.println("No Datta");
		      }
		      
		      
	
		   }
		  else
		  {
			  System.out.println(object);
		  }
		  
		  
		/*  
		  if(result.length() >= 5)
		   {
			  			  
			  String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "$");
			  System.out.println("1"+hexPairs0[0]); 
			  System.out.println("2"+hexPairs0[1]); 
			  String[] hexPairs1 = StringUtils.split(StringUtils.trim(hexPairs0[0]), "!");
		      String[] hexPairs2 = StringUtils.split(StringUtils.trim(hexPairs0[1]), "!");
		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
	    System.out.println("ID string"+hexPairs2[0]);
	    System.out.println("ID string"+hexPairs2[1]);
	    System.out.println("ID string"+hexPairs2[2]);
	    System.out.println("ID string"+hexPairs2[3]);
	//    System.out.println("ID string"+hexPairs2[9]);
	//    System.out.println("ID string"+hexPairs2[10]);
		 String temp =  StringUtils.substringBefore(hexPairs1[0], "-");
		 String temp1 = StringUtils.substringBefore(hexPairs2[0],"-");
		 System.out.println("ID"+temp);
		 System.out.println("0 - "+hexPairs1[0]+"\n"+"1 - "+hexPairs1[1]+"\n"+"2 - "+hexPairs1[2]+"\n"+"3 - "+hexPairs1[3]+"\n");
		 System.out.println("4 - "+hexPairs1[4]+"\n"+"5 - "+hexPairs1[5]+"\n"+"6 - "+hexPairs1[4]+"\n"+"7 - "+hexPairs1[2]+"\n");
	//	 System.out.println("8 - "+hexPairs1[8]+"\n"+"9 - "+hexPairs1[9]+"\n"+"10 - "+hexPairs1[10]+"\n"+"11 - "+hexPairs1[11]+"\n");
	//	 System.out.println("12 - "+hexPairs1[12]+"\n"+"13 - "+hexPairs1[13]+"\n"+"14 - "+hexPairs1[14]+"\n"+"15 - "+hexPairs1[15]+"\n");
	//	 System.out.println("16 - "+hexPairs1[16]+"\n"+"17 - "+hexPairs1[17]+"\n"+"18 - "+hexPairs1[18]+"\n"+"19 - "+hexPairs1[19]+"\n");
		 
		 if(temp.equals("PJSIP/"+agentid))
		 {
			/* object.put("ACTIVE_DATA_1", hexPairs1[0]);
			 object.put("ACTIVE_DATA_2", hexPairs1[1]);
			 object.put("ACTIVE_DATA_3", hexPairs1[2]);
			 object.put("ACTIVE_DATA_4", hexPairs2[3]); //Ringing
			 object.put("ACTIVE_DATA_5", hexPairs1[4]);
			 object.put("ACTIVE_DATA_6", hexPairs1[5]);
			// object.put("ACTIVE_DATA_7", hexPairs1[6]);
			 
			  object.put("ACTIVE_DATA_11", hexPairs2[0]);
		      object.put("ACTIVE_DATA_12", hexPairs2[1]);
			  object.put("ACTIVE_DATA_13", hexPairs2[2]);
			  object.put("ACTIVE_DATA_14", hexPairs2[3]);
		      object.put("ACTIVE_DATA_15", hexPairs2[4]);
			  object.put("ACTIVE_DATA_16", hexPairs2[5]);
			  
			  
			     object.put("ACTIVE_DATA_1", hexPairs1[0]);
				 object.put("ACTIVE_DATA_2", hexPairs1[1]);
				 object.put("ACTIVE_DATA_3", hexPairs1[2]);
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[4]);
				 object.put("ACTIVE_DATA_6", hexPairs1[5]);
				
				 
				  object.put("ACTIVE_DATA_11", hexPairs2[0]);
			      object.put("ACTIVE_DATA_12", hexPairs2[1]);
				  object.put("ACTIVE_DATA_13", hexPairs2[3]);
				  object.put("ACTIVE_DATA_14", hexPairs2[3]);
			      object.put("ACTIVE_DATA_15", hexPairs2[4]);
				  object.put("ACTIVE_DATA_16", hexPairs2[5]);
			
		 }
		 else if(temp1.equals("PJSIP/"+agentid))
			  {  
		  object.put("ACTIVE_DATA_1", hexPairs2[0]);
	      object.put("ACTIVE_DATA_2", hexPairs2[1]);
		  object.put("ACTIVE_DATA_3", hexPairs2[2]);
		  object.put("ACTIVE_DATA_4", hexPairs2[3]);
	      object.put("ACTIVE_DATA_5", hexPairs2[4]);
		  object.put("ACTIVE_DATA_6", hexPairs2[5]);
		//  object.put("ACTIVE_DATA_7", hexPairs2[6]);
		  
		     object.put("ACTIVE_DATA_11", hexPairs1[0]);
			 object.put("ACTIVE_DATA_12", hexPairs1[1]);
			 object.put("ACTIVE_DATA_13", hexPairs1[2]);
			 object.put("ACTIVE_DATA_14", hexPairs1[3]); //Ringing
			 object.put("ACTIVE_DATA_15", hexPairs1[4]);
			 object.put("ACTIVE_DATA_16", hexPairs1[5]);
		//	 object.put("ACTIVE_DATA_17", hexPairs1[6]);
			  
	 
		  System.out.println(object);
		   }
		  else
		  {
			  System.out.println("No Data");
		  }
		 
		   }
		  else
		  {
			  System.out.println(object);
		  }
	*/
		  return Response.status(200).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();
		  
		//   return Response.status(200).entity(object).build();
		   
	}
	
	
/* -------------------------------------------------------------- */
	
	@Path("/v2/mute/channelB")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response Xmute(@FormParam("channelno") String channelno) {
		String res ="";
        try
           {
        	res  = hm.muteChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(res).build();
    }
	
	
	@Path("/v2/unmute/channelB")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response Xunmute(@FormParam("channelno") String channelno) {
		String res ="";
        try
           {
        	res  = hm.unMuteChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(res).build();
    }
	

/*         ------------------------------------------------------ */
	@Path("/v2/hold/channel")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response Xhold(@FormParam("bridgeid") String bridgeid) {
		String res ="";
		Map<String, Object> object = new HashMap<>();
	//	ServiceManager s = new ServiceManager();
        try
           {
        	res = 	s.HoldOperation(bridgeid);
        	// String[] hexPairs0 = StringUtils.split(StringUtils.trim(res), "$");
			//  System.out.println("1"+hexPairs0[0]); 
			//  System.out.println("2"+hexPairs0[1]); 
			  
			  String[] hexPairs1 = StringUtils.split(res, "!");
			     object.put("result",            hexPairs1[0]); //Ringing
				 object.put("primary_channel",   hexPairs1[1]);
				 object.put("secondary_channel", hexPairs1[2]);
				 object.put("bridge_id", bridgeid);
				 
      //  	ServiceManager s = new ServiceManager();
        	//res  = hm.HoldChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(object).build();
    }
	
	@Path("/v2/unhold/channel")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response XUnhold(@FormParam("primaryid") String primaryChName,@FormParam("secondaryid") String secondaryChName) {
		String res ="";
	//	ServiceManager s = new ServiceManager();
        try
           {
        	res = 	s.UnHoldOperation(primaryChName,secondaryChName);
      //  	ServiceManager s = new ServiceManager();
        	//res  = hm.HoldChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(res).build();
    }
	

	

	
	
	/* -----------------------------------------------------------*/
	
	
	
	@Path("/v2/channelspy/channel")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response XChannelSpy(@FormParam("primaryid") String supervisorNo,@FormParam("secondaryid") String agentNo) {
		String res ="";
	//	ServiceManager s = new ServiceManager();
        try
           {
        	res = 	s.ChannelSpy(supervisorNo,agentNo);
      //  	ServiceManager s = new ServiceManager();
        	//res  = hm.HoldChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(res).build();
    }
	

	@Path("/v2/blindtransfer/channel")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
    public Response XBlindChannel(@FormParam("bridgeid") String bridgeid) {
		String res ="";
		
        try
           {
        	res = 	s.BlindTransferOperation(bridgeid);
      //  	ServiceManager s = new ServiceManager();
        	//res  = hm.HoldChannel(channelno);
               
           }
        catch (Exception ex)
        {
        	System.out.println("error"+ex.getMessage());
           // logger.info("Error creating coffee " + coffee.getName());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(200).entity(res).build();
    }
	




	
	
	
	
	
	
	/*@GET
	@Path("/v2/callinfo")
	
	//@CrossOrigin(origins = "http://localhost:8080,maxAge = 3600", allowedHeaders = "*")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response liveOutCall(@PathParam("cdialout") String opr) {
		//if ((name == null) || name.trim().isEmpty())  {
		//	name = "world";
	//	}
		Map<String, Object> object = new HashMap<>();
		result = cf.calldetail(result);
		 logger.info("result"+result);
		String[] hexPairs1 = StringUtils.split(StringUtils.trim(result), ",");
		//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
		//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
		//ci.setVAR_TOTALCALLS(hexPairs1[2]);
		
		  object.put("ACTIVE_CHANNELS", hexPairs1[0]);
		  object.put("ACTIVE_CALLS", hexPairs1[1]);
		  object.put("TOTAL_CALLS", hexPairs1[2]);
		//  object.put("key2", "value2");
		  logger.info("result"+object);
		  return Response.status(200).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(object).build();
		  
		//   return Response.status(200).entity(object).build();
		   
	}*/
}