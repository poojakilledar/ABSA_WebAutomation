package com.absa.browser;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.service.DriverService;


public abstract class BrowserSettings {

	private String browserType;
	private DriverService driverService;
	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;
	private final String CHROME_DRIVER_FILEPATH = System.getProperty("user.dir")+"/resources/Drivers/chromedriver.exe";	
	private final String FIREFOX_GECKODRIVER_PATH = System.getProperty("user.dir")+"/src/main/resources/Drivers/geckodriver.exe";
	private final String IE_DRIVER_PATH = System.getProperty("user.dir")+"/src/main/resources/Drivers/IEDriverServer.exe";

	public BrowserSettings(final BrowserType browserType){
		setBrowserType(browserType.getBrowserType());
	}

	public BrowserSettings() throws IOException{
		setBrowserType(BrowserType.valueOf("FIREFOX").getBrowserType());
	}

	private String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	protected void setDriver(WebDriver driver){
		this.driver = driver;
	}

	protected void startDriver() throws IOException{
		if(getBrowserType().equals("firefox")){
			startFirefoxDriver();
		} else if(getBrowserType().equals("chrome")){
			startCromeDriver();
		} else if(getBrowserType().equals("ie")){
			startIEDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setJavaScriptExecutor();
	}


	private void startCromeDriver() throws IOException{
		driverService = new ChromeDriverService.Builder().usingAnyFreePort().usingDriverExecutable(new File(CHROME_DRIVER_FILEPATH)).build();
		driverService.start();
		driver = new ChromeDriver((ChromeDriverService) driverService);
	}


	private void startFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", FIREFOX_GECKODRIVER_PATH);
		driver = new FirefoxDriver();
	}

	private void startIEDriver() throws IOException{
		driverService = new InternetExplorerDriverService.Builder().usingAnyFreePort().usingDriverExecutable(new File(IE_DRIVER_PATH)).build();
		driverService.start();
		driver = new InternetExplorerDriver((InternetExplorerDriverService) driverService);
	}

	protected void stopDriverService(){
		if(driverService.isRunning())
			driverService.stop();
		driver = null;
	}

	public WebDriver getDriver(){
		return driver;
	}

	private void setJavaScriptExecutor(){
		javascriptExecutor = (JavascriptExecutor) driver;
	}

	public JavascriptExecutor getJavaScriptExecutor(){
		return javascriptExecutor;
	}
}
