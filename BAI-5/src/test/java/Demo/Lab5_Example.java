package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_Example{
	
	static WebDriver driver;
	static WebDriverWait wait; 
	
	@BeforeClass
	public void init() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}
	@Test
	public void TC01_GoogleSearch() {
	// mở trang gogle
	driver.get("https://www.google.com.vn/");
	
	// cài đặt thời gian tải trang không quá 15s
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	// lấy ra ô nhập văn bản tìm kiếm
	WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));	
	
	//nhâp từ khoá "selenium" vào ô tìm kiếm 
	inputSearch.sendKeys("Selenium");
	
	//lấy ra nút tìm kiếm trên google
	WebElement btnSearch = driver.findElement(By.name("btnK"));

	// tHỰC HIỆN CLICK CHUỘT VÀO NÚT TÌM KIẾM TRÊN GOOGLE
	btnSearch.click();
	
	// Wait for search results page to load (you can add more assertions here)
	System.out.println("FINISHTC 01");
	
	}
	@AfterClass
	public void terminate() {
		System.out.println("finish: close browser");
		driver.close();
	}

}
