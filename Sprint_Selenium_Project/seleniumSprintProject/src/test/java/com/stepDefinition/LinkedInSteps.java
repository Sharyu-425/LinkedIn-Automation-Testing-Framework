package com.stepDefinition;

import java.util.Map;

import com.pages.AccPreferancePageFac;
import com.pages.HomePageFac;
import com.pages.LoginPageFac;
import com.pages.ProfilePageFac;
import com.pages.SearchPageFac;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedInSteps {
	SearchPageFac searchPageFac ;
	ExcelReader reader;
	ProfilePageFac profilePageFac;
	HomePageFac homePageFac;
	AccPreferancePageFac accPreferancePageFac;
	//--------------------------------------BACKGROUND-----------------------------
	@Given("User launches the browser")
	public void user_launches_the_browser() {
		System.out.print("Browser is Launched");

	}
	@When("User logs into LinkedIn with valid credentials")
	public void user_logs_into_linked_in_with_valid_credentials() {
		
		System.out.println("Login is handled by hooks with Excel-driven data");

	}
	@Then("User is navigated to the Homepage")
	public void user_is_navigated_to_the_homepage() {
		
		LoginPageFac loginPageFac = new LoginPageFac(BaseSteps.driver);
		loginPageFac.isHomepage();
	}

//-------------------------------------@TS_LinkedIn_01-----------------------------------------------
	@When("User enters a valid keyword in the seach bar and presses Enter")
	public void user_enters_a_valid_keyword_in_the_seach_bar_and_presses_enter() {
		
		//will have to re-initialize it because cucumber creates new object of stepDefination for each scenario
		 reader = new ExcelReader("src\\test\\resources\\ExcelData\\RequiredData.xlsx");
		Map<String,String>validSearchData=reader.getRowData("Valid_Search", 1);
		String validKeyword = validSearchData.get("SearchKeyword");

		searchPageFac = new SearchPageFac(BaseSteps.driver);
		searchPageFac.searchForProfile(validKeyword);
		
	}
	@When("User clicks on the first profile result")
	public void user_clicks_on_the_first_profile_result() {
		searchPageFac.profileClick();
	}
	@When("User follows the selected profile")
	public void user_follows_the_selected_profile() {
		profilePageFac = new ProfilePageFac(BaseSteps.driver);
		profilePageFac.clickFollow();		
		
	}
	@Then("User should see the profile as followed")
	public void user_should_see_the_profile_as_followed() {
		profilePageFac.isFollowing();
	}

//------------------------------------------------------------------------------------------
//--------------------------------------TS_LinekdIn_02-------------------------------------------
	
	@When("User performs profile search with an invalid keyword")
	public void user_performs_profile_search_with_an_invalid_keyword() throws InterruptedException {
		reader = new ExcelReader("src\\test\\resources\\ExcelData\\RequiredData.xlsx");
		Map<String,String>invalidSearchData = reader.getRowData("Invalid_Search", 1);
		String invalidKeyword = invalidSearchData.get("SearchKeyword");
		searchPageFac = new SearchPageFac(BaseSteps.driver);
		searchPageFac.searchForProfile(invalidKeyword);
		Thread.sleep(3000);
	}
	@When("User selects the Jobs filter")
	public void user_selects_the_jobs_filter() throws InterruptedException {
		searchPageFac.applyFilter();
		Thread.sleep(3000);

	}
	@Then("System should display a No matching jobs found message")
	public void system_should_display_a_no_matching_jobs_found_message() {
		searchPageFac.errorDisplayed();
	}
	
	
//-----------------------------------------------------------------------------------------------------------
	
//-------------------------------------TS_LinkedIn_03------------------------------------------------------
	

@When("User click on the post textbox on the homepage")
public void user_click_on_the_post_textbox_on_the_homepage() {
	homePageFac = new HomePageFac(BaseSteps.driver);
	homePageFac.clickCreatePost();
}
@When("User enters valid content into the field and clicks on post button")
public void user_enters_valid_content_into_the_field_and_clicks_on_post_button() throws InterruptedException {
	homePageFac.createPost();
	Thread.sleep(3000);
}
@Then("the post should be successfully shared on the feed")
public void the_post_should_be_successfully_shared_on_the_feed() {
	homePageFac.isPosted();
}

//--------------------------------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------TS_LinkedIn_04---------------------------------------------------------------
	

@When("User attemps to post the same content again")
public void user_attemps_to_post_the_same_content_again() {
	homePageFac = new HomePageFac(BaseSteps.driver);
	homePageFac.clickCreatePost();
	homePageFac.createPost();
}
@Then("Duplicate post warning should be displayed")
public void duplicate_post_warning_should_be_displayed() throws InterruptedException {
	homePageFac.isDuplicateErrorDisplayed();
	Thread.sleep(4000);
}

//------------------------------------------------------------------------------------------------------------------------

//---------------------------------------TS_LinkedIn_05---------------------------------------------------------------------------------------------

@When("User navigates to Dark Mode in Settings & Privacy page")
public void user_navigates_to_dark_mode_in_settings_privacy_page() throws InterruptedException {
	homePageFac = new HomePageFac(BaseSteps.driver);	
	homePageFac.goToSettings();
	Thread.sleep(4000);
	accPreferancePageFac = new AccPreferancePageFac(BaseSteps.driver);
	accPreferancePageFac.goToDarkModeSetting();
	
	
}
@When("User switches the mode to the opposite of the current selection")
public void user_switches_the_mode_to_the_opposite_of_the_current_selection() {
	accPreferancePageFac.toggleDarkMode();
}
@Then("New Dark Mode setting should be applied")
public void new_dark_mode_setting_should_be_applied() {
	

}

}
