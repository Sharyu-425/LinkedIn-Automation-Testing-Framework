package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyNetworkPage {
    WebDriver driver;

    @FindBy(linkText = "My Network")
    WebElement myNetworkTab;

    @FindBy(xpath = "//section[contains(.,'People you may know')]")
    WebElement peopleYouMayKnowSection;

//    @FindBy(xpath = "(//button[contains(text(),'Connect')])[1]")
//    WebElement firstConnectButton;
    @FindBy(xpath = "(//span[text()='Connect']/ancestor::button)[1]")
    WebElement firstConnectButton;

    @FindBy(xpath = "(//span[contains(text(),'Pending') or contains(text(),'Withdraw')])[1]")
    WebElement pendingStatus;

    public MyNetworkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMyNetwork() {
        myNetworkTab.click();
    }

    public void scrollToSuggestions() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", peopleYouMayKnowSection);
    }

    public void connectFirstSuggestion() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(firstConnectButton));

            // Scroll into view and click using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", firstConnectButton);
            js.executeScript("arguments[0].click();", firstConnectButton);

            System.out.println("✅ Clicked on Connect button.");
        } catch (Exception e) {
            System.out.println("❌ Could not click Connect button: " + e.getMessage());
        }
    }

    public boolean isStatusPending() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Pending')])[1]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Withdraw')])[1]"))
            ));
            return true;
        } catch (Exception e) {
            System.out.println("❌ Pending status not found: " + e.getMessage());
            return false;
        }
    }
}