package JsonPathExamples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class ArrayNestedArray {

	public static void main(String[] args) {
		
		String jsArray = "[\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Amod\",\r\n"
				+ "    \"lastname\": \"Mahajan\",\r\n"
				+ "    \"age\": 28,\r\n"
				+ "    \"address\": [\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Bengaluru\",\r\n"
				+ "        \"country\": \"India\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Delhi\",\r\n"
				+ "        \"country\": \"India\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Samarth\",\r\n"
				+ "    \"lastname\": \"Jain\",\r\n"
				+ "    \"age\": 24,\r\n"
				+ "    \"address\": \"Mumbai\",\r\n"
				+ "    \"mob\": 1122334455\r\n"
				+ "  }\r\n"
				+ "]"; 
		
		JsonPath jsPath = new JsonPath(jsArray);
		List<Object> s = jsPath.get("$");
		System.out.println(s);
		System.out.println((Object)jsPath.get("[0].address"));
		
		System.out.println("List is "+jsPath.getList("$"));
		System.out.println("Size is "+jsPath.getList("$").size());
		System.out.println(jsPath.getString("[0].address[0].city"));
		Object js=jsPath.getList("$").get(0);
		System.out.println(js);
		
		
		// Get List of Object
		List<Object> ls = jsPath.getList("$");
		Object js1=jsPath.get("$");
		System.out.println(ls);
		System.out.println(js1);
		String str=jsPath.getString("[0].address.city");
		System.out.println(str);
		
		List<Object> city = jsPath.getList("[0].address.city");
		System.out.println(city);
	}

}
