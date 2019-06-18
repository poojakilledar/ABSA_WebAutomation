package com.absa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.absa.AutomationTest;
import com.absa.pageMethods.HomePageMethods;
import com.absa.reports.Assertion;
import com.absa.reports.ExtentReportManager;
import com.absa.utility.ExcelUtility;

public class TC1_UserListTable extends ExtentReportManager{

	/*TEST DATA APPROACH : Storing the data in Excel file and using Data Provider to pass the data to test method*/
	@DataProvider(name = "GET_USER_DETAILS")
	public Object[][] getUserDetails() throws Exception {		
		ExcelUtility readXlsx = new ExcelUtility();
		return readXlsx.readFileAndSheet(HomePageMethods.TEST_DATA_FILE, "data");
	}


	@Test(dataProvider = "GET_USER_DETAILS")
	public void addUserToUserListTable(Map<String, String> key,Method method)
	{
		AutomationTest autoTest = null;
		try
		{
			autoTest = new AutomationTest();
			Assertion.setAutomationTest(autoTest);

			/*Launch home page URL*/
			autoTest.browser.openURL(autoTest.properties.environmentProperties.getBaseURL());

			/*Verify the user list table is diaplayed*/
			autoTest.methods.homePageMethods.verifyUserListTable();

			/*Get the test data from  data provider. Enter the user details and save*/
			String firstName=key.get("FirstName");
			String lastName=key.get("LastName");
			String userName=key.get("UserName");
			String password=key.get("Password");
			String customer=key.get("Customer");
			String Role=key.get("Role");
			String Email=key.get("Email");
			String cellPhone=key.get("CellPhone");			

			/*Check the user name availability*/
			boolean flag=autoTest.methods.homePageMethods.checkUsernameAvailability(userName);			
			if(flag)
			{
				/*Click on the Add user button*/
				autoTest.methods.homePageMethods.clickOnAddUser();
				autoTest.methods.homePageMethods.addUser(firstName,lastName,userName,password,customer,Role,Email,cellPhone);
			}
			else
				Assertion.assertEquals(flag,true,"Username Check. Verify if '"+userName+"' already exists. Please use another username.",flag!=true);

			/*Verify if the users are added to list*/			
			autoTest.methods.homePageMethods.verifyUserIsAddedToList(firstName, lastName, userName, Email);

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Assertion.assertFail(e.getMessage());

		}finally 
		{
			autoTest.browser.closeAllBrowser();
		}
	}
}

