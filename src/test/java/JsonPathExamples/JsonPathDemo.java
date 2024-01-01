package JsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathDemo {

	public static void main(String[] args) {
		
		
		String jsonPath = "{\r\n"
				+ "  \"firstname\": \"123\",\r\n"
				+ "  \"lastname\": \"Jain\"\r\n"
				+ "}";
		
		JsonPath json = new JsonPath(jsonPath);
		
		String firstName = json.getString("firstname");
		System.out.println("FirstName is "+firstName);
		
		// Class cast Exception
		//  java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
//		int i = json.get("firstname");
//		System.out.println("First Name is "+i);
		
		String fname = json.getString("firstNAme1");
		System.out.println("firstName is "+fname);
		
		//  java.lang.NullPointerException
		int fname1 = json.getInt("firstName1");
		System.out.println("firstName is "+fname1);
		
		

	}

}
