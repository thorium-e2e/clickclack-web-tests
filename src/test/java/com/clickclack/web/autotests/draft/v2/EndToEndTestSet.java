package com.clickclack.web.autotests.draft.v2;

import com.clickclack.web.autotests.common.WebDriverManager;
import com.clickclack.web.autotests.mixedpattern.actions.clacks.AfterCreation;
import com.clickclack.web.autotests.mixedpattern.actions.clacks.Update;
import com.clickclack.web.autotests.mixedpattern.actions.clacks.Create;
import com.clickclack.web.autotests.mixedpattern.actions.clacks.Delete;
import com.clickclack.web.autotests.mixedpattern.verifications.clacks.Clack;
import com.clickclack.web.autotests.mixedpattern.verifications.clacks.Clacks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class EndToEndTestSet {

    @Test
    public void testEndtoEnd() throws Exception {
        String host = "http://localhost:3000";
        String clackId = "azertyuiop1234567890";
        WebDriver driver = WebDriverManager.getNewWebDriverWithType("chrome");

        int nbclacksBefore = Clacks.getNumber(driver, host);

        Clack.doesntExist(driver, host, clackId);

        Create.emptyClack(driver, host);
        clackId = AfterCreation.readId(driver);

        Clack.exist(driver, host, clackId);

        int nbClacksAfter = Clacks.getNumber(driver, host);
        Assert.assertEquals(nbClacksAfter, nbclacksBefore + 1);

        HashMap<String, String> clackUpdatebody = new HashMap<String, String>();
        clackUpdatebody.put("updated", "true");
        Update.clackById(driver, host, clackId, clackUpdatebody);

        Clack.hasKeyValue(driver, host, clackId, "updated", "true");

        Delete.clackById(driver, host, clackId);

        Clack.doesntExist(driver, host, clackId);

        Assert.assertEquals(Clacks.getNumber(driver, host), nbclacksBefore);
    }
}
