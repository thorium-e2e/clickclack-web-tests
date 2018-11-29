package com.apothuaud.selenium.clickclack.web.pages;

import com.apothuaud.selenium.common.PageObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public class ClacksListPage extends PageObject {

    // @FindBy(id = "link-back-home") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-home\"]")
    private WebElement lnk_home;

    // @FindBy(id = "link-create-clack") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-create-clack\"]")
    private WebElement lnk_createClack;

    // @FindBy(id = "clacks-list") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"clacks-list\"]")
    private WebElement ol_clacksList;

    // @FindBy(className = "clack") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"clack\"]")
    private List<WebElement> li_clack;

    // @FindBy(xpath = "//*[@id=\"clacks-list\"]/li[last()]/p/a[1]/button") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-update-clack\"][last()]")
    private WebElement btn_updateLastClack;

    // @FindBy(xpath = "//*[@id=\"clacks-list\"]/li[last()]/p/a[2]/button") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"btn-to-delete-clack\"][last()]")
    private WebElement btn_deleteLastClack;

    // @FindBy(xpath = "//*[@id=\"clacks-list\"]/li[last()]/a") deprecated
    @FindBy(xpath = "//*[@testsAutoId=\"lnk-to-clack-details\"][last()]")
    private WebElement lnk_lastClackDetails;

    public ClacksListPage(WebDriver driver, HashMap env) {
        super(driver, env);
        setUrl(getEnv().get("domain") + "/clacks");
    }

    public ClacksListPage openPage() {
        System.out.println("Open page: " + getClass().getName() + " with url: " + getUrl());
        getDriver().get(getUrl());
        return this;
    }

    public ClacksListPage verifyHeader() {
        Assert.assertEquals(getDriver().getTitle(), "Clacks");
        return this;
    }

    public ClacksListPage verifyContent() {
        Assert.assertTrue(lnk_home.isDisplayed());
        Assert.assertTrue(lnk_createClack.isDisplayed());
        Assert.assertTrue(ol_clacksList.isDisplayed());
        return this;
    }

    public ClacksListPage gotoHomePage() {
        System.out.println("going to HomePage from: " + getClass().getName());
        lnk_home.click();
        return this;
    }

    public ClacksListPage gotoCreatePage() {
        System.out.println("going to createPage from: " + getClass().getName());
        lnk_createClack.click();
        return this;
    }

    public ClacksListPage gotoDetailsLastClack() {
        System.out.println("going to DetailsPage of last clack in page: " + getClass().getName());
        lnk_lastClackDetails.click();
        return this;
    }

    public ClacksListPage gotoUpdateLastClack() {
        System.out.println("going to UpdatePage of last clack in page: " + getClass().getName());
        btn_updateLastClack.click();
        return this;
    }

    public ClacksListPage gotoDeleteLastClack() {
        System.out.println("going to deletePage of last clack in page: " + getClass().getName());
        btn_deleteLastClack.click();
        return this;
    }

    public String getLastClackId() throws IOException {
        WebElement lastClackElement = li_clack.get(li_clack.size()-1).findElement(By.tagName("a")).findElement(By.tagName("p"));
        JsonNode lastClack = new ObjectMapper().readTree(lastClackElement.getText());
        return lastClack.findValue("_id").toString().replace("\"", "");
    }

    public boolean verifyPresenceOfClackById(String testClackId) throws IOException {
        for (WebElement clack : li_clack) {
            WebElement clackElement = clack.findElement(By.tagName("a")).findElement(By.tagName("p"));
            JsonNode clackNode = new ObjectMapper().readTree(clackElement.getText());
            String clackId = clackNode.findValue("_id").toString().replace("\"", "");
            if (clackId.equals(testClackId)) {
                return true;
            }
        }
        return false;
    }
}
