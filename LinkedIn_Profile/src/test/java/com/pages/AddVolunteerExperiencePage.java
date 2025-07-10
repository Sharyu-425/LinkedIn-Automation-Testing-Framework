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
    WebElement organizationField;

    @FindBy(xpath ="//input[@placeholder='Ex: Fundraising Volunteer']")
    WebElement roleField;
    
    @FindBy(xpath ="//option[@value ='Science and Technology']")
    WebElement cause;

    @FindBy(xpath ="//label[text()='I am currently volunteering in this role']")
    WebElement currentlyVol;
    
    @FindBy(xpath ="//select[@name='month']")
    WebElement month;
    
    @FindBy(xpath ="//option[@value='2025']")
    WebElement year;
    
    @FindBy(xpath ="//textarea[@placeholder='Ex: I raised funds for our annual charity 5K.']")
    WebElement descri;
    
    @FindBy(css = ".artdeco-button.artdeco-button--2.artdeco-button--primary.ember-view")
    WebElement saveBtn;
    
    @FindBy(xpath = "//div[@class='artdeco-modal artdeco-modal--layer-default pe-edit-form-page__modal']")
    WebElement updated;

	public AddVolunteerExperiencePage(WebDriver driver) {
		super(driver);
		this.action = new Actions(driver);
	}
	
	public void addValidData(String organization, String role, String description) {
		waitUntilElementIsClickable(organizationField);
		organizationField.sendKeys(organization);
		roleField.sendKeys(role);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		cause.click();
		currentlyVol.click();
		waitUntilElementIsClickable(month);
		Select select = new Select(month);
		select.selectByValue("7");
		month.click();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		year.click();
		descri.sendKeys(description);
		saveBtn.click();
	}
	
	public boolean successfulUpdate() {
    	waitUntilWebElementIsVisible(updated);
    	if(updated.isDisplayed()) {
    		return true;
    	}else {
    		return false;
    	}
    }

}
