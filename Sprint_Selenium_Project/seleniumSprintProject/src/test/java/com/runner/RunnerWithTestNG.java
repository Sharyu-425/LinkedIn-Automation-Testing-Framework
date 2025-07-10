package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\raghav\\OneDrive - Capgemini\\Sprint Selenium Project\\seleniumSprintProject\\src\\test\\resources\\Features\\Homepage.feature",
glue= {"com.stepDefinition"},
//plugin= {
//		"pretty",
//},
monochrome=true
)
public class RunnerWithTestNG extends AbstractTestNGCucumberTests{

}
