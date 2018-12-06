package com.clickclack.web.tests.draft.v1.pop.clacks.create;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import org.testng.annotations.Test;


public class ClacksCreatePageUnitTestSet extends TestSet {

    // PASSED

    // 1 Clacks create page open and have form
    @Test(
            description = "I can open clacks create page and see header and content",
            groups = { "unit", "dev", "rec", "prod" }
    )
    public void testOpenCreateClackPage(){
        new ClacksCreatePage(getDriver())
                .openPage()
                .verifyHeader()
                .verifyContent()
        ;
    }
}
