package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\\\Windows\\\\System32\\\\config\\\\systemprofile\\\\eclipse-workspace\\\\LinkedInProject\\\\LinkedIn_Profile\\\\src\\\\test\\\\resource\\\\Feature\\\\LinkedInProfile.feature",
glue="com.stepdefinition")
public class LinkedInRunnerParallelTest extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}

}
