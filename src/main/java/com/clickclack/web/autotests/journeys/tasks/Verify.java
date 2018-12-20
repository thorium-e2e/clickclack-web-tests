package com.clickclack.web.autotests.journeys.tasks;

import com.clickclack.web.autotests.journeys.screens.clacks.DetailsScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Verify {

    public static void elementPresent(WebDriver driver, By selector) {
        Assert.assertTrue(driver.findElement(selector).isDisplayed());
    }

    public static boolean textPresent(WebDriver driver, String text) {
        return driver.getPageSource().contains(text);
    }

    public static void presenceOfClackById(WebDriver driver, String clackId){
        Assert.assertTrue(textPresent(driver, clackId));
    }

    public static void clackDoesntExist(WebDriver driver) {
        Assert.assertTrue(driver.findElement(DetailsScreen.error_not_found).isDisplayed());
    }
}
