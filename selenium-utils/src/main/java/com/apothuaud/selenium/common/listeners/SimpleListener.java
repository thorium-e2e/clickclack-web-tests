package com.apothuaud.selenium.common.listeners;

import org.testng.*;

import static io.restassured.RestAssured.given;

public class SimpleListener implements ITestListener, ISuiteListener {


    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getQualifiedName());
        System.out.println(result.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
