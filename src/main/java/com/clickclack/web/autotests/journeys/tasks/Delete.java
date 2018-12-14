package com.clickclack.web.autotests.journeys.tasks;

import com.clickclack.web.autotests.journeys.actions.Click;
import com.clickclack.web.autotests.journeys.screens.clacks.DeleteScreen;
import org.openqa.selenium.WebDriver;

public class Delete {

    public static void clackById(WebDriver driver, String host, String clackId) {
        driver.get(host + DeleteScreen.EP.replace("CLACK_ID", clackId));
        Click.on(driver, DeleteScreen.btn_sure);
    }
}
