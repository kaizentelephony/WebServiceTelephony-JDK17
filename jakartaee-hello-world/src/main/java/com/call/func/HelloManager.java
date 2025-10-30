package com.call.func;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.action.MuteAudioAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.asteriskjava.manager.action.PingAction;
import org.asteriskjava.manager.action.MuteAudioAction.Direction;
import org.asteriskjava.manager.action.MuteAudioAction.State;
import org.asteriskjava.manager.action.RedirectAction;
import org.asteriskjava.manager.action.BridgeAction;
import org.asteriskjava.manager.event.CoreShowChannelEvent;
//import org.asteriskjava.manager.action.`//Ping

public class HelloManager
{
    private ManagerConnection managerConnection;

    public HelloManager() throws IOException
    {
        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "192.168.5.56", "administrator", "mysecret");

        this.managerConnection = factory.createManagerConnection();
    }

    public void run() throws IOException, AuthenticationFailedException,
            TimeoutException
    {
      //  OriginateAction originateAction;
        ManagerResponse originateResponse = null;
       //   HoldEvent h = new HoldEvent(originateResponse);
       //   h.s
        MuteAudioAction muteaction;
        //Direction d = null;
        //Direction.
       // State s = null;
      //  PingAction pingaction;
        muteaction = new MuteAudioAction();
        muteaction.setActionId("22222233222");
        muteaction.setChannel("PJSIP/6003-00000002");
      //  muteaction.setDirection()
        muteaction.setDirection(Direction.IN);
        muteaction.setState(State.MUTE);
        
       
        //  pingaction = new PingAction();
     //   pingaction.setActionId("34333333");
     //   muteaction.setChannel("1233444");

     /*   originateAction = new OriginateAction();
        originateAction.setChannel("PJSIP/6003");
        originateAction.
        originateAction.setContext("default");
        originateAction.setExten("1300");
        originateAction.setPriority(new Integer(1));
        originateAction.setTimeout(new Integer(30000));
        */

        // connect to Asterisk and log in
        managerConnection.login();

        // send the originate action and wait for a maximum of 30 seconds for Asterisk
        // to send a reply
        originateResponse = managerConnection.sendAction(muteaction, 30000);
       // originateResponse = 
        // print out whether the originate succeeded or not
        System.out.println("Response"+originateResponse.getResponse());
        System.out.println( originateResponse.getMessage()); 
        // and finally log off and disconnect
        managerConnection.logoff();
    }

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
    		  System.out.print(""+e.getMessage());
    	  }
						return returnRes;
}

   public String Channel_Redirect(String channelno)
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
  		redirectaction.setChannel("PJSIP/out-00000064");
  		//redirectaction.
  		redirectaction.setExten("2929");
  		redirectaction.setContext("MOH_Test");
  		redirectaction.setPriority(1);
  		
  		redirectaction.setExtraChannel("12123453");
  		redirectaction.setExtraChannel("PJSIP/6003-00000065");
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
    
   public String Channel_Bridges(String channelno)
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
 		bridgeaction.setChannel1("PJSIP/6003-00000069");
 		bridgeaction.setChannel2("PJSIP/out-00000068");
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
   
/*
   public String Channel_Mapping(String channelno) .
   {
   	String returnRes = "";
 	  try
 	  {
 		  ManagerConnectionFactory factory = new ManagerConnectionFactory(
 	                "192.168.5.56", "administrator", "mysecret");

 	        this.managerConnection = factory.createManagerConnection();
 		//  OriginateAction originateAction;
 		ManagerResponse bridgeResponse = null;
 			
 		CoreShowChannelEvent coreshowchannels;
 		coreshowchannels = new CoreShowChannelEvent(coreshowchannels);
 		coreshowchannels.
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
 	/*	coreshowchannels.setActionId("");
 		bridgeaction.setActionId("12123453");
 		bridgeaction.setChannel1("PJSIP/out-00000050");
 		bridgeaction.setChannel2("PJSIP/6003-00000051");
   
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
   
*/
   
   
    public static void main(String[] args) throws Exception
    {
        HelloManager helloManager;

        helloManager = new HelloManager();
    //    helloManager.Channel_Redirect("");
        helloManager.Channel_Bridges("");
       // helloManager.run();
    }
}