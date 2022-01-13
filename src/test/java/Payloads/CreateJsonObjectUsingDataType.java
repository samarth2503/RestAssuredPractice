package Payloads;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateJsonObjectUsingDataType {

	public static void main(String[] args) {
		
		Map<String,Object> jsonObject = new LinkedHashMap<>();
		
		jsonObject.put("id", 1);
		jsonObject.put("first_name", "Samarth");
		jsonObject.put("last_name", "Jain");
		jsonObject.put("married", false);
		jsonObject.put("Salary", 123.45);
		
		RestAssured.given()
		.log()
		.all()
		.body(jsonObject)
		.get();

	}

}
