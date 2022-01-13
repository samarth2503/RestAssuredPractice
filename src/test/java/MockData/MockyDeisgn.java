package MockData;

import io.restassured.RestAssured;

public class MockyDeisgn {

	public static void main(String[] args) {
		
		RestAssured.given()
		.log()
		.all()
		.post("https://run.mocky.io/v3/0e540ab7-009f-4884-85bb-e2298141965a")
		.then()
		.log()
		.all();

	}

}
