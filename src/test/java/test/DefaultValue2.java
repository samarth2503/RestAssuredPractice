package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DefaultValue2 {
	
	@Test
	public void createBooking2()
	{
		RestAssured.given()
		.log()
		.all()
		.basePath("auth")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.when()
		.post()
		.then()
		.log()
		.all()
		.statusCode(500);
		
	}

}
