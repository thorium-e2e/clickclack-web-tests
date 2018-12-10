package com.clickclack.web.autotests.pageobjects.clacks;

import com.clickclack.web.autotests.common.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ClacksDeletePage extends ClackPageObject {

    private final By lbl_areYouSure = By.id("are-you-sure");
    private final By btn_notSure = By.id("not-sure");
    private final By btn_sure = By.id("sure");
    private final By lnk_listPage = By.id("btn-to-clacks-list");

    public ClacksDeletePage(WebDriver driver, String host, String id) {
        super(driver, "/clacks/" + id + "/delete_confirm", host, "Delete Clack " + id);
        super.setClackId(id);
    }

    public ClacksDeletePage openPage() {
        this.driver.get(this.URL);
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public ClacksDeletePage verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be: " + this.TITLE);
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksDeletePage verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: [" + lbl_areYouSure.toString() + ", " + btn_sure.toString() + ", " + btn_notSure + "]");
        Assert.assertTrue(isElementDisplayed(lbl_areYouSure));
        Assert.assertTrue(isElementDisplayed(btn_sure));
        Assert.assertTrue(isElementDisplayed(btn_notSure));
        return this;
    }

    public ClacksDeletePage gotoListPage() {
        ExtentLogger.INFO("Go to clacks list page");
        clickTo(lnk_listPage);
        ExtentLogger.INFO("link clicked");
        return this;
    }

    public ClacksDeletePage refuse() {
        ExtentLogger.INFO("refuse to delte");
        clickTo(btn_notSure);
        ExtentLogger.INFO("btn clicked");
        return this;
    }

    public ClacksDeletePage accept() {
        ExtentLogger.INFO("Accept to delete");
        clickTo(btn_sure);
        ExtentLogger.INFO("btn clicked");
        return this;
    }
}
