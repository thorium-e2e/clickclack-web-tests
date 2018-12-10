package com.clickclack.web.autotests.draft.v1.pop.clacks.create;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksCreatePage;

public class ClacksCreatePageFunctionalTestSet extends ClickClackWebTestSet {


    @Test(
            description = "I can add fields in create clack form",
            groups = { "fun", "clacks", "dev", "rec" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testCreateFormAddFields(String host, String browserType){
       driver = WebDriverManager.getNewWebDriverWithType(browserType);
       new ClacksCreatePage(driver, host)
                .openPage()
                .verifyNbFields(1)
                .addFields()
                .verifyNbFields(2);
       assert driver != null;
       driver.quit();
    }

    @Test(
            description = "I can remove fields in create clack form",
            groups = { "fun", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testCreateFormRemoveFields(String host, String browserType){
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .verifyNbFields(1)
                .addFields()
                .verifyNbFields(2)
                .removeFields()
                .verifyNbFields(1);
        assert driver != null;
        driver.quit();
    }
}
