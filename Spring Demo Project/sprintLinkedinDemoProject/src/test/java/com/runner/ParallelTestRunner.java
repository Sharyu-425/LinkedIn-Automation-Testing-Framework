package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",        // Path to feature files
	    glue = {"com.stepDefinition"}, 
	    // Step definition package
	    tags="@tc03",
	    plugin = {
	        "pretty",                                     //console output
	        "html:target/CucumberReport5.html",           // HTML report
	        "json:target/cucumber.json",                  //json report
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  //this is for extent report
	    }
	)
public class ParallelTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
	

}
