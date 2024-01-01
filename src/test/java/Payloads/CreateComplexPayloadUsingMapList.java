package Payloads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateComplexPayloadUsingMapList {

	public static void main(String[] args) {
		
		List<Map<String,Object>> finalPayload = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> firstJsonObject = new LinkedHashMap<String,Object>();
		
		firstJsonObject.put("id", "1");
		firstJsonObject.put("first_name", "Samarth");
		firstJsonObject.put("last_name", "Jain");
		firstJsonObject.put("email", "samarjain@deloitte.com");
		firstJsonObject.put("gender", "Male");
		
		List<String> mobileNo = new ArrayList<String>();
		
		mobileNo.add("9619399027");
		mobileNo.add("3892091886");
		
		firstJsonObject.put("mobile", mobileNo);
		
		Map<String,Object> skillsSet1 = new LinkedHashMap<String,Object>();
		
		skillsSet1.put("name", "Testing");
		skillsSet1.put("proficiency", "Medium");
		
		firstJsonObject.put("skills", skillsSet1);
		
		finalPayload.add(firstJsonObject);
		
		Map<String,Object> secondJsonObject = new LinkedHashMap<String,Object>();
		
		secondJsonObject.put("id", "2");
		secondJsonObject.put("first_name", "Alex");
		secondJsonObject.put("last_name", "Mahajan");
		secondJsonObject.put("email", "alexn@deloitte.com");
		secondJsonObject.put("gender", "Male");
		
		List<Map<String,Object>> skillsList = new ArrayList<>();
		
		skillsList.add(skillsSet1);
		
		Map<String,Object> javaSkills = new LinkedHashMap<String,Object>();
		
		javaSkills.put("name", "Java");
		javaSkills.put("proficiency", "Medium");
		
		List<String> cerifications = Arrays.asList("OCJP 11","OCJP 12");
		
		javaSkills.put("certifications", cerifications);
		
		skillsList.add(javaSkills);
		
		secondJsonObject.put("skills", skillsList);
		
		finalPayload.add(secondJsonObject);
		
		
		
		RestAssured.given()
		.log()
		.all()
		.body(finalPayload)
		.get();
	}

}
