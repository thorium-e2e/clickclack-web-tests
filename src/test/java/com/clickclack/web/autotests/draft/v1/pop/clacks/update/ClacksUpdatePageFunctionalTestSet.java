package com.clickclack.web.autotests.draft.v1.pop.clacks.update;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksUpdatePage;
import org.testng.annotations.Test;

public class ClacksUpdatePageFunctionalTestSet extends ClickClackWebTestSet {

    @Test(
            description = "I can add fields in update clack form",
            groups = { "fun", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testUpdateFormAddFields(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksUpdatePage(driver, host, clackId)
                .openPage();
        int nFieldsBefore = new ClacksUpdatePage(driver, host, clackId)
                .getNbFields();
        new ClacksUpdatePage(driver, host, clackId)
                .addFields()
                .verifyNbFields(nFieldsBefore + 1);
        assert driver != null;
        driver.quit();
    }

    @Test(
            description = "I can remove fields in update clack form",
            groups = { "fun", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testUpdateFormRemoveFields(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
            .openPage()
            .createEmpty();
        String clackId = new ClacksListPage(driver, host)
            .getLastClackId();
        new ClacksUpdatePage(driver, host, clackId)
            .openPage();
        int nFieldsBefore = new ClacksUpdatePage(driver, host, clackId)
            .getNbFields();
        new ClacksUpdatePage(driver, host, clackId)
            .addFields()
            .verifyNbFields(nFieldsBefore + 1)
            .removeFields()
            .verifyNbFields(nFieldsBefore);
        assert driver != null;
        driver.quit();
    }
}
