package com.clickclack.web.tests.utils;

import com.apothuaud.selenium.common.SeleniumTestSet;
import org.testng.annotations.DataProvider;

public class ClickClackWebTestSet extends SeleniumTestSet {

    @DataProvider
    public static Object[][] AllHostsAndBrowsersProvider() {
        return new Object[][]{
                // DEV Local
                {"https://localhost:3000", "chrome"},
                {"https://localhost:3000", "chrome"},
                {"https://localhost:3000", "chrome"},
                // RECETTE Heroku
                {"https://rec-clickclack-web.herokuapp.com", "chrome"},
                {"https://rec-clickclack-web.herokuapp.com", "firefox"},
                {"https://rec-clickclack-web.herokuapp.com", "ie"},
                // PRODUCTION Heroku
                {"https://clickclack-web.herokuapp.com", "chrome"},
                {"https://clickclack-web.herokuapp.com", "firefox"},
                {"https://clickclack-web.herokuapp.com", "ie"}
        };
    }

    @DataProvider
    public static Object[][] LocalHostAndAllBrowsersProvider() {
        return new Object[][]{
                // DEV Local
                {"http://localhost:3000", "chrome"},
                {"http://localhost:3000", "firefox"},
                {"http://localhost:3000", "ie"},
        };
    }

    @DataProvider
    public static Object[][] RecHostsAndAllBrowsersProvider() {
        return new Object[][]{
                // RECETTE Heroku
                {"https://rec-clickclack-web.herokuapp.com", "chrome"},
                {"https://rec-clickclack-web.herokuapp.com", "firefox"},
                {"https://rec-clickclack-web.herokuapp.com", "ie"},
        };
    }

    @DataProvider
    public static Object[][] ProdHostsAndAllBrowsersProvider() {
        return new Object[][]{
                // PRODUCTION Heroku
                {"https://clickclack-web.herokuapp.com", "chrome"},
                {"https://clickclack-web.herokuapp.com", "firefox"},
                {"https://clickclack-web.herokuapp.com", "ie"},
        };
    }

    @DataProvider
    public static Object[][] LocalHostChromeBrowsersProvider() {
        return new Object[][]{
                {"http://localhost:3000", "chrome"},
        };
    }

}
