package MockData;

import io.restassured.RestAssured;

public class MockyDeisgn {

	public static void main(String[] args) {
		
		RestAssured.given()
		.log()
		.all()
		.post("https://run.mocky.io/v3/6c1c7e46-2e1d-4f4d-8911-ceec33321aa8")
		.then()
		.log()
		.all();

	}

}
