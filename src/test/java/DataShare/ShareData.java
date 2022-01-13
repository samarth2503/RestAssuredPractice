package DataShare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ShareData {

	public static void main(String[] args) {
		
		

	}
	
	@Test
	public void createAndRetriveBooking()
	{
		int bookingId = RestAssured.given()
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
		
		Response res = RestAssured.given().get("https://restful-booker.herokuapp.com/booking/"+bookingId);
		res.then().log().all();
	}

}
