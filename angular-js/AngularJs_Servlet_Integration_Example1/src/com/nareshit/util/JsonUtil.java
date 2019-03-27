package com.nareshit.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*Util is a helper class .
 * In General Util class contain static
 * memebers .
 * Util class we can create to reuse the logic
 * and to hide the complex code
 */
public class JsonUtil {
public static String 
convertJavaToJson(Object obj){
	String jsonStr="";
ObjectMapper mapper=new ObjectMapper();
//convert java obj into json
   try {
	jsonStr=mapper.writeValueAsString(obj);
} catch (JsonGenerationException e) {
	e.printStackTrace();
} catch (JsonMappingException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
	return jsonStr;
}
}
/**
 * to convert java obj into json and json into
 * java obj we can use Jackson-API.
 * Jackson-API provided ObjectMapper class.
 * It contain two important methods
 * 1)writeValueAsString()-->used to convert java obj into json
 * 2)readValue()-->used to convert json into java obj
 */
