package com.clickclack.web.autotests.pageobjects.clacks;

import com.clickclack.web.autotests.common.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.clickclack.web.autotests.common.SeleniumPageObject;

public class ClacksCreatePage extends SeleniumPageObject {

    private final By clack_fields_pair = By.id("clack-fields-pair");
    private final By btn_addFields = By.id("btn-add-fields");
    private final By btn_rmFields = By.id("btn-delete-fields");
    private final By btn_submit = By.id("btn-submit-form");
    private final By lnk_clacksPage = By.id("btn-to-clacks-list");

    public ClacksCreatePage(WebDriver driver, String host) {
        super(driver, "/clacks/create", host, "Create Clack");
    }

    public ClacksCreatePage openPage() {
        this.driver.get(this.URL);
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public ClacksCreatePage verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be: " + this.TITLE);
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksCreatePage verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: [" + btn_addFields.toString() + ", " + btn_submit.toString() + ", " + lnk_clacksPage + "]");
        Assert.assertTrue(isElementDisplayed(btn_addFields));
        Assert.assertTrue(isElementDisplayed(btn_submit));
        Assert.assertTrue(isElementDisplayed(lnk_clacksPage));
        return this;
    }

    public ClacksCreatePage verifyNbFields(int expected) {
        ExtentLogger.INFO("Verify nb fields, should be: " + expected);
        Assert.assertEquals(listElements(clack_fields_pair).size(), expected);
        return this;
    }

    public ClacksCreatePage addFields() {
        ExtentLogger.INFO("Adding key/value fields");
        clickTo(btn_addFields);
        waitForElementVisible(btn_rmFields);
        ExtentLogger.INFO("A new key/value fields should be present");
        return this;
    }

	public ClacksCreatePage removeFields() {
        ExtentLogger.INFO("Remove a key/value fields");
        clickTo(btn_rmFields);
        ExtentLogger.INFO("Fields removed");
        return this;
    }

    public ClacksCreatePage gotoListPage() {
        ExtentLogger.INFO("Going to clacks list page");
        clickTo(lnk_clacksPage);
        ExtentLogger.INFO("Link clicked");
        return this;
    }

    public ClacksCreatePage createEmpty() {
        ExtentLogger.INFO("Create an empty clack");
        clickTo(btn_submit);
        ExtentLogger.INFO("btn clicked");
        return this;
    }
}
