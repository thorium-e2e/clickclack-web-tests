package com.clickclack.web.autotests.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class SeleniumTestSet {

    protected WebDriver driver;

    @DataProvider
    public static Object[][] HostsAndBrowsersProvider() {
        return new Object[][]{
                //{"http://localhost:3000", "chrome"},
                //{"http://localhost:3000", "firefox"},
                {"http://rec-clickclack-web.herokuapp.com", "chrome"},
                //{"http://rec-clickclack-web.herokuapp.com", "firefox"},
                //{"http://clickclack-web.herokuapp.com", "chrome"},
                //{"http://clickclack-web.herokuapp.com", "firefox"}
        };
    }

    @DataProvider
    public static Object[][] LocalHostChromeBrowserProvider() {
        return new Object[][]{
                {"http://localhost:3000", "chrome"}
        };
    }

    @DataProvider
    public static Object[][] LocalHostChromeAndFirefoxBrowsersProvider() {
        return new Object[][]{
                {"http://localhost:3000", "chrome"},
                {"http://localhost:3000", "firefox"}
        };
    }
}
