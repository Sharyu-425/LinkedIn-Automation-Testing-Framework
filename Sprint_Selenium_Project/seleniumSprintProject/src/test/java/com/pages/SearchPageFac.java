package com.pages;



import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SearchPageFac extends BasePage {
	
	
	public SearchPageFac(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	WebElement searchBar;
	@FindBy(xpath="//h2[text()=\"On this page\"]")
	WebElement searchPageValidator;
	@FindBy (linkText="Capgemini")
	WebElement Profile;
	@FindBy(xpath="//div[@class=\"wIsRjMHLuluBexAtOEJvVQIAYPvoGkaQ\"]/child::*[2]/child::div[1]")
	WebElement jobFilter;
	@FindBy(xpath="p[class=\"t-24 t-black t-normal text-align-center\"]")
	WebElement noResultError;
	
	public void searchForProfile(String keyword) {
		searchBar.clear();
		sendKeys(searchBar,keyword);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public void isSearchResultDisplayed() {
		waitForElement(searchPageValidator);
		Assert.assertTrue("Search is Displayed",searchPageValidator.isDisplayed());
	}
	public void profileClick() {
		Profile.click();
	}
	
	public void applyFilter(){
		jobFilter.click();	
	}
	public void errorDisplayed() {
		assertElementText(noResultError,"No matching jobs found.","Invalid search Error is not Displayed");
	}
}

