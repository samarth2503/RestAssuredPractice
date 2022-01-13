package Payloads;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJsonArrayResponseToList {

	public static void main(String[] args) {
		
		List allEmp = RestAssured.given()
		.get("https://run.mocky.io/v3/04ad9e49-744f-4e93-9c27-973a7d302f62")
		.as(List.class);
		
		System.out.println("Size is "+allEmp.size());
		
		Map<String,Object> firstEmp = (Map<String, Object>) allEmp.get(0);
		System.out.println(firstEmp.get("first_Name"));
		System.out.println(firstEmp.get("last_Name"));

	}

}
