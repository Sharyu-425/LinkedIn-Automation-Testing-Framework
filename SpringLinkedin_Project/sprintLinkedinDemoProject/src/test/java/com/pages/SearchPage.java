package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    public void searchPerson(String personName, String searchInputXpath) {
        try {
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputXpath)));
            searchInput.clear();
            searchInput.sendKeys(personName);
            searchInput.sendKeys(Keys.ENTER);
            System.out.println("✅ Searched for: " + personName);
        } catch (TimeoutException e) {
            System.out.println("❌ Search bar not found. Please check the XPath or page load: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Failed to search: " + e.getMessage());
        }
    }


    public void clickPeopleFilter(String peopleFilterXpath) {
        try {
            // Wait for the filter bar to be visible
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'search-reusables__filter-list')]")));

            WebElement peopleFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(peopleFilterXpath)));

            // Scroll into view and click
            js.executeScript("arguments[0].scrollIntoView(true);", peopleFilter);
            js.executeScript("arguments[0].click();", peopleFilter);

            System.out.println("✅ Clicked on People filter");
        } catch (Exception e) {
            System.out.println("❌ Failed to click People filter: " + e.getMessage());
        }
    }



    public void clickConnect(String connectBtnXpath) {
        try {
            WebElement connectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(connectBtnXpath)));
            js.executeScript("arguments[0].scrollIntoView(true);", connectBtn);
            js.executeScript("arguments[0].click();", connectBtn);
            System.out.println("✅ Clicked on Connect");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Connect: " + e.getMessage());
        }
    }


    public void clickSendWithoutNote(String sendBtnXpath) {
        try {
            // Wait for the modal to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("artdeco-modal__actionbar")));

            WebElement sendBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sendBtnXpath)));
            sendBtn.click();
            System.out.println("✅ Clicked on Send without a note");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Send without a note: " + e.getMessage());
        }
    }


    public boolean isConnectionPending(String pendingStatusXpath) {
        try {
            // Scroll up slightly to bring the Pending button into view
            js.executeScript("window.scrollBy(0, -300);");
            Thread.sleep(1000); // Allow UI to adjust

            WebElement pending = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pendingStatusXpath)));
            return pending.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Pending status not found: " + e.getMessage());
            return false;
        }
    }

}
