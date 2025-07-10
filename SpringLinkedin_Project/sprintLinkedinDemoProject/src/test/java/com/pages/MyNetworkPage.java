package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class MyNetworkPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'/mynetwork') and contains(@class,'global-nav__primary-link')]")
    WebElement myNetworkTab;


//    @FindBy(xpath = "//section[contains(.,'People you may know')]")
//    WebElement peopleYouMayKnowSection;

    @FindBy(xpath = "(//span[text()='Connect']/ancestor::button)[1]")
    WebElement firstConnectButton;

    @FindBy(xpath = "(//span[contains(text(),'Pending') or contains(text(),'Withdraw')])[1]")
    WebElement pendingStatus;

    public MyNetworkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMyNetwork() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(myNetworkTab));
            myNetworkTab.click();
            System.out.println("Navigated to My Network");
        } catch (Exception e) {
            System.out.println(" Failed to navigate to My Network: " + e.getMessage());
        }
    }

    public void scrollToSuggestions() {
        try {
            System.out.println("🔄 Scrolling to 'Stay in touch through daily games' heading...");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement heading = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[contains(text(),'Stay in touch through daily games')]")
            ));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", heading);
            js.executeScript("arguments[0].style.border='3px solid orange'", heading); // Optional highlight

            System.out.println("✅ Scrolled to 'Stay in touch through daily games' section.");

        } catch (Exception e) {
           // ScreenshotUtil.takeScreenshot(driver, "ScrollToDailyGamesSectionFailed");
            throw new RuntimeException("❌ Scroll to daily games section failed: " + e.getMessage(), e);
        }
    }
    
    public void connectFirstSuggestion() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(firstConnectButton));

            // Scroll into view and click using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", firstConnectButton);
            js.executeScript("arguments[0].click();", firstConnectButton);

            System.out.println(" Clicked on Connect button.");
        } catch (Exception e) {
            System.out.println(" Could not click Connect button: " + e.getMessage());
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
            System.out.println(" Pending status not found: " + e.getMessage());
            return false;
        }
    }
}