package LAB6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB6 {
	private String url = "https://automationexercise.com/products";
	private WebDriver driver;
	private String keywork = "Stylish Dress";
	
	@BeforeClass
	public void input() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	@Test
	public void TC01_search() {
		Actions action = new Actions(driver);
		System.out.println("Start TC01");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement inputsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		WebElement inputsearchbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_search")));
		assertEquals(true, inputsearch.isDisplayed(),"Page load failed");
		
		action.sendKeys(inputsearch,keywork).build().perform();
		action.click(inputsearchbutton).build().perform();
		
		wait = new WebDriverWait(driver, 5);
		//WebElement resultsMesg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Searched Products']")));
		WebElement resultsMesg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Searched Products']")));
		assertEquals(true,resultsMesg.isDisplayed(), "tìm kiếm thất bại");
		
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='single-products']"));
		assertEquals(1,products.size(),"Có nhiều hơn 1 sản phẩm");
		
		//WebElement image = driver.findElement(By.xpath("//*[@class='single-products']/div[1]/img"));
		WebElement image = driver.findElement(By.xpath("//div[@class='single-products']"));
		assertTrue(image.isDisplayed(),"không có bức ảnh nào được tìm thấy");
		
		//WebElement productName = driver.findElement(By.xpath("//*[@class='single-products']/div[1]/p"));
		WebElement productName = driver.findElement(By.xpath("//div[@class='productinfo text-center']//p[contains(text(),'Stylish Dress')]"));
		assertEquals(keywork,productName.getText(),"tên sản phẩm không trùng với nội dung tìm kiếm");
		
		//WebElement productPrice = driver.findElement(By.xpath("//*[@class='single-products']/div[1]/h2"));
		WebElement productPrice = driver.findElement(By.xpath("//div[@class='productinfo text-center']//h2[contains(text(),'Rs. 1500')]"));
		assertTrue(productPrice.isDisplayed(),"không xuất hiện giá sản phẩm");
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement addcardbutton = driver.findElement(By.xpath("//*[@class='single-products']/div[1]/a"));
		assertTrue(addcardbutton.isDisplayed(),"không có button add to card");
		
		addcardbutton.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,5);
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='modal-content']/div[2]/p[1]"))));
		//WebElement message = driver.findElement(By.xpath("//*[@class='modal-content']/div[2]/p[1]"));
		WebElement message = driver.findElement(By.xpath("//p[normalize-space()='Your product has been added to cart.']"));
		String actualmesg = message.getText();
		String expectedmesg = "Your product has been added to cart.";
		assertEquals(actualmesg, expectedmesg,"message trả về trùng khớp");
		
	}
		
		@AfterClass
		public void terminate() {
			driver.close();

	}
}
