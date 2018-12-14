package com.clickclack.web.autotests.mixedpattern.actions.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Find {

    public static String textOfElement(WebDriver driver, By selector) {
        return driver.findElement(selector).getText();
    }
}
