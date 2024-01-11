package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
// đường dẫn đến propertys file trong foder configuration
	private static String CONFIG_PATH = "./configuration/configs.properties";
// lấy ra giá trong property bất kỳ theo key
	public static String getProperty(String key) {
		Properties properties = new Properties();
		String value = null;
		FileInputStream fileInputStream = null;
		// bắt exception
		try {
			fileInputStream = new FileInputStream(CONFIG_PATH);
			properties.load(fileInputStream);
			value = properties.getProperty(key);
			return value;
		} catch( Exception ex) {
			System.out.println("xảy ra lỗi khi đọc giá trị của " + key);
			ex.printStackTrace();
		}
		finally {
			// luôn nhảy vào đây dù có xảy ra exception hay không.
			// thực hiện đóng 
			if(fileInputStream != null) {
				try {
					fileInputStream.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
	 
}
