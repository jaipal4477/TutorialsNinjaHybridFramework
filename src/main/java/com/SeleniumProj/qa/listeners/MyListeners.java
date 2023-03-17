package com.SeleniumProj.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import com.SeleniumProj.qa.Utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener{

	
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution of Project Test Started");
		extentReport = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		testName = result.getName();
		ExtentTest extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+"Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		testName = result.getName();
		extentTest.log(Status.PASS, testName+"got Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot  t = (TakesScreenshot) DemoListener.driver;
		  
	     File srcFile = t.getScreenshotAs(OutputType.FILE);
	  
	     try {
	     File arg0 = null;
		 File destFile = new File ("./ScreenShots/"+arg0.getName()+".jpg");
	     FileUtils.copyFile(srcFile, destFile);
	     Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	    } 
	    catch (IOException e) {
	    e.printStackTrace();
	   }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		 testName = result.getName();
		 extentTest.log(Status.INFO, result.getThrowable());
		 extentTest.log(Status.SKIP, testName+"Got Skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished Executing Project Test");
		extentReport.flush();
	}

}
