package com.stepDefinition;

import com.pages.LoginPage;
import com.pages.MessagingPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Messaging extends BaseSteps {

   WebDriver driver=getDriver();
   MessagingPage msgPage=new MessagingPage(driver); 
 
    
    
    @Then("I should see my home pageA")
    public void i_should_see_my_home_page_a() {
    	String title = driver.getTitle();
        System.out.println("Logged in, page title is: " + title);
        //  Use Assert here for validation
        assert title.contains("LinkedIn") : "Login failed or wrong page!";
       
    }
    
    
 // ---------------------------------------------------Scenario 1 @MessagingModule----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */
    @When("user checks for messaging icon")
    public void user_checks_for_messaging_icon() {
      
       Assert.assertTrue(msgPage.isMessagingIconVisible(),"Messaging icon is not visible");
    }
    @Then("Messaging icon should be visible")
    public void messaging_icon_should_be_visible() {
    	Assert.assertTrue(msgPage.isMessagingIconVisible(),"Messaging icon is not Displayed");
    }
    
    
    
 // ---------------------------------------------------Scenario 2 @MessagingModule----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */
    
    @When("user click on messaging icon")
    public void user_click_on_messaging_icon() {
    
    	msgPage.clickMessagingIcon();
       
    }
    @Then("messaging window should be open")
    public void messaging_window_should_be_open() {
    	Assert.assertTrue(msgPage.isMessagingWindowVisible(),"Messaging window is not visible");
          
    }
    @When("user click on compose message button")
    public void user_click_on_compose_message_button() {
       msgPage.clickNewMessageButton();
    }
    @When("enter {string} in the search field")
    public void enter_in_the_search_field(String connection) {
    	String connFromExcel=ExcelReader.getCellValue("Sheet1", 5, 0);
    	msgPage.searchForConnection(connFromExcel);
        
    }

    @When("user type {string} into the message box")
    public void user_type_into_the_message_box(String message) {
    	String msgFromExcel=ExcelReader.getCellValue("Sheet1", 5, 1);
       msgPage.enterMessage(msgFromExcel);
    	
    }
    @When("User click the Send button")
    public void user_click_the_send_button() {
        msgPage.clickSendButton();
    }
    @Then("The message should appear in the chat thread")
    public void the_message_should_appear_in_the_chat_thread() {
        msgPage.verifyMessageSent();
    }
    
    
 // ---------------------------------------------------Scenario 3 @MessagingModule----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */

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

 // ---------------------------------------------------Scenario 4 Messaging module----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */
   
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
       
   
       TakesScreenshot ts=(TakesScreenshot) BaseSteps.driver;
       File src=ts.getScreenshotAs(OutputType.FILE);
       String destPath="screenshots/manage_settings_Afetr_Redirectpage1.png";
       try {
    	   FileUtils.copyFile(src, new File(destPath));
    	   System.out.println("Screenshot captured" +destPath);
       }catch(Exception e) {
    	   e.printStackTrace();
       }
   }

 // ---------------------------------------------------Scenario 5 @MessagingModule----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */
   
    @When("user is on messaging window")
    public void user_is_on_messaging_window() {
        msgPage.clickMessagingIcon();
    }
    
    @When("user search for following names:")
    public void user_search_for_following_names(io.cucumber.datatable.DataTable dataTable) throws Exception {
      List<List<String>> data = dataTable.asLists();
      String fileName=data.get(0).get(0);
      String sheetName=data.get(0).get(1);
      int recordCount=Integer.parseInt(data.get(0).get(2));
      
      int startRow=8;
      
        for(int i=startRow;i<startRow+recordCount;i++) {
        	String name=ExcelReader.getCellValue(sheetName, i, 0);
        			msgPage.searchMessage(name);
        }
    }
    
   
    @When("user is on messaging window panel")
    public void user_is_on_messaging_window_panel() {
       msgPage.clickMessagingIcon();
    }
    @When("user searches invalid names from excel:")
    public void user_searches_invalid_names_from_excel(io.cucumber.datatable.DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists();
    	String fileName=data.get(0).get(0);
        String sheetName=data.get(0).get(1);
        int recordCount=Integer.parseInt(data.get(0).get(2));
        int startRow=14;
        for(int i=startRow;i<startRow+recordCount;i++) {
        	String invalidData=ExcelReader.getCellValue(sheetName, i, 0);
        			msgPage.searchMessage(invalidData);
        
    }
   }
 
    
    
    
 // ---------------------------------------------------Scenario 6 @MessagingModule----------------------------------------------------------------------------//
    /*created By:
	 * Reviewed By:
	 * Motive:
	 */
    
    @When("user is on messaging the window")
    public void user_is_on_messaging_the_window() {
       msgPage.clickMessagingIcon(); 
    }
    @When("user clicks on the minimized messaging panel")
    public void user_clicks_on_the_minimized_messaging_panel() throws AWTException{
       msgPage.clickMinimizedMessagingPanel(BaseSteps.driver); 
    }
    @AfterStep
	public void tearDown(Scenario scenario) // wil take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Image");
		
	}
 
}

