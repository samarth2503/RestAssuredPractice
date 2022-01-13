package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DefaultValue1 {
	
	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		RestAssured.basePath="booking";
		System.out.println("Inside Before Test");
		
		RestAssured.requestSpecification = RestAssured.given().log().all();
		RestAssured.responseSpecification = RestAssured.expect().statusCode(200);
	}
	
	@Test
	public void createBooking()
	{
		RestAssured.given()
		.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")
		.when()
		.post()
		.then()
		.log()
		.all();
	}
	
	@Test
	public void createBooking1()
	{
		RestAssured.given()
		.body("{\r\n"
				+ "    \"firstname\" : \"Amod\",\r\n"
				+ "    \"lastname\" : \"Mahajan\",\r\n"
				+ "    \"totalprice\" : 114,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2018-01-10\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}")
		.when()
		.post()
		.then()
		.log()
		.all();
	}
}
