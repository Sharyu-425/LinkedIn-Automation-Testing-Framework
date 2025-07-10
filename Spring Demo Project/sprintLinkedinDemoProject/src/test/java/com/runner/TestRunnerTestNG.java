package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests; //base class to run cucumber using testNG
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",        // Path to feature files
    glue = {"com.stepDefinition"}, 
    // Step definition package
    tags="@tc_negative",
    plugin = {
        "pretty",                                     //console output
        "html:target/CucumberReport5.html",           // HTML report
        "json:target/cucumber.json",                  //json report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  //this is for extent report
    }
)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
   
}
