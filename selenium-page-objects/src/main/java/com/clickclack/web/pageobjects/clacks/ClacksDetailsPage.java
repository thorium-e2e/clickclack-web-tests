package com.clickclack.web.pageobjects.clacks;

import com.apothuaud.selenium.common.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class ClacksDetailsPage extends PageObject {

    private String clackId;

    public String getClackId() {
        return clackId;
    }

    private void setClackId(String clackId) {
        this.clackId = clackId;
    }

    // @FindBy(id = "link-list") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-to-clacks-list\"]")
    WebElement btn_toClacksList;

    // @FindBy(id = "link-update") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-to-update-clack\"]")
    WebElement btn_toUpdateClack;

    public ClacksDetailsPage(WebDriver driver, String clackId) {
        super(driver);
        setClackId(clackId);
        setUrl("https://rec-clickclack-web.herokuapp.com/clacks/" + getClackId() + "/details");
    }

    public ClacksDetailsPage openPage() {
        System.out.println("Open page: " + getClass().getName() + " with url: " + getUrl());
        getDriver().get(getUrl());
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    public ClacksDetailsPage gotoListPage() {
        System.out.println("going to ListPage from: " + getClass().getName());
        btn_toClacksList.click();
        return this;
    }

    public ClacksDetailsPage gotoUpdatePage() {
        System.out.println("going to updatePage from: " + getClass().getName());
        btn_toUpdateClack.click();
        return this;
    }

    public ClacksDetailsPage verifyContent() {
        Assert.assertTrue(btn_toClacksList.isDisplayed());
        Assert.assertTrue(btn_toUpdateClack.isDisplayed());
        return this;
    }

    public ClacksDetailsPage verifyError() {
        Assert.assertTrue(getDriver().getPageSource().contains("API Call Failed"));
        return this;
    }

    public ClacksDetailsPage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "Clack " + getClackId());
        return this;
    }
}