package com.clickclack.web.tests.draft.v1.pop.clacks.update;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.pageobjects.clacks.ClacksUpdatePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksUpdatePageFunctionalTestSet extends TestSet {

    // PASSED

    private String newClackId;
    int nFields;

    private String getNewClackId() {
        return newClackId;
    }

    private void setNewClackId(String newClackId) {
        this.newClackId = newClackId;
    }

    @BeforeClass
    public void beforeTest() throws IOException {
        new ClacksCreatePage(getDriver())
                .openPage()
                .createEmpty();
        setNewClackId(new ClacksListPage(getDriver())
                .getLastClackId());
    }

    // 1. add fields in update clack form
    @Test(
            description = "I can add fields in update clack form",
            groups = { "fun", "dev", "rec", "prod" }
    )
    public void testUpdateFormAddFields(){
        new ClacksUpdatePage(getDriver(), getNewClackId())
                .openPage();
        nFields = new ClacksUpdatePage(getDriver(), getNewClackId())
                .getNbFields();
        new ClacksUpdatePage(getDriver(), getNewClackId())
                .addFields()
                .verifyNbFields(nFields + 1);
    }

    // 1. remove fields in update clack form
    @Test(
            description = "I can remove fields in update clack form",
            groups = { "fun", "dev", "rec", "prod" },
            dependsOnMethods = { "testUpdateFormAddFields" }
    )
    public void testUpdateFormRemoveFields(){
        new ClacksUpdatePage(getDriver(), getNewClackId())
                .removeFields()
                .verifyNbFields(nFields);
    }
}
