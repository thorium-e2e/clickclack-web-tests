package com.clickclack.web.autotests.journeys.tasks;

import com.clickclack.web.autotests.common.ExtentLogger;
import com.clickclack.web.autotests.journeys.actions.Click;
import com.clickclack.web.autotests.journeys.actions.Enter;
import com.clickclack.web.autotests.journeys.screens.clacks.CreateScreen;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Create {

    public static void newClack(WebDriver driver, String host, HashMap<String, String> clackBody) {
        ExtentLogger.INFO("Create a new Clack with body: " + clackBody);
        driver.get(host + CreateScreen.EP);
        if(clackBody != null && clackBody.size() >= 1){
            // first key/value
            String key = String.valueOf(clackBody.keySet().toArray()[0]);
            String value = clackBody.get(key);
            Enter.textInto(driver, key, CreateScreen.input_key(1));
            Enter.textInto(driver, value, CreateScreen.input_value(1));
            // other key/value
            if(clackBody.size() >= 2){
                for (int i = 1; i < clackBody.size(); i++) {
                    Click.on(driver, CreateScreen.btn_add_fields);
                    key = String.valueOf(clackBody.keySet().toArray()[i]);
                    value = clackBody.get(key);
                    Enter.textInto(driver, key, CreateScreen.input_key(i + 1));
                    Enter.textInto(driver, value, CreateScreen.input_value(i + 1));
                }
            }
        }
        Click.on(driver, CreateScreen.btn_submit);
    }
}
