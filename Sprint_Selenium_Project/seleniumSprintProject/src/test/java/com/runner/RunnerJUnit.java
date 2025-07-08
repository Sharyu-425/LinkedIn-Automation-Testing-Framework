package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Homepage.feature",
glue= {"com.stepDefinition"},
plugin= {
		"pretty",
},
monochrome=true,
tags="@TS_LinkedIn_05")
public class RunnerJUnit {
	
}


////span[text()="It appears that this post has already been shared. Please edit your draft."]