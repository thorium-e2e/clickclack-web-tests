package com.clickclack.web.autotests.journeys.tasks;

import com.clickclack.web.autotests.common.ExtentLogger;
import com.clickclack.web.autotests.journeys.actions.Click;
import com.clickclack.web.autotests.journeys.actions.Enter;
import com.clickclack.web.autotests.journeys.screens.clacks.UpdateScreen;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Update {

    public static void clackById(WebDriver driver, String host, String clackId, HashMap<String, String> clackBody) {
        ExtentLogger.INFO("Update Clack " + clackId + " with body: " + clackBody);
        driver.get(host + UpdateScreen.EP.replace("CLACK_ID", clackId));
        if(clackBody != null && clackBody.size() >= 1){
            // first key/value
            String key = String.valueOf(clackBody.keySet().toArray()[0]);
            String value = clackBody.get(key);
            Enter.textInto(driver, key, UpdateScreen.input_key(1));
            Enter.textInto(driver, value, UpdateScreen.input_value(1));
            // other key/value
            if(clackBody.size() >= 2){
                for (int i = 1; i < clackBody.size(); i++) {
                    key = String.valueOf(clackBody.keySet().toArray()[i]);
                    value = clackBody.get(key);
                    Enter.textInto(driver, key, UpdateScreen.input_key(i + 1));
                    Enter.textInto(driver, value, UpdateScreen.input_value(i + 1));
                }
            }
        }
        Click.on(driver, UpdateScreen.btn_submit);
    }
}
