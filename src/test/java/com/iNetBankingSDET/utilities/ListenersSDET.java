package com.iNetBankingSDET.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iNetBanking.testData.ExtentReportSDET;
import com.iNetBankingSDET.testCases.BaseClass;

public class ListenersSDET implements ITestListener{
//	public class ListenersSDET extends BaseClass implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportSDET.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}


//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
////		ITestListener.super.onTestFailure(result);
//extentTest.get().fail(result.getThrowable());//
//		
//		try {
////			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
//					driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
//					.get(result.getInstance());
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		
//		String filePath = null;
//		try {
//			
//			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//	}
	
	@Override
	public void onTestFailure(ITestResult result) {

	    extentTest.get().fail(result.getThrowable());

	    // ✅ SAFE WAY (No reflection)
	    Object testClass = result.getInstance();
	    WebDriver driver = ((BaseClass) testClass).driver;

	    String filePath = null;
	    try {
	        filePath = ((BaseClass) testClass)
	                .getScreenshot(result.getMethod().getMethodName(), driver);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
