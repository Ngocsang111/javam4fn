package com.api.auto.utilNC;

import java.io.*;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PropertiesFileUtilsNC {
	public static String readJson(String path, String key) {
		String value = "";
		try {
//			JSONObject jsonObject = (JSONObject) (new JSONParser()).parse(new FileReader(path));
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
			value = (String) jsonObject.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void writeJson(String path, int numOfFeld, String key, String value) {
		try {
			JSONObject job = new JSONObject();

			for (int i = 0; i < numOfFeld; i++) {
				job.put(key, value);
			}
			FileWriter file = new FileWriter(path);
			file.write(job.toJSONString());
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
