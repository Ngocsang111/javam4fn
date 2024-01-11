package com.api.auto.testcaseNC;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.auto.baseNC.RequestInstance;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_API_CreateWorkNC extends RequestInstance {
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;

	@BeforeClass
	public void setup() {

		usercreatework.put("nameWork", nameWork);
		usercreatework.put("experience", experience);
		usercreatework.put("education", education);

		RequestSpecification request = given().contentType(ContentType.JSON).header("token", token)
				.body(usercreatework);
		response = request.post(url + createWorkPath);

		responseBody = response.getBody();
		jsonBody = responseBody.jsonPath();

		System.out.println(response.getStatusCode() + "\n" + responseBody.asPrettyString());
	}

	@Test(priority = 0)
	public void TC_01_Validate201Created() {
		assertEquals(response.getStatusCode(), 201, "Status check Failed!");
	}

	@Test(priority = 1)
	public void TC_02_ValidateWorkId() {
		assertTrue(responseBody.asString().contains("id"), "id feid check Failed!");
	}

	@Test(priority = 2)
	public void TC_03_ValidateNameOfWorkMatched() {
		assertTrue(responseBody.asString().contains("nameWork"), "nameWork feid check Failed!");
		String nameworkActual = jsonBody.getString("nameWork");
		assertEquals(nameworkActual, nameWork, "nameWork is not matched!");
	}

	@Test(priority = 3)
	public void TC_04_ValidateExperienceMatched() {
		assertTrue(responseBody.asString().contains("experience"), "experience feid check Failed!");
		String experienceActual = jsonBody.getString("experience");
		assertEquals(experienceActual, experience, "experience is not matched!");
	}

	@Test(priority = 4)
	public void TC_05_ValidateEducationMatched() {
		assertTrue(responseBody.asString().contains("education"), "education feid check Failed!");
		String educationActual = jsonBody.getString("education");
		assertEquals(educationActual, education, "education is not matched!");
	}

}
