package com.stepDefinition;

import com.pages.LoginPage;
import com.pages.MessagingPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Profile extends BaseSteps {

    WebDriver driver=getDriver();
   MessagingPage msgPage=new MessagingPage(driver); //this line to handle nullptrfor scenario3
    //MessagingPage msgPage;

   
    @Then("I should see my home pageA")
    public void i_should_see_my_home_page_a() {
    	String title = driver.getTitle();
        System.out.println("Logged in, page title is: " + title);
        // ✅ Use Assert here for validation
        assert title.contains("LinkedIn") : "Login failed or wrong page!";
       // quitDriver();
    }
    
    @When("user checks for messaging icon")
    public void user_checks_for_messaging_icon() {
       msgPage=new MessagingPage(getDriver());
       Assert.assertTrue(msgPage.isMessagingIconVisible(),"Messaging icon is not visible");
    }
    @Then("Messaging icon should be visible")
    public void messaging_icon_should_be_visible() {
    	Assert.assertTrue(msgPage.isMessagingIconVisible(),"Messaging icon is not Displayed");
    }
    @When("user click on messaging icon")
    public void user_click_on_messaging_icon() {
    	msgPage=new MessagingPage(driver);
    	msgPage.clickMessagingIcon();
       
    }
    @Then("messaging window should be open")
    public void messaging_window_should_be_open() {
    	msgPage=new MessagingPage(driver);
    	Assert.assertTrue(msgPage.isMessagingWindowVisible(),"Messaging window is not visible");
          
    }
    @When("user click on compose message button")
    public void user_click_on_compose_message_button() {
       msgPage.clickNewMessageButton();
    }
    @When("enter {string} in the search field")
    public void enter_in_the_search_field(String connection) {
    	msgPage.searchForConnection(connection);
        
    }

    @When("user type {string} into the message box")
    public void user_type_into_the_message_box(String message) {
       msgPage.enterMessage(message);
    	
    }
    @When("User click the Send button")
    public void user_click_the_send_button() {
        msgPage.clickSendButton();
    }
    @Then("The message should appear in the chat thread")
    public void the_message_should_appear_in_the_chat_thread() {
        msgPage.verifyMessageSent();
    }

    @When("user is on the messaging window")
    public void user_is_on_the_messaging_window() {
        msgPage.clickMessagingIcon();
    }
    @When("user clicks on the Focused dropdown")
    public void user_clicks_on_the_focused_dropdown() {
     msgPage.clickFocusedDropdown();
    	
    }
   
    
    @When("user selects Archieved from the dropdown options")
    public void user_selects_archieved_from_the_dropdown_options() throws Exception {
    	msgPage.selectArchivedUsingRobot();
    }
    @Then("Archieved messages should be displayed")
    public void archieved_messages_should_be_displayed() {
       Assert.assertTrue( msgPage.isArchivedVisible());
    }

   
    @When("user clicks on messaging icon")
    public void user_clicks_on_messaging_icon() {
       msgPage.clickMessagingIcon();
    }
    @When("user clicks on the three dots menu")
    public void user_clicks_on_the_three_dots_menu() {
      msgPage.clickThreeDots();  
    }
    @When("user selects Manage settings option")
    public void user_selects_manage_settings_option() throws Exception {
       msgPage.openManageSettingsWithRobots();
    }


   

    
   

}

