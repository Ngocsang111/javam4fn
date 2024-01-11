package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.utils.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;
	@BeforeClass
	public void initDriverInstance() {
		WebDriverManager.chromedriver().setup();
		// khởi tạo chrome driver
		driver = new ChromeDriver();
		
		//set max size cho cửa sổ trình duyệt
		driver.manage().window().maximize();
		driver.get(PropertiesFileUtils.getProperty("base_url"));
	}
	
	@AfterClass
	public void closeDriverInstance() {
		driver.quit();
	}

}
