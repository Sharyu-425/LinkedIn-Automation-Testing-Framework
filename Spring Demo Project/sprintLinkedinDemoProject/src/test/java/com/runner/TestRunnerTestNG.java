package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",        // Path to feature files
    glue = {"com.stepDefinition"}, 
    // Step definition package
   tags="@tc02",
    plugin = {
        "pretty",
        "html:target/CucumberReport5.html",           // HTML report
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
   
}
