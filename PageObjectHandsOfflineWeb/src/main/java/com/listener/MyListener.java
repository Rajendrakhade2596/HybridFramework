package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utility.DriverUtils;
import com.utility.ReportUtils;

public class MyListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		ReportUtils.test = ReportUtils.report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		ReportUtils.test.log(Status.PASS, "Testcase passed with name : " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		ReportUtils.test.log(Status.FAIL, "Testcase failed with name : " + result.getName());
		
		String path = DriverUtils.getScreenshot(result.getName());
		
		ReportUtils.test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		
		ReportUtils.test.log(Status.SKIP, "Testcase skipped with name : " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		DriverUtils.getScreenshot(result.getName());
	}

	public void onStart(ITestContext context) {
		
		ReportUtils.reportInit();
		
	}

	public void onFinish(ITestContext context) {
		
		ReportUtils.report.flush();
	}

}
