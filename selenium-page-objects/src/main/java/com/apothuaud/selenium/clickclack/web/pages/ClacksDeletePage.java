package com.apothuaud.selenium.clickclack.web.pages;

import com.apothuaud.selenium.common.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;

@SuppressWarnings("UnusedReturnValue")
public class ClacksDeletePage extends PageObject {

    private String clackId;

    private String getClackId() {
        return clackId;
    }

    private void setClackId(String clackId) {
        this.clackId = clackId;
    }

    // @FindBy(id = "confirm-delete-label") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"are-you-sure\"")
    private WebElement lbl_areYouSure;

    // @FindBy(xpath = "/html/body/p[3]/a[1]/button") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"not-sure\"")
    private WebElement btn_notSure;

    // @FindBy(className = "button-create") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"sure\"")
    private WebElement btn_sure;

    // @FindBy(xpath = "//*[@id=\"link-back\"]") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-clacks-list\"")
    private WebElement lnk_listPage;

    public ClacksDeletePage(WebDriver driver, HashMap env, String id) {
        super(driver, env);
        setClackId(id);
        setUrl(getEnv().get("domain") + "/clacks/" +  getClackId() + "/delete_confirm");
    }

    public ClacksDeletePage openPage() {
        System.out.println("Open page: " + getClass().getName() + " with url: " + getUrl());
        getDriver().get(getUrl());
        return this;
    }

    public ClacksDeletePage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "Delete Clack " + getClackId());
        return this;
    }

    public ClacksDeletePage verifyContent() {
        Assert.assertTrue(lbl_areYouSure.isDisplayed());
        Assert.assertTrue(btn_sure.isDisplayed());
        Assert.assertTrue(btn_notSure.isDisplayed());
        return this;
    }

    public ClacksDeletePage gotoListPage() {
        System.out.println("going to ListPage from: " + getClass().getName());
        lnk_listPage.click();
        return this;
    }

    public ClacksDeletePage refuse() {
        System.out.println("Refuse delete in page: " + getClass().getName());
        btn_notSure.click();
        return this;
    }

    public ClacksDeletePage accept() {
        System.out.println("Accept delete in page: " + getClass().getName());
        btn_sure.click();
        return this;
    }
}
