package com.apothuaud.selenium.common;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if(extent == null) {
            String workingDire = System.getProperty("user.dir");
            extent = new ExtentReports(workingDire + "/ExtentReports/ExtentReportResults.html", true);
        }
        return extent;
    }
}
