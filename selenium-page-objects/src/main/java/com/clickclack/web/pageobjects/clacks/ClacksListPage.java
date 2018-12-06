package com.clickclack.web.pageobjects.clacks;

import com.apothuaud.selenium.common.SeleniumPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ClacksListPage extends SeleniumPageObject {

    private final By lnk_home = By.id("btn-to-home");
    private final By lnk_createClack = By.id("btn-to-create-clack");
    private final By ol_clacksList = By.id("clacks-list");
    private final By li_clack = By.id("clack");
    private final By btn_updateClack = By.id("btn-to-update-clack");
    private final By btn_deleteClack = By.id("btn-to-delete-clack");
    private final By lnk_ClackDetails = By.id("lnk-to-clack-details");

    public ClacksListPage(WebDriver driver, String host) {
        super(driver, "/clacks", host, "Clacks");
    }

    public ClacksListPage openPage() {
        this.driver.get(this.URL);
        return this;
    }

    public ClacksListPage verifyHeader() {
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksListPage verifyContent() {
        Assert.assertTrue(isElementDisplayed(lnk_home));
        Assert.assertTrue(isElementDisplayed(lnk_createClack));
        Assert.assertTrue(isElementDisplayed(ol_clacksList));
        Assert.assertTrue(isElementDisplayed(li_clack));
        Assert.assertTrue(isElementDisplayed(btn_updateClack));
        Assert.assertTrue(isElementDisplayed(btn_deleteClack));
        Assert.assertTrue(isElementDisplayed(lnk_ClackDetails));
        return this;
    }

    public ClacksListPage gotoHomePage() {
        clickTo(lnk_home);
        return this;
    }

    public ClacksListPage gotoCreatePage() {
        clickTo(lnk_createClack);
        return this;
    }

    public ClacksListPage gotoDetailsLastClack() {
        List<WebElement> linksToClackDetails = listElements(lnk_ClackDetails);
        int nbclacks = linksToClackDetails.size();
        int lastItemIndex = nbclacks - 1;
        WebElement lnkToLastClackdetails = linksToClackDetails.get(lastItemIndex);
        clickTo(lnkToLastClackdetails);
        return this;
    }

    public ClacksListPage gotoUpdateLastClack() {
        List<WebElement> buttonsToUpdateClack = listElements(btn_updateClack);
        int nbclacks = buttonsToUpdateClack.size();
        int lastItemIndex = nbclacks - 1;
        WebElement buttonToUpdateLastClack = buttonsToUpdateClack.get(lastItemIndex);
        clickTo(buttonToUpdateLastClack);
        return this;
    }

    public ClacksListPage gotoDeleteLastClack() {
        List<WebElement> buttonsToDeleteClack = listElements(btn_deleteClack);
        int nbclacks = buttonsToDeleteClack.size();
        int lastItemIndex = nbclacks - 1;
        WebElement buttonToDeleteLastClack = buttonsToDeleteClack.get(lastItemIndex);
        clickTo(buttonToDeleteLastClack);
        return this;
    }

    public String getLastClackId() {
        List<WebElement> linksToClackDetails = listElements(lnk_ClackDetails);
        int nbclacks = linksToClackDetails.size();
        int lastItemIndex = nbclacks - 1;
        WebElement lnkToLastClackdetails = linksToClackDetails.get(lastItemIndex);
        String[] hrefElements = lnkToLastClackdetails.getAttribute("href").split("/");
        int sizeOfHrefElements = hrefElements.length;
        return hrefElements[sizeOfHrefElements - 2];
    }
}
