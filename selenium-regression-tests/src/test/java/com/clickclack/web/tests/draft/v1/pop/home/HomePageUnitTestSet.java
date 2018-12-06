package com.clickclack.web.tests.draft.v1.pop.home;

import com.apothuaud.selenium.common.WebDriverManager;
import com.clickclack.web.pageobjects.HomePageObject;
import com.clickclack.web.tests.utils.ClickClackWebTestSet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open home page and see header and content",
            groups = { "unit tests", "home page", "dev", "rec", "prod" },
            dataProvider = "LocalHostChromeBrowsersProvider"
    )
    public void testOpenHomePage(String host, String browserType) {
        WebDriver driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new HomePageObject(driver, host)
                .openPage()
                .verifyHeader()
                .verifyContent()
        ;
        assert driver != null;
        driver.quit();
    }
}
