package com.stepDefinition;

import java.util.Map;

import com.pages.BasePage;
import com.pages.LoginPageFac;
import com.parameters.ConfigReader;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	BaseSteps baseSteps;
	ExcelReader reader;
	
	
	@Before
	public void launchBrowserAndLogin() {
		baseSteps=new BaseSteps();
		baseSteps.setup(ConfigReader.getProperty("browser"));
		
		try {
			//initialize Excel reader and read credentials
			reader =new ExcelReader("src\\test\\resources\\ExcelData\\RequiredData.xlsx");

			//Perfrom login using Excel credentials
			Map<String,String>loginData = reader.getRowData("LoginData", 1);
			String username = loginData.get("Username");
			String password = loginData.get("Password");			
			LoginPageFac loginPageFac = new LoginPageFac(BaseSteps.driver);
			loginPageFac.login(username, password);
			
		}catch(Exception e) {
			System.out.print("Error in hooks during login"+e.getMessage());
		}
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot when failed
		String scenarioName = scenario.getName().replaceAll(" ","_");
		//
		BasePage basePage = new BasePage(BaseSteps.driver);
		basePage.takeScreenshot(scenarioName+"_FAILED!");
		}
		if(BaseSteps.driver!=null) {
			BaseSteps.driver.quit();
		}
	}
}
