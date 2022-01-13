package Payloads;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonObjectResponseToJavaMapWithGenerics {

	public static void main(String[] args) {
		
		Map<String,Object> m = RestAssured.given()
		.get("https://run.mocky.io/v3/0e540ab7-009f-4884-85bb-e2298141965a")
		.as(new TypeRef<Map<String,Object>>() {});
		
		String name = (String) m.get("first_Name");
		System.out.println("Name is "+name);

	}

}
