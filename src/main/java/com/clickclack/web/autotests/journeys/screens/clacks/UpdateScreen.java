package com.clickclack.web.autotests.journeys.screens.clacks;

import org.openqa.selenium.By;

public class UpdateScreen {

    public static String EP = "/clacks/CLACK_ID/update";

    public static By lnk_clacks = By.id("lnk_clacks");
    public static By lnk_clack_details = By.id("lnk_clack_details");
    public static By clacks_fields_pair_list = By.id("clacks_fields_pair_list");
    public static By clacks_fields_pair = By.id("clacks_fields_pair");
    public static By keys = By.id("keys");
    public static By values = By.id("values");
    public static By btn_delete_fields = By.id("btn_delete_fields");
    public static By btn_reset = By.id("btn_reset");
    public static By btn_add_fields = By.id("btn_add_fields");
    public static By btn_submit = By.id("btn_submit");
    public static By err_not_found = By.id("err_not_found");
    public static By input_key(int pos) {
        return By.xpath("//*[@id=\"" + keys + "][" + pos + "]\"");
    }
    public static By input_value(int pos) {
        return By.xpath("//*[@id=\"" + values + "][" + pos + "]\"");
    }
}
