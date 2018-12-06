package com.clickclack.web.tests.draft.v1.pop.clacks.update;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.pageobjects.clacks.ClacksUpdatePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksUpdatePageIntegrationTestSet extends TestSet {

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

    @Test(
            description = "I can navigate to List page from Details page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testDetailsPageToListPage(){
        new ClacksUpdatePage(getDriver(), getNewClackId())
                .openPage()
                .gotoListPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksListPage(getDriver()).getUrl());
    }
}
