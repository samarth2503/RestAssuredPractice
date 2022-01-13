package MockData;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJsonObjectResponseMap {

	public static void main(String[] args) {
		
		
		Map m = RestAssured.given()
		.get("https://run.mocky.io/v3/0e540ab7-009f-4884-85bb-e2298141965a")
		.as(Map.class);
		
		System.out.println("Name is "+m.get("first_Name"));
		
		m.keySet().forEach(k->System.out.println(k));
		
		Map<String,Object> skill = (Map<String, Object>) m.get("skill");
		
		System.out.println("Name is "+skill.get("name"));

	}

}
