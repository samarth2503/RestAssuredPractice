package JsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathForSimpleJsonObject {

	public static void main(String[] args) {
		
		String str = "{\r\n"
				+ "  \"firstname\" : \"Samarth\",\r\n"
				+ "  \"lastname\" : \"Jain\",\r\n"
				+ "  \"age\" : 30,\r\n"
				+ "  \"address\" : \"Mumbai\",\r\n"
				+ "  \"salary\" : 45.67,\r\n"
				+ "  \"married\" : false\r\n"
				+ "}\r\n"
				+ "";
		
		JsonPath json = new JsonPath(str);
		
		String firstName = json.getString("firstname");
		System.out.println(firstName);
		
		int age = json.getInt("age");
		System.out.println("Age is " +age);
		
		boolean Ismarried = json.getBoolean("married");
		System.out.println("Ismarried "+Ismarried);
		
		Float salary = json.getFloat("salary");
		System.out.println("Salary is "+salary);

	}

}
