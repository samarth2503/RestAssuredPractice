package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeadersinRestAssured {
	
	@Test
	public void HearersTest()
	{
		RestAssured.given()
		.log().all()
		.header("Header1","value1")									// Adding Single Header
		.header("Header2", "value2", "value3","value4")				// Adding Multiple values with same header 
		.when()
		.get();
	}
	
	@Test
	public void passHeader1()
	{
		RestAssured.given()
		.log()
		.all()
		.header("Header1","value1")
		.header("Header1","value2")
		.when()
		.get();
	}
	
	@Test
	public void passHeader2()
	{
		RestAssured.given()
		.log()
		.all()
		.headers("h1","v1", "h2","v2","h3","v3")					// Passing multiple hedaer in key-value pair
		.when()
		.get();
	}
	
	@Test
	public void MapHeaderVlaue()
	{
		Map<String,String> hm = new HashMap<String,String>();
		hm.put("h1", "v1");
		hm.put("h2", "v2");
		hm.put("h3", "v3");
		
		RestAssured.given()
		.log()
		.all()
		.headers(hm)
		.when()
		.get();
	}
	
	@Test
	public void UsingHeaderClass()
	{
		Header head = new Header("Header1","Value1");
		Header head1 = new Header("Header2","Value2");
		Header head2 = new Header("Header3","Value3");
		
		List<Header> allHead = new ArrayList<Header>();
		
		allHead.add(head);
		allHead.add(head1);
		allHead.add(head2);
		
		Headers headers = new Headers(allHead);
		
		RestAssured.given()
		.log()
		.all()
		.headers(headers)
		.when()
		.get();
	}



}
