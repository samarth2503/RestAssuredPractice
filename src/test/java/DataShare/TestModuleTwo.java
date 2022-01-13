package DataShare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestModuleTwo {
	
	@Test(priority=1)
	public void createBooking()
	{
		DataStore.BOOKING_ID=RestAssured.given()
		.log()
		.all()
		.body("{\r\n"
				+ "    \"firstname\" : \"Alex\",\r\n"
				+ "    \"lastname\" : \"Jain\",\r\n"
				+ "    \"totalprice\" : 102,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-02-01\",\r\n"
				+ "        \"checkout\" : \"2019-02-01\"\r\n"
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
		
		DataStoreAsMap.setValue(Constants.BOOKING_ID, DataStore.BOOKING_ID);
		
		System.out.println("Thread Is Created is "+Thread.currentThread().getId()+" and created Booking Id is "+DataStore.BOOKING_ID);
		
	}
	
	
	@Test(priority=2)
	public void retriveBooking() throws InterruptedException
	{
		Thread.sleep(15000);
		int bookingId = (int)DataStoreAsMap.getValue(Constants.BOOKING_ID);
		System.out.println("Thread Created is "+Thread.currentThread().getId()+" Retrived booking id is "+bookingId);
		RestAssured.given()
		.log()
		.all()
		.get("https://restful-booker.herokuapp.com/booking/"+bookingId)
		.then()
		.log()
		.all()
		.extract()
		.response();
		
	}

}
