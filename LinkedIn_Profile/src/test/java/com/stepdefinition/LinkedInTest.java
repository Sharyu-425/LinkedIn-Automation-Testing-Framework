package com.stepdefinition;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.AddAboutPage;
import com.pages.EditIntroPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProfilePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedInTest {
	WebDriver driver;
	HomePage hom;
	LoginPage log;
	ProfilePage pro;
	EditIntroPage intro;
	ExcelReader excel;
	AddAboutPage about;
	
	@Given("user is logged in")
	public void user_is_logged_in() {
		driver=BaseSteps.edgedriver();
		log = new LoginPage(driver);
		log.signinbtn();
	    log.typeData();
	    log.clickbtn();  
	}
	@When("user clicks on profile")
	public void user_clicks_on_profile() {
		hom = new HomePage(driver);
		hom.clickbtn();
	}
	@When("user clicks on edit intro icon")
	public void user_clicks_on_edit_intro_icon() {
		pro = new ProfilePage(driver);
		pro.editIntro();
	}
	@When("user enters invalid {string} and {string} fields")
	public void user_enters_invalid_and_fields(String firstName, String lastName) {
		intro = new EditIntroPage(driver);
    	excel=new ExcelReader();
		String[] data=excel.provideIntroData(firstName, lastName);
		intro.LogInvalidData(data[0], data[1]);
	}
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		intro = new EditIntroPage(driver);
	    intro.save();
	}
	@Then("it should give error message")
	public void it_should_give_error_message() {
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://www.linkedin.com/in/shrawni-shinde-615a4725a/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION"));
	}
	@When("user enters valid {string} and {string} fields")
	public void user_enters_valid_and_fields(String firstName, String lastName) {
		intro = new EditIntroPage(driver);
    	excel=new ExcelReader();
		String[] data=excel.provideIntroData(firstName, lastName);
		intro.LogInvalidData(data[0], data[1]);
	}
	@Then("it should navigate us to profile page")
	public void it_should_navigate_us_to_profile_page() {
		Assert.assertTrue(about.successfulUpdate());
	}
	@When("user clicks on add profile section button")
	public void user_clicks_on_add_profile_section_button() throws AWTException {
		pro = new ProfilePage(driver);
	    pro.addProfile();
	}
	@When("user clicks on add about button")
	public void user_clicks_on_add_about_button() {
		pro.addAbout();
	}
	@When("user enters valid data in about field using datatable")
	public void user_enters_valid_data_in_about_field_using_datatable(io.cucumber.datatable.DataTable dataTable) {

		about = new AddAboutPage(driver);
		excel = new ExcelReader();
				
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		String aboutCoords = data.get("about");
		String skillsCoords = data.get("skills");
		
		
		String[] details = excel.provideAbout(aboutCoords, skillsCoords);
		about.addAboutValid(details[0]);
		about.addSkills(details[1]);
	}


}
