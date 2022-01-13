package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETBooking {
	
	@Test
	public void pathParameter1()
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 1)
		.get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}

	@Test(enabled=false)
	public void NamedpathParameter()
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("{booking}/{bookingid}")
		.pathParam("booking", "booking")
		.pathParam("bookingid", 1)
		.when()
		.get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test(enabled=false)
	public void inlinePathParameter()
	{
		RestAssured.given()
		.log()
		.all()
		.get("https://restful-booker.herokuapp.com/{basePath}/{bookingid}", "booking",2)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void inlineAndPathParameter()
	{
		RestAssured.given()
		.log()
		.all()
		.pathParam("basepath", "booking")
		.get("https://restful-booker.herokuapp.com/{basepath}/{bookingid}",2)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}

}
