package com.clickclack.web.autotests.draft.v1.pop.home;

import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.home.HomePageObject;

public class HomePageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open home page and see header and content",
            groups = { "unit tests", "home page", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenHomePage(String host, String browserType) {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new HomePageObject(driver, host)
                .openPage()
                .verifyHeader()
                .verifyContent()
        ;
        assert driver != null;
        driver.quit();
    }
}
