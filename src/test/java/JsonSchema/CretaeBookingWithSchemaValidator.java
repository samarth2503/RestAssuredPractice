package JsonSchema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CretaeBookingWithSchemaValidator {
	
	public static void main(String[] args)
	{
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.basePath("booking")
		.baseUri("https://restful-booker.herokuapp.com/")
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
		.log().all()
		.statusCode(200)
		.body(JsonSchemaValidator
				.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
		
	}

}
