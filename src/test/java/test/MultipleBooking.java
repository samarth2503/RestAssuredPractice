package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class MultipleBooking {
	
	RequestSpecification requestSpecification;
	String bookingId;
	
	@BeforeClass
	public void setUpRequestSpec()
	{
		requestSpecification = RestAssured.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				
				.contentType(ContentType.JSON);
	}
	
	@Test(priority=1)
	public void createBooking()
	{
		bookingId = RestAssured.given()
		.spec(requestSpecification)
		.basePath("booking")
		.body("{\r\n"
				+ "    \"firstname\" : \"Kevin\",\r\n"
				+ "    \"lastname\" : \"noop\",\r\n"
				+ "    \"totalprice\" : 1090,\r\n"
				+ "    \"depositpaid\" : false,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}")
		.when()
		.post()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200).extract()
		.body()
		.jsonPath().getString(".bookingid");
	}
	
	@Test(priority=2)
	public void updateboking()
	{
		System.out.println("Booking Id is "+bookingId);
		RestAssured.given()
		.spec(requestSpecification)
		.pathParam("booking", bookingId)
		.basePath("booking/{booking}")
		.body("{\r\n"
				+ "    \"firstname\" : \"Amod\",\r\n"
				+ "    \"lastname\" : \"Mahajan\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")
		.when()
		.put()
		.then().log().all()
		.assertThat()
		.statusCode(201);
		
	}

}
