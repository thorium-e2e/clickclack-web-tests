package com.clickclack.web.tests.draft.v1.pop.clacks.create;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClacksCreatePageIntegrationTestSet extends TestSet {

    // PASSED

    // 1. From Create Clack page I can go to Clacks list page
    @Test(
            description = "I can navigate to Clacks page from Create page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testCreatePageToListPage(){
        new ClacksCreatePage(getDriver())
                .openPage()
                .gotoListPage();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksListPage(getDriver()).getUrl());
    }
}
