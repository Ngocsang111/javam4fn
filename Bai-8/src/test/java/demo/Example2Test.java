package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Example2Test {
	private Response response; //lưu response của API
	private ResponseBody resBody; // body của response
	private JsonPath bodyJson; // body của response đã dc convert sang JSON
	int userId;
	
	@BeforeClass
	public void init() {
		userId = 40;
		// thiết lập endpoint
		//restAssured.baseURI = "https://reqres.in"; //Setup base URI
		//RessAssured.basePath = "/api/users/{userId}"; //Setup Base Path
		// tạo request
		RequestSpecification req = RestAssured.given().when().pathParam("userId", userId);
		//gọi GET và lấy về response
		response = req.get("https://reqres.in/api/users/{userId}");
		resBody = response.getBody();
		bodyJson = resBody.jsonPath();//response JSON
		System.out.println(resBody.asString());
	}
	
	@Test
	public void T01_StatusCodeTest() {
		//kiểm tra HTTP status code có == 404 hay không?
		assertEquals(404, response.getStatusCode(),"Status Check Failed!");
	}
	@Test
	public void T02_MessageChecked() {
		//xác minh kết quả trả về có trường message hay không?
		assertEquals(true, resBody.asString().contains("message"));
	}
	@Test
	public void T03_verifyOnMessageContainName() {
		String resName = bodyJson.getString("message");
		String expectMessage = "User not found!";
		assertEquals(resName, expectMessage);	
	}
	@AfterClass
	public void afterTest() {
		//reset valuse
		RestAssured.baseURI = null; //Setup Base URI
		RestAssured.basePath = null;
		
	}
}
