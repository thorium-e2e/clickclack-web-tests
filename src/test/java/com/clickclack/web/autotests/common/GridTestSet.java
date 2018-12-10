package com.clickclack.web.autotests.common;

import org.testng.annotations.Test;

import com.clickclack.web.autotests.common.GridManager;

public class GridTestSet {

    @Test
    public void testGridSetUp() {
        GridManager.startHub();
    }
}
