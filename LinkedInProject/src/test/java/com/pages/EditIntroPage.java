package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIntroPage extends BasePage{
	
	WebDriver driver;
	
	@FindBy(css = "#single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-firstName")
	WebElement firstname;
	
	@FindBy(css = "#single-line-text-form-component-profileEditFormElement-TOP-CARD-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-lastName")
	WebElement lastname;
	
    @FindBy(xpath ="//button[@data-view-name='profile-form-save']")
    WebElement savebtn;
    
	public EditIntroPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void LogInvalidData() {
		waitUntilElementIsClickable(firstname);
		waitUntilElementIsClickable(lastname);
		firstname.clear();
		firstname.sendKeys("1@345#");
		lastname.clear();
		lastname.sendKeys("42@456");
	}
	
	public void LogValidData() {
		waitUntilElementIsClickable(firstname);
		waitUntilElementIsClickable(lastname);
		firstname.clear();
		firstname.sendKeys("Shrawni");
		lastname.clear();
		lastname.sendKeys("Shinde");
	}
	
	
	public void save() {
		savebtn.click();
	}

}
