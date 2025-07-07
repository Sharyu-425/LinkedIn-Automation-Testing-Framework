package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		action = new Actions(driver);
	}
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		action.click(element);
	}
	
	public void sendKeys(WebElement element,String value) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
		
	}
	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
