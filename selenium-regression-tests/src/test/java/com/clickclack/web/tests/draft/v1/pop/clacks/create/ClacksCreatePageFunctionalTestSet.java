package com.clickclack.web.tests.draft.v1.pop.clacks.create;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import org.testng.annotations.Test;

public class ClacksCreatePageFunctionalTestSet extends TestSet {

    // PASSED

    // 1. add fields in create clack form
    @Test(
            description = "I can add fields in create clack form",
            groups = { "fun", "dev", "rec", "prod" }
    )
    public void testCreateFormAddFields(){
        new ClacksCreatePage(getDriver())
                .openPage()
                .verifyNbFields(1)
                .addFields()
                .verifyNbFields(2);
    }

    // 1. remove fields in create clack form
    @Test(
            description = "I can remove fields in create clack form",
            groups = { "fun", "dev", "rec", "prod" },
            dependsOnMethods = { "testCreateFormAddFields" }
    )
    public void testCreateFormRemoveFields(){
        new ClacksCreatePage(getDriver())
                .removeFields()
                .verifyNbFields(1);
    }
}
