package com.automation.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
	

	public static void takeScreenshot(WebDriver driver, String name) throws Exception {
		String filename = "";
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			filename = "./screenshots/" + name + ".png";
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destiny = new File(filename);
			FileUtils.copyFile(source, destiny);
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi chụp màn hình");
			ex.printStackTrace();
		}
		attachScreenshotToReport(filename);

	}

	public static void attachScreenshotToReport(String filename) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			File file = new File(filename);

			Reporter.log("<a title =\"screenshots\" href=\"" + file.getAbsolutePath() + "\">" + "<img src=\""
					+ file.getAbsolutePath() + "\" alt='" + file.getName() + "'height='243'width='418'/></a>");
		} catch (Exception e) {

		}
	}
}



