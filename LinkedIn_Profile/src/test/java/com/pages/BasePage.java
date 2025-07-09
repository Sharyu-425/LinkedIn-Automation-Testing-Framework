package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}		
	
	public void waitUntilWebElementIsVisible(WebElement element) {
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementIsClickable(WebElement element) {
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
