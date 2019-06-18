package com.absa.pageMethods;
import com.absa.browser.Browser;

public class Methods {

	public HomePageMethods homePageMethods;
	public Browser browser;
	public Methods(Browser browser){
		this.browser = browser;
		this.homePageMethods=new HomePageMethods(this.browser);
	}
	
	
}
