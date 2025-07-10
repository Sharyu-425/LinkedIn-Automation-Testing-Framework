package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.parameters.PropertyFileReader;

public class LoginPage extends BasePage{
	
	PropertyFileReader fileReader;
	 
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
		fileReader=new PropertyFileReader("C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInProject\\LinkedIn_Profile\\src\\test\\resource\\PropertiesFiles\\data.properties");
		 
	}
	
	public void typeData() {
		username.sendKeys((fileReader.getProperty("username")));
		password.sendKeys((fileReader.getProperty("password")));
	}
	public void signinbtn() {
		signin.click();
	}
	
	public void clickbtn(){
		logbtn.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
