package com.stepDefinition;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pages.BasePage;
import com.pages.LoginPageFac;
import com.parameters.ConfigReader;
import com.parameters.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.setup.BaseSteps;
import com.utility.ExtentManager;
import com.utility.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	BaseSteps baseSteps;
	ExcelReader reader;
	ExtentReports report;
	ExtentTest test;
	
	
	
	@Before
	public void launchBrowserAndLogin(Scenario scenario) {
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
			
			//start extent report
			report = ExtentManager.getInstance();
			test= report.startTest(scenario.getName());
			
		}catch(Exception e) {
			System.out.print("Error in hooks during login"+e.getMessage());
		}
		
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
//		if(scenario.isFailed()) {
//			//take screenshot when failed
//		String scenarioName = scenario.getName().replaceAll(" ","_");
//		//
//		BasePage basePage = new BasePage(BaseSteps.driver);
//		basePage.takeScreenshot(scenarioName+"_FAILED!");
//		}
		
		String screenshotPath = ScreenshotUtil.captureScreenshot(BaseSteps.driver,scenario.getName());
		String image = test.addScreenCapture(screenshotPath);
		
		if(scenario.isFailed()) {
			test.log(LogStatus.FAIL,"Scenario Failed", image);
		}else {
			test.log(LogStatus.PASS,"Scenario Passed", image);
		}
		
		scenario.attach(((TakesScreenshot)BaseSteps.driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
		
		//finalize extent report
		report.endTest(test);
		report.flush();
		
		
		if(BaseSteps.driver!=null) {
			BaseSteps.driver.quit();
		}
	}
}
