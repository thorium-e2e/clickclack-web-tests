package com.clickclack.web.autotests.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverManager {

    public static WebDriver currentDriver;

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
        currentDriver = new ChromeDriver();
        return currentDriver;
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
        currentDriver = new InternetExplorerDriver();
        return currentDriver;
    }

    private static WebDriver getNewFirefoxDriver() {
        setGeckodriverPropertyDependingOnOS();
        currentDriver = new FirefoxDriver();
        return currentDriver;
    }

    public static String getScreenshot(String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) currentDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination;
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        if (OSValidator.isMac()) {
            destination = System.getProperty("user.dir") + "/target/ExtentReports/TestsScreenshots/" + screenshotName + dateName + ".png";
        } else if (OSValidator.isWindows()){
            destination = System.getProperty("user.dir") + "\\target\\ExtentReports\\TestsScreenshots\\" + dateName + ".png";
            destination = destination.replace(" ", "\\ ");
            System.out.println(destination);
        } else {
            throw new Exception("Le systeme d exploitation n est pas pris en charge.");
        }
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }
}
