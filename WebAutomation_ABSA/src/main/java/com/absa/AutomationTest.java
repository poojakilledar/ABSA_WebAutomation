package com.absa;


import java.io.IOException;

import com.absa.browser.Browser;
import com.absa.browser.BrowserType;
import com.absa.pageMethods.Methods;
import com.absa.properties.Properties;
import com.absa.reports.Assertion;

public class AutomationTest {

	public Browser browser; 
	public Properties properties;
	public Methods methods;
	public Assertion assertion;
	
	public AutomationTest() throws IOException{
		//this.executionEssentials=new ExecutionEssentials();
		this.properties=new Properties();
		this.setBrowser();		
		this.methods=new Methods(browser);
		this.assertion=new Assertion();
	}

	private void setBrowser() throws IOException{
		browser = new Browser();
		String browserName = properties.environmentProperties.getBrowserType();		
		if(browserName != null)
			browser.setBrowserType(BrowserType.valueOf(browserName).getBrowserType());

	}
}



