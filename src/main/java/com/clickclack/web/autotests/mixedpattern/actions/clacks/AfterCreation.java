package com.clickclack.web.autotests.mixedpattern.actions.clacks;

import com.clickclack.web.autotests.mixedpattern.actions.basic.Find;
import com.clickclack.web.autotests.mixedpattern.screens.clacks.CreatedScreen;
import org.openqa.selenium.WebDriver;

public class AfterCreation {

    public static String readId(WebDriver driver) {
        return Find.textOfElement(driver, CreatedScreen.CLACK_ID).replace("ID = ", "");
    }
}
