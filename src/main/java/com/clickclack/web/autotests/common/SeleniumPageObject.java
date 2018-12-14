package com.clickclack.web.autotests.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumPageObject {

    protected WebDriver driver;
    public String URL;
    protected String TITLE;

    public SeleniumPageObject(WebDriver driver, String EP, String host, String TITLE) {
        this.driver = driver;
        this.TITLE = TITLE;
        this.URL = host + EP;
    }

    private WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    protected boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    protected void clickTo(By by) {
        findElement(by).click();
    }

    protected List<WebElement> listElements(By by) {
        return driver.findElements(by);
    }

    protected void clickTo(WebElement element) {
        element.click();
    }

    protected void waitForElementVisible(By by) {
        ExpectedCondition<WebElement> cdtn = ExpectedConditions.presenceOfElementLocated(by);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(cdtn);
    }

    protected boolean isTextPresent(@SuppressWarnings("SameParameterValue") String text) {
        return this.driver.getPageSource().contains(text);
    }
}
