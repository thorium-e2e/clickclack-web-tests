package com.apothuaud.selenium.common.listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

public class SampleListener implements IClassListener, ISuiteListener, ITestListener, IInvokedMethodListener {

    // SUITE Listeners

    public void onStart(ISuite suite) {
        System.out.println("on start suite");

        setSuiteFolder("./target/ExtentReports/" + suite.getName());

    }

    public void onFinish(ISuite suite) {
        System.out.println("on finish suite");
    }

    // TEST SET Listeners

    public void onStart(ITestContext context) {
        setTestSetReport(new ExtentReports(getSuiteFolder() + "/" + context.getName() + ".html", true));
    }

    public void onFinish(ITestContext context) {
        getTestSetReport().flush();
    }

    // CLASS Listeners

    public void onBeforeClass(ITestClass testClass) {
        setCurrentTestClass(getTestSetReport().startTest(testClass.getName()));
    }

    public void onAfterClass(ITestClass testClass) {
        getTestSetReport().endTest(getCurrentTestClass());
    }

    // TEST Listeners

    public void onTestStart(ITestResult result) {
        System.out.println("on currentTest start");
        setCurrentTest(getTestSetReport().startTest(result.getName()));
        getCurrentTestClass().appendChild(getCurrentTest());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("on currentTest success");
        getCurrentTest().log(LogStatus.PASS, result.toString());
        getTestSetReport().endTest(getCurrentTest());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("on currentTest failure");
        getCurrentTest().log(LogStatus.FAIL, result.toString());
        getTestSetReport().endTest(getCurrentTest());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("on currentTest skipped");
        getCurrentTest().log(LogStatus.SKIP, result.toString());
        getTestSetReport().endTest(getCurrentTest());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on currentTest failed within success percentage");
        getCurrentTest().log(LogStatus.WARNING, result.toString());
        getTestSetReport().endTest(getCurrentTest());
    }

    // METHOD INVOCATION Listeners

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    private String suiteFolder; // root
    private ExtentReports testSetReport; // 1 test set => 1 report
    private ExtentTest currentTestClass; // main view expand
    private ExtentTest currentTest; // a line in report

    private String getSuiteFolder() {
        return suiteFolder;
    }

    private void setSuiteFolder(String suiteFolder) {
        this.suiteFolder = suiteFolder;
    }

    private ExtentReports getTestSetReport() {
        return testSetReport;
    }

    private void setTestSetReport(ExtentReports testSetReport) {
        this.testSetReport = testSetReport;
    }

    private ExtentTest getCurrentTestClass() {
        return currentTestClass;
    }

    private void setCurrentTestClass(ExtentTest currentTestClass) {
        this.currentTestClass = currentTestClass;
    }

    private ExtentTest getCurrentTest() {
        return currentTest;
    }

    private void setCurrentTest(ExtentTest currentTest) {
        this.currentTest = currentTest;
    }
}
