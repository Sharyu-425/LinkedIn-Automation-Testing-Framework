package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFac extends BasePage {
	@FindBy(id="username")
	WebElement userField;
	@FindBy(id="password")
	WebElement passField;
	@FindBy(css ="button[class=\"btn__primary--large from__button--floating\"]")
	WebElement loginBtn;
//	@FindBy(css="button[class=\"sc-nkuzb1-0 sc-d5trka-0 eZxMRy button\"]")
//	WebElement startPuzzleBtn;

	
	public LoginPageFac(WebDriver driver) {
		super(driver);	
	}

	public void login(String username, String password) throws InterruptedException{
		sendKeys(userField,username);
		sendKeys(passField,password);
		loginBtn.click();
//		waitForElement(startPuzzleBtn);
//		startPuzzleBtn.click();
		
		Thread.sleep(10000);
	}
	public void isHomepage() {
		assertURL("feed","Feed page not displayed after login");
	}
	

}
