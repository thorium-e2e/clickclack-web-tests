package com.apothuaud.selenium.clickclack.web.pages;

import com.apothuaud.selenium.common.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;

@SuppressWarnings("unused")
public class HomePage extends PageObject {

    // @FindBy(id = "title") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"home-title\"]")
    private WebElement h_title;

    // @FindBy(id = "intro") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"home-intro\"]")
    private WebElement div_intro;

    // @FindBy(id = "content") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"home-content\"]")
    private WebElement div_content;

    // @FindBy(id = "content-list") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"home-content-list\"]")
    private WebElement ul_contentList;

    // @FindBy(id = "link-list-clacks") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"btn-to-clacks-list\"]")
    private WebElement lnk_listClacks;

    // @FindBy(id = "content-info") deprecated
    @FindBy(xpath = "//*[@testsautoid=\"home-content-info\"]")
    private WebElement div_contentInfo;

    public HomePage(WebDriver driver, HashMap env) {
        super(driver, env);
        setUrl(getEnv().get("domain") + "/");
    }

    public HomePage openPage() {
        System.out.println("Open page: " + getClass().getName() + " with url: " + getUrl());
        getDriver().get(getUrl());
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    public HomePage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "ClickClack");
        return this;
    }

    public HomePage verifyContent() {
        Assert.assertTrue(h_title.isDisplayed());
        Assert.assertTrue(div_intro.isDisplayed());
        Assert.assertTrue(div_content.isDisplayed());
        Assert.assertTrue(ul_contentList.isDisplayed());
        Assert.assertTrue(lnk_listClacks.isDisplayed());
        Assert.assertTrue(div_contentInfo.isDisplayed());
        return this;
    }

    public HomePage gotoListPage() {
        System.out.println("going to ListPage from: " + getClass().getName());
        lnk_listClacks.click();
        return this;
    }
}
