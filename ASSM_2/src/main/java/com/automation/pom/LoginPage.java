package com.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
	private WebDriverWait wait;
	
	
	private By login_email = By.xpath(PropertiesFileUtils.getProperty("login_email"));
	private By login_password = By.xpath(PropertiesFileUtils.getProperty("login_password"));
	private By login_signin = By.xpath(PropertiesFileUtils.getProperty("login_signin"));

	public LoginPage(WebDriver driver) {
		wait = new WebDriverWait(driver,30);
	}
	
	public void enterEmail(String email)throws InterruptedException{
		WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated (login_email));
		inputEmail.sendKeys(email);
		Thread.sleep(2000);
	}
	
	public void enterPassword(String password) throws InterruptedException{
		WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(login_password));
		inputPassword.sendKeys(password);
		Thread.sleep(2000);
	}
	
	
	public void clickSignIn() throws InterruptedException{
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(login_signin));
		signInButton.click();
		Thread.sleep(2000);
	}
}
	
