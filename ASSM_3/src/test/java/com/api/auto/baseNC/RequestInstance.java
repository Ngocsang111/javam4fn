package com.api.auto.baseNC;

import java.util.HashMap;
import java.util.Map;

import com.api.auto.utilNC.PropertiesFileUtilsNC;

public class RequestInstance {

	protected String url = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "baseurl");
	protected String loginPath = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "loginPath");
	protected String createWorkPath = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "createWorkPath");
	protected String account = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "account");
	protected String password = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "password");
	protected String nameWork = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "nameWork");
	protected String experience = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "experience");
	protected String education = PropertiesFileUtilsNC.readJson("./data/inputJSON.json", "education");
	protected String token = PropertiesFileUtilsNC.readJson("./data/token.json", "token");

	protected Map<String, String> userLogin = new HashMap<String, String>();
	protected Map<String, String> usercreatework = new HashMap<String, String>();
}
