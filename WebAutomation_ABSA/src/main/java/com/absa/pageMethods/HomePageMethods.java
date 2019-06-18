package com.absa.pageMethods;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.absa.browser.Browser;
import com.absa.pages.HomePage;
import com.absa.reports.Assertion;
import com.absa.reports.ExtentReportManager;


public class HomePageMethods extends ExtentReportManager{
	private Browser browser;	
	
	
	public static String TEST_DATA_FILE=System.getProperty("user.dir") + "//resources//testdata//UserDetails.xlsx";

	public HomePageMethods(Browser browser){
		this.browser = browser;
	}

	/**
	 * This method verifies if the user list table is displayed or not
	 */
	public void verifyUserListTable()
	{		
		Assertion.assertEquals(this.browser.isElementVisible(HomePage.userListTable().getLocator()),true, "Verify user list table is Displayed",this.browser.isElementVisible(HomePage.userListTable().getLocator())!=true);		
	}


	/**
	 * This method clicks on the Add User button
	 */
	public void clickOnAddUser()
	{
		this.browser.click(HomePage.addUserButton().getLocator());
	}

	/**
	 * This method adds the user to user list table
	 */	
	public void addUser(String fName,String lName,String uName,String password,String customer, String role,String email,String mobilePhone)
	{	
		
			this.browser.enterText(HomePage.firstNameTextBox().getLocator(), fName);
			this.browser.enterText(HomePage.lastNameTextBox().getLocator(), lName);
			this.browser.enterText(HomePage.userNameTextBox().getLocator(), uName);
			this.browser.enterText(HomePage.passwordTextBox().getLocator(), password);
			this.browser.click(HomePage.customerRadioButton(customer).getLocator());
			this.browser.selectByLabel(HomePage.roleList().getLocator(), role);
			this.browser.enterText(HomePage.emailTextBox().getLocator(), email);
			this.browser.enterText(HomePage.mobilePhoneTextBox().getLocator(),mobilePhone);
			this.browser.click(HomePage.saveButton().getLocator());
	}
	
	
	/**
	 * verify if the user name is already existing in tbale
	 */
	public boolean checkUsernameAvailability(String uName)
	{
		List <WebElement> userNameList=this.browser.getEelementList(HomePage.userName().getLocator());
		for (Iterator<WebElement> iterator = userNameList.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			String text=webElement.getText();	
			if(text.equals(uName))
				return false;
			break;			
		}
		return true;
	}

	
	/**
	 * verify if the element is added to list
	 */
	public void verifyUserIsAddedToList(String fName, String lName, String uName,String eMail)
	{	
		boolean actual = false;
		if(this.browser.isElementVisible((HomePage.userListTableRecord(fName).getLocator())))
		actual=this.browser.isElementVisible(HomePage.userListTableRecord(fName).getLocator())&&this.browser.isElementVisible(HomePage.userListTableRecord(lName).getLocator())&&this.browser.isElementVisible(HomePage.userListTableRecord(uName).getLocator())&&this.browser.isElementVisible(HomePage.userListTableRecord(eMail).getLocator());
		Assertion.assertEquals(actual,true,"User :'"+uName+"' is successfully added to the list",this.browser.isElementVisible((HomePage.userListTableRecord(fName).getLocator()))!=true);
	}
	
}



