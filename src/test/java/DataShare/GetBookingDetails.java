package DataShare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

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


}
