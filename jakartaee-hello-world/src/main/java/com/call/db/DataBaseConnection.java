
package com.call.db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;





/**
 *
 * @author lbit
 */
public class DataBaseConnection {
    private static String db_Host="";
    private static String db_Port="";
    private static String db_Database="";
    private static String db_User="";
    private static String db_Password="";
    private static String db_Sqlpath="";
 // private static org.apache.log4j.Logger log = Logger.getLogger(DataBaseConnection.class);
    public Connection con;
// LogWriter logger = new LogWriter();
    public static void main(String args[])
    {
        DataBaseConnection d = new DataBaseConnection();
        d.db_Connect();
    }
    
 public void db_Connect()
    {
        try
           {
                Properties pro = new Properties();
                FileInputStream in = new FileInputStream("C:/VoizBuzz/config.properties");
                pro.load(in);
                db_Host         = pro.getProperty("DB_HOST");
                db_Port         = pro.getProperty("DB_PORT");
                db_Database     = pro.getProperty("DATABASE");
                db_User         = pro.getProperty("DB_USER");
                db_Password     = pro.getProperty("DB_PASSWORD");
                
              /*  db_Host         = "53.88.75.108";
                db_Port         = "1433";
                db_Database     = "Benz_DB";
                db_User         = "sa";
                db_Password     = "Muruga@275";*/
                System.out.println();
                try
                    {
                        
                        
                  /*      
                         logger.WriteDebugMode("jdbc:mysql://"+db_Host+":"+db_Port+"/"+db_Database+db_User+db_Password);
                        Class.forName("com.mysql.jdbc.Driver");
                        con = (Connection) DriverManager.getConnection("jdbc:mysql://"+db_Host+":"+db_Port+"/"+db_Database,db_User,db_Password);
                      
                      */ 
                         //log.debug("jdbc:mysql://"+db_Host+":"+db_Port+"/"+db_Database+db_User+db_Password);
                        
                        
                     
                       
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = (Connection) DriverManager.getConnection("jdbc:sqlserver://"+db_Host+":"+db_Port+";user="+db_User+";password="+db_Password+";database="+db_Database);
                      
                    
                       
//                        logger.WriteDebugMode("connection success");
                        System.out.println("Success");
                    }
                catch(Exception e)
                    {
                     //   logger.WriteDebugMode("connection error"+e.getMessage());
                        System.out.println("error"+e.getMessage());
                    }
           }
        catch(Exception e)
           {
                //    logger.WriteDebugMode("db configuration error"+e.getMessage());
           }

    }
 
 
 public void Sqlite_db()
{
    
    //Connection c = null;
    try {
        Properties pro = new Properties();
                FileInputStream in = new FileInputStream("D:/BioVoiceWebService/config.properties");
                pro.load(in);
                db_Sqlpath         = pro.getProperty("SQLPATH");
              //  log.debug(db_Sqlpath+"/db.sqlite");
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:"+db_Sqlpath+"/db.sqlite");
      con.setAutoCommit(false);
     // log.debug("sqlite db connected");
     
    } catch ( Exception e ) 
    {
     //   log.debug("sqlite db conn failed");
    //  System.err.println(e.getClass().getName() + ": " + e.getMessage());
    //  System.exit(0);
    }
  
  
    
    
}

 
 
 
 public void close_Conn()
 {
     try
     {
         con.close();
     }
     catch(Exception e)
     {
     }
     }
 }


