package com.clickclack.web.autotests.mixedpattern.verifications.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyThatElement {
    public static void isDisplayed(WebDriver driver, By selector) {
        Assert.assertTrue(driver.findElement(selector).isDisplayed());
    }
}
