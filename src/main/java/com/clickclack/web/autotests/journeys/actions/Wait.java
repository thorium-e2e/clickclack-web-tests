package com.clickclack.web.autotests.journeys.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wait {

    public static void forVisibilityOf(WebDriver driver, By selector, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
