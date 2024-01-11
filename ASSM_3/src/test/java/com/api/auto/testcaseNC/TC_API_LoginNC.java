package com.api.auto.testcaseNC;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import io.restassured.http.ContentType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.auto.baseNC.RequestInstance;
import com.api.auto.utilNC.PropertiesFileUtilsNC;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_API_LoginNC extends RequestInstance {
	private ResponseBody responseBody;
	private JsonPath jsonBody;
	private Response response;

	@BeforeClass
	public void setup() {
		userLogin.put("account", account);
		userLogin.put("password", password);

		RequestSpecification request = given().contentType(ContentType.JSON);
		response = request.body(userLogin).post(url + loginPath);

		responseBody = response.getBody();
		jsonBody = responseBody.jsonPath();

		System.out.println(response.getStatusCode() + "\n" + responseBody.asPrettyString());
	}

	@Test(priority = 0)
	public void TC_01_Validate200Ok() {
		assertEquals(response.getStatusCode(), 200, "Status Check Failed!");
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
		PropertiesFileUtilsNC.writeJson("./data/token.json", 1, "token", token);
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
		String accountActual = jsonBody.getString("user.account");
		assertEquals(accountActual,account, "account is not matched!");

		assertTrue(response.asString().contains("password"), "password feid check Failed!");
		String passwordActual = jsonBody.getString("user.password");
		assertEquals(passwordActual, password, "password feid is not matched!");
	}

}
