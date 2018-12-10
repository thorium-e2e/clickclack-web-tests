package com.clickclack.web.autotests.pageobjects.clacks;

import com.clickclack.web.autotests.common.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ClacksUpdatePage extends ClackPageObject {

    private final By p_clackFields = By.id("clack-fields-pair");
    private final By btn_addFields = By.id("btn-add-fields");
    private final By btn_rmFields = By.id("btn-delete-fields");
    private final By btn_submit = By.id("btn-submit-form");
    private final By lnk_clacksPage = By.id("btn-to-clacks-list");

    public ClacksUpdatePage(WebDriver driver, String host, String id) {
        super(driver, "/clacks/" + id + "/update", host, "Update Clack " + id);
        setClackId(id);
    }

    public ClacksUpdatePage openPage() {
    	this.driver.get(this.URL);
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public ClacksUpdatePage verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be: " + this.TITLE);
    	Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksUpdatePage verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: ["
                + p_clackFields.toString()
                + ", " + btn_addFields.toString()
                + ", " + btn_submit
                + ", " + lnk_clacksPage.toString()
                + "]");
        Assert.assertTrue(isElementDisplayed(p_clackFields));
        Assert.assertTrue(isElementDisplayed(btn_addFields));
        Assert.assertTrue(isElementDisplayed(btn_submit));
        Assert.assertTrue(isElementDisplayed(lnk_clacksPage));
        return this;
    }

    public ClacksUpdatePage verifyNbFields(int expected) {
        ExtentLogger.INFO("Verify nb fields, should be: " + expected);
        Assert.assertEquals(listElements(p_clackFields).size(), expected);
        return this;
    }

    public ClacksUpdatePage addFields() {
        ExtentLogger.INFO("Adding key/value fields");
    	clickTo(btn_addFields);
    	waitForElementVisible(btn_rmFields);
        ExtentLogger.INFO("A new key/value fields should be present");
        return this;
    }

    public ClacksUpdatePage removeFields() {
        ExtentLogger.INFO("Remove a key/value fields");
    	clickTo(btn_rmFields);
    	ExtentLogger.INFO("btn clicked");
        return this;
    }

    public ClacksUpdatePage gotoListPage() {
        ExtentLogger.INFO("Going to clacks list page");
    	clickTo(lnk_clacksPage);
    	ExtentLogger.INFO("btn clicked");
        return this;
    }

    public ClacksUpdatePage submit() {
        ExtentLogger.INFO("Submit the form");
    	clickTo(btn_submit);
        ExtentLogger.INFO("btn clicked");
        return this;
    }

    public int getNbFields() {
        int nFields = listElements(p_clackFields).size();
        ExtentLogger.INFO("found " + nFields + " fields");
        return nFields;
    }
}
