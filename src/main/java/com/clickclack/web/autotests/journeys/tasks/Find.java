package com.clickclack.web.autotests.journeys.tasks;

import com.clickclack.web.autotests.journeys.screens.clacks.DetailsScreen;
import com.clickclack.web.autotests.journeys.screens.clacks.ListScreen;
import org.openqa.selenium.WebDriver;

public class Find {

    public static void clacks(WebDriver driver, String host) {
        driver.get(host + ListScreen.EP);
    }

    public static void clackById(WebDriver driver, String host, String clackId){
        driver.get(host + DetailsScreen.EP.replace("CLACK_ID", clackId));
    }
}
