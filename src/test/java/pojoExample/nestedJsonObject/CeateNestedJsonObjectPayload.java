package pojoExample.nestedJsonObject;

import io.restassured.RestAssured;

public class CeateNestedJsonObjectPayload {
	
	public static void main(String[] args) {
		
		Employees e = new Employees();
		
		e.setFirstName("Samarth");
		e.setLastName("Jain");
		e.setProfession("Automation Tester");
		
		Address a = new Address();
		a.setCity("Mumbai");
		a.setCountry("India");
		a.setHouseNo(23);
		a.setState("MH");
		a.setStreetName("MG Road");
		
		e.setAddress(a);
		
		RestAssured.given()
		.log()
		.all()
		.body(e)
		.when()
		.get()
		.then()
		.log()
		.all();
		
	}
	
	
	

}
