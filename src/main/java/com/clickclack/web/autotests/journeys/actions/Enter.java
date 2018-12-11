package com.clickclack.web.autotests.journeys.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter {

    public static void textInto(WebDriver driver, String text, By selector) {
        driver.findElement(selector).sendKeys(text);
    }
}
