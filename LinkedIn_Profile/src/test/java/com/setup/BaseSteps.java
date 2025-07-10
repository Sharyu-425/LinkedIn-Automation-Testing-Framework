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
		WebDriverManager.chromedriver().setup(); // Auto-setup ChromeDriver
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");
	//	coptions.addArguments("Incognite");
		coptions.addArguments("disable-notifications");
		
		driver = new ChromeDriver(coptions); // Launch Chrome with options
		driver.get("https://www.linkedin.com");
		driver.manage().window().maximize(); // Ensure window is maximized 
		return driver;
	}
	
	public static WebDriver edgedriver() {
		WebDriverManager.edgedriver().setup(); // Auto-setup EdgeDriver
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maximized");
	//	eoptions.addArguments("Incognite");
		eoptions.addArguments("disable-notifications");
		
		driver = new EdgeDriver(eoptions); // Launch Edge with options
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize(); // Ensure window is maximized 
		return driver;
		
	}
	
	public void tearDown() {
		driver.close();
	}

}
