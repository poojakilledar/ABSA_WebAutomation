package com.absa.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.absa.AutomationTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReportManager implements ITestListener{
	
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	protected static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	protected static ThreadLocal <ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static String filePath;
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			//test.get().log(Status.FAIL,"test case failed :"+result.getName());
			//test.log(LogStatus.FAIL,result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			test.get().log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
		
	}

	@AfterTest
	public void endReport(){		
		//extent.flush();
	}


	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File oldReport = new File(System.getProperty("user.dir") +"/Results/AutomationReport.html");
		boolean exists = oldReport.exists();
		if(exists)
		{
			oldReport.renameTo(new File(System.getProperty("user.dir") +"/Results/AutomationReport"+timeStamp+".html"));
			//File destFile = new File(System.getProperty("user.dir") +"/Results/AutomationReport"+timeStamp+".html");	
			//FileUtil.moveFile(oldReport, destFile);
		}

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Results/AutomationReport.html");
		htmlReporter.config().setDocumentTitle("WEB-Automation-Report");
		extent = new ExtentReports ();				
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User Name", "Pooja Killedar");
		System.out.println("Report Path :"+System.getProperty("user.dir"));
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentTest parent = extent.createTest(arg0.getInstance().getClass().getSimpleName());
		parentTest.set(parent);
		ExtentTest child = parentTest.get().createNode(arg0.getName());
		test.set(child);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
	
		}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
	
	public static String capture(AutomationTest test,String screenShotName) throws IOException
	{	
		WebDriver driver=test.browser.getDriver();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".jpeg";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);    
		return dest;
	}


}