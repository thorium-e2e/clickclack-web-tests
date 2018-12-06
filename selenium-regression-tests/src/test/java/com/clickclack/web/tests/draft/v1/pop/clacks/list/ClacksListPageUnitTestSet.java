package com.clickclack.web.tests.draft.v1.pop.clacks.list;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import org.testng.annotations.Test;

public class ClacksListPageUnitTestSet extends TestSet {

    // PASSED

    // 1 Clacks list page open and have list
    @Test(
            description = "I can open clacks page and see header and content",
            groups = { "unit", "dev", "rec", "prod" }
    )
    public void testOpenClacksPage(){
        new ClacksListPage(getDriver())
                .openPage()
                .verifyHeader()
                .verifyContent()
        ;
    }
}
