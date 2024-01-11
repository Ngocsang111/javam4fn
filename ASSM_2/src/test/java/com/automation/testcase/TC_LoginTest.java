package com.automation.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFileUtils;

public class TC_LoginTest extends DriverInstance {
	@Test(dataProvider = "Excel")
	public void TC01_LoginFirstAccount(String email, String password) throws InterruptedException {
		// lấy URL từ properties file và tải trang

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// lấy định danh iconSignin từ properties file và tìm kiếm, click
		WebElement iconSignIn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(PropertiesFileUtils.getProperty("icon_signin"))));
		iconSignIn.click();
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);

		// thực hiện đăng nhập qua loginPage
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();

		WebElement iconSignOut = driver.findElement(By.xpath(PropertiesFileUtils.getProperty("icon_signout")));
		iconSignOut.click();
	}

	@Test
	@DataProvider(name = "Excel")
	public Object[][] testDataGenerator() throws IOException {
		String excelFilePath = "./datas/assignment2_data_test.xlsx";
		FileInputStream fis = new FileInputStream(new String(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		Object[][] data = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			data[i][0] = username.getStringCellValue();
			data[i][1] = password.getStringCellValue();
		}
		workbook.close();
		fis.close();
		return data;

	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				String email = (String) result.getParameters()[0];
				int index = email.indexOf('@');
				String accountName = email.substring(0, index);
				CaptureScreenshot.takeScreenshot(driver, accountName);
			} catch (Exception e) {
				System.out.println("Error capturing screenshot: " + e.getMessage());
			}
		}
	}

}
