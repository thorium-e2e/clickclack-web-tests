package com.clickclack.web.autotests.draft.v1.pop.clacks.create;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;

public class ClacksCreatePageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to Clacks page from Create page",
            groups = { "int", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testCreatePageToListPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .gotoListPage();
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        assert driver != null;
        driver.quit();
    }
}
