package com.call.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;


import org.apache.commons.lang3.StringUtils;

import com.bean.entity.CallRecord;
//import com.beans.Enrollment;

//import com.bean.entity;

public class FetchData {
	DataBaseConnection db = new DataBaseConnection();
	String Qry = "";
	String Qryupdate = "";
	String Result = "";
	int DeToHex;
	StringBuilder sb = new StringBuilder();
	
	public String TotalAgent()
    {
        try
       {
             db.db_Connect();
            Qry="select Count(*) as cnt from TBL_AGENT"; 
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	public String Sales()
    {
        try
       {
             db.db_Connect();
            Qry="select count(*) as cnt from t_sysagent where acds = 'A001'";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	public String Product()
    {
        try
       {
             db.db_Connect();
            Qry="select count(*) as cnt from t_sysagent where acds = 'A002'";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
  
	public String Market()
    {
        try
       {
             db.db_Connect();
            Qry="select count(*) as cnt from t_sysagent where acds = 'A003'";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalCalls()
    {
        try
       {
             db.db_Connect();
          //  Qry="select count(*) as cnt from t_agentstatusrecord";
             Qry = "select count(*) as cnt from TBL_CALL_DETAILS where  VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())  ";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalCallsInByHour()
    {
        try
       {
             db.db_Connect();
          //  Qry="select count(*) as cnt from t_agentstatusrecord";
             Qry = "select count(*) as cnt from TBL_CALL_DETAILS where VAR_CALLED_DATE > DATEADD(HOUR, -1, GETDATE()) and var_type = 'INBOUND' ";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalCallsOutByHour()
    {
        try
       {
             db.db_Connect();
          //  Qry="select count(*) as cnt from t_agentstatusrecord";
             Qry = "select count(*) as cnt from TBL_CALL_DETAILS where VAR_CALLED_DATE > DATEADD(HOUR, -1, GETDATE()) and var_type = 'OUTBOUND' ";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
          
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalCallsByProgress()
    {
        try
       {
             db.db_Connect();
          //  Qry="select count(*) as cnt from t_agentstatusrecord";
             Qry = "select count(*) as cnt from tbl_call_details  where var_disconnect_trace = 'PROGRESS' ";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
          
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	public String TotalCallsInByProgress()
    {
        try
       {
             db.db_Connect();
          //  Qry="select count(*) as cnt from t_agentstatusrecord";
             Qry = "select count(*) as cnt from T_AgentStatusRecord where agtstatus = 0 and mydomain='IN'";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
          
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	public String TotalCallsOutByProgress()
    {
        try
       {
             db.db_Connect();
             Qry = "select count(*) as cnt from T_AgentStatusRecord where DialOutFlag ='2' and MyDomain = 'OUT'";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
          
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	
	public String AgentIdle()
    {
        try
       {
             db.db_Connect();
            Qry="select count(*) as cnt from t_sysagent where loginstatus = 0";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
  
	public String AgentBusy()
    {
        try
       {
             db.db_Connect();
            Qry="select count(*) as cnt from t_sysagent where loginstatus = 1";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	
	public String TotalInboundCalls()
    {
        try
       {
             db.db_Connect();
             Qry= "select count(*) as cnt from TBL_CALL_DETAILS where VAR_TYPE='INBOUND' and  VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalOutboundCalls()
    {
        try
       {
             db.db_Connect();
             Qry="select count(*) as cnt from TBL_CALL_DETAILS where VAR_TYPE='OUTBOUND' and  VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	
	public String TotalConnectedCalls()
    {
        try
       {
             db.db_Connect();
             Qry="select count(*) as cnt from TBL_TRANSFER where VAR_STATUS='CONNECTED' and VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())"; 
             Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    } 
	public String TotalSales()
    {
        try
       {
             db.db_Connect();
           Qry ="select count(*) as cnt from TBL_TRANSFER where VAR_DISCONNECT_TRACE = 'SALES TEAM SELECTION' and VAR_STATUS='CONNECTED' and VAR_VDN_SERVICE='INBOUND' and VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";
           	Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    }
	
	public String TotalProduct()
    {
        try
       {
             db.db_Connect();
           Qry ="select count(*) as cnt from TBL_TRANSFER where VAR_DISCONNECT_TRACE = 'PRODUCT TEAM SELECTION' and VAR_STATUS='CONNECTED' and VAR_VDN_SERVICE='INBOUND' and VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";
            Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    }
	

	public String TotalMarketing()
    {
        try
       {
             db.db_Connect();
           Qry ="select count(*) as cnt from TBL_TRANSFER where VAR_DISCONNECT_TRACE = 'MARKETING TEAM SELECTION' and VAR_STATUS='CONNECTED' and VAR_VDN_SERVICE='INBOUND' and VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";

           	 Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    }
	
	public String TotalAgentMakeCallsConnected()
    {
        try
       {
             db.db_Connect();
           Qry ="select count(*) as cnt from TBL_TRANSFER where VAR_STATUS='CONNECTED' and VAR_VDN_SERVICE='OUTBOUND' and VAR_CALLED_DATE > DATEADD(DAY, -1, GETDATE())";
           	 Statement st = db.con.createStatement();
             ResultSet rs = st.executeQuery(Qry);
            if(rs.next())
            {
               // Result= rs.getString("BVP_ID");
                Result= rs.getString("cnt");
            }
            
               rs.close();
               st.close();
               
                
           

   // call executeUpdate to execute our sql update statement
   
   
      
       }
       catch(Exception e)
       {
           Result = "Error"+e.getMessage();
       }
         db.close_Conn();
          
       return Result;
    }
	
	 public String enrollmentInsert(String var_mob,String var_uniqueId,String var_filePath,String status)
     {
		 
		 //private String var_mob;
		    //private String var_uniqueId;
		   // private String var_filePath;
		    
         try
        {
            db.db_Connect();
            Qry = "insert into VAR_ENROLLMENT(var_cust_mob,var_Uniqueid,File_path)values(?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
            ps.setString(1, var_mob);
            ps.setString(2, var_uniqueId);
            ps.setString(3, var_filePath);
          //  ps.setString(4, status);
            ps.executeUpdate();
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
        //   logger.WriteDebugMode(Result);
        return Result;
     } 
	
	 public String tbl_callDetail(CallRecord em)
     {
		 //System.out.println(enroll.getVar_dnis());
		 
		 //private String var_mob;
		    //private String var_uniqueId;
		   // private String var_filePath;
		 //java.sql.Timestamp sqlTS = new java.sql.Timestamp(em.getVar_calledDate());
		 
		// String strDate = em.getVar_calledDate();
		// String reformattedStr="";
		 /*
		 * To convert String to java.sql.Date, use
		 * Date (long date) constructor.
		 * 
		 * It creates java.sql.Date object from the milliseconds provided.
		 */
		 
		 //first convert string to java.util.Date object using SimpleDateFormat
			/*
			 * try { System.out.println("Welcome "); SimpleDateFormat fromUser = new
			 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); SimpleDateFormat myFormat = new
			 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // SimpleDateFormat myFormat =
			 * new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); reformattedStr =
			 * myFormat.format(fromUser.parse(em.getVar_calledDate()+" "+em.getVar_startTime
			 * ())); // reformattedStr =
			 * myFormat.format(fromUser.parse(em.getVar_calledDate()));
			 * System.out.println(reformattedStr); } catch(Exception w) {
			 * System.out.println(w.getMessage()); }
			 */
		 
         try
        {
            db.db_Connect();
            Qry = "insert into VAR_CALL_DETAILS(VAR_CALLER_ID,VAR_UNIQUE_ID,VAR_CALLED_DATE,VAR_CALL_START_TIME,VAR_DURATION,VAR_DNIS,VAR_CHANNEL_ID,VAR_REGISTERED_STATUS,var_language)values(?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
			
			  ps.setString(1,em.getVar_mob() ); 
			  ps.setString(2,em.getVar_uniqueId());
			  ps.setString(3,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVar_calledDate(),em.getVar_startTime()));
			  ps.setString(4,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVar_calledDate(),em.getVar_startTime()));
			  ps.setString(5,em.getVar_duration()); 
			  ps.setString(6,em.getVar_dnis() );
			  DeToHex = Integer.parseInt(StringUtils.right(em.getVar_channelNo(), 8),16);  
			  //int decimal=Integer.parseInt(StringUtils.right(listelement[0], 8),16);  
			 ps.setString(7,String.valueOf(DeToHex));
			 ps.setString(8,em.getVar_registeredStatus() );
			 ps.setString(9,em.getVar_language()); ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	 
	 public String tbl_callDetail_update(CallRecord em)
     {
		 
		 
         try
        {
            db.db_Connect();
            Qry = "update var_call_details set var_call_end_time=? where var_unique_id=?";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
            ps.setString(1,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVar_calledDate(),em.getVar_endTime()));
			ps.setString(2,em.getVar_uniqueId());
			 ps.executeUpdate();
			  
			  
			 
			 Qryupdate = "update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id=?";
			 PreparedStatement ps1 = db.con.prepareStatement(Qryupdate);
			 ps1.setString(1,em.getVar_uniqueId());
			 ps1.executeUpdate();
			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
            ps1.close();
            Result = "Success";
            
            
            //update VAR_ENROLLMENT set Flag='1', VAR_CALL_STATUS='{Agent_Status}', var_end_time='{Call_End_Time}',VAR_AGENT_VDN='{IVR_VDN}' where var_Uniqueid='{Unique_Id}' and var_file='1' 
            
			 Qryupdate = "update VAR_ENROLLMENT set Flag='1', VAR_CALL_STATUS=?, var_end_time=? where var_Uniqueid=?";
			 PreparedStatement ps2 = db.con.prepareStatement(Qryupdate);
			 ps2.setString(1,em.getVar_callstatus());
			 ps2.setString(2, dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVar_calledDate(),em.getVar_patchendtime()));
			 ps2.setString(3,em.getVar_uniqueId());
			 ps2.executeUpdate();
			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
           ps2.close();
           Result = "Success";
           
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 public String tbl_enrollment(CallRecord em)
     {
		 	 
         try
        {
        	 System.out.println("Enrollment");
            db.db_Connect();
            //insert into VAR_ENROLLMENT(var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file,process_flag)       
            Qry = "insert into VAR_ENROLLMENT(var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file,process_flag,sftp_flag,var_call_status)values(?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
			
			  ps.setString(1,em.getVar_mob() ); 
			  ps.setString(2,em.getVar_uniqueId());
			  ps.setString(3,em.getVar_language());
			  ps.setString(4,"0");
			  ps.setString(5,em.getVar_filepath());
			  ps.setString(6, em.getVar_file());
			  ps.setString(7, em.getVar_proc_flag());
			  ps.setString(8,"0");
			  ps.setString(9,em.getVar_callstatus());
			    /*
			     * 
				 * ps.setString(3,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVar_calledDate(
				 * ),em.getVar_startTime()));
				 * ps.setString(4,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS"
				 * ,em.getVar_calledDate(),em.getVar_startTime()));
				 * ps.setString(5,em.getVar_duration()); ps.setString(6,em.getVar_dnis() );
				 * ps.setString(7,em.getVar_channelNo());
				 * ps.setString(8,em.getVar_registeredStatus() );
				 * ps.setString(9,em.getVar_language());
				 */
			  ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	 //insert into VAR_VERIFICATION (var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file)
	 

	 public String tbl_verification(CallRecord em)
     {
		 	 
         try
        {
        	 System.out.println("Verification");
            db.db_Connect();
            //insert into VAR_ENROLLMENT(var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file,process_flag)       
            Qry = "insert into VAR_VERIFICATION(var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file)values(?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
              ps.setString(1,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVar_calledDate(),""));
			  ps.setString(2,em.getVar_mob() ); 
			  ps.setString(3,em.getVar_uniqueId());
			  ps.setString(4,em.getVar_language());
			  ps.setString(5,"0");
			  ps.setString(6,em.getVar_filepath());
			  ps.setString(7, em.getVar_file());
			  //ps.setString(7, em.getVar_proc_flag());
			    /*
			     * 
				 * ps.setString(3,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVar_calledDate(
				 * ),em.getVar_startTime()));
				 * ps.setString(4,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS"
				 * ,em.getVar_calledDate(),em.getVar_startTime()));
				 * ps.setString(5,em.getVar_duration()); ps.setString(6,em.getVar_dnis() );
				 * ps.setString(7,em.getVar_channelNo());
				 * ps.setString(8,em.getVar_registeredStatus() );
				 * ps.setString(9,em.getVar_language());
				 */
			  ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	 
	 
	 
	 public String tbl_agentdetails(CallRecord em)
     {
		 	 
         try
        {
        	 System.out.println("Agent details");
            db.db_Connect();
            
            //Insert into VAR_AGENT_DETAILS (var_caller_id, var_patch_start_time,var_VDN,var_unique_id)
            //insert into VAR_ENROLLMENT(var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file,process_flag)       
            Qry = "insert into VAR_AGENT_DETAILS(var_caller_id,var_unique_id,var_patch_start_time,var_VDN)values(?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
			
			  ps.setString(1,em.getVar_mob() ); 
			  ps.setString(2,em.getVar_uniqueId());
			  ps.setString(3,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVar_calledDate(),em.getVar_patchstarttime()));
			  ps.setString(4,em.getVar_vdn());
			
			    /*
			     * 
				 * ps.setString(3,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVar_calledDate(
				 * ),em.getVar_startTime()));
				 * ps.setString(4,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS"
				 * ,em.getVar_calledDate(),em.getVar_startTime()));
				 * ps.setString(5,em.getVar_duration()); ps.setString(6,em.getVar_dnis() );
				 * ps.setString(7,em.getVar_channelNo());
				 * ps.setString(8,em.getVar_registeredStatus() );
				 * ps.setString(9,em.getVar_language());
				 */
			  ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	 public String agentstatus()
	    {
	        try
	       {
	             db.db_Connect();
	           Qry ="SELECT TOP 1 VAR_AGENT_VDN FROM VAR_AGENTS WHERE VAR_AGENT_STATUS IS NULL OR VAR_AGENT_STATUS='0'";
	           	 Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	            if(rs.next())
	            {
	               // Result= rs.getString("BVP_ID");
	                Result= rs.getString("VAR_AGENT_VDN");
	                System.out.println(Result);
	            }
	            else
	            {
	            	Result= "NODATA";
	            }
	            
	               rs.close();
	               st.close();
	               
	             //  UPDATE VAR_AGENTS SET VAR_AGENT_STATUS='1' WHERE VAR_AGENT_VDN='{IVR_VDN}'    
	           

	   // call executeUpdate to execute our sql update statement
	              Qryupdate = "UPDATE VAR_AGENTS SET VAR_AGENT_STATUS='1' WHERE VAR_AGENT_VDN=?";
	  			 PreparedStatement ps = db.con.prepareStatement(Qryupdate);
	  			 ps.setString(1,Result);
	  			 ps.executeUpdate();
	  			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
	              ps.close();
	             // Result = "Success";
	   
	      
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	
	 
	 public String agentupdate(String id)
	    {
	        try
	       {
	             db.db_Connect();
	          

	   // call executeUpdate to execute our sql update statement
	              Qryupdate = "UPDATE VAR_AGENTS SET VAR_AGENT_STATUS='0' WHERE VAR_AGENT_VDN=?";
	  			 PreparedStatement ps = db.con.prepareStatement(Qryupdate);
	  			 ps.setString(1,id);
	  			 ps.executeUpdate();
	  			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
	              ps.close();
	             Result = "Success";
	   
	      
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
//////////////////////////////// ------- BENZ --------  --------------///////
	 
	 public String TBL_CallLogging(CallRecord em)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_CALLDETAILS(VAR_CALLERID,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_CONVERSATIONID,VAR_CALLED_DATE,VAR_CALL_START_TIME,VAR_DNIS,VAR_CHANNELID,VAR_REGISTEREDSTATUS,var_language,VAR_REGISTERED_NUMBER)values(?,?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
			if(em.getVAR_CALLERID()!=null)
			  ps.setString(1,em.getVAR_CALLERID() ); 
			if(em.getVAR_UNIQUEID()!=null)
			  ps.setString(2,em.getVAR_UNIQUEID());
			if(em.getVAR_CONTRACTNO().equals("NODATA"))
			{ 
				String temp = hexToText("003131313131313131207c2064386235303233302d393932372d346138632d616234622d373435303061303531396237;encoding=hex;purpose=isdn-uui;content=isdn-uui");
				String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
				System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
				//hexToText(Qry)
			  ps.setString(3,hexPairs1[0]);
			  ps.setString(4,hexPairs1[1]);
				
			}
			else
			{

				String temp = hexToText(em.getVAR_CONTRACTNO());
				String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
				System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
				//hexToText(Qry)
			  ps.setString(3,"");
			  ps.setString(4,hexPairs1[1]);
			  ps.setString(11,hexPairs1[0]);
			}
			//if(em.getVAR_CONVERSATIONID()!=null)
			 // ps.setString(4,em.getVAR_CONVERSATIONID());
			if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			  //ps.setString(5,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
				  ps.setString(5,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
			if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			  ps.setString(6,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
			if(em.getVAR_DNIS()!=null)
			  ps.setString(7,em.getVAR_DNIS() );
			if(em.getVAR_CHANNELID()!=null)   
			 { 
				DeToHex = Integer.parseInt(StringUtils.right(em.getVAR_CHANNELID(), 8),16);  
			   //int decimal=Integer.parseInt(StringUtils.right(listelement[0], 8),16);  
			    ps.setString(8,String.valueOf(DeToHex));
			 }
			if(em.getVAR_REGISTEREDSTATUS()!=null)   
			  ps.setString(9,em.getVAR_REGISTEREDSTATUS() );
			if(em.getVAR_LANAGUAGE()!=null)   
			   ps.setString(10,em.getVAR_LANAGUAGE());
			//if(em.getVAR_REGISTERED_NUMBER()!=null)
			//	ps.setString(11,em.getVAR_REGISTERED_NUMBER());
			 ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	
	 public String TBL_TransferLogging(CallRecord em)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_TRANSFERDETAILS(VAR_CALLERID,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_CONVERSATIONID,VAR_CALLED_DATE,VAR_PATCH_START_TIME,VAR_TRANSFERVDN,VAR_CHANNELID,VAR_TRANSFERSTATUS,VAR_VOICEPRINT)values(?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
            if(em.getVAR_CALLERID()!=null)
			  ps.setString(1,em.getVAR_CALLERID() ); 
            if(em.getVAR_UNIQUEID()!=null)
			  ps.setString(2,em.getVAR_UNIQUEID());
            if(em.getVAR_CONTRACTNO()!=null)
			  ps.setString(3,em.getVAR_CONTRACTNO());
            if(em.getVAR_CONVERSATIONID()!=null)
			  ps.setString(4,em.getVAR_CONVERSATIONID());
            if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			  ps.setString(5,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
            if(em.getVAR_CALLED_DATE()!=null && em.getVAR_PATCH_START_TIME()!=null)
			  ps.setString(6,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_PATCH_START_TIME()));
            if(em.getVAR_TRANSFERVDN()!=null)
			  ps.setString(7,em.getVAR_TRANSFERVDN() );
            if(em.getVAR_CHANNELID()!=null)   
			 { 
			  DeToHex = Integer.parseInt(StringUtils.right(em.getVAR_CHANNELID(), 8),16);  
			  //int decimal=Integer.parseInt(StringUtils.right(listelement[0], 8),16);  
			  ps.setString(8,String.valueOf(DeToHex));
			 }
            if(em.getVAR_TRANSFERSTATUS()!=null)   
			 ps.setString(9,em.getVAR_TRANSFERSTATUS());
           // VAR_VOICEPRINT
            if(em.getVAR_VOICEPRINT()!=null)   
   			 ps.setString(10,em.getVAR_VOICEPRINT());
			// ps.setString(10,em.getVar_language());
			 ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 
	 public String tbl_updateinfo(CallRecord em)
     {
		 String QryUpdate1 = "";
		 String QryUpdate2 = "";
		 String QryUpdate3 = "";
		 String QryUpdate4 = "";
		 String QryUpdate5 = "";
         try
        {
            db.db_Connect();
            Qry = "update TBL_CALLDETAILS set VAR_CALL_END_TIME=? where VAR_UNIQUEID=?";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
            ps.setString(1,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_END_TIME()));
			ps.setString(2,em.getVAR_UNIQUEID());
			ps.executeUpdate();
			ps.close(); 
			  
			 
			QryUpdate1 = "update TBL_CALLDETAILS set VAR_DURATION=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where VAR_UNIQUEID=?";
			 PreparedStatement ps1 = db.con.prepareStatement(QryUpdate1);
			 ps1.setString(1,em.getVAR_UNIQUEID());
			 ps1.executeUpdate();
			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
            ps1.close();
            Result = "Success";
            
            QryUpdate3 = "update TBL_TRANSFERDETAILS set VAR_PATCH_END_TIME=? where VAR_UNIQUEID=?";     
            PreparedStatement ps3 = db.con.prepareStatement(QryUpdate3);
            ps3.setString(1,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_PATCH_END_TIME()));
			ps3.setString(2,em.getVAR_UNIQUEID());
			ps3.executeUpdate();
			ps3.close();
			//tt
            QryUpdate2 = "update TBL_TRANSFERDETAILS set var_patch_duration=DATEDIFF(SECOND,var_patch_start_time,var_patch_end_time) where VAR_UNIQUEID=?";
			 PreparedStatement ps2 = db.con.prepareStatement(QryUpdate2);
			 ps2.setString(1,em.getVAR_UNIQUEID());
			 ps2.executeUpdate();
			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
           ps2.close();
           
           QryUpdate4 ="update TBL_VERIFICATION set VAR_CALL_END_TIME='"+dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_END_TIME())+"' where VAR_UNIQUEID='"+em.getVAR_UNIQUEID()+"'";
          // QryUpdate4 = "update TBL_VERIFICATION set VAR_CALL_END_TIME=? where VAR_UNIQUEID=?";
           System.out.println("update TBL_VERIFICATION set VAR_CALL_END_TIME="+dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_END_TIME())+" where VAR_UNIQUEID="+em.getVAR_UNIQUEID());
           PreparedStatement ps4 = db.con.prepareStatement(QryUpdate4);
          //  ps4.setString(1,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_END_TIME()));
		//	ps4.setString(2,em.getVAR_UNIQUEID());
			ps4.executeUpdate();
			ps4.close();
           
		/*	 Qry = "update TBL_CALLDETAILS set VAR_CALL_END_TIME=? where VAR_UNIQUEID=?";     
	            PreparedStatement ps = db.con.prepareStatement(Qry);
	            ps.setString(1,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_END_TIME()));
				ps.setString(2,em.getVAR_UNIQUEID());
				ps.executeUpdate();
				ps.close();*/
			QryUpdate5="update TBL_CALLDISCONNECT set VAR_DISCONNECT_TRACE=? where VAR_UNIQUEID=?";
			PreparedStatement ps5=db.con.prepareStatement(QryUpdate5);
			ps5.setString(1, em.getVAR_DISCONNECT_TRACE());
			ps5.setString(2,em.getVAR_UNIQUEID());
			ps5.executeUpdate();
			ps5.close();
			
           Result = "Success";
            //update VAR_ENROLLMENT set Flag='1', VAR_CALL_STATUS='{Agent_Status}', var_end_time='{Call_End_Time}',VAR_AGENT_VDN='{IVR_VDN}' where var_Uniqueid='{Unique_Id}' and var_file='1' 
            
			/* Qryupdate = "update VAR_ENROLLMENT set Flag='1', VAR_CALL_STATUS=?, var_end_time=? where var_Uniqueid=?";
			 PreparedStatement ps2 = db.con.prepareStatement(Qryupdate);
			 ps2.setString(1,em.getVar_callstatus());
			 ps2.setString(2, dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVar_calledDate(),em.getVar_patchendtime()));
			 ps2.setString(3,em.getVar_uniqueId());
			 ps2.executeUpdate();
			 // update VAR_CALL_DETAILS set var_duration=DATEDIFF(SECOND,var_call_start_time,var_call_end_time) where var_unique_id='{Unique_Id}'
           ps2.close();
           Result = "Success";
           */
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
     	// logger.info("Res : "+table + " Operation -"+opr+"-"+res);
        //   logger.WriteDebugMode(Result);
        return Result;
     }

	 public String TBL_Verifyinfo(CallRecord em)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_VERIFICATION(VAR_CALLERID,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_CONVERSATIONID,VAR_CALLED_DATE,VAR_FILEPATH,VAR_FLAG,VAR_PROCESSFLAG,VAR_CALL_STATUS,VAR_VOICEPRINT)values(?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
            if(em.getVAR_CALLERID()!=null)
			  ps.setString(1,em.getVAR_CALLERID() ); 
            if(em.getVAR_UNIQUEID()!=null)
			  ps.setString(2,em.getVAR_UNIQUEID());
            if(em.getVAR_CONTRACTNO()!=null)
			  ps.setString(3,em.getVAR_CONTRACTNO());
            if(em.getVAR_CONVERSATIONID()!=null)
			  ps.setString(4,em.getVAR_CONVERSATIONID());
            if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			//  ps.setString(5,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
            	  ps.setString(5,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
          //  if(em.getVAR_CALLED_DATE()!=null && em.getVAR_PATCH_START_TIME()!=null)
			//  ps.setString(6,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_PATCH_START_TIME()));
            //if(em.getVAR_TRANSFERVDN()!=null)
			  //ps.setString(7,em.getVAR_TRANSFERVDN() );
           // if(em.getVAR_CHANNELID()!=null)   
			 //{ 
			  //DeToHex = Integer.parseInt(StringUtils.right(em.getVAR_CHANNELID(), 8),16);  
			  //int decimal=Integer.parseInt(StringUtils.right(listelement[0], 8),16);  
			  //ps.setString(8,String.valueOf(DeToHex));
			 //}
            //if(em.getVAR_TRANSFERSTATUS()!=null)   
			 //ps.setString(9,em.getVAR_TRANSFERSTATUS());
			// ps.setString(10,em.getVar_language());
            if(em.getVAR_FILEPATH()!=null)
            	ps.setString(6, em.getVAR_FILEPATH());
            //if(em.getVAR_FLAG()!=null)
            ps.setString(7,"0");
            ps.setString(8, "0");
            if(em.getVAR_CALL_STATUS()!=null)
            ps.setString(9,em.getVAR_CALL_STATUS());
            if(em.getVAR_VOICEPRINT()!=null)
				ps.setString(10,em.getVAR_VOICEPRINT());
			 ps.executeUpdate();
	 
		
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 public String TBL_Enrollinfo(CallRecord em)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_ENROLLMENT(VAR_CALLERID,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_CONVERSATIONID,VAR_CALLED_DATE,VAR_BVPSTATUS,VAR_FILEPATH,VAR_VOICEPRINT)values(?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
            if(em.getVAR_CALLERID()!=null)
			  ps.setString(1,em.getVAR_CALLERID() ); 
            if(em.getVAR_UNIQUEID()!=null)
			  ps.setString(2,em.getVAR_UNIQUEID());
            if(em.getVAR_CONTRACTNO()!=null)
			  ps.setString(3,em.getVAR_CONTRACTNO());
            if(em.getVAR_CONVERSATIONID()!=null)
			  ps.setString(4,em.getVAR_CONVERSATIONID());
            if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			//  ps.setString(5,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
            	  ps.setString(5,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
            //if(em.getVAR_CALLED_DATE()!=null && em.getVAR_PATCH_START_TIME()!=null)
			  
  //ps.setString(6,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_PATCH_START_TIME()));
            if(em.getVAR_BVPSTATUS()!=null)
            	ps.setString(6,em.getVAR_BVPSTATUS());
            
            //if(em.getVAR_TRANSFERVDN()!=null)
			  //ps.setString(7,em.getVAR_TRANSFERVDN() );
           // if(em.getVAR_CHANNELID()!=null)   
			 //{ 
			  //DeToHex = Integer.parseInt(StringUtils.right(em.getVAR_CHANNELID(), 8),16);  
			  //int decimal=Integer.parseInt(StringUtils.right(listelement[0], 8),16);  
			  //ps.setString(8,String.valueOf(DeToHex));
			 //}
            //if(em.getVAR_TRANSFERSTATUS()!=null)   
			 //ps.setString(9,em.getVAR_TRANSFERSTATUS());
			// ps.setString(10,em.getVar_language());
            if(em.getVAR_FILEPATH()!=null)
            	ps.setString(7, em.getVAR_FILEPATH());
            if(em.getVAR_VOICEPRINT()!=null)
				ps.setString(8,em.getVAR_VOICEPRINT());
			 ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }
	 public String TBL_CALLDISCONNECT(CallRecord em)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_CALLDISCONNECT(VAR_CALLERID,VAR_FLOW,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_DISCONNECT_TRACE,VAR_VOICEPRINT)values(?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
            
            if(em.getVAR_CALLERID() !=null)
            	ps.setString(1, em.getVAR_CALLERID());
            if(em.getVAR_FLOW() !=null)
            	ps.setString(2, em.getVAR_FLOW());
            if(em.getVAR_UNIQUEID() !=null)
            	ps.setString(3, em.getVAR_UNIQUEID());
            if(em.getVAR_CONTRACTNO() !=null)
            	ps.setString(4, em.getVAR_CONTRACTNO());
            if(em.getVAR_DISCONNECT_TRACE() !=null)
            	ps.setString(5, em.getVAR_DISCONNECT_TRACE());
            if(em.getVAR_VOICEPRINT()!=null)
				ps.setString(6,em.getVAR_VOICEPRINT());
			 ps.executeUpdate();
//			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }

	 public String TBL_verificationLogging(String callerid,String uniqueid,String contractid,String convid,String date,String time,String score,String filePath,String filecount,String voiceprint)
     {
		 
         try
        {
            db.db_Connect();
            Qry = "insert into TBL_VERIFICATION(VAR_CALLERID,VAR_UNIQUEID,VAR_CONTRACTNO,VAR_CONVERSATIONID,VAR_CALLED_DATE,VAR_VERIFICATION_STATUS,VAR_SCORE,VAR_FILEPATH,VAR_FILE,VAR_VOICEPRINT)values(?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement ps = db.con.prepareStatement(Qry);
           // logger.WriteDebugMode("Query"+Qry);
			if(callerid!=null)
			  ps.setString(1,callerid); 
			if(uniqueid!=null)
			  ps.setString(2,uniqueid);
		/*	if(contractid.equals("NODATA"))
			{ 
				String temp = hexToText("003131313131313131207c2064386235303233302d393932372d346138632d616234622d373435303061303531396237;encoding=hex;purpose=isdn-uui;content=isdn-uui");
				String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
				System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
				//hexToText(Qry)
			  ps.setString(3,hexPairs1[0]);
			  ps.setString(4,hexPairs1[1]);
				
			}
			else
			{

				String temp = hexToText(contractid);
				String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
				System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
				//hexToText(Qry)
			  ps.setString(3,hexPairs1[0]);
			  ps.setString(4,hexPairs1[1]);
			} */
			if(contractid!=null)
				ps.setString(3, contractid);
				if(convid!=null)
					ps.setString(4, convid);
			//if(em.getVAR_CONVERSATIONID()!=null)
			 // ps.setString(4,em.getVAR_CONVERSATIONID());
			if(date!=null && time!=null)
			  //ps.setString(5,dateConversion("dd/MM/yyyy","yyyy-MM-dd",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
				  ps.setString(5,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",date,time));
			//if(em.getVAR_CALLED_DATE()!=null && em.getVAR_CALL_START_TIME()!=null)
			//  ps.setString(6,dateConversion("dd/MM/yyyy HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS",em.getVAR_CALLED_DATE(),em.getVAR_CALL_START_TIME()));
			//if(em.getVAR_VERIFICATION_STATUS()!=null)
			  ps.setString(6,"Success");
			if(score!=null)   
			 { 
				ps.setString(7,score);
			 }
			if(filePath!=null)   
			  ps.setString(8,filePath);
			if(filecount!=null)   
				  ps.setString(9,filecount);
			if(voiceprint!=null)
				ps.setString(10, voiceprint);
			 ps.executeUpdate();
			 
            ps.close();
            Result = "Success";
                 
     }
        catch(Exception e)
        {
            Result = "Error"+e.getMessage();
        }
          db.close_Conn();
          System.out.println(Result);
        //   logger.WriteDebugMode(Result);
        return Result;
     }




	 
	 public String enrollstatus(String id)
	    {
	        try
	       {
	             db.db_Connect();
	           Qry ="SELECT var_callerid from tbl_enrollment WHERE var_callerid ='"+id+"'";
	           	 Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	            if(rs.next())
	            {
	               // Result= rs.getString("BVP_ID");
	                Result= "ENROLLED";
	               // System.out.println(Result);
	            }
	            else
	            {
	            	 Result= "NOTENROLLED";
	            }
	            
	               rs.close();
	               st.close();
	               
	             
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	 
	 
	 public String enrollmentstatus(String id)
	    {
	        try
	       {
	             db.db_Connect();
	           Qry ="SELECT VAR_CONTRACTNO from tbl_enrollment WHERE VAR_CONTRACTNO ='"+id+"'";
	           	 Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	            if(rs.next())
	            {
	               // Result= rs.getString("BVP_ID");
	                Result= "ENROLLED";
	               // System.out.println(Result);
	            }
	            else
	            {
	            	 Result= "NOTENROLLED";
	            }
	            
	               rs.close();
	               st.close();
	               
	             
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	
	 
	 public String verificationstatus(String id)
	    {
	        try
	       {
	        	sb.delete(0, sb.length());
	             db.db_Connect();
	           Qry ="SELECT TOP 2 var_score FROM TBL_VERIFICATION WHERE VAR_CONVERSATIONID = '"+id+"'  ORDER BY var_called_date DESC";
	           	 Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	             while(rs.next())
		            {
	            	     
	            	   if(Double.valueOf(rs.getString("score"))>=60)
		            	sb.append("Success"+"|");
	            	   else
	            		sb.append("Failed"+"|");
		            //	System.out.println(rs.getString("count"));
		            //	System.out.println(rs.getString("HOURS")+"-"+rs.getString("CALL_COUNT")+"|");
		               // Result= rs.getString("BVP_ID");
		               
		               // System.out.println(Result);
		            }
	               rs.close();
	               st.close();
	               
	             
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	
	 public String FetchCallerID(String id)
	    {
	        try
	       {
	             db.db_Connect();
	             
	           Qry ="SELECT var_callerid as id from tbl_call_transfer WHERE var_uniqueid_1 ='"+id+"'";
	           System.out.print("sdf"+Qry);	
	           Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	            if(rs.next())
	            {
	               // Result= rs.getString("BVP_ID");
	                Result= rs.getString("id");
	               // System.out.println(Result);
	            }
	            else
	            {
	            	 Result= "NOTFOUND";
	            }
	            
	               rs.close();
	               st.close();
	               
	             
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	 	
	 
	
	 public String HoursBySix(String id)
	    {
		 sb.delete(0, sb.length());
	        try
	       {
	             db.db_Connect();
 Qry ="select DATEPART(HOUR, VAR_CALL_START_TIME) as HOURS,count(*) as CALL_COUNT from TBL_CALLDETAILS where VAR_CALL_START_TIME >= DATEADD(HOUR,-6,GETDATE()) group by DATEPART(HOUR,VAR_CALL_START_TIME) order by HOURS";
	          //   Qry = "select count(*) as count from tbl_calldetails";
	             System.out.println(Qry);          		
	           	 Statement st = db.con.createStatement();
	             ResultSet rs = st.executeQuery(Qry);
	             int i = 0;
	           //  for(int i=0; i<rs.getFetchSize();i++)
	         
	         while(rs.next())
	            {
	            	sb.append(rs.getString("HOURS")+"-"+rs.getString("CALL_COUNT")+"|");
	            //	System.out.println(rs.getString("count"));
	            	System.out.println(rs.getString("HOURS")+"-"+rs.getString("CALL_COUNT")+"|");
	               // Result= rs.getString("BVP_ID");
	                i++;
	               // System.out.println(Result);
	            }
	       //	 System.out.println("size"+i);
	       	 for(int j=0;j<6-i; j++)
	       		 sb.append("0-0|");
	         //   System.out.println("l"+sb.length());
	          /*  else
	            {
	            	//sb.append("NOTEDATA|NOTEDATA);
	            	 sb.append("0|0");
	            }*/
	            
	               rs.close();
	               st.close();
	               Result= sb.toString();   
	             
	       }
	       catch(Exception e)
	       {
	           Result = "Error"+e.getMessage();
	       }
	         db.close_Conn();
	          
	       return Result;
	    }
	
	 
	 
	 
	 public String dateConversion(String usrformat,String appformat,String actualdate,String actualtime)
	 {
		 String result = "";
		 try 
			{
				System.out.println("Welcome ");
				//  User format dd/MM/yyyy HH:mm:ss
				// Application format yyyy-MM-dd HH:mm:ss.SSS
				
		        SimpleDateFormat fromUser = new SimpleDateFormat(usrformat);
		        SimpleDateFormat myFormat = new SimpleDateFormat(appformat);
		      //  SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		        result = myFormat.format(fromUser.parse(actualdate+" "+actualtime));
		       // reformattedStr = myFormat.format(fromUser.parse(em.getVar_calledDate()));
		        System.out.println(result);
			}
			catch(Exception w) 
				{
					System.out.println(w.getMessage());
				} 
		 return result;
	 }
	 public String hexToText(String customFormat)
	 {
			//String customFormat = "003132333435363738207c2030376662333036352d363130352d343538652d613339662d633763393033353036663039;encoding=hex;purpose=isdn-uui;content=isdn-uui";
		//	System.out.println(StringUtils.substringBefore(customFormat, ";encoding=hex"));
			
			String hexString =StringUtils.substringBefore(customFormat, ";encoding=hex");
	        String[] hexPairs = hexString.split("(?<=\\G.{2})");

	StringBuilder resultBuilder = new StringBuilder();
	for (String hexPair : hexPairs) {
	 int decimalValue = Integer.parseInt(hexPair, 16);
	 resultBuilder.append(Character.toChars(decimalValue));
	}

	String resultString = resultBuilder.toString();

	//System.out.println("Before the conversion: " +hexString);
	System.out.println("After the conversion: " +StringUtils.trim(resultString));
return StringUtils.trim(resultString);
	 }
	 public String hexToTextCov(String customFormat)
	 {
			//String customFormat = "003132333435363738207c2030376662333036352d363130352d343538652d613339662d633763393033353036663039;encoding=hex;purpose=isdn-uui;content=isdn-uui";
		//	System.out.println(StringUtils.substringBefore(customFormat, ";encoding=hex"));
			String hexString =StringUtils.substringBefore(customFormat, ";encoding=hex");
	        String[] hexPairs = hexString.split("(?<=\\G.{2})");

	StringBuilder resultBuilder = new StringBuilder();
	for (String hexPair : hexPairs) {
	 int decimalValue = Integer.parseInt(hexPair, 16);
	 resultBuilder.append(Character.toChars(decimalValue));
	}

	String resultString = resultBuilder.toString();

	//System.out.println("Before the conversion: " +hexString);
	System.out.println("After the conversion: " +StringUtils.trim(resultString));
	String temp = StringUtils.trim(resultString);
	String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
	System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
	//hexToText(Qry)
  //ps.setString(3,hexPairs1[0]);
  //ps.setString(4,hexPairs1[1]);
return StringUtils.trim(hexPairs1[0]+"!"+hexPairs1[1]);
	 }
	 
public String AsciiToHex(String ascii)
		{
		
			// Initialize final String
			String hex = "";

			// Make a loop to iterate through
			// every character of ascii string
			for (int i = 0; i < ascii.length(); i++) {

				// take a char from
				// position i of string
				char ch = ascii.charAt(i);

				// cast char to integer and
				// find its ascii value
				int in = (int)ch;

				// change this ascii value
				// integer to hexadecimal value
				String part = Integer.toHexString(in);

				// add this hexadecimal value
				// to final string.
				hex += part;
			}
		
			// return the final string hex
			return hex;
		}

	 
}
