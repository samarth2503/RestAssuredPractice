package JsonPathExamples;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFilter {
	

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\samarjain\\eclipse-workspace\\RestAssuredPractice\\src\\test\\resources\\01201920ACXPK3463A82J.json";
		
		File f = new File(filePath);
		
		JsonPath js = new JsonPath(f);
		
		
		List<String> date = js.getList("cdnur.nt_dt");
		System.out.println(date);
		
		String strdate = js.getString("cdnur[0].nt_dt");
		System.out.println("First Date "+strdate);
		
		List<String> iDate=js.getList("b2cl[0].inv.idt");
		System.out.println("Invoice Date "+iDate);
		
		System.out.println((Object)js.getJsonObject("$."));
		
		// To get Item details
		List<String> itemDetail=js.getList("b2cl[0].inv.itms.itm_det");
		System.out.println(itemDetail);
		
		// To get ctin
		String ctin=js.getString("b2b[0].ctin");
		System.out.println("Ctin = "+ctin);
		
	}

}
