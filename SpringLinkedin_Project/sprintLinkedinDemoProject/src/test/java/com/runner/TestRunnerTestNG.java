package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",        // Path to feature files
    glue = {"com.stepDefinition"},                   // Step definition package
    plugin = {
        "pretty",
        "html:target/CucumberReport.html",           // HTML report
        "json:target/cucumber.json"
    },
    monochrome = true,
    dryRun = false
)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
    // This class runs the Cucumber tests using TestNG
}
