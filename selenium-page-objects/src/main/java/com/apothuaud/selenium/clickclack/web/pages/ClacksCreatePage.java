package com.apothuaud.selenium.clickclack.web.pages;

import com.apothuaud.selenium.common.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class ClacksCreatePage extends PageObject {

    // @FindBy(className = "input-free-form") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"clack-fields-pair\"")
    private List<WebElement> clack_fields_pair;

    // @FindBy(id = "btn-add-clack_fields_pair") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-add-fields\"")
    private WebElement btn_addFields;

    // @FindBy(id = "btn-rm-clack_fields_pair") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-delete-fields\"")
    private WebElement btn_rmFields;

    // @FindBy(className = "button-submit") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-submit-form\"")
    private WebElement btn_submit;

    // @FindBy(id = "lnk-clacks") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-clacks-list\"")
    private WebElement lnk_clacksPage;

    public ClacksCreatePage(WebDriver driver, HashMap env) {
        super(driver, env);
        setUrl(getEnv().get("domain") + "/clacks/create");
    }

    public ClacksCreatePage openPage() {
        System.out.println("Open " + getClass().getName() + " with URL: " + getUrl());
        getDriver().get(getUrl());
        return this;
    }

    public ClacksCreatePage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "Create Clack");
        return this;
    }

    public ClacksCreatePage verifyContent() {
        Assert.assertTrue(btn_addFields.isDisplayed());
        Assert.assertTrue(lnk_clacksPage.isDisplayed());
        return this;
    }

    public ClacksCreatePage verifyNbFields(int expected) {
        Assert.assertEquals(clack_fields_pair.size(), expected);
        return this;
    }

    public ClacksCreatePage addFields() {
        System.out.println("Adding clack_fields_pair in page: " + getClass().getName());
        btn_addFields.click();
        ExpectedCondition<WebElement> cdtn = ExpectedConditions.presenceOfElementLocated(By.id("btn-rm-clack_fields_pair"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(cdtn);
        System.out.println("Fields added");
        return this;
    }

    public ClacksCreatePage removeFields() {
        System.out.println("Removing clack_fields_pair in page: " + getClass().getName());
        btn_rmFields.click();
        return this;
    }

    public ClacksCreatePage gotoListPage() {
        System.out.println("Going to ListPage from: " + getClass().getName());
        lnk_clacksPage.click();
        return this;
    }

    public ClacksCreatePage createEmpty() {
        System.out.println("Create empty element in page: " + getClass().getName());
        btn_submit.click();
        return this;
    }
}
