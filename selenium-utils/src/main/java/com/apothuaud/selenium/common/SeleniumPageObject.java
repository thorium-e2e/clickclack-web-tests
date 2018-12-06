package com.apothuaud.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumPageObject {

    protected WebDriver driver;
    public String URL;
    private String EP;
    protected String TITLE;

    public SeleniumPageObject(WebDriver driver, String EP, String host, String TITLE) {
        this.driver = driver;
        this.EP = EP;
        this.TITLE = TITLE;
        this.URL = host + this.EP;
    }

    protected WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    protected boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    protected void clickTo(By by){
        findElement(by).click();
    }

    protected List<WebElement> listElements(By by) {
        return driver.findElements(by);
    }

    protected void clickTo(WebElement element) {
        element.click();
    }
}
