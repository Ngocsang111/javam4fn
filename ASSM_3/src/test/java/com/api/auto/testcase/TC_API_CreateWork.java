package com.api.auto.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class TC_API_CreateWork {
	private String token;
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;

	private String mywork = "Tester";
	private String myExperience = "Fesher";
	private String myEducation = "University";

	@BeforeClass
	public void init() {
		String baseUrl = PropertiesFileUtils.getProperty("baseUrl").toString();
		String createWorkPath = PropertiesFileUtils.getProperty("createWorkPath").toString();
		String token = PropertiesFileUtils.getToken("token").toString();

		RestAssured.baseURI = baseUrl;
		RestAssured.basePath = createWorkPath;

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("nameWork", mywork);
		body.put("experience", myExperience);
		body.put("education", myEducation);

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).header("token", token)
				.body(body);
		response = request.post();
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
		assertEquals(nameworkActual, mywork, "nameWork is not matched!");
	}

	@Test(priority = 3)
	public void TC_04_ValidateExperienceMatched() {
		assertTrue(responseBody.asString().contains("experience"), "experience feid check Failed!");
		String experienceActual = jsonBody.getString("experience");
		assertEquals(experienceActual, myExperience, "experience is not matched!");
	}

	@Test(priority = 4)
	public void TC_05_ValidateEducationMatched() {
		assertTrue(responseBody.asString().contains("education"), "education feid check Failed!");
		String educationActual = jsonBody.getString("education");
		assertEquals(educationActual, myEducation, "education is not matched!");
	}
}
