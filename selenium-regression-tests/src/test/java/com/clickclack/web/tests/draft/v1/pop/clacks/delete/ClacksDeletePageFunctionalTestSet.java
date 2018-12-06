package com.clickclack.web.tests.draft.v1.pop.clacks.delete;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksDeletePage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksDeletePageFunctionalTestSet extends TestSet {

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

    // 1. On Delete page I can refuse delete
    @Test(
            description = "On Delete page I can refuse delete",
            groups = { "fun", "dev", "rec", "prod" }
    )
    public void testDeletePageRefuseToDelete() throws IOException {
        new ClacksDeletePage(getDriver(), getNewClackId())
                .openPage()
                .refuse();
        Assert.assertTrue(new ClacksListPage(getDriver())
                .verifyPresenceOfClackById(getNewClackId())
        );
    }

    // 1. On Delete page I can confirm delete
    @Test(
            description = "On Delete page I can confirm delete",
            groups = { "int", "dev", "rec", "prod" }
    )
    public void testDeletePageConfirmToDelete() throws IOException {
        new ClacksDeletePage(getDriver(), getNewClackId())
                .openPage()
                .accept();
        Assert.assertFalse(new ClacksListPage(getDriver())
                .verifyPresenceOfClackById(getNewClackId())
        );
    }
}
