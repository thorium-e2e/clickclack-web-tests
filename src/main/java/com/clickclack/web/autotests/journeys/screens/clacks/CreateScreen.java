package com.clickclack.web.autotests.journeys.screens.clacks;

import com.clickclack.web.autotests.common.SeleniumJourneyScreen;
import org.openqa.selenium.By;

public class CreateScreen extends SeleniumJourneyScreen {

    public static String EP = "/clacks/create";

    public static By lnk_clacks = By.id("lnk_clacks");
    public static By clacks_fields_pair_list = By.id("clacks_fields_pair_list");
    public static By clacks_fields_pair = By.id("clacks_fields_pair");
    public static By keys = By.id("keys");
    public static By values = By.id("values");
    public static By btn_delete_fields = By.id("btn_delete_fields");
    public static By btn_reset = By.id("btn_reset");
    public static By btn_add_fields = By.id("btn_add_fields");
    public static By btn_submit = By.id("btn_submit");
    public static By input_key(int pos) {
        return By.xpath("//*[@id=\"" + keys + "][" + pos + "]\"");
    }
    public static By input_value(int pos) {
        return By.xpath("//*[@id=\"" + values + "][" + pos + "]\"");
    }
}
