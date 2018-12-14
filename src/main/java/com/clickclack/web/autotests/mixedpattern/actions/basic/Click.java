package com.clickclack.web.autotests.mixedpattern.actions.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click {

    public static void toElement(WebDriver driver, By selector) {
        driver.findElement(selector).click();
    }
}
