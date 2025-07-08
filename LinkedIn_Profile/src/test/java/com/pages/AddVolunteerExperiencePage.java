package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddVolunteerExperiencePage extends BasePage{
	WebDriver driver;
	Actions action;
	
	@FindBy(xpath ="//input[@placeholder='Ex: Red Cross']")
    WebElement organization;

    @FindBy(xpath ="//input[@placeholder='Ex: Fundraising Volunteer']")
    WebElement role;
    
    @FindBy(xpath ="//option[@value ='Science and Technology']")
    WebElement cause;

    @FindBy(xpath ="//label[text()='I am currently volunteering in this role']")
    WebElement currentlyVol;
    
    @FindBy(xpath ="//select[@name='month']")
    WebElement month;
    
//    @FindBy(xpath ="//option[@value='7']")
//    WebElement month;
    
    @FindBy(xpath ="//option[@value='2025']")
    WebElement year;
    
    @FindBy(xpath ="//textarea[@placeholder='Ex: I raised funds for our annual charity 5K.']")
    WebElement descri;
    
    @FindBy(css = ".artdeco-button.artdeco-button--2.artdeco-button--primary.ember-view")
    WebElement saveBtn;


	public AddVolunteerExperiencePage(WebDriver driver) {
		super(driver);
		this.action = new Actions(driver);
	}
	
	public void addValidData() {
		waitUntilElementIsClickable(organization);
		organization.sendKeys("Tata Consultancy Services");
		role.sendKeys("Pragati: Path to Future");
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		cause.click();
		currentlyVol.click();
//		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		waitUntilElementIsClickable(month);
		Select select = new Select(month);
		select.selectByValue("7");
		month.click();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		year.click();
		descri.sendKeys("Volunteered in TCS program 'Pragati: Path to Future'.");
		saveBtn.click();
	}

}
