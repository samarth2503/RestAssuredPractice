package DataShare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ShareDataAmongMethods {
	
	@Test(priority=1)
	public void createBooking()
	{
		DataStore.BOOKING_ID=RestAssured.given()
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
		.extract()
		.jsonPath()
		.getInt("bookingid");
		
	}
	
	@Test(priority=2)
	public void retriveBooking()
	{
		RestAssured.given()
		.log()
		.all()
		.get("https://restful-booker.herokuapp.com/booking/"+DataStore.BOOKING_ID)
		.then()
		.log()
		.all()
		.extract()
		.response();
		
	}

}
