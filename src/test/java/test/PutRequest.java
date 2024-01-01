package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	public static void main(String[] args)
	{
		RestAssured.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("booking/2")
		.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"firstname\" : \"Rajesh\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n"
				+ "}")
		.when()
		.patch()
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
	
	@Test(enabled=false)
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
