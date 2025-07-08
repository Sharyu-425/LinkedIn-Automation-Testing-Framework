package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.stepDefinition", "com.setup"},
    //tags = "@SendConnection or @WithdrawRequest",
    tags = "@AcceptIgnoreRequest ",
    plugin = {
        "pretty",
        "html:target/CucumberReports/ProfileReport.html",
        "json:target/CucumberReports/ProfileReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Executes both scenarios sequentially
}