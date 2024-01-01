package JsonPathExamples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathforJsonArray {

	public static void main(String[] args) {
		
		
		String str = "[\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\",\r\n"
				+ "  \"40\",\r\n"
				+ "  \"50\"\r\n"
				+ "]";
		
		JsonPath json = new JsonPath(str);
		
		System.out.println(json.getString("[0]"));
		//System.out.println(json.getInt("[5]"));				// When the output is int then it 
		System.out.println(json.getList("$"));
		
		String jPath = "[\r\n"
				+ "  [\r\n"
				+ "    \"10\",\r\n"
				+ "    \"20\",\r\n"
				+ "    \"30\",\r\n"
				+ "    \"40\",\r\n"
				+ "    \"50\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "    \"100\",\r\n"
				+ "    \"200\",\r\n"
				+ "    \"300\",\r\n"
				+ "    \"400\",\r\n"
				+ "    \"500\"\r\n"
				+ "  ]\r\n"
				+ "]";
		
		JsonPath json1 = new JsonPath(jPath);
		
		System.out.println((Object)json1.get());
		System.out.println(json1.getString("[0][2]"));
		System.out.println("Size is "+json1.getList("$").size());
		
//		List<Object> ls1 = (List<Object>) json.getList("$").get(0);
//		System.out.println((Object) ls1);
		
		
		String jsonArray = "[\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Amod\",\r\n"
				+ "    \"lastname\": \"Mahajan\",\r\n"
				+ "    \"age\": 28,\r\n"
				+ "    \"address\": [\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Mumbai\",\r\n"
				+ "        \"country\": \"India\",\r\n"
				+ "        \"pincode\": 88900\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Bhopal\",\r\n"
				+ "        \"country\": \"India\",\r\n"
				+ "        \"pincode\": 87800\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Bengaluru\",\r\n"
				+ "        \"country\": \"India\",\r\n"
				+ "        \"pincode\": 56700\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Mukesh\",\r\n"
				+ "    \"lastname\": \"Otwani\",\r\n"
				+ "    \"age\": 34,\r\n"
				+ "    \"address\": [\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Bhopal\",\r\n"
				+ "        \"country\": \"India\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"city\": \"Delhi\",\r\n"
				+ "        \"country\": \"India\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "]";
		
		JsonPath jPa = new JsonPath(jsonArray);
		
		System.out.println("City 1 is "+jPa.getString("[0].address[1].city"));
		System.out.println("City 2 is "+jPa.getString("[1].address[0].city"));
		
		System.out.println(jPa.getString("[0].address.city"));
		
		System.out.println(jPa.getList("address.pincode"));
		
		//if(jPa.getList("address.pincode") isInstanceOf())
		
		
		

	}

}
