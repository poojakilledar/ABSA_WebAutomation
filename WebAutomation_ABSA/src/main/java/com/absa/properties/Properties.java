package com.absa.properties;

import java.io.IOException;

public class Properties {
	
	public EnvironmentProperties environmentProperties;
	public ExecutionProperties executionProperties;
	
	public Properties() throws IOException{
		executionProperties = new ExecutionProperties();
		environmentProperties = new EnvironmentProperties(executionProperties.getEnvironment());
	}

}
