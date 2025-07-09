package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIntroPage extends BasePage{
	WebDriver driver;
	
	@FindBy(css = "#single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-firstName")
	WebElement firstnameField;
	
	@FindBy(css = "#single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-lastName")
	WebElement lastnameField;
	
    @FindBy(xpath ="//button[@data-view-name='profile-form-save']")
    WebElement savebtn;
    
    @FindBy(xpath ="//div[@class='artdeco-inline-feedback artdeco-inline-feedback--error ember-view mt1']")
    WebElement errorMessage;
    
	public EditIntroPage(WebDriver driver) {
		super(driver);
	}

	public void LogInvalidData(String firstName, String lastName) {
		waitUntilElementIsClickable(firstnameField);
		waitUntilElementIsClickable(lastnameField);
		firstnameField.clear();
		firstnameField.sendKeys(firstName);
		lastnameField.clear();
		lastnameField.sendKeys(lastName);
	}
	
	public void LogValidData(String firstName, String lastName) {
		waitUntilElementIsClickable(firstnameField);
		waitUntilElementIsClickable(lastnameField);
		firstnameField.clear();
		firstnameField.sendKeys(firstName);
		lastnameField.clear();
		lastnameField.sendKeys(lastName);
	}
	
	public void save() {
		savebtn.click();
	}
	
	public boolean alert() {
    	if(errorMessage.isDisplayed()) {
    		return true;
    	}else {
    	return false;
    	}
    }
    
}
