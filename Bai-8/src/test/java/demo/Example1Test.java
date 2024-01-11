package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Example1Test {
	private Response response; //lưu response của API
	private ResponseBody resBody; //body của response
	private JsonPath bodyJson; // body của response đã dc convert sang json
	int userId;
	
	@BeforeClass
	public void init() {
		userId = 2;
		// thiết lập endpoint
		RestAssured.baseURI = "https://reqres.in"; //Setup Base URI
		RestAssured.basePath = "/api/users/{userId}"; // Setup Base Path
		
		//tạo request
		RequestSpecification req = RestAssured.given().when().pathParam("userId", userId);
		
		//gọi GET và lấy về response
		response = req.get("https://reqres.in/api/users/{userId}");
		resBody = response.getBody();
		bodyJson = resBody.jsonPath(); // response JSON
	}
	@Test
	public void T01_StatusCodeTest() {
		// kiểm tra HTTP status có == 200 hay không?
		assertEquals(200, response.getStatusCode(), "Status Check Failed!");
	}
	@Test
	public void T02_IdChecked() {
		// kiểm tra phản hồi có chứa trương id hay không?
		assertTrue(resBody.asString().contains("id"), "id field check Failed!");
	}
	@Test
	public void T03_EmailChecked() {
		// kiểm tra phản hồi có chứa trường email hay không?
		assertTrue(resBody.asString().contains("email"), "email field check Failed!");
	}
	@Test
	public void T04_FirstNameChecked() {
		// kiểm tra phản hồi có chứa trường FirstName hay không?
		assertTrue(resBody.asString().contains("first_name"), "FirstName field check Failed!");
	}
	@Test
	public void T05_LastNameChecked() {
		// kiểm tra phản hồi có chứa trường LastName hay không?
		assertTrue(resBody.asString().contains("last_name"), "LastName field check Failed!");
	}
	@Test
	public void T06_AvatarChecked() {
		// kiểm tra phản hồi có chứa trường avatar hay không?
		assertTrue(resBody.asString().contains("avatar"), "Avatar field check Failed!");
	}
	@Test
	public void T07_verifyOnMatchingId() {
		// kiểm tra id có giống với user id hay không?
		int id = bodyJson.getInt("data.id");
		assertEquals(id(),id, "UserId is not matched!");
	}
	private Object id() {
		// TODO Auto-generated method stub
		return null;
	}
	@AfterClass
	public void afterTest() {
		//kết thúc test hiện tại thì clear enpoint để chạy tiếp test liền sau
		// test Suite
		//nếu test sau không sd chung enpoint với test hiện tại
		RestAssured.baseURI = null; // setup base URI
		RestAssured.basePath = null;
		
	}

}
