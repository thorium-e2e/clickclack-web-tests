package com.clickclack.web.autotests.draft.v1.pop.clacks.list;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDetailsPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksUpdatePage;
import com.clickclack.web.autotests.pageobjects.home.HomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClacksListPageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to Home page from List page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testListPageToHomePage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksListPage(driver, host)
                .openPage()
                .gotoHomePage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new HomePageObject(driver, host).URL);
        driver.quit();
    }

    @Test(
            description = "I can navigate to Create page from List page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testListPageToCreatePage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksListPage(driver, host)
                .openPage()
                .gotoCreatePage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksCreatePage(driver, host).URL);
        driver.quit();
    }

    @Test(
            description = "I can navigate to Details page from List page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testListPageToDetailsPage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksListPage(driver, host)
                .openPage()
                .gotoDetailsLastClack();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksDetailsPage(driver, host, clackId).URL);
        driver.quit();
    }

    @Test(
            description = "I can navigate to Update page from List page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testListPageToUpdatePage(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksListPage(driver, host)
                .openPage()
                .gotoUpdateLastClack();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksUpdatePage(driver, host, clackId).URL);
        driver.quit();
    }
}
