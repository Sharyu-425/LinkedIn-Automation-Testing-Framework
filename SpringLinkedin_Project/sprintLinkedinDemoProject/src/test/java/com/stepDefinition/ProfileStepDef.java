package com.stepDefinition;

import com.parameters.ExcelReader;
import com.pages.ConnectionsPage;
import com.pages.MutualConnectionsPage;
import com.pages.MyNetworkPage;
import com.pages.WithdrawRequestPage;
import com.setup.BaseTest;
import com.utils.ScreenshotUtil;

import static com.setup.Hooks.scenario;

import java.time.Duration;
import java.util.List;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pages.SearchPage;


public class ProfileStepDef extends BaseTest {

    MyNetworkPage networkPage;
    WithdrawRequestPage withdrawPage;
    SearchPage searchPage;
    ConnectionsPage connectionsPage;
    WebElement selectedCard;
    JavascriptExecutor js;
    MutualConnectionsPage mutualPage;



    @Given("user launches the browser")
    public void launchBrowser() {
        // Already handled in Hooks
    }

    @When("I login with user from Excel")
    public void login_with_user_from_excel() throws InterruptedException {
        int rowNumber = scenario.getSourceTagNames().contains("@UsePQR") ? 1 : 2;
        String username = ExcelReader.getCellData("Sheet1", rowNumber, 0);
        String password = ExcelReader.getCellData("Sheet1", rowNumber, 1);

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

     // Wait for search bar to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("search.input.xpath"))));
            System.out.println(" Logged in and search bar is visible.");
        } catch (Exception e) {
            System.out.println(" Search bar not visible after login: " + e.getMessage());
        }
 // Let page load after login
        System.out.println(" Logged in with: " + username);
    }

    @When("user navigates to My Network section")
    public void goToNetwork() throws InterruptedException {
        networkPage = new MyNetworkPage(driver);
        networkPage.goToMyNetwork();
        Thread.sleep(3000);
        System.out.println(" Navigated to My Network page");
    }

    // ===================================== Scenario 1: Send Connection ==============================

    @When("user scrolls to 'People You May Know'")
    public void scrollToSuggestions() throws InterruptedException {
        networkPage.scrollToSuggestions();
        Thread.sleep(1000);
    }

    @When("user clicks on Connect for the first suggested profile")
    public void connectFirst() throws InterruptedException {
        networkPage.connectFirstSuggestion();
        Thread.sleep(1000);
    }

    @Then("connection status should change to Pending")
    public void verifyStatus() throws InterruptedException {
        boolean statusChanged = networkPage.isStatusPending();
        Assert.assertTrue(statusChanged, "Status did not change to Pending or Withdraw");
        System.out.println(" Connection status changed successfully.");
        Thread.sleep(3000);
    }

    // ============================================ Scenario 2: Withdraw Request ==============================

    @When("user opens the Sent Invitations list")
    public void openSentInvitations() {
        withdrawPage = new WithdrawRequestPage(driver);
        withdrawPage.openSentInvitations();
    }

    @Then("user captures screenshot of pending request")
    public void capturePendingScreenshot() {
        Assert.assertTrue(withdrawPage.isWithdrawButtonVisible(), "No pending request found.");
        ScreenshotUtil.takeScreenshot(driver, "PendingRequest");
    }

    @When("user clicks on Withdraw for the first pending request")
    public void clickWithdraw() {
        withdrawPage.clickWithdraw();
    }

    @And("user confirms the withdraw in the modal")
    public void confirmWithdrawInModal() {
        withdrawPage.confirmWithdrawInModal();
    }

    @Then("a success message should be displayed")
    public void verifyWithdrawSuccessMessage() throws InterruptedException {
        Assert.assertTrue(withdrawPage.isWithdrawSuccessMessageVisible(), "Success message not displayed.");
        Thread.sleep(1000);
    }

    //=====================================Scenario 3: Accept and Ignore Request ===============================

    @When("user opens the Received Invitations list")
    public void openReceivedInvitations() {
        withdrawPage = new WithdrawRequestPage(driver);
        withdrawPage.openReceivedInvitations();
    }

    @Then("user captures screenshot of received requests")
    public void captureReceivedScreenshot() {
        ScreenshotUtil.takeScreenshot(driver, "ReceivedRequests");
    }

    @When("user clicks on Accept for the first request")
    public void clickAccept() {
        try {
            withdrawPage.clickAcceptFirstRequest();
            Thread.sleep(2000); // Allow UI to update
        } catch (Exception e) {
            System.out.println("Step failed: Accept first request - " + e.getMessage());
        }
    }
    @Then("user scrolls down till last request")
    public void scrollToLastRequest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000); // Allow time for lazy-loaded elements
    }


    @When("user clicks on Ignore for the last request")
    public void clickIgnore() {
        try {
            withdrawPage.clickIgnoreLastRequest();
            Thread.sleep(4000); // Allow UI to update
        } catch (Exception e) {
            System.out.println("Step failed: Ignore last request - " + e.getMessage());
        }
    }
    
    //======================================= Scenario 4:Search and send request ===============================
    @When("user searches for a person from property file")
    public void searchPersonFromProperty() {
        searchPage = new SearchPage(driver);
        String person = prop.getProperty("search.person");
        String searchXpath = prop.getProperty("search.input.xpath");
        searchPage.searchPerson(person, searchXpath);
    }

    @And("user clicks on the People filter")
    public void clickPeopleFilter() throws InterruptedException {
        String peopleFilterXpath = prop.getProperty("people.filter.xpath");
        searchPage.clickPeopleFilter(peopleFilterXpath);
        Thread.sleep(15000); // Wait for real profiles to load
    }


    @And("user clicks on Connect for the selected profile")
    public void clickConnectFirstResult() {
        String connectXpath = prop.getProperty("connect.button.xpath");
        searchPage.clickConnect(connectXpath);
    }

    @And("user clicks on Send without a note in confirmation box")
    public void clickSendWithoutNote() {
        String sendXpath = prop.getProperty("send.without.note.xpath");
        searchPage.clickSendWithoutNote(sendXpath);
    }

    @Then("connection status should get changed to Pending")
    public void verifyPendingStatus() throws InterruptedException {
        String pendingXpath = prop.getProperty("pending.status.xpath");
        Assert.assertTrue(searchPage.isConnectionPending(pendingXpath), " Connection status did not change to Pending");
        System.out.println(" Connection status is now Pending");
        Thread.sleep(3000);
        
    }
    //=====================================Scenario 5 :verify connections ===============================
    
    @When("user clicks on Connections tab")
    public void clickConnectionsTab() {
        connectionsPage = new ConnectionsPage(driver);
        connectionsPage.clickConnectionsTab();
        System.out.println(" User clicks on Connections ");
    }

    @And("user scrolls through the connections list")
    public void scrollConnectionsList() {
        connectionsPage.scrollConnectionsList();
    }
 
//   ================================Scenerio 6: Mutual connections===========================================
    @And("user select the profile to check mutual")
    public void waitForUserToDisplayProfile() throws Exception {
        System.out.println(" Waiting for user to manually open a profile...");
        System.out.println(" Once the profile page is open, press Enter to continue...");
        new java.util.Scanner(System.in).nextLine(); // Manual pause
        Thread.sleep(2000); // Optional: slight buffer after Enter

        try {
            mutualPage = new MutualConnectionsPage(driver);
            mutualPage.clickMutualConnectionsLink();
            System.out.println(" Clicked on mutual connections link");
        } catch (Exception e) {
            System.out.println(" Failed to click mutual connections link: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "MutualLinkClickFailed");
            throw e;
        }
    }
    @And("user selects the profile {string} to check mutual")
    public void openProfileToCheckMutual(String profileUrl) throws Exception {
        System.out.println("🔗 Navigating to profile: " + profileUrl);
        driver.navigate().to(profileUrl);
        Thread.sleep(3000); // Wait for profile to load

        try {
            mutualPage = new MutualConnectionsPage(driver);
            mutualPage.clickMutualConnectionsLink();
            System.out.println("Clicked on mutual connections link");
        } catch (Exception e) {
            System.out.println(" Failed to click mutual connections link: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "MutualLinkClickFailed");
            throw e;
        }
    }


    @Then("click on mutual connections  link")
    public void clickOnMutualConnectionsLink() {
        try {
            mutualPage.clickMutualConnectionsLink();
            System.out.println(" Clicked on mutual connections link");
        } catch (Exception e) {
            System.out.println(" Failed to click mutual connections link: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "MutualLinkClickFailed");
            throw e;
        }
    }
    @And("list of mutual connections is appears")
    public void verifyMutualConnectionsList() {
        try {
            // Scroll to the bottom section to ensure full list is loaded
        	 Thread.sleep(3000);
            mutualPage.scrollToHelpfulResultsSection();
            Thread.sleep(3000);
            

            // Now verify the mutual connections list is visible
            boolean visible = mutualPage.isMutualConnectionsListVisible();
            Assert.assertTrue(visible, "Mutual connections list is not visible.");
            System.out.println("Mutual connections list is visible");

            // Optional: capture screenshot or perform further actions
        } catch (Exception e) {
            System.out.println("Error verifying mutual connections list: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "MutualListNotVisible");
            throw new RuntimeException(e);
        }
    }
    
    // ============================== Common =========================================
    @Then("screenshot is captured")
    public void captureScreenshot() {
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        ScreenshotUtil.takeScreenshot(driver, scenarioName);
    }

    @Then("browser is closed")
    public void closeBrowser() {
        tearDown();
    }
}


//@Then("connections list should be visible")
//public void verifyConnectionsListVisible() {
//	 System.out.println("✅ The Connection window get open");
//  Assert.assertTrue(connectionsPage.isConnectionsListVisible(), "❌ Connections list is not visible");
//  System.out.println("✅ The Connection list is visiable");
//}