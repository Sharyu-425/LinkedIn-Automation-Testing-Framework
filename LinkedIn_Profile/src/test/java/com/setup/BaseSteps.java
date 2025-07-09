package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	
	public static WebDriver driver;
	public static ChromeOptions coptions;
	public static EdgeOptions eoptions;
	
	public static WebDriver chromedriver() {
		WebDriverManager.chromedriver().setup();
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maxmized");
	//	coptions.addArguments("Incognite");
		coptions.addArguments("disable-notifications");
		
		driver = new ChromeDriver(coptions);
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static WebDriver edgedriver() {
		WebDriverManager.edgedriver().setup();
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maxmized");
	//	eoptions.addArguments("Incognite");
		eoptions.addArguments("disable-notifications");
		
		driver = new EdgeDriver(eoptions);
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public void tearDown() {
		driver.close();
	}

}
