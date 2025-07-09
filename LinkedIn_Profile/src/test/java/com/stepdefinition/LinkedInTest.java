package com.stepdefinition;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pages.AddAboutPage;
import com.pages.AddProjectPage;
import com.pages.AddVolunteerExperiencePage;
import com.pages.EditIntroPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProfilePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
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
	AddProjectPage project;
	AddVolunteerExperiencePage vol;
	
	//=========================  Background = Login  ======================================================
	
	@Given("user is logged in")
	public void user_is_logged_in() {
		driver=BaseSteps.edgedriver();
		log = new LoginPage(driver);
		log.signinbtn();
	    log.typeData();
	    log.clickbtn();  
	}
	
	//=========================  InvalidIntroData  ======================================================
	
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
	    Assert.assertTrue(intro.alert());
	}
	
	//=========================  ValidIntroData  ======================================================
	
	@When("user enters valid {string} and {string} fields")
	public void user_enters_valid_and_fields(String firstName, String lastName) {
		intro = new EditIntroPage(driver);
    	excel=new ExcelReader();
		String[] data=excel.provideIntroData(firstName, lastName);
		intro.LogInvalidData(data[0], data[1]);
	}
	@Then("it should navigate us to profile page")
	public void it_should_navigate_us_to_profile_page() {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.linkedin.com/in/shrawni-shinde-615a4725a/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION"));
	}
	
	//=========================  ValidAboutSection  ======================================================
	
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
	    List<String> list=dataTable.asList(String.class);
	    String data[]=excel.provideAbout(list.get(0));
	    about.addAboutValid(data[0]);
	    about.addSkills(data[1]);
	}
	@Then("about section is updated")
	public void about_section_is_updated() {
		Assert.assertTrue(about.successfulUpdate());
	}
	
	//=========================  InvalidAboutSection  ======================================================
	
	@When("user enters invalid data in about field using datatable")
	public void user_enters_invalid_data_in_about_field_using_datatable(io.cucumber.datatable.DataTable dataTable) {
		about = new AddAboutPage(driver);
		excel = new ExcelReader();
	    List<String> list=dataTable.asList(String.class);
	    String data[]=excel.provideAbout(list.get(0));
	    about.addAboutInvalid(data[2]);
	    about.addSkills(data[3]);
	}
	@Then("it should display an error message")
	public void it_should_display_an_error_message() {
		Assert.assertTrue(about.alert());

	}
	
	//=========================  ProjectSection  ======================================================
	
	@When("user clicks on recommended dropdown")
	public void user_clicks_on_recommended_dropdown() {
		pro = new ProfilePage(driver);
		pro.recommendedDropdown();
	}
	@When("user clicks on add projects button")
	public void user_clicks_on_add_projects_button() {
		pro.addProjects();
	}
	@When("user enters valid data in required fields using datatable")
	public void user_enters_valid_data_in_required_fields_using_datatable(io.cucumber.datatable.DataTable dataTable) {
		project = new AddProjectPage(driver);
		excel = new ExcelReader();
	    List<String> list=dataTable.asList(String.class);
	    String data[]=excel.getProjectDetails(list.get(0));
	    project.addValidDetails(data[0], data[1], data[2], data[3], data[4], data[5]);
	}
	
	@Then("a new project is added in users profile")
	public void a_new_project_is_added_in_users_profile() {
		Assert.assertFalse(driver.getCurrentUrl().equals("https://www.linkedin.com/in/shrawni-shinde-615a4725a/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION"));
	}

	//=========================  VolunteerExperience  ======================================================
	
	@When("user clicks on additional dropdown")
	public void user_clicks_on_additional_dropdown() {
		pro = new ProfilePage(driver);
		pro.additionalDropdown();
	}
	@When("user clicks on add volunteer experience button")
	public void user_clicks_on_add_volunteer_experience_button() {
		pro.addVolunteerExperience();
	}
	@When("user enters valid data in fields using datatable")
	public void user_enters_valid_data_in_fields_using_datatable(io.cucumber.datatable.DataTable dataTable) {
		vol = new AddVolunteerExperiencePage(driver);
		excel = new ExcelReader();
	    List<String> list=dataTable.asList(String.class);
	    String data[]=excel.getVolunteerExperienceDetails(list.get(0));
	    vol.addValidData(data[0], data[1], data[2]);
	}
	@Then("a new volunteer experience is added in users profile")
	public void a_new_volunteer_experience_is_added_in_users_profile() {
		Assert.assertFalse(driver.getCurrentUrl().equals("https://www.linkedin.com/in/shrawni-shinde-615a4725a/edit/forms/intro/new/?profileFormEntryPoint=PROFILE_SECTION"));

	}
	
	////----------------------------------------------------------------------------------------/////
	@After
	public void tearDown(Scenario scenario) // will take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", "Image");
	}
}
