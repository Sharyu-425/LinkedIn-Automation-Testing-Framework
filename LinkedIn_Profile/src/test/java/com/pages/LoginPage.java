package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(how=How.ID, using="password")
	WebElement password;
	
    @FindBy(className = "btn__primary--large")
    WebElement logbtn;
    
    @FindBy(className = "nav__button-secondary")
    WebElement signin;
    
    
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeData() {
		username.sendKeys("shravnishinde1308@gmail.com");
		password.sendKeys("Password@1302");
	}
	public void signinbtn() {
		signin.click();
	}
	
	public void clickbtn(){
		logbtn.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
