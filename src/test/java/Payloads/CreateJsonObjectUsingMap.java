package Payloads;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateJsonObjectUsingMap {

	public static void main(String[] args) {
		
		Map<String,Object> jsonObject = new HashMap<String,Object>();
		
		jsonObject.put("id", 1);
		jsonObject.put("first_name", "Samarth");
		jsonObject.put("last_name", "Jain");
		jsonObject.put("married", false);
		jsonObject.put("salary", 45.67);
		
		// RestAssured with Automatically parse map to JsonObject
		
		RestAssured.given()
		.log()
		.all()
		.body(jsonObject)							// Take Object as parameter
		.get();

	}

}
