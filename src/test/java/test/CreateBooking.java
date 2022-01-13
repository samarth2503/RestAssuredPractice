package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {
	
	@Test
	public void createBooking()
	{
		// Build request
		/*
		 * RequestSpecifiaction is interface
		 * given() is the ststic method of RestAssured class
		 * 
		 */
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification=requestSpecification.log().all();
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		
		requestSpecification.basePath("booking");
		
		requestSpecification.body("{\r\n"
				+ "	\"firstname\": \"Jim\",\r\n"
				+ "	\"lastname\": \"Brown\",\r\n"
				+ "	\"totalprice\": 111,\r\n"
				+ "	\"depositpaid\": true,\r\n"
				+ "	\"bookingdates\": {\r\n"
				+ "		\"checkin\": \"2018-01-01\",\r\n"
				+ "		\"checkout\": \"2019-01-01\"\r\n"
				+ "	},\r\n"
				+ "	\"additionalneeds\": \"Breakfast\"\r\n"
				+ "}");
		requestSpecification.contentType(ContentType.JSON);				// We are sending data in application/json type
		
		
		//Hit Request and get response
		/*
		 * Resposne is interface
		 */
		Response response=requestSpecification.when().post();
		
		System.out.println(response.prettyPrint().toString());
		
		// Validate Resposne
		ValidatableResponse validatableresposne=response.then().log().all();
		
		validatableresposne.assertThat().statusCode(200);
		
	}
	
	

}
