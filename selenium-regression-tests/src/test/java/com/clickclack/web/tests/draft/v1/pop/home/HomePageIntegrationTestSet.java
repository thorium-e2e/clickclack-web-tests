package com.clickclack.web.tests.draft.v1.pop.home;

import com.apothuaud.selenium.common.WebDriverManager;
import com.clickclack.web.pageobjects.HomePageObject;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.tests.utils.ClickClackWebTestSet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to List page from Home page",
            groups = { "integration", "home page", "dev", "rec", "prod" },
            dataProvider = "LocalHostChromeBrowsersProvider"
    )
    public void testHomePageToListPage(String host, String browserType) {
        WebDriver driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new HomePageObject(driver, host)
                .openPage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        driver.quit();
    }
}
