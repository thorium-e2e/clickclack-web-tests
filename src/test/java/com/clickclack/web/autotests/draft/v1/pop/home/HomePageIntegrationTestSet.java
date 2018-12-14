package com.clickclack.web.autotests.draft.v1.pop.home;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.home.HomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to List page from Home page",
            groups = { "int", "home page", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testHomePageToListPage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new HomePageObject(driver, host)
                .openPage()
                .gotoListPage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        driver.quit();
    }
}
