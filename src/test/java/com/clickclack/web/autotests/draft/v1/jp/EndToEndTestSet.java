package com.clickclack.web.autotests.draft.v1.jp;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.journeys.tasks.Create;
import com.clickclack.web.autotests.journeys.tasks.Find;
import com.clickclack.web.autotests.journeys.tasks.Verify;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EndToEndTestSet extends ClickClackWebTestSet {

    private static int nbClaskBeforeTest = 0;
    private static String testClackId = "azertyuiop1234567";

    @Test(
            groups = {"e2e", "clacks", "dev", "rec", "prod"},
            description = "Verify clack does not exist",
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void verifyClackDoesntExist(String host, String browserType) throws Exception {
        WebDriver driver = WebDriverManager.getNewWebDriverWithType(browserType);
        assert driver != null;
        Find.clackById(driver, host, testClackId);
        Verify.clackDoesntExist(driver);
        driver.quit();
    }

    @Test(
            groups = {"e2e", "clacks", "dev", "rec", "prod"},
            description = "Create new empty clack",
            dataProvider = "HostsAndBrowsersProvider",
            dependsOnMethods = {"verifyClackDoesntExist"}
    )
    public void createNewEmptyClack(String host, String browserType) throws Exception {
        WebDriver driver = WebDriverManager.getNewWebDriverWithType(browserType);
        assert driver != null;
        Create.newClack(driver, host, null);
        driver.quit();
    }
}
