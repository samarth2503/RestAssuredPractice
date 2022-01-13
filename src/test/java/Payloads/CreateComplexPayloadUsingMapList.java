package Payloads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateComplexPayloadUsingMapList {

	public static void main(String[] args) {
		
		List<Map<String,Object>> finalPayload = new LinkedList<>();
		
		Map<String,Object> firstObject = new LinkedHashMap<>();
		
		firstObject.put("id", 1);
		firstObject.put("first_name", "Samarth");
		firstObject.put("last_name", "Jain");
		firstObject.put("email", "samarthjain68@gmail.com");
		firstObject.put("gender", "Male");
		
		List<Object> mobile = Arrays.asList("5566778821","4422116680");
		
		firstObject.put("mobile", mobile);
		
		Map<String,Object> skillsObject = new LinkedHashMap<>();
		
		skillsObject.put("name", "Testing");
		skillsObject.put("proficiency", "Medium");
		
		firstObject.put("skills", skillsObject);
		
		finalPayload.add(firstObject);
		
		Map<String,Object> secondObject = new LinkedHashMap<>();
		
		secondObject.put("id", 2);
		secondObject.put("first_name", "Joe");
		secondObject.put("last_name", "Root");
		secondObject.put("email", "joeroot68@gmail.com");
		secondObject.put("gender", "Male");
		
		List<Map<String,Object>> skillSet = new ArrayList<>();
		
		Map<String,Object> skill = new LinkedHashMap<>(); 
		
		skill.put("name", "Testing");
		skill.put("proficiency", "Medium");
		
		skillSet.add(skill);
		
		Map<String,Object> skill2 = new LinkedHashMap<>();
		List<String> certificate = Arrays.asList("OCJP 11","OCJP 12");
		
		skill2.put("name", "Java");
		skill2.put("proficiency", "Medium");
		
		skill2.put("certification", certificate);
		
		skillSet.add(skill2);
		
		secondObject.put("skill",skillSet);
		
		finalPayload.add(secondObject);
		
		RestAssured.given()
		.log()
		.all()
		.body(finalPayload)
		.get();
	}

}
