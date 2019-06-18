package com.absa.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {
	private final String environmentPropertyPath = System.getProperty("user.dir")+"/resources/environments/";
	private Properties properties;
	private String baseURL;
	private String browserType;

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	public EnvironmentProperties(final String environment) throws IOException{
		readPropertiFile(environment);
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	private void readPropertiFile(final String environment) throws IOException{
		properties = new Properties();		
		properties.load(new FileInputStream(environmentPropertyPath+environment+"/environment.properties"));
		setBaseURL(properties.getProperty("baseURL"));
		setBrowserType(properties.getProperty("browserType"));

	}
}
