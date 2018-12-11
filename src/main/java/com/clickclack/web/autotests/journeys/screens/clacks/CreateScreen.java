package com.clickclack.web.autotests.journeys.screens.clacks;

import com.clickclack.web.autotests.common.SeleniumJourneyScreen;
import org.openqa.selenium.By;

public class CreateScreen extends SeleniumJourneyScreen {

    public static By clack_fields_pair = By.id("clack-fields-pair");
    public static By btn_addFields = By.id("btn-add-fields");
    public static By btn_rmFields = By.id("btn-delete-fields");
    public static By btn_submit = By.id("btn-submit-form");
    public static By lnk_clacksPage = By.id("btn-to-clacks-list");
}
