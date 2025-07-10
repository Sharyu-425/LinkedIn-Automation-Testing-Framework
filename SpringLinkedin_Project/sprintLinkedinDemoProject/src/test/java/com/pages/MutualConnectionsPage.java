package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Properties;

public class MutualConnectionsPage {
    WebDriver driver;
    WebDriverWait wait;
    Properties prop;

    public MutualConnectionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        prop = com.setup.BaseTest.prop;
    }

    public boolean isProfilePageLoaded() {
        try {
            String profileHeaderXpath = prop.getProperty("profile.header.xpath");
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileHeaderXpath)));
            System.out.println("--------profile page diplayed-----");
            return header.isDisplayed();
        } catch (Exception e) {
            System.out.println("Profile header not found: " + e.getMessage());
            return false;
        }
    }

    public void clickMutualConnectionsLink() {
        try {
            String mutualLinkXpath = prop.getProperty("mutual.link.xpath");

            // Wait for the link to be present
            WebElement mutualLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(mutualLinkXpath)));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", mutualLink);

            // Wait until it's clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(mutualLink)).click();

            System.out.println("Clicked on mutual connections link");
        } catch (Exception e) {
            throw new RuntimeException(" Mutual connections link not clickable: " + e.getMessage());
        }
    }
    public void scrollToHelpfulResultsSection() {
        try {
            // XPath for the "Are these results helpful?" heading
            String helpfulHeadingXpath = "//p[text()='Are these results helpful?']";

            // Wait for the element to be present
            WebElement helpfulHeading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(helpfulHeadingXpath)));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", helpfulHeading);

            // Optional: wait for visibility
            wait.until(ExpectedConditions.visibilityOf(helpfulHeading));  

            System.out.println("Scrolled to 'Are these results helpful?' section");
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to 'Are these results helpful?' section: " + e.getMessage());
        }
    }
    public boolean isMutualConnectionsListVisible() {
        try {
            String mutualListXpath = prop.getProperty("mutual.list.xpath");
            WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mutualListXpath)));
            return list.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}