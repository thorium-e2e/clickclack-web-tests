package com.clickclack.web.autotests.mixedpattern.actions.clacks;

import com.clickclack.web.autotests.mixedpattern.actions.basic.Click;
import com.clickclack.web.autotests.mixedpattern.actions.basic.Enter;
import com.clickclack.web.autotests.mixedpattern.screens.clacks.UpdateScreen;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Update {
    public static void clackById(WebDriver driver, String host, String clackId, HashMap<String, String> clackUpdatebody) {
        driver.get(host + UpdateScreen.EP.replace("CLACK_ID", clackId));
        if(clackUpdatebody != null && clackUpdatebody.size() >= 1){
            // first key/value
            String key = String.valueOf(clackUpdatebody.keySet().toArray()[0]);
            String value = clackUpdatebody.get(key);
            Enter.textInto(driver, key, UpdateScreen.input_key(1));
            Enter.textInto(driver, value, UpdateScreen.input_value(1));
            // other key/value
            if(clackUpdatebody.size() >= 2){
                for (int i = 1; i < clackUpdatebody.size(); i++) {
                    key = String.valueOf(clackUpdatebody.keySet().toArray()[i]);
                    value = clackUpdatebody.get(key);
                    Enter.textInto(driver, key, UpdateScreen.input_key(i + 1));
                    Enter.textInto(driver, value, UpdateScreen.input_value(i + 1));
                }
            }
        }
        Click.toElement(driver, UpdateScreen.SUBMIT);
    }
}
