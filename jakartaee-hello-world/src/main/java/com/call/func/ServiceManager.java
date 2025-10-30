package com.call.func;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import com.call.func.ManagerInfo;

public class ServiceManager {
	HttpMethod hmd = new HttpMethod();
	JsonParser jp = new JsonParser();
	//ManagerInfo mi = new ManagerInfo();
	ManagerInfo mi = new ManagerInfo();
	public String HoldOperation(String bridgeid)
	
	{
		String ToGetChName = "";
		String[] hexPairs;
		String GetPrimaryChName = "";
		String GetSecondaryChName = "";
	   try 
	   	    {
		   		// jp.getchannelNum(hmd.getChannelNo(bridgeid));
		   		 hexPairs = StringUtils.split( jp.getchannelNum(hmd.getChannelNo(bridgeid)), "!");
		   		// GetPrimaryChName   = hexPairs[0];
		   		// GetSecondaryChName = hexPairs[1];
		   		GetPrimaryChName   = jp.getPrimaryChName(hmd.getPrimaryChName(hexPairs[0]));
		   		GetSecondaryChName = jp.getSecondaryChName(hmd.getPrimaryChName(hexPairs[1]));
		   		ToGetChName =	mi.Channel_Redirect(GetPrimaryChName, GetSecondaryChName);
		   		ToGetChName = ToGetChName+"!"+GetPrimaryChName+"!"+GetSecondaryChName;
	   	    }
	   catch(Exception e)
	   	{
		   ToGetChName = e.getMessage();
		   ToGetChName = ToGetChName+"!0!"+0;
	   	}
		
		// = hmd.getChannelName(bridgeid);
		return ToGetChName;
	}

public String UnHoldOperation(String PrimaryChName,String SecondaryChName)
	
	{
		String ToGetChName = "";
	//	String[] hexPairs;
	//	String GetPrimaryChName = "";
	//	String GetSecondaryChName = "";
	   try 
	   	    {
		   		// jp.getchannelNum(hmd.getChannelNo(bridgeid));
		   		// hexPairs = StringUtils.split( jp.getchannelNum(hmd.getChannelNo(bridgeid)), "!");
		   		// GetPrimaryChName   = hexPairs[0];
		   		// GetSecondaryChName = hexPairs[1];
		   	//	GetPrimaryChName   = jp.getPrimaryChName(hmd.getPrimaryChName(hexPairs[0]));
		   	//	GetSecondaryChName = jp.getSecondaryChName(hmd.getPrimaryChName(hexPairs[1]));
		   		ToGetChName =	mi.Channel_Bridges(PrimaryChName, SecondaryChName);
	   		}
	   catch(Exception e)
	   	{
		   ToGetChName = e.getMessage();
	   	}
		
		// = hmd.getChannelName(bridgeid);
		return ToGetChName;
	}
public String ChannelSpy(String SupervisorNo ,String AgentNo)

{
	String ToGetChName = "";
//	String[] hexPairs;
//	String GetPrimaryChName = "";
//	String GetSecondaryChName = "";
   try 
   	    {
	   		// jp.getchannelNum(hmd.getChannelNo(bridgeid));
	   		// hexPairs = StringUtils.split( jp.getchannelNum(hmd.getChannelNo(bridgeid)), "!");
	   		// GetPrimaryChName   = hexPairs[0];
	   		// GetSecondaryChName = hexPairs[1];
	   	//	GetPrimaryChName   = jp.getPrimaryChName(hmd.getPrimaryChName(hexPairs[0]));
	   	//	GetSecondaryChName = jp.getSecondaryChName(hmd.getPrimaryChName(hexPairs[1]));
	   		ToGetChName =	mi.Channel_Spy(SupervisorNo,AgentNo);//(PrimaryChName, SecondaryChName);
   		}
   catch(Exception e)
   	{
	   ToGetChName = e.getMessage();
   	}
	
	// = hmd.getChannelName(bridgeid);
	return ToGetChName;
}


public String BlindTransferOperation(String bridgeid)

{
	String ToGetChName = "";
	String[] hexPairs;
	String GetPrimaryChName = "";
	String GetSecondaryChName = "";
   try 
   	    {
	   		// jp.getchannelNum(hmd.getChannelNo(bridgeid));
	   		 hexPairs = StringUtils.split( jp.getchannelNum(hmd.getChannelNo(bridgeid)), "!");
	   		// GetPrimaryChName   = hexPairs[0];
	   		// GetSecondaryChName = hexPairs[1];
	   		GetPrimaryChName   = jp.getPrimaryChName(hmd.getPrimaryChName(hexPairs[0]));
	   		GetSecondaryChName = jp.getSecondaryChName(hmd.getPrimaryChName(hexPairs[1]));
	   	//	ToGetChName =	mi.Channel_Redirect(GetPrimaryChName, GetSecondaryChName);
	   	//	ToGetChName = ToGetChName+"!"+GetPrimaryChName+"!"+GetSecondaryChName;
	   		ToGetChName = mi.Channel_BlindTransfer(GetPrimaryChName);
   	    }
   catch(Exception e)
   	{
	   ToGetChName = e.getMessage();
	   ToGetChName = ToGetChName+"!0!"+0;
   	}
	
	// = hmd.getChannelName(bridgeid);
	return ToGetChName;
}




public static void main(String args[])
{
	ServiceManager s = new ServiceManager();
	System.out.println(s.HoldOperation("9b2af9bd-6913-49f9-bb5f-7fa90be9b598"));
	System.out.println(s.UnHoldOperation("", ""));
	System.out.println(s.ChannelSpy("pjsip/8001","pjsip/6003"));
}
}
