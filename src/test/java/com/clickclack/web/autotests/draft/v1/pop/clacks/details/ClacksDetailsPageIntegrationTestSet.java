package com.clickclack.web.autotests.draft.v1.pop.clacks.details;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDetailsPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksUpdatePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClacksDetailsPageIntegrationTestSet extends ClickClackWebTestSet {

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
        new ClacksDetailsPage(driver, host, clackId)
                .openPage()
                .gotoListPage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        driver.quit();
    }

    @Test(
            description = "I can navigate to Update page from Details page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testDetailsPageToUpdatePage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksDetailsPage(driver, host, clackId)
                .openPage()
                .gotoUpdatePage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksUpdatePage(driver, host, clackId).URL);
        driver.quit();
    }
}
