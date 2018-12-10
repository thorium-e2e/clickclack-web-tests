package com.clickclack.web.autotests.pageobjects.home;

import com.clickclack.web.autotests.common.ExtentLogger;
import com.clickclack.web.autotests.common.SeleniumPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageObject extends SeleniumPageObject {

    private final By h_title = By.id("home-title");
    private final By div_intro = By.id("home-intro");
    private final By div_content = By.id("home-content");
    private final By ul_contentList = By.id("home-content-list");
    private final By lnk_listClacks = By.id("btn-to-clacks-list");
    private final By div_contentInfo = By.id("home-content-info");

    public HomePageObject(WebDriver driver, String host) {
        super(driver, "/", host, "ClickClack");
    }

    public HomePageObject openPage() {
        this.driver.get(this.URL);
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public HomePageObject verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be " + this.TITLE);
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public HomePageObject verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: ["
                + h_title.toString()
                + ", " + div_intro.toString()
                + ", " + div_content
                + ", " + ul_contentList
                + ", " + lnk_listClacks
                + ", " + div_contentInfo
                + "]");
        Assert.assertTrue(isElementDisplayed(h_title));
        Assert.assertTrue(isElementDisplayed(div_intro));
        Assert.assertTrue(isElementDisplayed(div_content));
        Assert.assertTrue(isElementDisplayed(ul_contentList));
        Assert.assertTrue(isElementDisplayed(lnk_listClacks));
        Assert.assertTrue(isElementDisplayed(div_contentInfo));
        return this;
    }

    public HomePageObject gotoListPage() {
        ExtentLogger.INFO("Go to clacks list page");
        clickTo(lnk_listClacks);
        ExtentLogger.INFO("btn clicked");
        return this;
    }
}
