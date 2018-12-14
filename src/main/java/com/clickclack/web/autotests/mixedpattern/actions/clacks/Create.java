package com.clickclack.web.autotests.mixedpattern.actions.clacks;

import com.clickclack.web.autotests.mixedpattern.actions.basic.Click;
import com.clickclack.web.autotests.mixedpattern.screens.clacks.CreateScreen;
import org.openqa.selenium.WebDriver;

public class Create {
    public static void emptyClack(WebDriver driver, String host) {
        driver.get(host + CreateScreen.EP);
        Click.toElement(driver, CreateScreen.SUBMIT);
    }
}
