package org.eclipse.jakarta.hello;

import java.util.HashMap;
import org.json.JSONArray; 
import org.json.JSONObject; 
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.slf4j.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.call.db.FetchData;

//import ch.qos.logback.classic.Logger;
public class TestingClass {
	// private static final Log logger = LogFactory.getLog(TestingClass.class);
	// private static final Logger logger = LoggerFactory.getLogger(TestingClass.class);
	 private static final Log logger = LogFactory.getLog(TestingClass.class);
	 static JSONArray jsonArray = new JSONArray(); 
	 static FetchData f = new FetchData();
	// private static final Logger logger = LoggerFactory.getLogger(MyApp.class);
	// private static final Logger logger = LoggerFactory.getLogger(MyApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	 <dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.12.0</version>
		</dependency>*/
		
		String customFormat = "003132333435363738207c2030376662333036352d363130352d343538652d613339662d633763393033353036663039;encoding=hex;purpose=isdn-uui;content=isdn-uui";
		System.out.println(StringUtils.substringBefore(customFormat, ";encoding=hex"));
		
		String hexString =StringUtils.substringBefore(customFormat, ";encoding=hex");
        String[] hexPairs = hexString.split("(?<=\\G.{2})");

StringBuilder resultBuilder = new StringBuilder();
for (String hexPair : hexPairs) {
 int decimalValue = Integer.parseInt(hexPair, 16);
 resultBuilder.append(Character.toChars(decimalValue));
}

String resultString = resultBuilder.toString();
String[] hexPairs1 = null;
String[] hexPairs2 = null;
//hexPairs1[4] = "0";

System.out.println("Before the conversion: " +hexString);
System.out.println("After the conversion: " +StringUtils.trim(resultString));
//String[] hexPairs1 = StringUtils.split(StringUtils.trim(resultString), "|");
//System.out.println("After the conversion: " +hexPairs1[0]+hexPairs1[1]);

logger.info("Application started");
logger.debug("Debugging information");
//logger.error("An error occurred", new RuntimeException("Test error"));
Map<String, Object> object = new HashMap<>();
String res =  f.HoursBySix("");
System.out.println(res);
 hexPairs1 = StringUtils.split(StringUtils.trim(res), "|");
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
//logger.error("An error occurred", new RuntimeException("Test error"));
	}
	public static JSONArray getJSONArray() { 
        // Create a JSONArray 
        JSONArray jsonArray = new JSONArray(); 
 
        // Add data to the JSONArray 
        JSONObject obj1 = new JSONObject(); 
        obj1.put("name", "John Doe"); 
        obj1.put("age", 30); 
        jsonArray.put(obj1); 
 
        JSONObject obj2 = new JSONObject(); 
        obj2.put("name", "Jane Smith"); 
        obj2.put("age", 25); 
        jsonArray.put(obj2); 
 
        return jsonArray; 
    } 
}
