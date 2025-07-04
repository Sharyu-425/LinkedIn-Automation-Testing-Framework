package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagingPage {
 WebDriver driver;

	
	@FindBy(xpath="//a[contains(@href,'/messaging')]")
	WebElement messagingIcon;
	
	@FindBy(xpath="//div[contains(@class,'msg-conversations-container')]")
	WebElement messagingWindow;
	
	
	
	public MessagingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public boolean isMessagingIconVisible() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(messagingIcon));
		return messagingIcon.isDisplayed();
	}
	public void clickMessagingIcon() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(messagingIcon)).click();
		wait.until(ExpectedConditions.visibilityOf(messagingWindow));
	}
	public boolean isMessagingWindowVisible() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(messagingIcon));
		return messagingWindow.isDisplayed();
}
}
