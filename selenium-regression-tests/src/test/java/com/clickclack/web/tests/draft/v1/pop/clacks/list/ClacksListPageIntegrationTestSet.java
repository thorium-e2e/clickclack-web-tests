package com.clickclack.web.tests.draft.v1.pop.clacks.list;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.*;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksDetailsPage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.pageobjects.clacks.ClacksUpdatePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksListPageIntegrationTestSet extends TestSet {

    // PASSED

    private String newClackId;

    private String getNewClackId() {
        return newClackId;
    }

    private void setNewClackId(String newClackId) {
        this.newClackId = newClackId;
    }

    @BeforeTest
    public void beforeTest() throws IOException {
        new ClacksCreatePage(getDriver())
                .openPage()
                .createEmpty();
        setNewClackId(new ClacksListPage(getDriver())
                .getLastClackId());
    }

    // 1 From Clacks list page I can go to Home, Create Clack, Clack Details and Update Clack pageobjects
    @Test(
            description = "I can navigate to Home page from List page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testListPageToHomePage(){
        new ClacksListPage(getDriver())
                .openPage()
                .gotoHomePage();
        //Assert.assertEquals(getDriver().getCurrentUrl(), new HomePageObject(getDriver()).getUrl());
    }

    @Test(
            description = "I can navigate to Create page from List page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testListPageToCreatePage(){
        new ClacksListPage(getDriver())
                .openPage()
                .gotoCreatePage();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksCreatePage(getDriver()).getUrl());
    }

    @Test(
            description = "I can navigate to Details page from List page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testListPageToDetailsPage(){
        new ClacksListPage(getDriver())
                .openPage()
                .gotoDetailsLastClack();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksDetailsPage(getDriver(), getNewClackId()).getUrl());
    }

    @Test(
            description = "I can navigate to Update page from List page",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testListPageToUpdatePage(){
        new ClacksListPage(getDriver())
                .openPage()
                .gotoUpdateLastClack();
        Assert.assertEquals(getDriver().getCurrentUrl(), new ClacksUpdatePage(getDriver(), getNewClackId()).getUrl());
    }
}
