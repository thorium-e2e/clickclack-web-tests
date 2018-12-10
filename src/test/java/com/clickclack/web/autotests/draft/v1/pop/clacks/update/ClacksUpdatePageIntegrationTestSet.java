package com.clickclack.web.autotests.draft.v1.pop.clacks.update;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksUpdatePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClacksUpdatePageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to List page from Details page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testDetailsPageToListPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksUpdatePage(driver, host, clackId)
                .openPage()
                .gotoListPage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        driver.quit();
    }
}
