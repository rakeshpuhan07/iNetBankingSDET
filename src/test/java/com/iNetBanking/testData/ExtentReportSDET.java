package com.iNetBanking.testData;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSDET {
	
//	public static ExtentReports getReportObject()
//	{
//		String path =System.getProperty("user.dir")+"//reports//index.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Web Automation Results");
//		reporter.config().setDocumentTitle("Test Results");
//		
//		ExtentReports extent =new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester", "Rakesh Puhan");
//		return extent;
//		
//		
//		
//	}
	static ExtentReports extent;

	public static ExtentReports getReportObject() {

	    if (extent == null) {

	        String reportDir = System.getProperty("user.dir") + "/reports";
	        new File(reportDir).mkdirs();

	        String path = reportDir + "/index.html";

	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setReportName("Web Automation Results");
	        reporter.config().setDocumentTitle("Test Results");

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Rakesh Puhan");
	    }

	    return extent;
	}

}
