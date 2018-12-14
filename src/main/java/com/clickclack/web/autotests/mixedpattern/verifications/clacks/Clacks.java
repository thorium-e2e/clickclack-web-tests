package com.clickclack.web.autotests.mixedpattern.verifications.clacks;

import com.clickclack.web.autotests.mixedpattern.screens.clacks.ListScreen;
import org.openqa.selenium.WebDriver;

public class Clacks {
    public static int getNumber(WebDriver driver, String host) {
        driver.get(host + ListScreen.EP);
        return driver.findElements(ListScreen.CLACK_ELEMENT).size();
    }
}
