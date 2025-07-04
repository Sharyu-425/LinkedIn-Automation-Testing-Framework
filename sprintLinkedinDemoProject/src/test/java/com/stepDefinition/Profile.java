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

   // WebDriver driver=getDriver();
    MessagingPage msgPage;
   // LoginPage login;

//    @Given("I open the LinkedIn login page")
//    public void i_open_linkedin_login_page() {
//        loadProperties("src/test/resources/PropertieFiles/profile.properties");
//        initializeDriver();
//        driver = getDriver();
//        driver.get(prop.getProperty("url"));
//    }
//
//    @When("I login using username {string} and password {string}")
//    public void i_login_with_credentials(String userKey, String passKey) {
//        login = new LoginPage(driver);
//        
//        // Fetch actual data from Excel
//        String username = ExcelReader.getCellValue("Sheet1", 1, 0);  // You can map "User1" to Excel row
//        String password = ExcelReader.getCellValue("Sheet1", 1, 1);
//
//        login.loginToLinkedIn(username, password);
//
//        try {
//            Thread.sleep(15000);  // ✅ As per your request — 15 sec delay after login
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

   
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


}

