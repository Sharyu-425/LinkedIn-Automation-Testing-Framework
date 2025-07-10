//package com.pages;
package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import com.utils.ScreenshotUtil;

public class ConnectionsPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public ConnectionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    // ✅ Clicks on the Connections tab in the My Network section
    public void clickConnectionsTab() {
        try {
            WebElement connectionsTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/mynetwork/invite-connect/connections/')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", connectionsTab);
            connectionsTab.click();

            // Wait for navigation to complete
            wait.until(ExpectedConditions.urlContains("/mynetwork/invite-connect/connections"));
            System.out.println("✅ Clicked on Connections tab");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Connections tab: " + e.getMessage());
        }
    }

    // ✅ Verifies if the connections list is visible
//    public boolean isConnectionsListVisible() {
//        try {
//            // Scroll to trigger lazy loading
//            js.executeScript("window.scrollBy(0, 400);");
//            Thread.sleep(2000);
//
//            // Wait for at least one connection card to be visible
//            wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("li.mn-connection-card")));
//
//            List<WebElement> cards = driver.findElements(By.cssSelector("li.mn-connection-card"));
//            if (!cards.isEmpty()) {
//                System.out.println("✅ Connections list loaded with " + cards.size() + " connections.");
//                return true;
//            } else {
//                System.out.println("❌ No connection cards found.");
//                return false;
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Connections list not visible: " + e.getMessage());
//            ScreenshotUtil.takeScreenshot(driver, "ConnectionsListNotVisible");
//            return false;
//        }
//    }

    // ✅ Scrolls through the connections list using Robot
    public void scrollConnectionsList() {
        try {
            List<WebElement> cards = driver.findElements(By.cssSelector("li.mn-connection-card"));
            if (cards.isEmpty()) {
                System.out.println("⚠️ No connections found to scroll.");
                return;
            }

            Robot robot = new Robot();
            for (int i = 0; i < 5; i++) {
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(1000);
            }
            System.out.println("✅ Scrolled through connections list using Robot");
        } catch (Exception e) {
            System.out.println("❌ Failed to scroll connections list: " + e.getMessage());
        }
    }

 }
