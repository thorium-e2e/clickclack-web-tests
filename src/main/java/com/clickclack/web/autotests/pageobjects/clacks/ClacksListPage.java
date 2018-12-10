package com.clickclack.web.autotests.pageobjects.clacks;

import java.util.List;

import com.clickclack.web.autotests.common.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.clickclack.web.autotests.common.SeleniumPageObject;

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
        ExtentLogger.INFO("Open page with URL: " + this.URL);
        return this;
    }

    public ClacksListPage verifyHeader() {
        ExtentLogger.INFO("Verify page title, should be: " + this.TITLE);
        Assert.assertEquals(this.driver.getTitle(), this.TITLE);
        return this;
    }

    public ClacksListPage verifyContent() {
        ExtentLogger.INFO("Verify page content, should be present: ["
                + lnk_home.toString()
                + ", " + lnk_createClack.toString()
                + ", " + ol_clacksList
                + ", " + li_clack.toString()
                + ", " + btn_updateClack
                + ", " + btn_deleteClack.toString()
                + ", " + lnk_ClackDetails
                + "]");
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
        ExtentLogger.INFO("going to home page");
        clickTo(lnk_home);
        ExtentLogger.INFO("link clicked");
        return this;
    }

    public ClacksListPage gotoCreatePage() {
        ExtentLogger.INFO("going to create clack page");
        clickTo(lnk_createClack);
        ExtentLogger.INFO("link clicked");
        return this;
    }

    public ClacksListPage gotoDetailsLastClack() {
        ExtentLogger.INFO("going to details page (last clack)");
        List<WebElement> linksToClackDetails = listElements(lnk_ClackDetails);
        int nbclacks = linksToClackDetails.size();
        int lastItemIndex = nbclacks - 1;
        WebElement lnkToLastClackdetails = linksToClackDetails.get(lastItemIndex);
        clickTo(lnkToLastClackdetails);
        ExtentLogger.INFO("link clicked");
        return this;
    }

    public ClacksListPage gotoUpdateLastClack() {
        ExtentLogger.INFO("going to update page (last clack)");
        List<WebElement> buttonsToUpdateClack = listElements(btn_updateClack);
        int nbclacks = buttonsToUpdateClack.size();
        int lastItemIndex = nbclacks - 1;
        WebElement buttonToUpdateLastClack = buttonsToUpdateClack.get(lastItemIndex);
        clickTo(buttonToUpdateLastClack);
        ExtentLogger.INFO("btn clicked");
        return this;
    }

    public ClacksListPage gotoDeleteLastClack() {
        ExtentLogger.INFO("going to delete page (last clack)");
        List<WebElement> buttonsToDeleteClack = listElements(btn_deleteClack);
        int nbclacks = buttonsToDeleteClack.size();
        int lastItemIndex = nbclacks - 1;
        WebElement buttonToDeleteLastClack = buttonsToDeleteClack.get(lastItemIndex);
        clickTo(buttonToDeleteLastClack);
        ExtentLogger.INFO("btn clicked");
        return this;
    }

    public String getLastClackId() {
        ExtentLogger.INFO("finding clack id (last clack)");
        List<WebElement> linksToClackDetails = listElements(lnk_ClackDetails);
        int nbclacks = linksToClackDetails.size();
        int lastItemIndex = nbclacks - 1;
        WebElement lnkToLastClackdetails = linksToClackDetails.get(lastItemIndex);
        String[] hrefElements = lnkToLastClackdetails.getAttribute("href").split("/");
        int sizeOfHrefElements = hrefElements.length;
        String lastClackId = hrefElements[sizeOfHrefElements - 2];
        ExtentLogger.INFO("Last clack id: " + lastClackId);
        return lastClackId;
    }

	public boolean verifyPresenceOfClackById(String newClackId) {
        ExtentLogger.INFO("Verify presence of clack by id: " + newClackId);
		List<WebElement> linksToClackDetails = listElements(lnk_ClackDetails);
		for (int i = 0; i < linksToClackDetails.size(); i++) {
			WebElement linkToClackDetails = linksToClackDetails.get(i);
			String[] hrefElements = linkToClackDetails.getAttribute("href").split("/");
	        int sizeOfHrefElements = hrefElements.length;
	        String clackId = hrefElements[sizeOfHrefElements - 2];
	        if (clackId.contains(newClackId)) {
	            ExtentLogger.INFO("FOUND");
				return true;
			}
		}
		ExtentLogger.INFO("NOT FOUND");
		return false;
	}
}
