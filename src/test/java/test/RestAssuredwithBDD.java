package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredwithBDD {
	
	@Test(enabled=false)
	public void CreateBooking()
	{
		RestAssured
		.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.body("{\r\n"
				+ "    \"firstname\" : \"Samarth\",\r\n"
				+ "    \"lastname\" : \"Jain\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-02\",\r\n"
				+ "        \"checkout\" : \"2019-01-08\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}")
		.when()
		.post()
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
		
		
	}
	
	@Test(enabled=false)
	public void test1()
	{
		String body=RestAssured.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.contentType(ContentType.JSON)
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
				.asPrettyString();
				
				
				System.out.println("Body is "+body.toString());
	}
	
	@Test
	public void extractResponseBody()
	{
		String body=RestAssured.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.contentType(ContentType.JSON)
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
				.log()
				.all()
				.extract()
				.body()
				//.asString();
				.asPrettyString();
				
				
				System.out.println("Body is "+body);
	}

}
