package com.call.func;

import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.action.BridgeAction;
import org.asteriskjava.manager.action.MuteAudioAction;
import org.asteriskjava.manager.action.MuteAudioAction.Direction;
import org.asteriskjava.manager.action.MuteAudioAction.State;
import org.asteriskjava.manager.response.ManagerResponse;
import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.action.MuteAudioAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.asteriskjava.manager.action.PingAction;
import org.asteriskjava.manager.action.RedirectAction;
import org.asteriskjava.manager.action.MuteAudioAction.Direction;
import org.asteriskjava.manager.action.MuteAudioAction.State;
import org.asteriskjava.manager.action.CommandAction;
import org.asteriskjava.manager.event.ChanSpyStartEvent;
import org.asteriskjava.manager.action.AtxferAction;


public class ManagerInfo {
	 private ManagerConnection managerConnection;
	 public String muteChannel(String channelno) 
 	{
 	String returnRes = "";
 	  try
 	  {
 		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
 	                "192.168.5.56", "administrator", "mysecret");

 	        this.managerConnection = factory.createManagerConnection();
 		//  OriginateAction originateAction;
 		ManagerResponse originateResponse = null;
 			
 		MuteAudioAction muteaction;
 		muteaction = new MuteAudioAction();
			muteaction.setActionId("");
			muteaction.setChannel(channelno);
			//  muteaction.setDirection()
			muteaction.setDirection(Direction.IN);
			muteaction.setState(State.MUTE);



						// connect to Asterisk and log in
						managerConnection.login();
						
						// send the originate action and wait for a maximum of 30 seconds for Asterisk
						// to send a reply
						originateResponse = managerConnection.sendAction(muteaction, 30000);
						// originateResponse = 
						// print out whether the originate succeeded or not
						System.out.println("Response"+originateResponse.getResponse());
						returnRes = originateResponse.getResponse();
					//	System.out.println( originateResponse.getMessage()); 
						// and finally log off and disconnect
						managerConnection.logoff();
 	  }
 	  catch(Exception e)
 	  {
 		 returnRes = e.getMessage();
 		  System.out.print(""+e.getMessage());
 	  }
						return returnRes;
}

	 public String unMuteChannel(String channelno) 
	 	{
	 	String returnRes = "";
	 	  try
	 	  {
	 		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	 	                "192.168.5.56", "administrator", "mysecret");

	 	        this.managerConnection = factory.createManagerConnection();
	 		//  OriginateAction originateAction;
	 		ManagerResponse originateResponse = null;
	 			
	 		MuteAudioAction muteaction;
	 		muteaction = new MuteAudioAction();
				muteaction.setActionId("");
				muteaction.setChannel(channelno);
				//  muteaction.setDirection()
				muteaction.setDirection(Direction.IN);
				muteaction.setState(State.UNMUTE);



							// connect to Asterisk and log in
							managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
							originateResponse = managerConnection.sendAction(muteaction, 30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
							System.out.println("Response"+originateResponse.getResponse());
							returnRes = originateResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	 	  }
	 	  catch(Exception e)
	 	  {
	 		 returnRes = e.getMessage();
	 		  System.out.print(""+e.getMessage());
	 	  }
							return returnRes;
	}
/*-----------------------------------------------------------------------------------*/
	 public String HoldChannel(String bridgeid) 
	 	{
	 	String returnRes = "";
	 	
	 	try
	 		{
	 //		h.getChannelName()
	 		
	 		}
	 	catch(Exception e)
	 		{
	 		
	 		}
	 	
	 	
	 	
	 	
	 	
	 	
	 	  try
	 	  {
	 		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	 	                "192.168.5.56", "administrator", "mysecret");

	 	        this.managerConnection = factory.createManagerConnection();
	 		//  OriginateAction originateAction;
	 		ManagerResponse originateResponse = null;
	 		
	 	
	 	

							// connect to Asterisk and log in
							managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
				//			originateResponse = managerConnection.se(holdevent, 30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
							System.out.println("Response"+originateResponse.getResponse());
							returnRes = originateResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	 	  }
	 	  catch(Exception e)
	 	  {
	 		 returnRes = e.getMessage();
	 		  System.out.print(""+e.getMessage());
	 	  }
							return returnRes;
	} 
/* ---------------------------------------------------------------------------------- */
	 public String Channel_Redirect(String primaryChName, String secondaryChName)
	    {
	    	String returnRes = "";
	  	  try
	  	  {
	  		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	  	                "192.168.5.56", "administrator", "mysecret");

	  	        this.managerConnection = factory.createManagerConnection();
	  		//  OriginateAction originateAction;
	  		ManagerResponse redirectResponse = null;
	  		RedirectAction redirectaction;
	  		redirectaction = new RedirectAction();

				/*
				 *  Action: Redirect
	    ActionID: <value>
	    Channel: <value>
	    ExtraChannel: <value>
	    Exten: <value>
	    ExtraExten: <value>
	    Context: <value>
	    ExtraContext: <value>
	    Priority: <value>
	    ExtraPriority: <value>
				* */

	  		redirectaction.setActionId("12123453");
	  		redirectaction.setChannel(primaryChName);
	  		//redirectaction.
	  		redirectaction.setExten("2929");
	  		redirectaction.setContext("MOH_Test");
	  		redirectaction.setPriority(1);
	  		
	  		redirectaction.setExtraChannel("121233453");
	  		redirectaction.setExtraChannel(secondaryChName);
	  		redirectaction.setExtraExten("2929");
	  		redirectaction.setExtraContext("MOH_Test");
	  		redirectaction.setExtraPriority(1);
	    
							// connect to Asterisk and log in
							managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
							redirectResponse = managerConnection.sendAction(redirectaction, 30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
							System.out.println("Response"+redirectResponse.getResponse());
							returnRes = redirectResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	  	  }
	  	  catch(Exception e)
	  	  {
	  		  System.out.print(""+e.getMessage());
	  	  }
							return returnRes;

	    }

	 
/*-----------------------------------------------------------------------------------*/	 
	 public String Channel_Bridges(String primaryChName, String secondaryChName)
	   {
	   	String returnRes = "";
	 	  try
	 	  {
	 		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	 	                "192.168.5.56", "administrator", "mysecret");

	 	        this.managerConnection = factory.createManagerConnection();
	 		//  OriginateAction originateAction;
	 		ManagerResponse bridgeResponse = null;
	 			
	 		BridgeAction bridgeaction;
	 		bridgeaction = new BridgeAction();
				
				/*
				 *  Action: Redirect
	   ActionID: <value>
	   Channel: <value>
	   ExtraChannel: <value>
	   Exten: <value>
	   ExtraExten: <value>
	   Context: <value>
	   ExtraContext: <value>
	   Priority: <value>
	   ExtraPriority: <value>
				* */

	 		bridgeaction.setActionId("12123453");
	 		bridgeaction.setChannel1(primaryChName);
	 		bridgeaction.setChannel2(secondaryChName);
	 		bridgeaction.setTone(true);
	   
							// connect to Asterisk and log in
							managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
							bridgeResponse = managerConnection.sendAction(bridgeaction, 30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
							System.out.println("Response"+bridgeResponse.getResponse());
							returnRes = bridgeResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	 	  }
	 	  catch(Exception e)
	 	  {
	 		  System.out.print(""+e.getMessage());
	 	  }
							return returnRes;

	   }

	 /* ---------------------------------------------------------------------------------- */
	 public String Channel_Spy(String SupervisorNo, String AgentNo)
	    {
	    	String returnRes = "";
	  	  try
	  	  {
	  		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	  	                "192.168.5.61", "administrator", "mysecret");

	  	        this.managerConnection = factory.createManagerConnection();
	  		//  OriginateAction originateAction;
	  		ManagerResponse CommandResponse = null;
	  		CommandAction commandAction;
	  		commandAction = new CommandAction();

				/*
				 *  Action: Redirect
	    ActionID: <value>
	    Channel: <value>
	    ExtraChannel: <value>
	    Exten: <value>
	    ExtraExten: <value>
	    Context: <value>
	    ExtraContext: <value>
	    Priority: <value>
	    ExtraPriority: <value>
				* */

	  		commandAction.setActionId("12133ee3323453");
	  		commandAction.setCommand("channel originate PJSIP/"+SupervisorNo+" application ChanSpy PJSIP/"+AgentNo+",dqS");
	  		//originateAction.setData("pjsip/6003");
	  		//redirectaction.
	  	//	originateAction.setExten("2929");
	  	//	originateAction.setContext("MOH_Test");
	  	//	originateAction.setPriority(1);
	  		
	  	//	originateAction.setExtraChannel("121233453");
	  	//	originateAction.setExtraChannel(secondaryChName);
	  	//	originateAction.setExtraExten("2929");
	  	//	originateAction.setExtraContext("MOH_Test");
	  	//	originateAction.setExtraPriority(1);
	    
							// connect to Asterisk and log in
							managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
							CommandResponse = managerConnection.sendAction(commandAction, 30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
							System.out.println("Response"+CommandResponse.getResponse());
							returnRes = CommandResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	  	  }
	  	  catch(Exception e)
	  	  {
	  		  System.out.print(""+e.getMessage());
	  	  }
							return returnRes;

	    }

	 
	 
	 
	 
/* ----------------------------------------------------------------------------------*/	 

	 public String Channel_BlindTransfer(String primaryChannelNo)
	    {
	    	String returnRes = "";
	  	  try
	  	  {
	  		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
	  	                "192.168.5.56", "administrator", "mysecret");

	  	        this.managerConnection = factory.createManagerConnection();
	  		//  OriginateAction originateAction;
	  	        ManagerResponse redirectResponse = null;
		  		RedirectAction redirectaction;
		  		redirectaction = new RedirectAction();

				redirectaction.setActionId("12123453");
		  		redirectaction.setChannel(primaryChannelNo);
		  		//redirectaction.
		  		redirectaction.setExten("4100");
		  		redirectaction.setContext("Atxfer");
		  		redirectaction.setPriority(1);
		  		//redirectaction.
		  		
		  		
			managerConnection.login();
							
							// send the originate action and wait for a maximum of 30 seconds for Asterisk
							// to send a reply
			redirectResponse = managerConnection.sendAction(redirectaction,30000);
							// originateResponse = 
							// print out whether the originate succeeded or not
	System.out.println("Response"+redirectResponse.getResponse());
		returnRes = redirectResponse.getResponse();
						//	System.out.println( originateResponse.getMessage()); 
							// and finally log off and disconnect
							managerConnection.logoff();
	  	  }
	  	  catch(Exception e)
	  	  {
	  		  System.out.print(""+e.getMessage());
	  	  }
							return returnRes;

	    }

	 
	 
	 
	 
/* ----------------------------------------------------------------------------------*/	 

	 
	 
	 public static void main(String args[])
	 {
	 	ManagerInfo s = new ManagerInfo();
	 	//System.out.println(s.HoldOperation("9b2af9bd-6913-49f9-bb5f-7fa90be9b598"));
	 	//System.out.println(s.UnHoldOperation("9b2af9bd-6913-49f9-bb5f-7fa90be9b598"));
	    //System.out.println(s.Channel_Spy("pjsip/8001","pjsip/6002"));
	// 	System.out.println(s.Channel_Transfer("",""));
	 }
}
