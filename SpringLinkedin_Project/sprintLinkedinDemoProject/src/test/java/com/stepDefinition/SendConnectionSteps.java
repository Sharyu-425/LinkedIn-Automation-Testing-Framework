package com.stepDefinition;

import com.parameters.ExcelReader;
import com.pages.MyNetworkPage;
import com.setup.BaseTest;
import com.utils.ScreenshotUtil;

import static com.setup.Hooks.scenario;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SendConnectionSteps extends BaseTest {

    MyNetworkPage networkPage;

    @Given("user launches the browser")
    public void launchBrowser() {
        // Browser is already launched in Hooks
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
        System.out.println("✅ navigated to My Network page ");
        
    }

    @When("user scrolls to 'People You May Know'")
    public void scrollToSuggestions() throws InterruptedException {
        networkPage.scrollToSuggestions();
        Thread.sleep(1000); 
    }

    @When("user clicks on Connect for the first suggested profile")
    public void connectFirst() throws InterruptedException {
        networkPage.connectFirstSuggestion();
        System.out.println("🔍 Connect button displayed: ");
        Thread.sleep(1000); 
        
        
    }

    @Then("connection status should change to Pending")
    public void verifyStatus() throws InterruptedException {
        boolean statusChanged = networkPage.isStatusPending();
        Assert.assertTrue(statusChanged, "❌ Status did not change to Pending or Withdraw");
        System.out.println("✅ Connection status changed successfully.");
        Thread.sleep(3000); 
    }


@Then("screenshot is captured")
public void captureScreenshot() {
    ScreenshotUtil.takeScreenshot(driver, "SendConnection");
}

    @Then("browser is closed")
    public void closeBrowser() {
        tearDown();
    }
}