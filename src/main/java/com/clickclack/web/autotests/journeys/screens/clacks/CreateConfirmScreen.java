package com.clickclack.web.autotests.journeys.screens.clacks;

import com.clickclack.web.autotests.common.SeleniumJourneyScreen;
import org.openqa.selenium.By;

public class CreateConfirmScreen extends SeleniumJourneyScreen {

    public static String EP = "/clacks/create";

    public static By lnk_clacks = By.id("lnk_clacks");
    public static By lnk_clacks_create = By.id("lnk_clacks_create");
    public static By text_created = By.id("text_created");
    public static By clack_table_elements = By.id("clack_table_elements");
    public static By btn_clack_details = By.id("btn_clack_details");
    public static By btn_clack_update = By.id("btn_clack_update");
    public static By btn_clack_delete = By.id("btn_clack_delete");
}
