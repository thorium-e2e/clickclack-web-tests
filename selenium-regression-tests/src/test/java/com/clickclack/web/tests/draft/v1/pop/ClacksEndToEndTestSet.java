package com.clickclack.web.tests.draft.v1.pop;

import com.apothuaud.selenium.common.TestSet;
import com.clickclack.web.pageobjects.clacks.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClacksEndToEndTestSet extends TestSet {

    // PASSED

    private String clackId;

    private String getClackId() {
        return clackId;
    }

    private void setClackId(String clackId) {
        this.clackId = clackId;
    }

    @Test(
            description = "I can CRUD clack",
            groups = { "e2e", "dev", "rec", "prod" }
    )
    public void testCRUDClack() throws IOException {
        new ClacksCreatePage(getDriver())
                .openPage()
                .createEmpty();
        setClackId(new ClacksListPage(getDriver())
                .getLastClackId());
        new ClacksDetailsPage(getDriver(), getClackId())
                .openPage()
                .verifyContent();
        new ClacksUpdatePage(getDriver(), getClackId())
                .openPage()
                .addFields()
                .submit();
        new ClacksListPage(getDriver())
                .openPage()
                .gotoDeleteLastClack();
        new ClacksDeletePage(getDriver(), getClackId())
                .accept();
    }
}
