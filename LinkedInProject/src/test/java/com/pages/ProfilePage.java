package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
	WebDriver driver;
	Actions action;
	

    @FindBy(css = "button[aria-label='Edit intro']")
    WebElement editIntroButton;
    
    @FindBy(css = ".artdeco-button.artdeco-button--2.artdeco-button--secondary.ember-view.m0.mr2")
    WebElement addProfileSection;

    @FindBy(css =".wsMvqdsCQwHMdXuvCLlSAkmVYButhGSUc.link-without-hover-state")
    WebElement addAboutSection;
    
//    @FindBy(className = "nav__button-secondary")
//    WebElement signin;
   
	public ProfilePage(WebDriver driver) {
		super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
	}
	

    public void editIntro() {
    	waitUntilElementIsClickable(editIntroButton);
    	editIntroButton.click();
    }
    
    public void addProfile() throws AWTException {
    	JavascriptExecutor js =(JavascriptExecutor) driver;
//    	waitUntilElementIsClickable(addProfileSection);
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addProfileSection);
//    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    	wait.until(ExpectedConditions.elementToBeClickable(addProfileSection));
//		js.executeScript("location.reload()");
    	
		js.executeScript("window.scrollBy(0,100)");
//		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//		wait.until(ExpectedConditions.visibilityOf(addProfileSection));
		Robot robot = new Robot();
		robot.mouseMove(250, 530);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
    }
    
//    public void addProfile() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(addProfileSection));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addProfileSection);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addProfileSection);
//        } catch (Exception e) {
//            System.out.println("Element not interactable: " + e.getMessage());
//        }
//    }
    


    
    public void addAbout() {
    	waitUntilElementIsClickable(addAboutSection);
    	addAboutSection.click();
    }

	
}
