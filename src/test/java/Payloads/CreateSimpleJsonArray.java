package Payloads;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpleJsonArray {

	public static void main(String[] args) {
		
		Map<String,Object> empDetails = new LinkedHashMap<>();
		
		empDetails.put("id", 1);
		empDetails.put("first_name", "Samarth");
		empDetails.put("last_name", "Jain");
		empDetails.put("email", "samarthjain68@gmail.com");
		empDetails.put("gender", "Male");
		
		Map<String,Object> empDetails2 = new LinkedHashMap<>();
		
		empDetails2.put("id", 2);
		empDetails2.put("first_name", "Rajesh");
		empDetails2.put("last_name", "Jain");
		empDetails2.put("email", "rajeshjain689@gmail.com");
		empDetails2.put("gender", "Male");

		
		List<Map<String,Object>> allEmployees = new ArrayList<>();
		
		allEmployees.add(empDetails);
		allEmployees.add(empDetails2);
		
		RestAssured.given()
		.log()
		.all()
		.body(allEmployees)
		.get();

	}

}
