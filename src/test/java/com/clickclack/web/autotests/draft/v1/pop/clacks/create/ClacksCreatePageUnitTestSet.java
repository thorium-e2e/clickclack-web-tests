package com.clickclack.web.autotests.draft.v1.pop.clacks.create;

import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;

public class ClacksCreatePageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open clacks create page and see header and content",
            groups = { "unit", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenCreateClackPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .verifyHeader()
                .verifyContent();
        assert driver != null;
        driver.quit();
    }
}
