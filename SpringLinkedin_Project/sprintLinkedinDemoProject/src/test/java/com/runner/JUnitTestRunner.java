package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.stepDefinition", "com.setup"},
    plugin = {
        "pretty",
        "html:target/CucumberReportsJUnit/ProfileReport.html",
        "json:target/CucumberReportsJUnit/ProfileReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    //tags = "@MutualConnections",
    monochrome = true
)
public class JUnitTestRunner {
}