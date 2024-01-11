package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	static WebDriverWait wait;
	WebDriver driver;
	public LoginPage(WebDriver dr) {
		wait = new WebDriverWait(dr, 15);
		driver = dr;
		PageFactory.initElements(dr, driver);
	}
	public void openLoginPage() {
		WebElement loginIcon = driver.findElement(By.xpath("//*[@href='/login']"));
		loginIcon.click();
	}
	public void InputEmail(String email) {
		WebElement inputEmail = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
		inputEmail.sendKeys(email);
	}
	public void InputPassword(String password) {
		WebElement inputPassword = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
		inputPassword.sendKeys(password);
	}
	public void SignInbtn() {
		WebElement btnLogin = driver.findElement(By.xpath("//*[@data-qa='login-button']"));

		btnLogin.click();
	}
	
}
