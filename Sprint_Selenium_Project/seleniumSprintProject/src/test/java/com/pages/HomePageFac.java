package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFac extends BasePage{
	
	@FindBy(xpath="// div[@class=\"share-box-feed-entry__top-bar\"]/child::button")
	WebElement createPostBtn;
	@FindBy(css="div[class=\"ql-editor ql-blank\"]")
	WebElement postField;
	@FindBy(xpath="//div[@class=\"share-box_actions\"]/child::button")
	WebElement postBtn;
	@FindBy(xpath="//span[text()=\"Post successful.\"]")
	WebElement postSuccessPopup;
	@FindBy(linkText="View post")
	WebElement viewPostBtn;
	@FindBy(xpath="//span[text()=\"It appears that this post has already been shared. Please edit your draft.\"]")
	WebElement duplicatePostErr;
	@FindBy(xpath="//nav[@class=\"global-nav__nav\"]/descendant::li[6]")
	WebElement profileDropdown;
	@FindBy(linkText="Settings & Privacy")
	WebElement settingBtn;
	
	
	
	public HomePageFac(WebDriver driver) {
		super(driver);
	}
	
//----------------------------------------------------------------------------------------------------
	public void clickCreatePost() {
		click(createPostBtn);
	}
	
	public void createPost() {
		sendKeys(postField,"Just checking how things look when I post an update here."
				+ " Hoping this message reaches my network smoothly.");
		click(postBtn);
	}
	public void isPosted() {
		assertElementText(postSuccessPopup,"Post successful.","Error is Posting your Post");
		click(viewPostBtn);
	}
//------------------------------------------------------------------------------------------------------
	public void isDuplicateErrorDisplayed() {
		assertElementText(duplicatePostErr,"It appears that this post has already been shared. Please edit your draft.","Duplicate Error was not displayed");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	public void goToSettings() {
		click(profileDropdown);
		click(settingBtn);	
	}
	
//-------------------------------------------------------------------------------------------------------
	

	
	
	
	
	
	

}
