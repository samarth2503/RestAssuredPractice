package Payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class HandlingDynamicJsonResponse {

	public static void main(String[] args) {
		
		List l = RestAssured.given()
		.get("https://run.mocky.io/v3/64ae3122-18b2-4ed9-9561-1bfd32ddc7bb")
		.as(List.class);
		
		System.out.println(l.size());
		
		//com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `
		//java.util.ArrayList<java.lang.Object>` out of START_OBJECT token
		
		Map m = RestAssured.given()
				.get("https://run.mocky.io/v3/afbfaba4-fb9d-466a-868a-ded98d767ea4")
				.as(Map.class);
		
		System.out.println(m.keySet());
		
		//com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of 
		//`java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` out of START_ARRAY token

	}

}
