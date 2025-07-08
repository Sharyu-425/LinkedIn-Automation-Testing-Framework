package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAboutPage extends BasePage {
    WebDriver driver;
    Actions action;
    
    @FindBy(xpath ="//textarea[@id='gai-text-form-component-profileEditFormElement-SUMMARY-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-summary']")
    WebElement aboutField;

    @FindBy(xpath ="//button[@class='artdeco-button artdeco-button--2 artdeco-button--secondary ember-view typeahead-cta__button']")
    WebElement skillsField;

    @FindBy(xpath ="//input[@placeholder='Skill (ex: Project Management)']")
    WebElement typeSkills;
    
    @FindBy(className ="artdeco-inline-feedback__message")
    WebElement errorMessage;
    
    @FindBy(xpath = "//div[@class='artdeco-modal artdeco-modal--layer-default pe-edit-form-page__modal']")
    WebElement updated;
    

    public AddAboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver); // Initialize Actions with the driver
    }
    
    public void addAboutValid(String about) {
    	waitUntilElementIsClickable(aboutField);
    	
        String aboutText = about;

        // Send text in chunks
        for (String chunk : aboutText.split("\r\n")) {
            aboutField.sendKeys(chunk);
            aboutField.sendKeys(Keys.RETURN);
        }
    }

    public void addAboutInvalid(String about) {
        waitUntilElementIsClickable(aboutField);
        String aboutText = about;
                
        // Send text in chunks
        for (String chunk : aboutText.split("\r\n")) {
            aboutField.sendKeys(chunk);
            aboutField.sendKeys(Keys.RETURN);
        }
    }

    public void addSkills(String skills) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", skillsField);
        skillsField.click();
        typeSkills.click();
        action.sendKeys(skills).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    
    public boolean alert() {
    	if(errorMessage.isDisplayed()) {
    		return true;
    	}else {
    	return false;
    	}
    }
    
    public boolean successfulUpdate() {
    	waitUntilWebElementIsVisible(updated);
    	if(updated.isDisplayed()) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
