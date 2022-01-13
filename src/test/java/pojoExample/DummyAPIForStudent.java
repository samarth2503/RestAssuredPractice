package pojoExample;

import io.restassured.RestAssured;

public class DummyAPIForStudent {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		
		s.setAccountNo(234);
		s.setBalnce(3456.78);
		s.setEmail("samarjain@gmail.com");
		s.setFirstName("Samarth");
		s.setGender("Male");
		s.setLastName("Jain");
		
		RestAssured.given()
		.log()
		.all()
		.body(s)
		.when()
		.get()
		.then()
		.log()
		.all();
	}

}
