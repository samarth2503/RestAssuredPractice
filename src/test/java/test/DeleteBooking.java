package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

public class DeleteBooking {
	
	@Test(enabled=false)
	public void deleteBooking()
	{
		// Construct request
		
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 6)
		.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.header("Content-type","application/json")		
		// Hit Request 
		.when()
		.delete()
		// validate response
		.then()
		.log()
		.all()
		.statusCode(201);
	}
	
	@Test
	public void extractResponseBody()
	{
		String body=RestAssured
		.given()
		
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		
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
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.extract()
		.body()
		.asString();
		
		System.out.println(body);
	}
	
}
