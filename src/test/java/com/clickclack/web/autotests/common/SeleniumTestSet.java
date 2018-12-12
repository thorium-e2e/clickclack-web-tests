package com.clickclack.web.autotests.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class SeleniumTestSet {

    protected WebDriver driver;

    @DataProvider
    public static Object[][] HostsAndBrowsersProvider() {

        Object[][] data = new Object[][];

        if(System.getProperty("env.name") == "local"){
            data[0] = new Object[]{"http://localhost:3000"};
        } else if(System.getProperty("env.name") == "rec"){
            data[0] = new Object[]{"https://rec-clickclack-web.herokuapp.com"};
        } else if(System.getProperty("env.name") == "prod"){
            data[0] = new Object[]{"https://clickclack-web.herokuapp.com"};
        } else if(System.getProperty("env.name") == "all"){
            data[0] = new Object[]{"http://localhost:3000"};
            data[1] = new Object[]{"https://rec-clickclack-web.herokuapp.com"};
            data[2] = new Object[]{"https://clickclack-web.herokuapp.com"};
        } else {

        }

        if(System.getProperty("browser.type") == "chrome"){
            data[0][1] = "chrome";
        } else if(System.getProperty("browser.type") == "firefox"){
            data[0][1] = "firefox";
        } else if(System.getProperty("browser.type") == "ie"){
            data[0][1] = "ie";
        } else if(System.getProperty("browser.type") == "all"){

        } else {

        }

        return data;
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
