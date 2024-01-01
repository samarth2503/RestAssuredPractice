package test;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;

public class GETBooking {
	
	public Map<String, Object> hm = null;
	
	@BeforeClass
	public void tearUp()
	{
		hm = new HashMap<String, Object>();
		
		hm.put("Server", "Cowboy");
		hm.put("Report-To", "{\"group\":\"heroku-nel\",\"max_age\":3600,\"endpoints\":[{\"url\":\"https://nel.heroku.com/reports?ts=1703145463&sid=c46efe9b-d3d2-4a0c-8c76-bfafa16c5add&s=H5bwAWnbRNotd66qe7fhpFCKgosZDO617YzYhm%2BE7hY%3D\"}]}");
		hm.put("Via", "1.1 vegur");
		hm.put("Date", "Thu, 21 Dec 2023 07:57:43 GMT");
		hm.put("Etag", "W/\"a9-8uG7AEEeHcLQ+L3iZkRrEDD3N+g\"");
		hm.put("Content-Length", 169);
		hm.put("Content-Type", "application/json; charset=utf-8");
		hm.put("X-Powered-By", "Express");
		hm.put("Nel", "{\"report_to\":\"heroku-nel\",\"max_age\":3600,\"success_fraction\":0.005,\"failure_fraction\":0.05,\"response_headers\":[\"Via\"]}");
		
	}
	
	
	
	@Test
	public void pathParameter1()
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 1)
		.get()
		
	
		.then()
		.log().all()
		.assertThat()
		
		.contentType(Matchers.containsString("application/json"));
		//.headers(hm);
		
		
		//.statusCode(200);
	}

	@Test(enabled=false)
	public void NamedpathParameter()
	{
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("{booking}/{bookingid}")
		.pathParam("booking", "booking")
		.pathParam("bookingid", 1)
		.when()
		.get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test(enabled=false)
	public void inlinePathParameter()
	{
		RestAssured.given()
		.log()
		.all()
		.get("https://restful-booker.herokuapp.com/{basePath}/{bookingid}", "booking",2)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void inlineAndPathParameter()
	{
		RestAssured.given()
		.log()
		.all()
		.pathParam("basepath", "booking")
		.get("https://restful-booker.herokuapp.com/{basepath}/{bookingid}",2)
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}

}
