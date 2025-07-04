package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
	
	WebDriver driver;
	Actions action;
	Robot robot;

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
    	robot = new Robot();
//    	waitUntilElementIsClickable(addProfileSection);
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addProfileSection);
//    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    	wait.until(ExpectedConditions.elementToBeClickable(addProfileSection));
    	JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("location.reload()");
		js.executeScript("window.scrollBy(0,100)");
		robot.mouseMove(360, 315);
		robot.delay(1000);
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
