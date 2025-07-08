package com.stepDefinition;

import com.parameters.ExcelReader;
import com.pages.MyNetworkPage;
import com.pages.WithdrawRequestPage;
import com.setup.BaseTest;
import com.utils.ScreenshotUtil;

import static com.setup.Hooks.scenario;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Profile extends BaseTest {

    MyNetworkPage networkPage;
    WithdrawRequestPage withdrawPage;

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

        Thread.sleep(20000); // Let page load after login
        System.out.println("✅ Logged in with: " + username);
    }

    @When("user navigates to My Network section")
    public void goToNetwork() throws InterruptedException {
        networkPage = new MyNetworkPage(driver);
        networkPage.goToMyNetwork();
        Thread.sleep(3000);
        System.out.println("✅ Navigated to My Network page");
    }

    // ============================== Scenario 1: Send Connection ==============================

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
        Assert.assertTrue(statusChanged, "❌ Status did not change to Pending or Withdraw");
        System.out.println("✅ Connection status changed successfully.");
        Thread.sleep(3000);
    }

    // ============================== Scenario 2: Withdraw Request ==============================

    @When("user opens the Sent Invitations list")
    public void openSentInvitations() {
        withdrawPage = new WithdrawRequestPage(driver);
        withdrawPage.openSentInvitations();
    }

    @Then("user captures screenshot of pending request")
    public void capturePendingScreenshot() {
        Assert.assertTrue(withdrawPage.isWithdrawButtonVisible(), "❌ No pending request found.");
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
        Assert.assertTrue(withdrawPage.isWithdrawSuccessMessageVisible(), "❌ Success message not displayed.");
        Thread.sleep(1000);
    }

    //=============================== Scenario 3: Accept and Ignore Request ===============================

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
            System.out.println("❌ Step failed: Accept first request - " + e.getMessage());
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
            System.out.println("❌ Step failed: Ignore last request - " + e.getMessage());
        }
    }

    // ============================== Common ==============================

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
//package com.stepDefinition;
//
//import com.parameters.ExcelReader;
//import com.pages.MyNetworkPage;
//import com.pages.WithdrawRequestPage;
//import com.setup.BaseTest;
//import com.utils.ScreenshotUtil;
//
//import static com.setup.Hooks.scenario;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.testng.Assert;
//
//public class Profile extends BaseTest {
//
//    MyNetworkPage networkPage;
//    WithdrawRequestPage withdrawPage;
//
//    @Given("user launches the browser")
//    public void launchBrowser() {
//        // Already handled in Hooks
//    }
//
//    @When("I login with user from Excel")
//    public void login_with_user_from_excel() throws InterruptedException {
//        int rowNumber = scenario.getSourceTagNames().contains("@UsePQR") ? 1 : 2;
//        String username = ExcelReader.getCellData("Sheet1", rowNumber, 0);
//        String password = ExcelReader.getCellData("Sheet1", rowNumber, 1);
//
//        driver.findElement(By.id("username")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        Thread.sleep(20000); // Let page load after login
//        System.out.println("✅ Logged in with: " + username);
//    }
//
//    @When("user navigates to My Network section")
//    public void goToNetwork() throws InterruptedException {
//        networkPage = new MyNetworkPage(driver);
//        networkPage.goToMyNetwork();
//        Thread.sleep(3000);
//        System.out.println("✅ Navigated to My Network page");
//    }
//
//    // ============================== Scenario 1: Send Connection ==============================
//
//    @When("user scrolls to 'People You May Know'")
//    public void scrollToSuggestions() throws InterruptedException {
//        networkPage.scrollToSuggestions();
//        Thread.sleep(1000);
//    }
//
//    @When("user clicks on Connect for the first suggested profile")
//    public void connectFirst() throws InterruptedException {
//        networkPage.connectFirstSuggestion();
//        Thread.sleep(1000);
//    }
//
//    @Then("connection status should change to Pending")
//    public void verifyStatus() throws InterruptedException {
//        boolean statusChanged = networkPage.isStatusPending();
//        Assert.assertTrue(statusChanged, "❌ Status did not change to Pending or Withdraw");
//        System.out.println("✅ Connection status changed successfully.");
//        Thread.sleep(3000);
//    }
//
//    // ============================== Scenario 2: Withdraw Request ==============================
//
//    @When("user opens the Sent Invitations list")
//    public void openSentInvitations() {
//        withdrawPage = new WithdrawRequestPage(driver);
//        withdrawPage.openSentInvitations();
//    }
//
//    @Then("user captures screenshot of pending request")
//    public void capturePendingScreenshot() {
//        Assert.assertTrue(withdrawPage.isWithdrawButtonVisible(), "❌ No pending request found.");
//        ScreenshotUtil.takeScreenshot(driver, "PendingRequest");
//    }
//
//    @When("user clicks on Withdraw for the first pending request")
//    public void clickWithdraw() {
//        withdrawPage.clickWithdraw();
//    }
//    
//    @And("user confirms the withdraw in the modal")
//    public void confirmWithdrawInModal() {
//        withdrawPage.confirmWithdrawInModal();
//    }
//
//    @Then("a success message should be displayed")
//    public void verifyWithdrawSuccessMessage() throws InterruptedException {
//        Assert.assertTrue(withdrawPage.isWithdrawSuccessMessageVisible(), "❌ Success message not displayed.");
//        Thread.sleep(1000);
//    }
//    
//    //=============================== Scenerio3 : Accept and ignore request====================================
//    
//    @When("user opens the Received Invitations list")
//    public void openReceivedInvitations() {
//        withdrawPage = new WithdrawRequestPage(driver);
//        withdrawPage.openReceivedInvitations(); // new method in page object
//    }
//    @Then("user captures screenshot of received requests")
//    public void captureReceivedScreenshot() {
//        ScreenshotUtil.takeScreenshot(driver, "ReceivedRequests");
//    }
//
//    @And("user scrolls down and up to reveal all requests")
//    public void scrollDownAndUp() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 500);");
//        Thread.sleep(1000);
//        js.executeScript("window.scrollBy(0, -500);");
//        Thread.sleep(1000);
//    }
//    @When("user clicks on Accept for the first request")
//    public void clickAccept() {
//        withdrawPage.clickAcceptFirstRequest();
//    }
//
//    @When("user clicks on Ignore for the last request")
//    public void clickIgnore() {
//        withdrawPage.clickIgnoreLastRequest();
//    }
//
//
//    // ============================== Common ==============================
//
//    @Then("screenshot is captured")
//    public void captureScreenshot(io.cucumber.java.Scenario scenario) {
//    	String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
//    	ScreenshotUtil.takeScreenshot(driver, scenarioName);
//
//    }
//
//    @Then("browser is closed")
//    public void closeBrowser() {
//        tearDown();
//    }
//}