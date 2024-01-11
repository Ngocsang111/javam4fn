package com.api.auto.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.auto.utils.PropertiesFileUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_API_Login {
	private String account;
	private String password;
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;

	@BeforeClass
	public void init() throws IOException {
		String baseUrl = PropertiesFileUtils.getProperty("baseUrl");
		String loginPath = PropertiesFileUtils.getProperty("loginPath");
		account = PropertiesFileUtils.getProperty("account");
		password = PropertiesFileUtils.getProperty("password");
		
		RestAssured.baseURI = baseUrl;
		RestAssured.basePath = loginPath;

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("account", account);
		body.put("password", password);

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).body(body);
		response = request.post();
		responseBody = response.getBody();
		jsonBody = responseBody.jsonPath();

		System.out.println(response.getStatusCode() + "\n" + responseBody.asPrettyString());
	}

	@Test(priority = 0)
	public void TC_01_Validate200Ok() {
		assertEquals(response.getStatusCode(), 200 , "Status Check Failed!");
	}

	@Test(priority = 1)
	public void TC_02_ValidateMessage() {
		assertTrue(responseBody.asString().contains("message"), "message feid check Failed!");

		String messageExpected = "Đăng nhập thành công";
		String messageActual = jsonBody.get("message");
		assertEquals(messageActual, messageExpected, "message is not macthed!");
	}

	@Test(priority = 2)
	public void TC_03_ValidateToken() {
		String token = jsonBody.getString("token");
		assertTrue(response.asString().contains("token"), "token feid check Failed!");

		PropertiesFileUtils.saveToken(token);
	}

	@Test(priority = 3)
	public void TC_04_ValidateUserType() {
		assertTrue(response.asString().contains("user"), "user feid check Failed!");
		assertTrue(response.asString().contains("type"), "type feid check Failed!");

		String typeExpected = "UNGVIEN";
		String typeActual = jsonBody.getString("user.type");
		assertEquals(typeActual, typeExpected, "type is not macthed!");
	}

	@Test(priority = 4)
	public void TC_05_ValidateAccount() throws IOException {
		assertTrue(response.asString().contains("account"), "account feid check Failed!");
		String accountExpected = PropertiesFileUtils.getProperty("account");
		String accountActual = jsonBody.getString("user.account");
		assertEquals(accountActual, accountExpected, "account is not matched!");

		assertTrue(response.asString().contains("password"), "password feid check Failed!");
		String passwordExpected = PropertiesFileUtils.getProperty("password");
		String passwordActual = jsonBody.getString("user.password");
		assertEquals(passwordActual, passwordExpected, "password feid is not matched!");
	}
}
