package Payloads;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateNestedJsonObject {

	public static void main(String[] args) {
		
		Map<String,Object> jsonObjectPayload = new LinkedHashMap<String,Object>();
		
		jsonObjectPayload.put("id", "1");
		jsonObjectPayload.put("first_name", "Samarth");
		jsonObjectPayload.put("last_name", "Jain");
		jsonObjectPayload.put("married", false);
		jsonObjectPayload.put("salary", "123.45");
		
		Map<String,Object> addressPayload = new LinkedHashMap<String,Object>();
		addressPayload.put("no", "#81");
		addressPayload.put("streetname", "ABC Lane");
		addressPayload.put("city", "Banaglore");
		addressPayload.put("state", "KA");
		
		jsonObjectPayload.put("address", addressPayload);
		
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(jsonObjectPayload);
		
	}

}
