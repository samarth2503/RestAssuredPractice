package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void test1()
	{	
		Response response= get("https://reqres.in/api/users?page=2");

		
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		response.header("Content-type");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test2()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8));
		
		
	}
	
	@Test
	public void test3()
	{
		baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=given();
		
		Response response = httprequest.request(Method.GET, "/users?page=2");
		
		System.out.println("Session Id is "+response.getSessionId());
		
		System.out.println("Content Type is "+response.getContentType());
		
		System.out.println(response.body().asString());
	}

}
