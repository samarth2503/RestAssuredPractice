package DataShare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBookingTest {
	
	@Test
	public void createBookingTest(ITestContext context)
	{
		int id = RestAssured.given()
				.log()
				.all()
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
				.contentType(ContentType.JSON)
				.post("https://restful-booker.herokuapp.com/booking")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.jsonPath()
				.getInt("bookingid");
		
		context.setAttribute("BookingId", id);
		
	}
	
	@Test
	public void secondExample()
	{
		// Send Request
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec = reqSpec.log().all();
		reqSpec = reqSpec.baseUri("https://restful-booker.herokuapp.com/");
		reqSpec = reqSpec.basePath("booking");
		reqSpec = reqSpec.contentType(ContentType.JSON);
		
		// Hit Request and Get Resposne
		
		Response response = reqSpec.post("{\r\n"
				+ "    \"firstname\" : \"Kane\",\r\n"
				+ "    \"lastname\" : \"Smith\",\r\n"
				+ "    \"totalprice\" : 1110,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-01-01\",\r\n"
				+ "        \"checkout\" : \"2023-04-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		
		// Validate The Resposne
		ValidatableResponse  validateableResponse = response.then().log().all();
		validateableResponse.statusCode(200);
	}

}
