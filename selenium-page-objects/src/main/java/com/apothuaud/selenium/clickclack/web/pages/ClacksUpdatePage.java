package com.apothuaud.selenium.clickclack.web.pages;

import com.apothuaud.selenium.common.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class ClacksUpdatePage extends PageObject {

    private String clackId;

    private String getClackId() {
        return clackId;
    }

    private void setClackId(String clackId) {
        this.clackId = clackId;
    }

    // @FindBy(className = "input-free-form") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"clack-fields\"]")
    private List<WebElement> div_clackFields;

    // @FindBy(id = "btn-add-fields") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-add-fields\"]")
    private WebElement btn_addFields;

    // @FindBy(xpath = "//*[@id=\"clack-fields\"]/p/button") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-delete-fields\"]")
    private WebElement btn_rmFields;

    // @FindBy(className = "button-submit") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-submit-form\"]")
    private WebElement btn_submit;

    // @FindBy(id = "lnk-clacks") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-to-clacks-list\"]")
    private WebElement lnk_clacksPage;

    public ClacksUpdatePage(WebDriver driver, HashMap env, String id) {
        super(driver, env);
        setClackId(id);
        setUrl(getEnv().get("domain") + "/clacks/" + getClackId() + "/update");
    }

    public ClacksUpdatePage openPage() {
        System.out.println("Open page: " + getClass().getName() + " with url: " + getUrl());
        getDriver().get(getUrl());
        return this;
    }

    public ClacksUpdatePage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "Update Clack " + getClackId());
        return this;
    }

    public ClacksUpdatePage verifyContent() {
        Assert.assertTrue(btn_addFields.isDisplayed());
        Assert.assertTrue(lnk_clacksPage.isDisplayed());
        return this;
    }

    public ClacksUpdatePage verifyNbFields(int expected) {
        Assert.assertEquals(div_clackFields.size(), expected);
        return this;
    }

    public ClacksUpdatePage addFields() {
        System.out.println("Add fields in page: " + getClass().getName());
        btn_addFields.click();
        ExpectedCondition<WebElement> cdtn = ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@testsautoid=\"btn-delete-fields\"]"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(cdtn);
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    public ClacksUpdatePage removeFields() {
        System.out.println("Remove fields in page: " + getClass().getName());
        btn_rmFields.click();
        return this;
    }

    public ClacksUpdatePage gotoListPage() {
        System.out.println("going to ListPage from: " + getClass().getName());
        lnk_clacksPage.click();
        return this;
    }

    public ClacksUpdatePage submit() {
        System.out.println("Submit form in page: " + getClass().getName());
        btn_submit.click();
        return this;
    }

    public int getNbFields() {
        return div_clackFields.size();
    }
}
