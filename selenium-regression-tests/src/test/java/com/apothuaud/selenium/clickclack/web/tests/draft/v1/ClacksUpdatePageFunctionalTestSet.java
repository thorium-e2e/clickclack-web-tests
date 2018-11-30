package com.apothuaud.selenium.clickclack.web.tests.draft.v1;

import com.apothuaud.selenium.clickclack.web.pages.ClacksCreatePage;
import com.apothuaud.selenium.clickclack.web.pages.ClacksListPage;
import com.apothuaud.selenium.clickclack.web.pages.ClacksUpdatePage;
import com.apothuaud.selenium.common.TestSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
        new ClacksCreatePage(getDriver(), getEnv())
                .openPage()
                .createEmpty();
        setNewClackId(new ClacksListPage(getDriver(), getEnv())
                .getLastClackId());
    }

    // 1. add fields in update clack form
    @Test(
            description = "I can add fields in update clack form",
            groups = { "fun", "dev", "rec", "prod" }
    )
    public void testUpdateFormAddFields(){
        new ClacksUpdatePage(getDriver(), getEnv(), getNewClackId())
                .openPage();
        nFields = new ClacksUpdatePage(getDriver(), getEnv(), getNewClackId())
                .getNbFields();
        new ClacksUpdatePage(getDriver(), getEnv(), getNewClackId())
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
        new ClacksUpdatePage(getDriver(), getEnv(), getNewClackId())
                .removeFields()
                .verifyNbFields(nFields);
    }
}
