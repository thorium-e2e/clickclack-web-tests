package com.clickclack.web.autotests.pageobjects.clacks;

import com.clickclack.web.autotests.common.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ClacksDetailsPage extends ClackPageObject {

    private final By btn_toClacksList = By.id("btn-to-clacks-list");
    private final By btn_toUpdateClack = By.id("btn-to-update-clack");

    public ClacksDetailsPage(WebDriver driver, String host, String id) {
        super(driver, "/clacks/" + id + "/details", host, "Clack " + id);
        setClackId(clackId);
    }

    public ClacksDetailsPage openPage() {
        this.driver.get(this.URL);
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public ClacksDetailsPage verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be: " + this.TITLE);
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksDetailsPage verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: [" + btn_toClacksList.toString() + ", " + btn_toUpdateClack.toString() + "]");
        Assert.assertTrue(isElementDisplayed(btn_toClacksList));
        Assert.assertTrue(isElementDisplayed(btn_toUpdateClack));
        return this;
    }

    public ClacksDetailsPage gotoListPage() {
        ExtentLogger.INFO("going to clacks list page");
        clickTo(btn_toClacksList);
        ExtentLogger.INFO("link clicked");
        return this;
    }

    public ClacksDetailsPage gotoUpdatePage() {
        ExtentLogger.INFO("going to update page");
        clickTo(btn_toUpdateClack);
        ExtentLogger.INFO("btn clicked");
        return this;
    }

    public ClacksDetailsPage verifyError() {
        ExtentLogger.INFO("Verify error message");
        Assert.assertTrue(isTextPresent("API Call Failed"));
        return this;
    }
}
