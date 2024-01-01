package Payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingdynamicJsonUsingInstanceOf {

	public static void main(String[] args) {
		
		//  https://run.mocky.io/v3/0e540ab7-009f-4884-85bb-e2298141965a  ----Map
		//  https://run.mocky.io/v3/47556716-a28e-4e37-b4d5-e2cde28ae67c  ---List
		
		Response res = RestAssured.given()
		.get("https://run.mocky.io/v3/47556716-a28e-4e37-b4d5-e2cde28ae67c");
		
		
		Object responseObject = res.as(Object.class);
		
		if(responseObject instanceof List)
		{
			System.out.println("Inside List Instance");
			List l = (List) responseObject;
			System.out.println(l.size());
		}
		else if(responseObject instanceof Map)
		{
			System.out.println("Inside Map Instance");
			
			@SuppressWarnings("unchecked")
			Map<String,Object> m = (Map<String,Object>) responseObject;
			
			m.keySet().forEach(e ->System.out.println(e));
			System.out.println(m.get("first_Name"));
		}

	}

}
