package test;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractRepsosne {
	
	public static void main(String[] args)
	{
		extractRepsone();
	}
	
	public static void extractRepsone()
	{
		RestAssured.given()
		.log().all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/1")
		.contentType(ContentType.JSON)
		.when().get()
		.then().log().all()
		.assertThat()
		.contentType(Matchers.containsString("application"));
	
	}

}
