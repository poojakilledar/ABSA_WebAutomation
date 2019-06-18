package com.absa.browser;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.absa.pageObjectModel.Locator;
import com.absa.reports.Assertion;


public class Browser extends BrowserSettings{

	private WebElement element;


	public Browser() throws IOException{
		super();
		System.out.println("inside browser ctor");

	}

	public Browser(final BrowserType browserType) {
		super(browserType);
		System.out.println("inside browser param ctor");
	}

	public void openURL(final String url) throws IOException{		
		if(getDriver() == null || getDriver().getWindowHandles().isEmpty()){
			startDriver();			
		}
		getDriver().get(url);
		Assertion.assertTrue(true,"Open URL :"+url);
		//maximizeBrowserWindow();
	}

	public void refreshBrowser()
	{
		getDriver().navigate().refresh();
	}
	public void click(Locator pageElement)
	{
		try {
			this.element=this.getElement(pageElement);
			this.element.click();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void maximizeBrowserWindow(){
		getDriver().manage().window().maximize();
	}

	private WebElement getElement(final Locator locator)
			throws ParserConfigurationException, SAXException, IOException {
		WebElement webElement = null;

		// Reset implicit wait if changed
		//this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);



		try {
			switch (locator.getLocatorType()) {
			case CLASS_NAME:
				webElement = getDriver().findElement(By.className(locator.getLocatorValue()));
				break;
			case ID:
				webElement = getDriver().findElement(By.id(locator.getLocatorValue()));
				break;
			case LINK_TEXT:
				webElement = getDriver().findElement(By.linkText(locator.getLocatorValue()));
				break;
			case NAME:
				webElement = getDriver().findElement(By.name(locator.getLocatorValue()));
				break;
			case PARTIAL_LINK_TEXT:
				webElement = getDriver().findElement(By.partialLinkText(locator.getLocatorValue()));
				break;
			case TAG_NAME:
				webElement = getDriver().findElement(By.tagName(locator.getLocatorValue()));
				break;
			case XPATH:
				webElement = getDriver().findElement(By.xpath(locator.getLocatorValue()));
				break;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public boolean isElementVisible(Locator pageElement){

		try {
			this.element = this.getElement(pageElement);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(element == null){
			return false;
		}
		else {
			return element.isDisplayed();
		}
	}


	public void closeBrowser()
	{
		getDriver().close();
	}

	public void closeAllBrowser()
	{
		getDriver().quit();
	}

	public void enterText(Locator pageElement,String textToEnter)
	{
		try {			
			this.element=this.getElement(pageElement);
			this.element.clear();
			this.element.sendKeys(textToEnter);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void selectByLabel(Locator pageElement,String textToSelect)
	{
		try {
			this.element=this.getElement(pageElement);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropDown=new Select(this.element);
		dropDown.selectByVisibleText(textToSelect);
	}
	
	
	public List<WebElement> getEelementList(Locator pageElement)
	{
		List <WebElement> elements=this.getDriver().findElements(pageElement.getLocator());
		return elements;
	}
	
	public String getEelementText(Locator pageElement)
	{
		String text=this.getDriver().findElement(pageElement.getLocator()).getText();
		return text;
	}
	
	

}

