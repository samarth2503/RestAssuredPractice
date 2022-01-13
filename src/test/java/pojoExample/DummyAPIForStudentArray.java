package pojoExample;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class DummyAPIForStudentArray {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		
		s.setAccountNo(234);
		s.setBalnce(3456.78);
		s.setEmail("samarjain@gmail.com");
		s.setFirstName("Samarth");
		s.setGender("Male");
		s.setLastName("Jain");
		
		Student s1 = new Student();
		
		s1.setAccountNo(235);
		s1.setBalnce(3456.79);
		s1.setEmail("amodmahajan@gmail.com");
		s1.setFirstName("amod");
		s1.setGender("Male");
		s1.setLastName("Mahajan");
		
		List<Student> jsonArray = new ArrayList<>();
		jsonArray.add(s);
		jsonArray.add(s1);
		
		RestAssured.given()
		.log()
		.all()
		.body(jsonArray)
		.when()
		.get()
		.then()
		.log()
		.all();
	}

}
