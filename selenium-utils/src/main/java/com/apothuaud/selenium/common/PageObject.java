package com.apothuaud.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private WebDriver driver;
    private String url;

    public PageObject(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(getDriver(), this);
    }
}
