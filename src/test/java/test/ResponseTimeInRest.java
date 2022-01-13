package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseTimeInRest {
	
	Map<String,Object> m;
	public RequestSpecification reqSpec;
	
	
	
	@BeforeClass
	public void setup()
	{
		m = new HashMap<String,Object>();
		
		m.put("Booking","booking");
		m.put("Baseuri", "https://restful-booker.herokuapp.com/");
		
		reqSpec=RestAssured.given();
		reqSpec=reqSpec.basePath((String) m.get("Booking"));
		reqSpec=reqSpec.baseUri((String) m.get("Baseuri"));
		
	}
	
	@Test
	public void responseTime()
	{
		Response res=RestAssured.given(reqSpec)
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
		.contentType(ContentType.JSON)
		.post();
		
		long resTime=res.time();
		
		System.out.println("Response Time "+resTime);
		
		System.out.println("Time in Seconds = "+res.timeIn(TimeUnit.MICROSECONDS));
		System.out.println("TimeUnit in milli seconds "+res.timeIn(TimeUnit.MILLISECONDS));
		
		System.out.println("Get Time in seconds "+res.getTime());
		System.out.println("Get Time In "+res.getTimeIn(TimeUnit.SECONDS));
		
		// response Time using Hamcrest
		System.out.println("Response Body is "+res.body().toString());
		
		// To validate that resposne time not greater than 2 sec
		res.then().assertThat().time(Matchers.greaterThan(2000L));
		
		// To validate the time Unit
		res.then().assertThat().time(Matchers.greaterThan(1L), TimeUnit.SECONDS);
		
		// To Validate Time in between 2Sec and 5 sec
		res.then().assertThat().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(5000L)));
		
		res.then().assertThat().time(Matchers.greaterThanOrEqualTo(2000L));
	}

}
