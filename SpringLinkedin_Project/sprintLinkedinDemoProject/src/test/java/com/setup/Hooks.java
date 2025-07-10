package com.setup;

import com.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    public static Scenario scenario;

    @Before
    public void setUp(Scenario sc) {
        scenario = sc;
        initializeBrowser();
        loadPage();
    }
    
    
    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, "FAILED_" + scenario.getName().replace(" ", "_"));
        }
        tearDown();
    }
}
