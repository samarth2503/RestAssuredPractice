package test;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AssertThatfunction {

	public static void main(String[] args) {
		
		assertThatMethod();

	}
	
	public static void assertThatMethod()
	{
		RestAssured.given()
		.log().all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.contentType(ContentType.JSON)
		.when().get()
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.statusCode(Matchers.equalTo(200))
		//.header("max_age", Matchers.equalTo(3600))
		.header("Server", "Cowboy")
		.headers("Content-Type", "application/json; charset=utf-8", "Connection","keep-alive");
		
	}

}
