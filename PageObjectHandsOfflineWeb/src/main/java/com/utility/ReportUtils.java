package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseClass;

public class ReportUtils extends BaseClass{
	
	public static ExtentReports report = null;
	
	public static ExtentSparkReporter spark = null; 
	
	public static ExtentTest test = null;
	
	public static void reportInit() {
		
		log.info("Creating object of ExtentReports & ExtentSparkReporter");
		
		report = new ExtentReports();
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/ExtentReport.html");
		
		report.attachReporter(spark);
	}

}
