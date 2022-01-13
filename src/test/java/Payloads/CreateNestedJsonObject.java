package Payloads;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateNestedJsonObject {

	public static void main(String[] args) {
		
		Map<String,Object> jsonObject = new LinkedHashMap<>();
		
		jsonObject.put("id", 1);
		jsonObject.put("first_name", "Samarth");
		jsonObject.put("last_name", "Jain");
		jsonObject.put("married", false);
		jsonObject.put("Salary", 123.45);
		
		Map<String,Object> addressObject = new LinkedHashMap<>();
		
		addressObject.put("streetName", "MG Road");
		addressObject.put("city", "Mumbai");
		addressObject.put("state", "MH");
		addressObject.put("streetNo", "#81");
		
		jsonObject.put("address", addressObject);
		
		RestAssured.given()
		.log()
		.all()
		.body(jsonObject)
		.get();
		
	}

}
