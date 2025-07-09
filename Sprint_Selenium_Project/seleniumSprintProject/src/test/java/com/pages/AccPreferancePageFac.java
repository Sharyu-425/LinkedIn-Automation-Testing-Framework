package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccPreferancePageFac extends BasePage {
	public AccPreferancePageFac(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class=\"artdeco-list category-list--new\"]/child::li[2]/child::ul")
	WebElement darkmodeBtn;
	@FindBy(xpath="//label[text()=\"Always on\"]")
	WebElement alwaysOnRadio;
	@FindBy(xpath="//label[text()=\"Always off\"]")
	WebElement alwaysOffRadio;
	@FindBy(xpath="//div[@data-test-checked-radio-button]")
	WebElement selectedRadio;
	
	
	public void goToDarkModeSetting() {
		click(darkmodeBtn);
	}
	
	public void toggleDarkMode() {
		if(alwaysOnRadio.isSelected()) {
			click(alwaysOffRadio);
		}else {
			click(alwaysOnRadio);
		}
	}
	
	public void isModeChanged() {
		Assert.assertNotNull("No radio button is selected",selectedRadio );
	}
	
	
	

}
