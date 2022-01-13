package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	
	public RequestSpecification reqSpec;
	
	@BeforeClass
	public void setup()
	{
		reqSpec=RestAssured.given()
		.basePath("https://restful-booker.herokuapp.com/")
		.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void createBooking()
	{
		RestAssured
		.given()
		.spec(reqSpec)
		.baseUri("booking")
		.body("{\r\n"
				+ "    \"firstname\": \"Alex\",\r\n"
				+ "    \"lastname\": \"James\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    }\r\n"
				+ "    ,\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}\r\n"
				+ "")
		.when()
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	
	@Test
	public void updateBooking()
	{
		RestAssured
		.given()
		.spec(reqSpec)
		.basePath("booking/1")
		.log()
		.all()
		.body("{\r\n"
				+ "    \"firstname\": \"Jim\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    }\r\n"
				+ "    ,\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}\r\n"
				+ "")
		.when()
		.put()
		.then()
		.assertThat()
		.statusCode(201);
	}

}
