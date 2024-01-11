package com.automation.base;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.io.FileHandler;


public class CaptureScreenshot {
	public static void takeScreenshot(WebDriver driver, String testcaseName) {

	try {
		//tạo tên ảnh trùng với tên testcase, kiểu ảnh là png
		String imageName = testcaseName + ".png";
		
		//thực hiện chụp ảnh màn hình, lấy ra đối tượng file ảnh source.
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//tạo đối tượng file với tên đã đặt bên trên tại thư mục /ScreenShots.
		//sau đó thực hiện copy file ảnh nguồn vào file đích đó
		File destiny = new File("./ScreenShots" + "/" + imageName);
		FileHandler.copy(source, destiny);
	}catch (Exception ex) {
		System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
		ex.printStackTrace();
	}
	}
}