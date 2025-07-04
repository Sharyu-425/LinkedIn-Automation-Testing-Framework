package com.stepDefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pages.AddAboutPage;
import com.pages.EditIntroPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProfilePage;
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
	
//	@When("user clicks on edit intro icon")
//	public void user_clicks_on_edit_intro_icon() {
//		pro = new ProfilePage(driver);
//		pro.editintro();
//	}
//	@When("user enters invalid fields")
//	public void user_enters_invalid_fields() {
//		intro.LogInvalidData();
//	}
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		intro = new EditIntroPage(driver);
	    intro.save();
	}
//	@Then("it should give error message")
//	public void it_should_give_error_message() {
//	    Assert.assertTrue(driver.getCurrentUrl().equals("https://www.linkedin.com/in/shrawni-shinde-615a4725a/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION"));;
//	}
//	@When("user enters valid fields")
//	public void user_enters_valid_fields() {
//		intro = new EditIntroPage(driver);
//	    intro.LogValidData();
//	}
	@Then("it should navigate us to profile page")
	public void it_should_navigate_us_to_profile_page() {
		Assert.assertTrue(about.alert());
	    
	}
	
	@When("user clicks on add profile section button")
	public void user_clicks_on_add_profile_section_button() throws AWTException {
		pro = new ProfilePage(driver);
	    pro.addProfile();
	}
	@When("user clicks on add about button")
	public void user_clicks_on_add_about_button() {
		pro = new ProfilePage(driver);
		pro.addAbout();
	}
	@When("user enters valid data in about field")
	public void user_enters_valid_data_in_about_field() {
		about = new AddAboutPage(driver);
		
		about.addAbout();
//	    about.addSkills();
	}

}
