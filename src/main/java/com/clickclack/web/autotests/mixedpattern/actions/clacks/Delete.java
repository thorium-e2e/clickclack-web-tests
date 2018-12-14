package com.clickclack.web.autotests.mixedpattern.actions.clacks;

import com.clickclack.web.autotests.mixedpattern.actions.basic.Click;
import com.clickclack.web.autotests.mixedpattern.screens.clacks.DeleteConfirmScreen;
import org.openqa.selenium.WebDriver;

public class Delete {
    public static void clackById(WebDriver driver, String host, String clackId) {
        driver.get(host + DeleteConfirmScreen.EP.replace("CLACK_ID", clackId));
        Click.toElement(driver, DeleteConfirmScreen.SURE);
    }
}
