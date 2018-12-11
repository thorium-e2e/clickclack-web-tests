package com.clickclack.web.autotests.journeys.screens.home;

import com.clickclack.web.autotests.common.SeleniumJourneyScreen;
import org.openqa.selenium.By;

public class HomeScreen extends SeleniumJourneyScreen {

    public static By h_title = By.id("home-title");
    public static By div_intro = By.id("home-intro");
    public static By div_content = By.id("home-content");
    public static By ul_contentList = By.id("home-content-list");
    public static By lnk_listClacks = By.id("btn-to-clacks-list");
    public static By div_contentInfo = By.id("home-content-info");
}
