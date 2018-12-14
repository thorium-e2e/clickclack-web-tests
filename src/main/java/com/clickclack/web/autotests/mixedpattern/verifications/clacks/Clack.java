package com.clickclack.web.autotests.mixedpattern.verifications.clacks;

import com.clickclack.web.autotests.mixedpattern.screens.clacks.DetailsScreen;
import com.clickclack.web.autotests.mixedpattern.screens.clacks.UpdateScreen;
import com.clickclack.web.autotests.mixedpattern.verifications.basic.VerifyThatElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Clack {
    public static void doesntExist(WebDriver driver, String host, String clackId) {
        driver.get(host + DetailsScreen.EP.replace("CLACK_ID", clackId));
        VerifyThatElement.isDisplayed(driver, DetailsScreen.ERROR_NOT_FOUND);
    }

    public static void exist(WebDriver driver, String host, String clackId) {
        driver.get(host + DetailsScreen.EP.replace("CLACK_ID", clackId));
        Assert.assertFalse(driver.findElement(DetailsScreen.ERROR_NOT_FOUND).isDisplayed());
    }

    public static void hasKeyValue(WebDriver driver, String host, String clackId, String expectedKey, String expectedValue) {
        boolean assertion = false;
        driver.get(host + UpdateScreen.EP.replace("CLACK_ID", clackId));
        List<WebElement> fields = driver.findElements(UpdateScreen.CLACK_FIELDS_PAIR);
        for(WebElement field: fields){
            String key = field.findElement(UpdateScreen.KEYS).getAttribute("value");
            String value = field.findElement(UpdateScreen.VALUES).getAttribute("value");
            if(key.equals(expectedKey) && value.equals(expectedValue)) assertion = true;
        }
        Assert.assertTrue(assertion);
    }
}
