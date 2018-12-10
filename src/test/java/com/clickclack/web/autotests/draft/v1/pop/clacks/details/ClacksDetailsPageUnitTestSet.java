package com.clickclack.web.autotests.draft.v1.pop.clacks.details;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDetailsPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import org.testng.annotations.Test;

public class ClacksDetailsPageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open clacks details page and see header and content",
            groups = { "unit", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenClackDetailsPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksDetailsPage(driver, host, clackId)
                .openPage()
                .verifyHeader()
                .verifyContent();
        assert driver != null;
        driver.quit();
    }
}
