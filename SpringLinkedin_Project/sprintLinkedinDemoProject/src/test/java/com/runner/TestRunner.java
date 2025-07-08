package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.stepDefinition", "com.setup"},
    tags = "@SendConnection",
    plugin = {
        "pretty",
        "html:target/CucumberReports/SendConnectionReport.html",
        "json:target/CucumberReports/SendConnectionReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Executes Cucumber scenarios using TestNG
}