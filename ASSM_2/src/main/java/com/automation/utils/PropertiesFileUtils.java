package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtils {
//đường dẫn đến properties files trong folder configuration
	private static String CONFIG_PATH = "./configuration/configs.properties";
	
//lấy ra giá trị property bất kỳ theo key
	public static String getProperty(String key) {
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream(CONFIG_PATH);
			properties.load(input);
		}catch (IOException e) {
			System.out.println("Lỗi khi đọc tệp properties: " + e.getMessage());
			e.printStackTrace();	
		}
		return properties.getProperty(key);
	}
}
