package JsonPathExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class InlineAssertionForArray {

	public static void main(String[] args) {
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking")
		.when()
		.get()
		.then()
		.log()
		.all()
		.body("bookingid", Matchers.hasItems(90,10))
		.body("bookingid", Matchers.contains(119));
		

	}

}
