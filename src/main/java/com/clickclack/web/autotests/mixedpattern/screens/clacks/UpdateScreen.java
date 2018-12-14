package com.clickclack.web.autotests.mixedpattern.screens.clacks;

import org.openqa.selenium.By;

public class UpdateScreen {

    public static final String EP = "/clacks/CLACK_ID/update";
    public static final By SUBMIT = By.id("btn-submit-form");
    public static final By CLACK_FIELDS_PAIR = By.id("clack-fields-pair");
    public static final By KEYS = By.id("keys");
    public static final By VALUES = By.id("values");

    public static By input_key(int position) {
        return By.xpath("//*[@id=\"keys\"][" + (position - 1) + "]");
    }
    public static By input_value(int position) {
        return By.xpath("//*[@id=\"values\"][" + (position - 1) + "]");
    }
}
