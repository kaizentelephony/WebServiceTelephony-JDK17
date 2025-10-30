package com.call.func;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
public String getchannelNum(String jsString)
	{
		 String resString = "";
		 try
		  {
			 JSONObject coderollsJSONObject = new JSONObject(jsString);
			 //   JSONArray arr = new JSONArray(JsonString);
			 JSONArray eJSONArray = coderollsJSONObject.getJSONArray("channels");
		    System.out.println("Printing the employees JSON array: \n"+eJSONArray.toString()+"\n");
		    //  JSONObject employeeJSONObject = employeesJSONArray.getJSONObject(0);
		    System.out.println("Name: " + eJSONArray.getString (0));
		    resString = eJSONArray.getString(0)+"!"+eJSONArray.getString(1);
		  }
			catch(Exception e)
			{
				resString = e.getMessage();
			}
		return resString;
	}
public String getPrimaryChName(String jsString)
{
	String resString = "";

	try
	  {
		JSONObject jsonObject = new JSONObject(jsString);
		// Access nested fields
		resString = jsonObject.getString("name");
		System.out.println("Name: " + resString);
	  }
	catch(Exception e)
	{
		resString = e.getMessage();
	}

return resString;
}
public String getSecondaryChName(String jsString)
{
	String resString = "";

	try
	  {
		JSONObject jsonObject = new JSONObject(jsString);
		// Access nested fields
		resString = jsonObject.getString("name");
		System.out.println("Name: " + resString);
	  }
	catch(Exception e)
	{
		resString = e.getMessage();
	}

return resString;
}
}
