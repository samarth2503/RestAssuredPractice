package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResposneClass {

	public static void main(String[] args) {
		
		String body = requestBody().body().asPrettyString();
		//System.out.println("Body is "+body);
		
		System.out.println("Content Type is "+requestBody().contentType());
		System.out.println("Content Type is using getContentType"+requestBody().getContentType());
		
		//System.out.println(requestBody().cookie(""));
		System.out.println(requestBody().getCookies());
		
		System.out.println("Session Id "+requestBody().getSessionId()+"; Status Code "+requestBody().getStatusCode()+"; Status Line "+requestBody().getStatusLine());
		System.out.println(requestBody().getHeaders());
		
		System.out.println(requestBody().getHeaders().asList());

	}
	
	public static Response requestBody()
	{
		Response res = RestAssured.given()
		.log().all()
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
		.contentType(ContentType.JSON)
		.when().post();
		
		return res;
	}
	
	public static Response requestBody2()
	{
		Response res = RestAssured.given()
		.log().all()
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
		.contentType(ContentType.JSON)
		.when().post();
		
		return res;
	}


}
