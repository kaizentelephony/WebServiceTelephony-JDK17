package com.logging;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DirectIO {
    private static final File TEMP_DIRECTORY = new File("C:/VoizBuzz/Logs/HTTP");
    Date currentDate = new java.util.Date(System.currentTimeMillis());
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
    LocalTime localTime = LocalTime.now();
    String format = "dd-MM-yyyy";
    DateFormat dateFormatter = new SimpleDateFormat(format);
    String  parentDIR = dateFormatter.format(currentDate);
    String childDIR =dtf.format(localTime);
	public String directoryCreation()
	{
		 File newDirectory = new File(TEMP_DIRECTORY, parentDIR);
		 File nestedDirectory = new File(newDirectory, childDIR);
	        if(newDirectory.exists())
	        {
	        	   System.out.println(("directoriesCreated 1"));
	        	   assertTrue(newDirectory.exists());
	        	
	        	if(nestedDirectory.exists())
	        	{
	        		   assertTrue(nestedDirectory.exists());
	        		   System.out.println(("directoriesCreated 2" ));
	        	}
	        	else
	        	{
	        		 assertFalse(nestedDirectory.exists());
	        		 boolean directoriesCreated = nestedDirectory.mkdirs();
	        		   System.out.println(("directoriesCreated 3"));
	        	}
	        }
	        else
	        {
	          assertFalse(newDirectory.exists());
	          newDirectory.mkdir();
	          System.out.println(("directoriesCreated 4"));
	        }
	   /*    File nestedDirectory = new File(newDirectory, "nested_directory");
	       	assertTrue(newDirectory.exists());
	       assertFalse(nestedDirectory.exists());

	        boolean directoriesCreated = nestedDirectory.mkdirs();
	    */
	        System.out.println(("directoriesCreated 5"+TEMP_DIRECTORY+"\\"+parentDIR+"\\"+childDIR));
		return TEMP_DIRECTORY+"\\"+parentDIR+"\\"+childDIR;
	}
  public static void main(String args[])
	{
	   DirectIO  io = new DirectIO();
	   System.out.println(io.directoryCreation());
	}
}
