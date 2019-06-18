package com.absa.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.absa.AutomationTest;
import com.absa.browser.Browser;
import com.absa.browser.BrowserSettings;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

public class Assertion extends ExtentReportManager{
	
	private static AutomationTest autoTest;
	
 public static void setAutomationTest(AutomationTest automationTest)
	{
		autoTest=automationTest;
	}

	public static void assertEquals(boolean actual,boolean expected,String details,boolean screenShot)
	{
		if(actual==expected)
		{		
			test.get().log(Status.PASS, details);
			Assert.assertTrue(true,details);
		}
		else
		{			
			
			String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			try {
				test.get().log(Status.FAIL,details, MediaEntityBuilder.createScreenCaptureFromPath(capture(autoTest, name)).build());				
				//test.get().addScreenCaptureFromPath(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false,details);
		}
	}

	public static void assertFail(String details)
	{		
		String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try {
			test.get().log(Status.FAIL,details, MediaEntityBuilder.createScreenCaptureFromPath(capture(autoTest, name)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.fail(details);
	}

	public static void assertTrue(boolean condition ,String details)
	{
		if(condition)
		{
			test.get().log(Status.PASS, details);
			Assert.assertTrue(condition, details);
		}
		else
		{
			String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			try {
				test.get().log(Status.FAIL,details, MediaEntityBuilder.createScreenCaptureFromPath(capture(autoTest, name)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			Assert.assertTrue(condition, details);
		}
	}

}
