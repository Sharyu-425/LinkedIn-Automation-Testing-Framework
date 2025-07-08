package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageFac extends BasePage {
	
	@FindBy(css="button[aria-label=\"Follow\"]")
	WebElement followBtn;
	@FindBy(xpath="//span[text()=\"Following\"]")
	WebElement followingBtn;

	
	public ProfilePageFac(WebDriver driver) {
		super(driver);
	}
	
	public void clickFollow() {
		followBtn.click();		
	}
	
	public void isFollowing() {
		assertElementIsDisplayed(followingBtn,"Follow Unseccessful");
	}
	
	

}
