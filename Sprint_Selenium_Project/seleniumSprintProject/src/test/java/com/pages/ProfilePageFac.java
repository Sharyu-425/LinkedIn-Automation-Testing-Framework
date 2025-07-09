package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageFac extends BasePage {
	
	@FindBy(xpath="//div[@class=\"org-top-card-primary-actions__inner\"]/button/span")
	WebElement followOrUnfollowBtn;
	@FindBy(xpath="//span[text()=\"Following\"]")
	WebElement followingBtn;
	@FindBy(xpath="//span[text()=\"Unfollow\"]")
	WebElement unfollowBtn;
	

	
	public ProfilePageFac(WebDriver driver) {
		super(driver);
	}
	
	public void clickFollow() {
		if(followOrUnfollowBtn.getText().equalsIgnoreCase("follow")) {
			click(followOrUnfollowBtn);
		}else if(followOrUnfollowBtn.getText().equalsIgnoreCase("following")) {
			click(followOrUnfollowBtn);
			click(unfollowBtn);
		}
			
	}
	
	public void isFollowingOrFollow() {
		if(followOrUnfollowBtn.getText().equalsIgnoreCase("follow")) {
		assertElementIsDisplayed(followOrUnfollowBtn,"Unfollow Done");
		}
		else if(followOrUnfollowBtn.getText().equalsIgnoreCase("following")) {
			assertElementIsDisplayed(followOrUnfollowBtn,"Follow Done");
		}
		
	}
	
	

}
