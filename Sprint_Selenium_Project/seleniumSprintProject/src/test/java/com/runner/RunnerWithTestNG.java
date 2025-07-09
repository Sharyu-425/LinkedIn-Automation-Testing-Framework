package com.runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features/Homepage.feature",
glue= {"com.stepDefinition"},
plugin= {
		"pretty",
},
monochrome=true,
tags="@LinkedIn")
public class RunnerWithTestNG extends {

}
