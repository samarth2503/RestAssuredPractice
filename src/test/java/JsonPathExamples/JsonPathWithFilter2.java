package JsonPathExamples;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFilter2 {
	
	public static void main(String[] args)
	{
		String filePath = "C:\\Users\\samarjain\\eclipse-workspace\\RestAssuredPractice\\src\\test\\resources\\SampleData.json";
		File f = new File(filePath);
		
		JsonPath js = new JsonPath(f);
		
		List<Object> booktitle=js.getList("store.book.price");
		System.out.println(booktitle);
		
		if(booktitle instanceof List)
		{
			System.out.println("Book Title is isnatnce of List...");
		}
		
		// By using findAll we will get List
		List<String> authorList=js.getList("store.book.findAll{it.price < 50.00f}.author");
		System.out.println(authorList);
		
		// By using find we will get only one result
		String title=js.getString("store.book.find{it.category=='fiction' | it.price>50.00f}.title");
		System.out.println("Title is "+title);
		
		List<Object> firstName = js.getList("store.book.findAll{it.gender == 'Female'}.author");
		System.out.println(firstName);
		
		
		// Get will return primitive datatype type, List or Map
		// Object can hold Map,List and any primitive datatype
		// Eg:- Object obj = new LinkedHashMap<String,String>();
		Object bicycle=js.get("store.bicycle");
		System.out.println(bicycle);
		
		int listSize=js.getList("store.book").size();
		System.out.println("List Size is "+listSize);
		
		System.out.println(""+js.get("color"));
		
		//All Female First NAme
		List<Object> author = js.getList("store.book.findAll{it.gender == 'Female'}.author");
		System.out.println(author);
		
		String category = js.getString("store.book.find{it.author == 'Nigel Rees' & it.title == 'Sayings of the Century'}.category");
		System.out.println("Category is "+category);
	}

}
