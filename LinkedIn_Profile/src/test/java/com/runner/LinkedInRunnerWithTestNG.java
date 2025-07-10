package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInProject\\LinkedIn_Profile\\src\\test\\resource\\Feature\\LinkedInProfile.feature",
glue = "com.stepdefinition",
plugin = {"pretty", "html:target/cucumber-reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class LinkedInRunnerWithTestNG extends AbstractTestNGCucumberTests {
}

