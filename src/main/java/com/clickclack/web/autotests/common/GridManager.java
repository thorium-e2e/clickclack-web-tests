package com.clickclack.web.autotests.common;

import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;

public class GridManager {

    public Hub getMyHub() {
        return myHub;
    }

    @SuppressWarnings("static-access")
	public void setMyHub(Hub myHub) {
        this.myHub = myHub;
    }

    static Hub myHub = null;
    static String registrationUrl;

    public static void startHub() {
        if (myHub == null) {
            myHub = new Hub(new GridHubConfiguration());
            registrationUrl = myHub.getRegistrationURL().toString();
        }
        try {
            myHub.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
