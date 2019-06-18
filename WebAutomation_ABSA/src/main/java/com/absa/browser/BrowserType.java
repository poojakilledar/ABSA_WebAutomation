package com.absa.browser;


public enum BrowserType {
	CHROME("chrome"),
	FIREFOX("firefox"),
	INTERNET_EXPLORER("ie");
	

	private String browserType;

	BrowserType(String browserType){
		this.browserType = browserType;
	}

	public String getBrowserType(){
		return browserType;
	}


}
