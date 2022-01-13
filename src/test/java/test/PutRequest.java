package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutRequest {
	
	public static void main(String[] args)
	{
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/2")
		.header("Content-Type","application/json")
		.header("authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.body("{\r\n"
				+ "    \"firstname\" : \"Alex\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-05-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}")
		.when()
		.put()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test(enabled=false)
	public void PatchRequest()
	{
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/1")
		.body("{\r\n"
				+ "    \"firstname\" : \"JAMES\",\r\n"
				+ "    \"lastname\" : \"BROWN\"\r\n"
				+ "}")
		.when()
		.patch()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void extractingResponse()
	{
		String response =RestAssured.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
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
		.then().log()
		.all()
		.extract()
		.body()
		.asPrettyString();
		
		System.out.println(response);
	}

}
