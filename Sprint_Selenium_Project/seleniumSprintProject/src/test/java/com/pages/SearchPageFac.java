package com.pages;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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
	@FindBy(xpath="//div[@id=\"search-reusables__filters-bar\"]/descendant::button[text()=\"Jobs\"]")  
	WebElement jobFilter;
	@FindBy(css="p[class=\"t-24 t-black t-normal text-align-center\"]")
	WebElement noResultError;
	@FindAll({
		@FindBy(xpath="//div[@data-view-name=\"job-card\"]/descendant::div[2]/div[2]/div[2]/span")
	})List<WebElement>CompanyName;
	
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
	
	public List<String>getAllJobCompanyNames(){
		List<String> companies = new ArrayList<>();
		for(WebElement company: CompanyName) {
			if(company.isDisplayed()) {
				companies.add(company.getText().trim());
			}
		}
		return companies;
	}

	public void jobIsDisplayed() {
		List<String>companies = getAllJobCompanyNames();
		Assert.assertFalse("No job is Listed",companies.isEmpty());
	}

	public void SearchContainsKeywords(String validKeyword) {
	List<String> companyNames = getAllJobCompanyNames();
		
		for(String name: companyNames) {
			Assert.assertTrue("Search does not contains:"+name,name.toLowerCase().contains(validKeyword.toLowerCase()));
		}
		
	}
}

