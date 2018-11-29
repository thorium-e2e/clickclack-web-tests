package com.apothuaud.selenium.clickclack.web.tests.draft.v1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.apothuaud.testng.listeners.SlackNotifier.class)
public class ListenerTestSet {

    @Test
    public void testPass() {
        System.out.println("pass");
    }

    @Test
    public void testFail() {
        System.out.println("fail");
        Assert.assertTrue(1+2==4);
    }
}
