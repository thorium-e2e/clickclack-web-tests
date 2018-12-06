package com.clickclack.web.tests.draft.v1.pop.clacks.update;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.ClacksListPage;
import com.clickclack.web.pageobjects.clacks.ClacksUpdatePage;
import com.clickclack.web.pageobjects.clacks.ClacksCreatePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksUpdatePageUnitTestSet extends TestSet {

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

    // 1 Clacks update page open and have attributes and form
    @Test(
            description = "I can open clacks update page and see header and content",
            groups = { "unit", "dev", "rec", "prod" }
    )
    public void testOpenClackUpdatePage(){
        new ClacksUpdatePage(getDriver(), getNewClackId())
                .openPage()
                .verifyHeader()
                .verifyContent()
        ;
    }
}
