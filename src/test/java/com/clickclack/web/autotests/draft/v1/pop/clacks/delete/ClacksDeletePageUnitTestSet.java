package com.clickclack.web.autotests.draft.v1.pop.clacks.delete;

import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDeletePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;

public class ClacksDeletePageUnitTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can open clacks create page and see header and content",
            groups = { "unit", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testOpenClacksDeletePage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
    	new ClacksCreatePage(driver, host)
        	.openPage()
        	.createEmpty();
    	String newClackId = new ClacksListPage(driver, host)
        .getLastClackId();
        new ClacksDeletePage(driver, host, newClackId)
            .openPage()
            .verifyHeader()
            .verifyContent()
        ;
        assert driver != null;
        driver.quit();
    }
}
