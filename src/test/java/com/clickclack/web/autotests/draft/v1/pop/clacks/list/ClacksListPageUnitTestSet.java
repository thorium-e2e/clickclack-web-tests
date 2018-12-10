package com.clickclack.web.autotests.draft.v1.pop.clacks.list;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import org.testng.annotations.Test;

public class ClacksListPageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open clacks page and see header and content",
            groups = { "unit", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenClacksPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksListPage(driver, host)
                .openPage()
                .verifyHeader()
                .verifyContent();
        assert driver != null;
        driver.quit();
    }
}
