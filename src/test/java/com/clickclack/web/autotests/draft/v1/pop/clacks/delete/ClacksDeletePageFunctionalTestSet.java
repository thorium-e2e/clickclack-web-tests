package com.clickclack.web.autotests.draft.v1.pop.clacks.delete;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDeletePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;

public class ClacksDeletePageFunctionalTestSet extends ClickClackWebTestSet {

    @Test(
            description = "On Delete page I can refuse delete",
            groups = { "fun", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testDeletePageRefuseToDelete(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
    	new ClacksCreatePage(driver, host)
    		.openPage()
    		.createEmpty();
    	String newClackId = new ClacksListPage(driver, host)
    		.getLastClackId();
        new ClacksDeletePage(driver, host, newClackId)
            .openPage()
            .refuse();
        Assert.assertTrue(new ClacksListPage(driver, host)
            .verifyPresenceOfClackById(newClackId)
        );
        assert driver != null;
        driver.quit();
    }

    @Test(
            description = "On Delete page I can confirm delete",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testDeletePageConfirmToDelete(String host, String browserType) throws Exception {
    	driver = WebDriverManager.getNewWebDriverWithType(browserType);
    	new ClacksCreatePage(driver, host)
    		.openPage()
    		.createEmpty();
    	String newClackId = new ClacksListPage(driver, host)
    		.getLastClackId();
        new ClacksDeletePage(driver, host, newClackId)
            .openPage()
            .accept();
        Assert.assertFalse(new ClacksListPage(driver, host)
            .verifyPresenceOfClackById(newClackId)
        );
        assert driver != null;
        driver.quit();
    }
}
