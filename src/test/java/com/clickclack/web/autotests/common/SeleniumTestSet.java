package com.clickclack.web.autotests.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class SeleniumTestSet {

    protected WebDriver driver;

    @DataProvider
    public static Object[][] HostsAndBrowsersProvider() throws Exception {

        String envName = (System.getProperty("env.name") != null) ? System.getProperty("env.name") : "rec";
        String browserType = (System.getProperty("browser.type") != null) ? System.getProperty("browser.type") : "chrome";

        if(envName.equals("local") && browserType.equals("chrome")){
            return new Object[][]{{"http://localhost:3000", "chrome"}};
        }
        if(envName.equals("local") && browserType.equals("firefox")){
            return new Object[][]{{"http://localhost:3000", "firefox"}};
        }
        if(envName.equals("local") && browserType.equals("ie")){
            return new Object[][]{{"http://localhost:3000", "ie"}};
        }

        if(envName.equals("rec") && browserType.equals("chrome")){
            return new Object[][]{{"https://rec-clickclack-web.herokuapp.com", "chrome"}};
        }
        if(envName.equals("rec") && browserType.equals("firefox")){
            return new Object[][]{{"https://rec-clickclack-web.herokuapp.com", "firefox"}};
        }
        if(envName.equals("rec") && browserType.equals("ie")){
            return new Object[][]{{"https://rec-clickclack-web.herokuapp.com", "ie"}};
        }

        if(envName.equals("prod") && browserType.equals("chrome")){
            return new Object[][]{{"https://clickclack-web.herokuapp.com", "chrome"}};
        }
        if(envName.equals("prod") && browserType.equals("firefox")){
            return new Object[][]{{"https://clickclack-web.herokuapp.com", "firefox"}};
        }
        if(envName.equals("prod") && browserType.equals("ie")){
            return new Object[][]{{"https://clickclack-web.herokuapp.com", "ie"}};
        }

        throw new Exception("Les parametres donnes ne correspondent a aucun cas actuellement pris en charge ...");
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
