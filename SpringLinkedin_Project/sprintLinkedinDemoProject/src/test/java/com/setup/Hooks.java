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
//package com.setup;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class Hooks extends BaseTest {
//
//    @Before
//    public void setUp() {
//        initializeBrowser();
//        loadPage();
//    }
//
//    @After
//    public void tearDownScenario(Scenario scenario) {
//        if (scenario.isFailed()) {
//            try {
//                File screenshot = new File("target/screenshots/SendConnection.png");
//                if (screenshot.exists()) {
//                    byte[] fileContent = Files.readAllBytes(Paths.get(screenshot.getPath()));
//                    scenario.attach(fileContent, "image/png", "Failure Screenshot");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        tearDown();
//    }
//}