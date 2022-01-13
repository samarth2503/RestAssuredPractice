package Payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class HandlingDynamicJsonResponse {

	public static void main(String[] args) {
		
		List l = RestAssured.given()
		.get("https://run.mocky.io/v3/0e540ab7-009f-4884-85bb-e2298141965a")
		.as(List.class);
		
		System.out.println(l);
		
		//com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `
		//java.util.ArrayList<java.lang.Object>` out of START_OBJECT token
		
		Map m = RestAssured.given()
				.get("https://run.mocky.io/v3/47556716-a28e-4e37-b4d5-e2cde28ae67c")
				.as(Map.class);
		
		System.out.println(m);
		
		//com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of 
		//`java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` out of START_ARRAY token

	}

}
