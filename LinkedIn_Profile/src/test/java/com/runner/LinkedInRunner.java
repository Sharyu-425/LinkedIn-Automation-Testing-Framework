package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Feature\\LinkedInProfile.feature",
tags="@VolExp",
glue="com.stepdefinition",
plugin = {"pretty", "html:target/cucumber-reports.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class LinkedInRunner {
}

