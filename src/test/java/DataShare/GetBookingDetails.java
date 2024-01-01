package DataShare;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetBookingDetails {
	
	@Test
	public void getBookingDetails(ITestContext context)
	{
		RestAssured.given()
		.log()
		.all()
		.get("https://restful-booker.herokuapp.com/booking/"+context.getAttribute("BookingId"))
		.then()
		.log()
		.all()
		.extract()
		.response();
	}
	
	@Test
	public void getBookingDetails()
	{
		RestAssured.given().log().all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 10)
		.when()
		.get()
		.then().log().all()
		.statusCode(200);
	}
	
	@Test
	public void getBookingInlineParameter()
	{
		RestAssured.given()
		.log().all()
		.when()
		.get("https://restful-booker.herokuapp.com/{basePath}/{id}","booking",2)
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("200 OK"));
	}
	
	@Test
	public void getBookingDetailsPathParameter()
	{
		Map<String,Object> pathParameters = new HashMap<String,Object>();
		
		pathParameters.put("basePath", "booking");
		pathParameters.put("bookingId", 2);
		
		RestAssured.given()
		.log().all()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("{basePath}/{bookingId}")
		.pathParams(pathParameters)
		.when().get()
		.then()
		.log().all()
		.assertThat()
		.contentType(ContentType.JSON);
	}


}
