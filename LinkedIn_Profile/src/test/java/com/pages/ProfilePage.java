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
	JavascriptExecutor js;
	
    @FindBy(css = "button[aria-label='Edit intro']")
    WebElement editIntroButton;
    
    @FindBy(css = ".artdeco-button.artdeco-button--2.artdeco-button--secondary.ember-view.m0.mr2")
    WebElement addProfileSection;

    @FindBy(css =".wsMvqdsCQwHMdXuvCLlSAkmVYButhGSUc.link-without-hover-state")
    WebElement addAboutSection;
    
    @FindBy(css =".pv-goals__section-button")
    WebElement coreDropdown;
    
    @FindBy(xpath = "//span[text()='Add projects']")
    WebElement addProjectsSection;
   
    @FindBy(xpath = "//h3[contains(@class,'truncate text-body-small')]")
    WebElement openToWork;
    
	public ProfilePage(WebDriver driver) {
		super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
        this.js =(JavascriptExecutor) driver;
	}
	
    public void editIntro() {
    	waitUntilElementIsClickable(editIntroButton);
    	editIntroButton.click();
    }
    
    public void addProfile() {
		js.executeScript("window.scrollBy(0,100)");
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(250, 530);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
    
    public void addAbout() {
    	Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(410, 465);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//    	waitUntilElementIsClickable(addAboutSection);
//    	addAboutSection.click();
    }
    
    public void recommendedDropdown() {
    	coreDropdown.click();
    	action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recommendedDropdown);
//        recommendedDropdown.click();	
    }
    
    public void addProjects() {
    	action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
//        addProjectsSection.click();
    }
    
    public void additionalDropdown() {
    	coreDropdown.click();
    	action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
    }

	public void addVolunteerExperience() {
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void openToWork() {
		js.executeScript("window.scrollBy(0,200)");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", openToWork);
//		Robot robot;
//		try {
//			robot = new Robot();
//			robot.mouseMove(250, 600);
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		openToWork.click();
		
	}
}
