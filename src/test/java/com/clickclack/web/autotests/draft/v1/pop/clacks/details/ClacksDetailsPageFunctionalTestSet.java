package com.clickclack.web.autotests.draft.v1.pop.clacks.details;

import com.clickclack.web.autotests.common.ClickClackWebTestSet;
import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.pageobjects.clacks.ClacksDetailsPage;
import org.testng.annotations.Test;

public class ClacksDetailsPageFunctionalTestSet extends ClickClackWebTestSet {

    @Test(
            description = "Error clack not found on details page",
            groups = { "fun", "clacks", "dev", "rec", "prod" },
            dataProvider = "HostsAndBrowsersProvider"
    )
    public void testErrorClackNotFound(String host, String browserType) throws Exception {
        driver = WebDriverManager.getNewWebDriverWithType(browserType);
        new ClacksDetailsPage(driver, host, "er45tgjlkfh565653ezsfkjh")
                .openPage()
                .verifyError();
        assert driver != null;
        driver.quit();
    }
}
