package JsonPathExamples;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithInlineAssertion {

	public static void main(String[] args) {
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.log()
		.all()
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.log()
		.all()
		.body("token", Matchers.notNullValue())
		.body("token.length()", Matchers.is(15));

	}

}
