package JsonPathExamples;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFilter2 {
	
	public static void main(String[] args)
	{
		String filePath = "C:\\Users\\samarth.jain\\eclipse-workspace\\RestAssuredPractice\\src\\test\\resources\\SampleData.json";
		File f = new File(filePath);
		
		JsonPath js = new JsonPath(f);
		
		List<Object> booktitle=js.getList("store.book.title");
		System.out.println(booktitle);
		
		// By using findAll we will get List
		List<String> authorList=js.getList("store.book.findAll{it.price < 50.00f}.author");
		System.out.println(authorList);
		
		// By using find we will get only one result
		String title=js.getString("store.book.find{it.category=='fiction' | it.price>50.00f}.title");
		System.out.println("Title is "+title);
		
		
		// Get will return primitive datatype type, List or Map
		// Object can hold Map,List and any primitive datatype
		// Eg:- Object obj = new LinkedHashMap<String,String>();
		Object bicycle=js.get("store.bicycle");
		System.out.println(bicycle);
		
		int listSize=js.getList("store.book").size();
		System.out.println("List Size is "+listSize);
		
		System.out.println(""+js.get("color"));
		
	}

}
