package com.clickclack.web.tests.draft.v1.pop.clacks.delete;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksDeletePage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksDeletePageIntegrationTestSet extends TestSet {

    // PASSED

    private String newClackId;

    private String getNewClackId() {
        return newClackId;
    }

    private void setNewClackId(String newClackId) {
        this.newClackId = newClackId;
    }

    @BeforeMethod
    public void beforeTest() throws IOException {
        new ClacksCreatePage(getDriver())
                .openPage()
                .createEmpty();
        setNewClackId(new ClacksListPage(getDriver())
                .getLastClackId());
    }

    // 1. From Delete page I can go to Clacks page
    @Test(
            description = "I can navigate to Clacks page from Delete page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testDeletePageToListPage(){
        new ClacksDeletePage(getDriver(), getNewClackId())
                .openPage()
                .gotoListPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksListPage(getDriver()).getUrl());
    }
}
