package testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.CaptureScreenshot;
import com.automation.base.LoginPage;
import com.automation.base.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7DemoTest {
	private String base_url;
	WebDriver driver;

	@BeforeClass
	public void Init() {
		System.out.println("ini: Open Chrome");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(PropertiesFileUtils.getProperty("base_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void TC01_LoginFirstAccount() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLoginPage();
		loginPage.InputEmail(PropertiesFileUtils.getProperty("email_1"));
		loginPage.InputPassword(PropertiesFileUtils.getProperty("password_1"));
		loginPage.SignInbtn();
		Thread.sleep(1000);
		
		WebElement btnLogout = driver.findElement(By.xpath("//*[@href='/logout']"));
		btnLogout.click();
	}

	@Test(priority = 1)
	public void TC02_LoginSecondAccount() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLoginPage();
		loginPage.InputEmail(PropertiesFileUtils.getProperty("email_2"));
		loginPage.InputPassword(PropertiesFileUtils.getProperty("password_2"));
		loginPage.SignInbtn();
		Thread.sleep(1000);
		
		WebElement btnLogout = driver.findElement(By.xpath("//*[@href='/logout']"));
		btnLogout.click();

	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
// nếu kết quả failed thì chụp lại màn hình
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				CaptureScreenshot.takeScreenshot(driver, result.getName());
				System.out.println("Đã chụp màn hình: " + result.getName());
			} catch (Exception ex) {
				System.out.println("Exception while taking screenshot " + ex.getMessage());
			}
		}
	}

	@AfterClass
	public void finish() {
		driver.close();
	}
}
