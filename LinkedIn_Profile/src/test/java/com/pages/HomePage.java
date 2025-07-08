package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;

   @FindBy(css = ".profile-card-name.text-heading-large")
   WebElement profilebtn;

	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickbtn() {
		waitUntilElementIsClickable(profilebtn);
		profilebtn.click();
		
		
	}
}
