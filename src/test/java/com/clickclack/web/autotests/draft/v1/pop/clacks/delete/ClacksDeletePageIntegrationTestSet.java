package com.clickclack.web.autotests.draft.v1.pop.clacks.delete;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDeletePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClacksDeletePageIntegrationTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can navigate to Clacks page from Delete page",
            groups = { "int", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testDeletePageToListPage(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
    	new ClacksCreatePage(driver, host)
        	.openPage()
        	.createEmpty();
    	String newclackId = new ClacksListPage(driver, host)
			.getLastClackId();
        new ClacksDeletePage(driver, host, newclackId)
            .openPage()
            .gotoListPage();
        assert driver != null;
        Assert.assertEquals(driver.getCurrentUrl(), new ClacksListPage(driver, host).URL);
        driver.quit();
    }
}
