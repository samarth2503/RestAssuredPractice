package JsonPathExamples;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {
	
	// Json Path is similar to xpath
	// It is used to traverse through JsonPath
	// It is used as query language for JSOn document
	// RestAssured has by default json-path
	// Root node is represented by '$' sign
	// Child node is represented by '.' sign
	
	@Test(enabled=false)
	public void jsonPathDemo()
	{
		String json = "{\r\n"
				+ "    \"firstname\":\"Samarth\",\r\n"
				+ "    \"lastname\":\"Jain\"\r\n"
				+ "}";
		
		JsonPath js = new JsonPath(json);
		
		//Object obj=js.get("firstname");
		
		//Object obj1 = js.get("firstname");						// classCast Exception
		String last=js.getString("lastname");
		System.out.println(last);
	
		
	//	System.out.println((Object)js.get("firstname1"));
	}
	
	@Test(enabled=true)
	public void nestedJson()
	{
		String nestedJson ="{\r\n"
				+ "    \"firstname\":\"Samarth\",\r\n"
				+ "    \"lastname\":\"Jain\",\r\n"
				+ "    \"age\": 28,\r\n"
				+ "    \"address\":{\r\n"
				+ "        \"flatno\":401,\r\n"
				+ "        \"buildingName\":\"ABC\",\r\n"
				+ "        \"streetname\":\"XYZ\",\r\n"
				+ "        \"pin\":400089\r\n"
				+ "    },\r\n"
				+ "    \"salary\":100.50,\r\n"
				+ "    \"married\":false\r\n"
				+ "}";
		
		JsonPath js = new JsonPath(nestedJson);
		
		// Various ways to use root node and get output
		
		System.out.println((Object)js.get("$"));
		System.out.println(js.getString("$"));
		System.out.println((Object)js.get());
		System.out.println(js.getString(""));
		
		int age =js.getInt("age");
		System.out.println("Age is "+age);
		
		boolean married = js.getBoolean("married");
		System.out.println("Is Married "+married);
		
		double salary=js.getDouble("salary");
		System.out.println("Salary is "+salary);
		
		int flatno = js.getInt("address.flatno");
		System.out.println(flatno);
	}

}
