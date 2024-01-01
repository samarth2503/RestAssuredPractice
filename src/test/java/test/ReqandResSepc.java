package test;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqandResSepc {
	
	Map<String,Object> m = new HashMap<String,Object>();
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setup()
	{
		
		m.put("Booking","booking");
		m.put("Basepath", "https://restful-booker.herokuapp.com/");
		
		reqSpec = reqSpec.given()
				.log().all()
				.baseUri((String)m.get("Basepath"))
				.baseUri((String) m.get("Booking"))
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"firstname\" : \"Kalesh\",\r\n"
						+ "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 33455,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}");
		
		resSpec=RestAssured.expect();						// expect will take all the assertion related methods
		resSpec=resSpec.contentType(ContentType.JSON);
		resSpec=resSpec.statusCode(200);
		
	}
	
	@Test(enabled=false)
	public void createBooking()
	{
		RestAssured.given()
		.log()
		.all()
		.baseUri((String) m.get("Basepath"))
		.basePath("{Booking}")
		.pathParam("Booking", "booking")
		
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
		.spec(resSpec);
		
	}
	
	@Test
	public void usingRequestAndResposneSpecTogether()
	{
		RestAssured
		.given(reqSpec, resSpec)				// when we use request and response together then we can't add body we have to directly use API call
		.post()
		.then()									// then().log().all() will not be part of response spec
		.log()
		.all();
	}

}
