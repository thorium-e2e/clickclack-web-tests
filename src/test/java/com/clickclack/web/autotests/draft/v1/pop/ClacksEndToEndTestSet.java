package com.clickclack.web.autotests.draft.v1.pop;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ClacksEndToEndTestSet extends ClickClackWebTestSet {

	@Test(
            description = "I can CRUD clack",
            groups = { "e2e", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testCRUDClack(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksCreatePage(driver, host)
                .openPage()
                .createEmpty();
        String clackId = new ClacksListPage(driver, host)
                .getLastClackId();
        new ClacksDetailsPage(driver, host, clackId)
                .openPage()
                .verifyContent();
        new ClacksUpdatePage(driver, host, clackId)
                .openPage()
                .addFields()
                .submit();
        new ClacksListPage(driver, host)
                .openPage()
                .gotoDeleteLastClack();
        new ClacksDeletePage(driver, host, clackId)
                .accept();
        assert driver != null;
        driver.quit();
    }
}
