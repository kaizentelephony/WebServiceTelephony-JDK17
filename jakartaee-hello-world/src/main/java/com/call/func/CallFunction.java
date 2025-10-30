package com.call.func;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

//import com.call.db.FetchData;

//import com.call.db.FetchData;

public class CallFunction {
	private static String ASTERISK_HOST = "192.168.5.61";
    private static int ASTERISK_PORT = 5038;
    private static  String AMI_USERNAME = "administrator";
    private static  String AMI_PASSWORD = "mysecret";
    private static  String AMI_PORT = "";
   // private static String 
    StringBuffer s = new StringBuffer();
 //   FetchData f = new FetchData();
    JSONArray jsonArray = new JSONArray(); 
	public String calldetail(String result)
	{
		try {
			 Properties pro = new Properties();
             FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
             
              pro.load(in);
             ASTERISK_HOST         = pro.getProperty("AMI_IP");
          //   AMI_PORT              = pro.getProperty("AMI_PORT");
         AMI_USERNAME    	   = pro.getProperty("AMI_USER");
             AMI_PASSWORD		   = pro.getProperty("AMI_PASSWORD");
            s.delete(0, s.length());
            // Establish connection to Asterisk AMI
           Socket socket = new Socket(ASTERISK_HOST,ASTERISK_PORT);
   //    Socket socket = new Socket("192.168.5.61",);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Login to Asterisk AMI
            writer.write("Action: Login\r\n");
            writer.write("Username: " + AMI_USERNAME + "\r\n");
            writer.write("Secret: " + AMI_PASSWORD + "\r\n");
           writer.write("Events: off\r\n\r\n");
            writer.flush();
            //writer.println();
            // Send command to Asterisk
            writer.write("Action: Command\r\n");
        //    writer.write("Command: core show channels verbose\r\n\r\n");
            writer.write("Command: core show channels count\r\n\r\n");
            writer.flush();

            // Read response from Asterisk
            String line;
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
          //  line = reader.readLine();
        //    line = reader.readLine();
            while ((line = reader.readLine()) != "") {
                // Process the response
                 String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  // if(line.equalsIgnoreCase(null))
                   s.append(line1+",");
               //   String modifiedOutput = line.replace(" ", "\t");
              // String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  if(line.equals(""))
                    break;
                   
            }

            result = s.toString();
         //   if((line = reader.readLine()) != null)
                System.out.println("Close Socket"+s.toString());
            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return result;
	}
	
	public String outDialCall(String anum,String cnum)
	{
		try {
			 Properties pro = new Properties();
             FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
             
              pro.load(in);
             ASTERISK_HOST         = pro.getProperty("AMI_IP");
          //   AMI_PORT              = pro.getProperty("AMI_PORT");
             AMI_USERNAME    	   = pro.getProperty("AMI_USER");
             AMI_PASSWORD		   = pro.getProperty("AMI_PASSWORD");
            s.delete(0, s.length());
            // Establish connection to Asterisk AMI
            Socket socket = new Socket(ASTERISK_HOST,ASTERISK_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Login to Asterisk AMI
            writer.write("Action: Login\r\n");
            writer.write("Username: " + AMI_USERNAME + "\r\n");
            writer.write("Secret: " + AMI_PASSWORD + "\r\n");
           writer.write("Events: off\r\n\r\n");
            writer.flush();
            //writer.println();
            // Send command to Asterisk
            writer.write("Action: Command\r\n");
        //    writer.write("Command: core show channels verbose\r\n\r\n");
            //writer.write("Command: originate "+anum+" application dial "+cnum+",30,m(Dialer_moh)\r\n\r\n");
            //originate pjsip/09361598282@out application dial pjsip/09150054994@out,30,m(Dialer_moh)
            writer.write("Command: originate pjsip/"+anum+" application dial pjsip/"+cnum+"@out,30,m(Dialer_moh)\r\n\r\n");
            writer.flush();

            // Read response from Asterisk
            String line;
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
          //  line = reader.readLine();
        //    line = reader.readLine();
            while ((line = reader.readLine()) != "") {
                // Process the response
                 String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  // if(line.equalsIgnoreCase(null))
                   s.append(line1+",");
               //   String modifiedOutput = line.replace(" ", "\t");
              // String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  if(line.equals(""))
                    break;
                   
            }

            anum = s.toString();
         //   if((line = reader.readLine()) != null)
                System.out.println("Close Socket"+s.toString());
            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return anum;
	}
	
	
	public String QueueStatus(String anum,String cnum)
	{
		try {
			 Properties pro = new Properties();
             FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
             
              pro.load(in);
             ASTERISK_HOST         = pro.getProperty("AMI_IP");
          //   AMI_PORT              = pro.getProperty("AMI_PORT");
             AMI_USERNAME    	   = pro.getProperty("AMI_USER");
             AMI_PASSWORD		   = pro.getProperty("AMI_PASSWORD");
            s.delete(0, s.length());
            // Establish connection to Asterisk AMI
            Socket socket = new Socket(ASTERISK_HOST,ASTERISK_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Login to Asterisk AMI
            writer.write("Action: Login\r\n");
            writer.write("Username: " +   AMI_USERNAME + "\r\n");
            writer.write("Secret: "   +   AMI_PASSWORD + "\r\n");
           writer.write("Events: off\r\n\r\n");
            writer.flush();
            //writer.println();
            // Send command to Asterisk
            writer.write("Action: Command\r\n");
        //    writer.write("Command: core show channels verbose\r\n\r\n");
            //writer.write("Command: originate "+anum+" application dial "+cnum+",30,m(Dialer_moh)\r\n\r\n");
            //originate pjsip/09361598282@out application dial pjsip/09150054994@out,30,m(Dialer_moh)
            writer.write("Command: queue show A001\r\n\r\n");
            writer.flush();

            // Read response from Asterisk
            String line;
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
          //  line = reader.readLine();
        //    line = reader.readLine();
            while ((line = reader.readLine()) != "") {
                // Process the response
                 String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  // if(line.equalsIgnoreCase(null))
                   s.append(line+",");
               //   String modifiedOutput = line.replace(" ", "\t");
              // String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line + line1);
                  if(line.equals(""))
                    break;
                   
            }

            anum = s.toString();
         //   if((line = reader.readLine()) != null)
                System.out.println("Close Socket"+s.toString());
            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return anum;
	}
	

	
	
	
	public String AgentData(String result,String id)
	{
		 String line1 = "";
		 String bridgeID = "";
		try {
			 Properties pro = new Properties();
             FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
             
              pro.load(in);
             ASTERISK_HOST         = pro.getProperty("AMI_IP");
          //   AMI_PORT              = pro.getProperty("AMI_PORT");
             AMI_USERNAME    	   = pro.getProperty("AMI_USER");
             AMI_PASSWORD		   = pro.getProperty("AMI_PASSWORD");
            s.delete(0, s.length());
            // Establish connection to Asterisk AMI
            Socket socket = new Socket(ASTERISK_HOST,ASTERISK_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Login to Asterisk AMI
            writer.write("Action: Login\r\n");
            writer.write("Username: " + AMI_USERNAME + "\r\n");
            writer.write("Secret: " + AMI_PASSWORD + "\r\n");
           writer.write("Events: off\r\n\r\n");
            writer.flush();
            //writer.println();
            // Send command to Asterisk
            writer.write("Action: Command\r\n");
        //    writer.write("Command: core show channels verbose\r\n\r\n");
            writer.write("Command: core show channels customlog\r\n\r\n");
            writer.flush();

            // Read response from Asterisk
            String line;
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine(); 
          //  line = reader.readLine();
        //    line = reader.readLine();
            while ((line = reader.readLine()) != "") {
                // Process the response
             //     line1 = StringUtils.substringBetween(line, " ", " ");
                //  System.out.println("Line1"+ line1);
                  StringUtils.remove(s.toString(), "Output: ");
                  // if(line.equalsIgnoreCase(null))
                  String tmp = StringUtils.substringBefore(StringUtils.remove(line, "Output: "), "-");
               //   String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "!");
              //    System.out.println("Agent"+tmp);
             //     System.out.println("Agent"+tmp + "===PJSIP/"+id);
             //	 String temp1 = StringUtils.substringBefore(hexPairs0[3],",");
                  if(tmp.equals("PJSIP/"+id))
                  {
                	  System.out.println("Agent"+tmp + "===PJSIP/"+id);
                       s.append(line+"$");
                  //     String[] hexPairs0 = StringUtils.split(StringUtils.remove(line, "Output: "), "!");
           			//  String tmp1 = StringUtils.substringBefore(hexPairs0[2], ",");
           			//   bridgeID = hexPairs0[5];
           			//  System.out.println("bridgeID" + bridgeID);
                       
                  }
                  else
                  {
                	 /* String tmp3 = StringUtils.remove(line, "Output: ");
                	  System.out.println("Else 11"+tmp3.isEmpty());
                	  if(tmp3.isEmpty())
                	  {
                		  
                	  }
                	  else
                	  	{
                		  if(StringUtils.remove(tmp3, "Output: ")!="")
                		  { 
                			  System.out.println("Else"+line);
                			  //    String tmp = StringUtils.substringBefore(StringUtils.remove(line, "Output: "), "-");
                			  String[] hexPairs0 = StringUtils.split(StringUtils.remove(line, "Output: "), "!");
                			//  String tmp1 = StringUtils.substringBefore(hexPairs0[2], ",");
                			  String tmp1 = StringUtils.substringBefore(hexPairs0[0], "-");
                			  String tmpBridge = hexPairs0[5];
                			  System.out.println("Else"+tmp1);
                			  if(tmp1.equals("PJSIP/out"))
                			  {
                				  System.out.println("Else"+tmpBridge);
                				  if(bridgeID.equals(tmpBridge))
                					        s.append(line+"$");
                			  }
                		  }
                	  	}*/
               //PJSIP/out-00000012!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174004378132^2025-02-20 14:59:42^00919840859543^00000012^6003^/usr/Record/DAILER/February_2025/20/14hrs/174004378132^PREDICTIVE DIALER)!00919840859543!00:02:24!1740043781.32 	  
                  }
                 // if(temp1.equals("PJSIP/"+id))
                //	  s.append(line+"$");
               //   String modifiedOutput = line.replace(" ", "\t");
              // String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line);
                 // line = "";
                  if(line.equals(""))
                   break;
                   
            }
            
        //    System.out.println("Result1111"+s.toString());
           result = s.toString();
       //    System.out.println("Result1"+result);
            result =StringUtils.remove(s.toString(), "Output: ");
        //    result = line1;
         //   if((line = reader.readLine()) != null)
                System.out.println("Result1"+result);
           //     String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "$");
  		//	  System.out.println("1"+hexPairs0[0]); 
  		//	  System.out.println("2"+hexPairs0[1]); 
  			  
  			  
  		//	 String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "$");
		//	  System.out.println("1"+hexPairs0[0]); 
		//	  System.out.println("2"+hexPairs0[1]); 
  			  
  			  
  			  
            // Close the connection
            socket.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
	//	Sys
		return result;
	}
	public String TestStatus(String anum,String cnum)
	{
		try {
			 Properties pro = new Properties();
             FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
             
              pro.load(in);
             ASTERISK_HOST         = pro.getProperty("AMI_IP");
          //   AMI_PORT              = pro.getProperty("AMI_PORT");
             AMI_USERNAME    	   = pro.getProperty("AMI_USER");
             AMI_PASSWORD		   = pro.getProperty("AMI_PASSWORD");
            s.delete(0, s.length());
            // Establish connection to Asterisk AMI
            Socket socket = new Socket(ASTERISK_HOST,ASTERISK_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Login to Asterisk AMI
            writer.write("Action: Login\r\n");
            writer.write("Username: " + AMI_USERNAME + "\r\n");
            writer.write("Secret: " + AMI_PASSWORD + "\r\n");
           writer.write("Events: off\r\n\r\n");
            writer.flush();
            //writer.println();
            // Send command to Asterisk
        //    writer.write("Action: Hold\r\nChannel:PJSIP/out-0000000d\r\n\r\n");
         //   writer.write("Action: MuteAudio\r\n\r\n");
            writer.write("Action: Command \r\n");
		
		  writer.write("Action: MuteAudio \r\n");
		  writer.write("ActionID: 1212321 \r\n");
		  writer.write("Channel: PJSIP/out-00000048 \r\n");
		  writer.write("Direction: all \r\n"); 
		  writer.write("State: on \r\n");
		
         //   writer.write("Action: Command \r\n");
       //     writer.write("Action: BridgeHold\r\nChannel:PJSIP/out-00000001\r\nExten:1\r\nContext:queue-options\r\nPriority:1\r\n\r\n");
          //  writer.write("Command: MuteAudio PJSIP/out-00000046 all off \\r\\n\\r\\n");           // channel redirect Channel:PJSIP/out-00000001 [[queue-options,]1,]1
    //    channel redirect <channel> <[[context,]exten,]priority>

         //   Action: ChannelRedirect
         //   Channel: PJSIP/100-00000001      ; The customer's channel
        //    Exten: 100                       ; The original extension (the agent's extension, for example)
       //     Context: default                  ; The original context where the agent is
       //     Priority: 1
            //Action: Hold\r\nChannel: {channel_id}\r\n\r\n
        //    writer.write("Command: core show channels verbose\r\n\r\n");
            //writer.write("Command: originate "+anum+" application dial "+cnum+",30,m(Dialer_moh)\r\n\r\n");
            //originate pjsip/09361598282@out application dial pjsip/09150054994@out,30,m(Dialer_moh)
        //    writer.write("Channel: PJSIP/out-0000000d\r\n\r\n");
            writer.flush();

            // Read response from Asterisk
            String line;
          //  line = reader.readLine();
         //   line = reader.readLine();
      //     line = reader.readLine();
      //      line = reader.readLine();
       //     line = reader.readLine();
      //      line = reader.readLine();
          //  line = reader.readLine();
        //    line = reader.readLine();
            while ((line = reader.readLine()) != "") {
                // Process the response
             //    String line1 = StringUtils.substringBetween(line, " ", " ");
                   System.out.println("Line"+line );
                  // if(line.equalsIgnoreCase(null))
                   s.append(line+",");
               //   String modifiedOutput = line.replace(" ", "\t");
              // String line1 = StringUtils.substringBetween(line, " ", " ");
                //   System.out.println("Line"+line + line1);
                  if(line.equals(""))
                    break;
                   
            }

            anum = s.toString();
         //   if((line = reader.readLine()) != null)
                System.out.println("Close Socket"+s.toString());
            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return anum;
	}
	
/*
	
	public String SplitMethod(String test )
	{
	  String result = "";	
	  String agentid ="6003";
		Map<String, Object> object = new HashMap<>();
		result = AgentData("","6003");
	//  result = "PJSIP/out-00000022!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174004872558^2025-02-20 16:22:07^00919840859543^00000022^6003^/usr/Record/DAILER/February_2025/20/16hrs/174004872558^PREDICTIVE DIALER)!00919840859543!00:02:18!1740048725.58$PJSIP/6003-00000023!!Up!(Outgoing Line)!914469177636!00:02:16!1740048727.59$";
	//  result = "PJSIP/6003-00000023!!Up!(Outgoing Line)!914469177636!00:02:16!1740048727.59$PJSIP/out-00000022!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174004872558^2025-02-20 16:22:07^00919840859543^00000022^6003^/usr/Record/DAILER/February_2025/20/16hrs/174004872558^PREDICTIVE DIALER)!00919840859543!00:02:18!1740048725.58$";  
		//  PJSIP/out-0000001a!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174004534045^2025-02-20 15:25:41^00919840859543^0000001a^6003^/usr/Record/DAILER/February_2025/20/15hrs/174004534045^PREDICTIVE DIALER)!00919840859543!00:00:07!1740045340.45$PJSIP/6003-0000001b!914469177636!Ringing!(Outgoing Line)!914469177636!00:00:06!1740045341.46$
		//  PJSIP/6003-0000001b!914469177636!Ringing!(Outgoing Line)!914469177636!00:00:06!1740045341.46$PJSIP/out-0000001a!914469177636!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^174004534045^2025-02-20 15:25:41^00919840859543^0000001a^6003^/usr/Record/DAILER/February_2025/20/15hrs/174004534045^PREDICTIVE DIALER)!00919840859543!00:00:07!1740045340.45   
	
	//	 result ="PJSIP/6003-00000001!Ringing!(Outgoing Line)!914469177636!00:00:25!1740063009.1$PJSIP/out-00000000!Up!PJSIP/6003,30,gmU(my_gosub_routine_DAILER_PREDICTIVE^17400630080^2025-02-20 20:20:09^00919840859543^00000000^6003^/usr/Record/DAILER/February_2025/20/20hrs/17400630080^PREDICTIVE DIALER)!00919840859543!00:00:26!1740063008.0";

		  
		  if(result.length() >= 5)
		   {
			  			  
			  String[] hexPairs0 = StringUtils.split(StringUtils.trim(result), "$");
			  System.out.println("1"+hexPairs0[0]); 
		//	  System.out.println("2"+hexPairs0[1]); 
			  
			  String[] hexPairs1 = StringUtils.split(StringUtils.trim(hexPairs0[0]), "!");
			  
		//      String[] hexPairs2 = StringUtils.split(StringUtils.trim(hexPairs0[1]), "!");
		      
		      if(StringUtils.substringBefore(hexPairs1[0], "-").equals("PJSIP/"+agentid))
		      {
		  	    System.out.println("yes 1"+hexPairs1[6].isEmpty());
		  	     object.put("DATA", "Part 1");
		  	     object.put("ACTIVE_DATA_1", StringUtils.substringBetween(hexPairs1[0],"PJSIP/", "-"));
		  	     object.put("ACTIVE_DATA_2", hexPairs1[1]); // DDI
				 object.put("ACTIVE_DATA_3", hexPairs1[2]); // Ringing status
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[4]);
				 object.put("ACTIVE_DATA_6", hexPairs1[5]); // DDI
				// if(hexPairs1[5].isEmpty())
				//	 System.out.println("Yes");
				 object.put("ACTIVE_DATA_7", hexPairs1[6]); // DDI
				 object.put("ACTIVE_DATA_8", hexPairs1[0]); // DDI
				 System.out.print("sdf"+StringUtils.remove(hexPairs1[6],"."));
				// String tmp = StringUtils.remove(hexPairs1[6],".");
				// int i = Integer.parseInt(tmp) - 1;
				 //System.out.print("shhdf"+i);
	//			 object.put("ACTIVE_DATA_9",f.FetchCallerID(hexPairs1[6])); // DDI
		/*		 object.put("ACTIVE_DATA_7", hexPairs2[0]);
			     object.put("ACTIVE_DATA_8", hexPairs2[1]);
			     object.put("ACTIVE_DATA_9", hexPairs2[3]);
			     object.put("ACTIVE_DATA_10", hexPairs2[3]);
			     object.put("ACTIVE_DATA_11", hexPairs2[4]);
			     object.put("ACTIVE_DATA_12", hexPairs2[5]);
			 //    object.put("ACTIVE_DATA_13", hexPairs2[6]);
			     // 	object.put("ACTIVE_DATA_17", hexPairs2[6]);
		   }
		      else if(StringUtils.substringBefore(hexPairs0[1], "-").equals("PJSIP/"+agentid))
		      {
		    	  System.out.println("yes 2");
		    	  System.out.println("0 - "+hexPairs1[0]+"\n"+"1 - "+hexPairs1[1]+"\n"+"2 - "+hexPairs1[2]+"\n"+"3 - "+hexPairs1[3]+"\n");
		 		 System.out.println("4 - "+hexPairs1[4]+"\n"+"5 - "+hexPairs1[5]+"\n"+"6 - "+hexPairs1[6]+"\n"+"7 - "+hexPairs1[2]+"\n");
		 	
		    //     object.put("ACTIVE_DATA_11", hexPairs2[0]);
			//		 object.put("ACTIVE_DATA_12", hexPairs2[1]);
			//		 object.put("ACTIVE_DATA_13", hexPairs2[2]);
			//		 object.put("ACTIVE_DATA_14", hexPairs2[3]);
			//		 object.put("ACTIVE_DATA_15", hexPairs2[4]);
			//		 object.put("ACTIVE_DATA_16", hexPairs2[5]);
				//	 object.put("ACTIVE_DATA_17", hexPairs2[6]);
				 
			//  object.put("ACTIVE_DATA_7", hexPairs2[6]);
			  
			     object.put("ACTIVE_DATA_1", hexPairs1[0]);
				 object.put("ACTIVE_DATA_2", hexPairs1[1]);
				 object.put("ACTIVE_DATA_3", hexPairs1[2]);
				 object.put("ACTIVE_DATA_4", hexPairs1[3]); //Ringing
				 object.put("ACTIVE_DATA_5", hexPairs1[4]);
				 object.put("ACTIVE_DATA_6", hexPairs1[5]);
				 object.put("ACTIVE_DATA_7", hexPairs1[6]);
		    	  
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
		  System.out.println(object);
		  return "";
	}
	*/
	
	
	
public String JSONBulid(String JsonObj)
{
	String[] hexPairs1 = null;
	String[] hexPairs2 = null;
	//hexPairs1[4] = "0";

	//System.out.println("Before the conversion: " +hexString);
	//System.out.println("After the conversion: " +StringUtils.trim(resultString));
	//String[] hexPairs1 = StringUtils.split(StringUtils.trim(resultString), "|");
	//System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);

	//logger.info("Application started");
	//logger.debug("Debugging information");
	//logger.error("An error occurred", new RuntimeException("Test error"));
	Map<String, Object> object = new HashMap<>();
	//String res =  f.HoursBySix("");
	System.out.println(JsonObj);
	 hexPairs1 = StringUtils.split(StringUtils.trim(JsonObj), "|");
	 System.out.println("length"+hexPairs1.length);
	 
	 hexPairs2 = StringUtils.split(hexPairs1[0], "-");
	 JSONObject obj1 = new JSONObject(); 
	 obj1.put("Hour", hexPairs2[0]); 
	 obj1.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj1); 
	 
	 hexPairs2 = StringUtils.split(hexPairs1[1], "-");
	 JSONObject obj2 = new JSONObject(); 
	 obj2.put("Hour", hexPairs2[0]); 
	 obj2.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj2); 
	 
	 hexPairs2 = StringUtils.split(hexPairs1[2], "-");
	 JSONObject obj3 = new JSONObject(); 
	 obj3.put("Hour", hexPairs2[0]); 
	 obj3.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj3); 
	 
	 hexPairs2 = StringUtils.split(hexPairs1[3], "-");
	 JSONObject obj4 = new JSONObject(); 
	 obj4.put("Hour", hexPairs2[0]); 
	 obj4.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj4); 
	 
	 hexPairs2 = StringUtils.split(hexPairs1[4], "-");
	 JSONObject obj5 = new JSONObject(); 
	 obj5.put("Hour", hexPairs2[0]); 
	 obj5.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj5); 
	 
	 hexPairs2 = StringUtils.split(hexPairs1[5], "-");
	 JSONObject obj6 = new JSONObject(); 
	 obj6.put("Hour", hexPairs2[0]); 
	 obj6.put("Count",hexPairs2[1]); 
	 jsonArray.put(obj6); 
	   //StringUtils.appendIfMissing(
	   //System.out.println(jsonArray.toString());
	//System.out.println(hexPairs1[0] + hexPairs1[1] + hexPairs1[2]+ hexPairs1[3]+ hexPairs1[4]);// + hexPairs1[5]);
	//ci.setVAR_ACTIVECHANNELS(hexPairs1[0]);
	//ci.setVAR_ACTIVECALLS(hexPairs1[1]);
	//ci.setVAR_TOTALCALLS(hexPairs1[2]);

	  //object.put("HOURS", hexPairs1[0]);
	  //object.put("COUNT", hexPairs1[1]);
	  
	  
	  // Add data to the JSONArray 
		/*
		 * JSONObject obj1 = new JSONObject(); obj1.put("Hour", "11"); obj1.put("Count",
		 * "302"); jsonArray.put(obj1);
		 * 
		 * 
		 * 
		 * JSONObject obj2 = new JSONObject(); obj2.put("Hour", "12"); obj2.put("Count",
		 * "30"); jsonArray.put(obj2);
		 */

	 
	  
	  //object.put("TOTAL_CALLS", hexPairs1[2]);
	  System.out.println(jsonArray.toString());

	
	
	return jsonArray.toString();
}


public String JSONBulid1(String JsonObj,String convID)
{
	String[] hexPairs1 = null;
	String[] hexPairs2 = null;
	//hexPairs1[4] = "0";
	JsonObj = "Success|Success1";
	//System.out.println("Before the conversion: " +hexString);
	//System.out.println("After the conversion: " +StringUtils.trim(resultString));
	//String[] hexPairs1 = StringUtils.split(StringUtils.trim(resultString), "|");
	//System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);

	//logger.info("Application started");
	//logger.debug("Debugging information");
	//logger.error("An error occurred", new RuntimeException("Test error"));
	Map<String, Object> object = new HashMap<>();
	//String res =  f.HoursBySix("");
	System.out.println(JsonObj);
	 hexPairs1 = StringUtils.split(StringUtils.trim(JsonObj), "|");
	 System.out.println("length"+hexPairs1.length);
	 
	 //hexPairs2 = StringUtils.split(hexPairs1[0], "-");
	 JSONObject obj1 = new JSONObject(); 
	 obj1.put("id",convID); 
	 obj1.put("Status", hexPairs1[0]); 
	
	 jsonArray.put(obj1); 
	 
	 //hexPairs2 = StringUtils.split(hexPairs1[1], "-");
	 JSONObject obj2 = new JSONObject(); 
	 obj2.put("id",convID); 
	 obj2.put("Hour", hexPairs1[1]); 
	 
	 jsonArray.put(obj2); 
	 
	
	 
	  
	  //object.put("TOTAL_CALLS", hexPairs1[2]);
	  System.out.println(jsonArray.toString());

	
	
	return jsonArray.toString();
}

public String JsonConst(String jsonObj)
{
	// JSON data with nested objects
    String jsonString = "{\r\n"
    		+ "    \"id\": \"1744272214.23\",\r\n"
    		+ "    \"name\": \"PJSIP/6003-0000000d\",\r\n"
    		+ "    \"state\": \"Up\",\r\n"
    		+ "    \"protocol_id\": \"d5691b50-25f8-405f-a029-2d58ed2d275b\",\r\n"
    		+ "    \"caller\": {\r\n"
    		+ "        \"name\": \"\",\r\n"
    		+ "        \"number\": \"2727\"\r\n"
    		+ "    },\r\n"
    		+ "    \"connected\": {\r\n"
    		+ "        \"name\": \"6001\",\r\n"
    		+ "        \"number\": \"6001\"\r\n"
    		+ "    },\r\n"
    		+ "    \"accountcode\": \"\",\r\n"
    		+ "    \"dialplan\": {\r\n"
    		+ "        \"context\": \"from-interval\",\r\n"
    		+ "        \"exten\": \"00914469177640\",\r\n"
    		+ "        \"priority\": 1,\r\n"
    		+ "        \"app_name\": \"AppQueue\",\r\n"
    		+ "        \"app_data\": \"(Outgoing Line)\"\r\n"
    		+ "    },\r\n"
    		+ "    \"creationtime\": \"2025-04-10T13:33:34.390+0530\",\r\n"
    		+ "    \"language\": \"en\"\r\n"
    		+ "}";
    
    String JsonString = "{\r\n"
    		+ "    \"id\": \"f3a3760e-8888-4542-b369-a215e0ba7df7\",\r\n"
    		+ "    \"technology\": \"simple_bridge\",\r\n"
    		+ "    \"bridge_type\": \"mixing\",\r\n"
    		+ "    \"bridge_class\": \"basic\",\r\n"
    		+ "    \"creator\": \"\",\r\n"
    		+ "    \"name\": \"\",\r\n"
    		+ "    \"channels\": [\r\n"
    		+ "        \"1745571574.134\",\r\n"
    		+ "        \"1745571575.135\"\r\n"
    		+ "    ],\r\n"
    		+ "    \"creationtime\": \"2025-04-25T14:29:39.843+0530\",\r\n"
    		+ "    \"video_mode\": \"none\"\r\n"
    		+ "}";

    // Create a JsonReader from the string
 //   JsonReader reader = Json.createReader(new StringReader(jsonString));

    // Parse the JSON string into a JsonObject
  //  JsonObject userObject = reader.readObject();
    JSONObject jsonObject = new JSONObject(JsonString);
    // Access nested fields
    String name = jsonObject.getString("name");
    System.out.println("Name: " + name);
   JSONObject coderollsJSONObject = new JSONObject(JsonString);
 //   JSONArray arr = new JSONArray(JsonString);
   JSONArray employeesJSONArray = coderollsJSONObject.getJSONArray("channels");
    System.out.println("Printing the employees JSON array: \n"+employeesJSONArray.toString()+"\n");
  //  JSONObject employeeJSONObject = employeesJSONArray.getJSONObject(0);
    System.out.println("Name: " + employeesJSONArray.getString (0));
  //  int age = userObject.getInt("age");
  ///  JsonObject addressObject = userObject.getJsonObject("address");
  //  String city = addressObject.getString("city");
  //  String zipcode = addressObject.getString("zipcode");

    // Output values
  
  //  System.out.println("Age: " + age);
 //   System.out.println("City: " + city);
 //   System.out.println("Zipcode: " + zipcode);

  //  reader.close();

 return "";
}
public String getchannelNum(String jsString)
{
	 String resString = "";
	
	 JSONObject coderollsJSONObject = new JSONObject(jsString);
	 //   JSONArray arr = new JSONArray(JsonString);
	 JSONArray eJSONArray = coderollsJSONObject.getJSONArray("channels");
	    System.out.println("Printing the employees JSON array: \n"+eJSONArray.toString()+"\n");
	  //  JSONObject employeeJSONObject = employeesJSONArray.getJSONObject(0);
	    System.out.println("Name: " + eJSONArray.getString (0));
	    resString = eJSONArray.getString(0)+"!"+eJSONArray.getString(1);
	
	return resString;
}
public static void main(String args[])
{
	CallFunction cf = new CallFunction();
	//System.out.println(cf.JSONBulid1(""));
	//System.out.println(cf.AgentData("","6003"));
	//System.out.println(cf.SplitMethod(""));
//	System.out.println(cf.TestStatus("", ""));
//	System.out.println(cf.JsonConst(""));
	System.out.println(cf.calldetail(""));
}
}
