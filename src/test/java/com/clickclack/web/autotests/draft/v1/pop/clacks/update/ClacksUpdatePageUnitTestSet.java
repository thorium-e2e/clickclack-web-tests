package com.clickclack.web.autotests.draft.v1.pop.clacks.update;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksUpdatePage;
import org.testng.annotations.Test;

public class ClacksUpdatePageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open clacks update page and see header and content",
            groups = { "unit", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenClackUpdatePage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksUpdatePage(driver, host, clackId)
                .openPage()
                .verifyHeader()
                .verifyContent();
        assert driver != null;
        driver.quit();
    }
}
