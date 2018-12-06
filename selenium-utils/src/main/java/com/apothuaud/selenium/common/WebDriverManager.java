package com.apothuaud.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

    private static void setChromeDriverPropertyDependingOnOS() {
        if (OSValidator.isMac()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac");
        } else if (OSValidator.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_win.exe");
        } else if (OSValidator.isUnix()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_linux");
        }
    }

    private static void setGeckodriverPropertyDependingOnOS() {
        if (OSValidator.isMac()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_mac");
        } else if (OSValidator.isWindows()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_win.exe");
        } else if (OSValidator.isUnix()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_linux");
        }
    }

    private static void setIEDriverPropertyDependingOnOS() {
        if (OSValidator.isMac()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_mac");
        } else if (OSValidator.isWindows()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_win.exe");
        } else if (OSValidator.isUnix()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver_linux");
        }
    }

    private static WebDriver getNewChromeDriver() {
        setChromeDriverPropertyDependingOnOS();
        return new ChromeDriver();
    }

    public static WebDriver getNewWebDriverWithType(String browserType) {
        if (browserType.contains("chrome")) {
            return getNewChromeDriver();
        } else if (browserType.contains("firefox")) {
            return getNewFirefoxDriver();
        } else if (browserType.contains("ie")) {
            return getNewIEDriver();
        } else {
            return null;
        }
    }

    private static WebDriver getNewIEDriver() {
        setIEDriverPropertyDependingOnOS();
        return new InternetExplorerDriver();
    }

    private static WebDriver getNewFirefoxDriver() {
        setGeckodriverPropertyDependingOnOS();
        return new FirefoxDriver();
    }
}
