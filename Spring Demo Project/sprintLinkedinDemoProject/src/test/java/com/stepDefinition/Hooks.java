package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseSteps {
	
	WebDriver driver;
	LoginPage login;
	
	@Before
	public void setupAndLogin() throws InterruptedException {
		loadProperties("src\\test\\resources\\PropertieFiles\\linkedin.properties");
		initializeDriver();
		driver=getDriver();
		driver.get(prop.getProperty("url"));
		login=new LoginPage(driver);
		String uername= ExcelReader.getCellValue("Sheet1", 1, 0);
		String password=ExcelReader.getCellValue("Sheet1", 1, 1);
		login.loginToLinkedIn(uername, password);
		Thread.sleep(20000);
		
		
	}
	@After
	public void tearDown() {
		//quitDriver();
	}

}
