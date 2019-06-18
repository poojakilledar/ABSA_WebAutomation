package com.absa.properties;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExecutionProperties {
	private final String propertyFilePath = System.getProperty("user.dir")+"/resources/config/executionHost.properties";
	private String environment;
	private Properties properties;	

	public ExecutionProperties() throws IOException{
		readPropetyFile();
	}

	public void readPropetyFile() throws IOException{
		properties = new Properties();
		properties.load(new FileInputStream(propertyFilePath));		
		setEnvironment(properties.getProperty("environment"));
			
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}


}
