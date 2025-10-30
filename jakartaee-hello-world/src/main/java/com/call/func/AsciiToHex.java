package com.call.func;

//Java program to convert ASCII
//string to Hexadecimal format string
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

class AsciiToHex {

	// function to convert ASCII to HEX
	public static String AsciiToHex(String ascii)
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

	 public static String hexToTextCov(String customFormat)
	 {
			//String customFormat = "003132333435363738207c2030376662333036352d363130352d343538652d613339662d633763393033353036663039;encoding=hex;purpose=isdn-uui;content=isdn-uui";
		//	System.out.println(StringUtils.substringBefore(customFormat, ";encoding=hex"));
			
		//	String hexString =StringUtils.substringBefore(customFormat, ";encoding=hex");
	        String[] hexPairs = customFormat.split("(?<=\\G.{2})");

	StringBuilder resultBuilder = new StringBuilder();
	for (String hexPair : hexPairs) {
	 int decimalValue = Integer.parseInt(hexPair, 16);
	 resultBuilder.append(Character.toChars(decimalValue));
	}

	String resultString = resultBuilder.toString();

	//System.out.println("Before the conversion: " +hexString);
	System.out.println("After the conversion: " +StringUtils.trim(resultString));
	String temp = StringUtils.trim(resultString+";encoding=hex;purpose=ivr-cc;content=sub-data");
//	String[] hexPairs1 = StringUtils.split(StringUtils.trim(temp), "|");
//	System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);
	//hexToText(Qry)
  //ps.setString(3,hexPairs1[0]);
  //ps.setString(4,hexPairs1[1]);
return temp;
	 }
	
	
	// Driver Function
	public static void main(String arg[])
	{
		// print the Hex String
		//System.out.println(AsciiToHex("+919840000000|B1234567890123456|YES|YES|75.0"));
		System.out.println(AsciiToHex("654648983333|+919840000000|B1234567890123456|YES|YES|75.0"));
		System.out.println(hexToTextCov("3635343634383938333333337c2b3931393834303030303030307c42313233343536373839303132333435367c5945537c5945537c37352e30"));
	}
}
