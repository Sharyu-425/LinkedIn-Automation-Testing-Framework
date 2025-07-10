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
	@FindBy(xpath="//button[text()=\"Start Puzzle\"]")
	WebElement startPuzzleBtn;
	
//--------------frames for start puzzle------------------------
	@FindBy(xpath="//iframe[@id=\"captcha-internal\"]")
	WebElement iframe_0;
	@FindBy(xpath="//iframe[@id=\"arkoseframe\"]")
	WebElement iframe_1;
	@FindBy(xpath="//iframe[@title=\"Verification challenge\"]")
	WebElement iframe_2;
	@FindBy(xpath="//iframe[@id=\"game-core-frame\"]")
	WebElement iframe_3;
//--------------------------------------------------------------


	
	public LoginPageFac(WebDriver driver) {
		super(driver);	
	}

	public void login(String username, String password) throws InterruptedException{
		sendKeys(userField,username);
		sendKeys(passField,password);
		loginBtn.click();
		driver.switchTo().frame(iframe_0);
		driver.switchTo().frame(iframe_1);
		driver.switchTo().frame(iframe_2);
		driver.switchTo().frame(iframe_3);
		click(startPuzzleBtn);
		driver.switchTo().defaultContent();
		Thread.sleep(13000);
		
	}
	public void isHomepage() {
		assertURL("feed","Feed page not displayed after login");
	}
	

}
