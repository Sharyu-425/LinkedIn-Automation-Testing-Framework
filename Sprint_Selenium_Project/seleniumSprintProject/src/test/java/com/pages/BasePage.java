package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public Robot robot;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		action = new Actions(driver);
	}
	//---------------waits----------------
	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
//----------------------------------------------------------
	
	//---------actions-------------
	public void click(WebElement element) {
		try {
		waitForClickable(element);
		element.click();
		}catch(Exception e){
			//if above not working then try this
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
		}
	}
	public void sendKeys(WebElement element,String value) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
	}
	//-------------------------------------------
	
	//-----------------------------------------------robot-------------------------------------------------
	
	public void robotClick(int x, int y) {
		try {
		robot= new Robot();
		robot.mouseMove(x, y);
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}catch(AWTException | InterruptedException e) {
			e.printStackTrace();
		}	
	}
	//----------------------------------------------------------------------------------------------------
	
	
	//----------------------------------------Screenshot------------------------------------------------
	
	public void takeScreenshot(String filename) {
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		String finalFileName = "src\\test\\java\\screenshots\\"+ filename + "_" + timeStamp+ ".png";
		try {
			FileUtils.copyFile(src, new File(finalFileName));
			System.out.println("Screenshot saved:"+finalFileName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
//-------------------------------------------------------------------------------------------------------
//asserts
	public void assertElementIsDisplayed(WebElement element,String message) {
		waitForElement(element);
		Assert.assertTrue(message,element.isDisplayed());
	}
	public void assertElementIsEnabled(WebElement element,String message) {
		waitForClickable(element);
		Assert.assertTrue(message,element.isEnabled());
	}
	public void assertElementText(WebElement element, String expectedText, String message) {
		waitForElement(element);
		Assert.assertTrue(message,expectedText.equalsIgnoreCase(element.getText()));
	}
	public void assertURL(String keyword,String message) {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(message,driver.getCurrentUrl().contains(keyword));
	}
	

}
