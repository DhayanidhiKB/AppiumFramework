package org.appium.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporter.getReport();

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Execution is Success");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
