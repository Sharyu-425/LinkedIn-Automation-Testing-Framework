package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class WithdrawRequestPage {
    WebDriver driver;
    WebDriverWait wait;

    public WithdrawRequestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===================== Common Utilities =====================

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ===================== Navigation =====================

    public void goToMyNetwork() {
        driver.findElement(By.linkText("My Network")).click();
    }

    public void openSentInvitations() {
        try {
            WebElement showAll = waitToBeClickable(By.xpath("//a[@aria-label='Show all invitations']"));
            scrollToElement(showAll);
            showAll.click();
            System.out.println("Clicked on 'Show all invitations'");

            WebElement sentTab = waitToBeClickable(By.xpath("//span[contains(text(),'Sent') or contains(text(),'sent')]"));
            scrollToElement(sentTab);
            sentTab.click();
            System.out.println(" Clicked on 'Sent' tab");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(" Error opening Sent Invitations: " + e.getMessage());
        }
    }

    public void openReceivedInvitations() {
        try {
            WebElement showAll = waitToBeClickable(By.xpath("//a[@aria-label='Show all invitations']"));
            scrollToElement(showAll);
            showAll.click();
            System.out.println("Clicked on 'Show all invitations'");

            WebElement receivedTab = waitToBeClickable(By.xpath("//span[contains(text(),'Received') or contains(text(),'received')]"));
            scrollToElement(receivedTab);
            receivedTab.click();
            System.out.println(" Clicked on 'Received' tab");
        } catch (Exception e) {
            System.out.println(" Error opening Received Invitations: " + e.getMessage());
        }
    }

    // ===================== Sent Invitations =====================

    public boolean isWithdrawButtonVisible() {
        try {
            WebElement withdrawBtn = waitForElement(By.xpath("(//button[@data-view-name='sent-invitations-withdraw-single'])[1]"));
            return withdrawBtn.isDisplayed();
        } catch (Exception e) {
            System.out.println("Withdraw button not visible: " + e.getMessage());
            return false;
        }
    }

    public void clickWithdraw() {
        try {
            WebElement withdrawBtn = waitToBeClickable(By.xpath("(//button[@data-view-name='sent-invitations-withdraw-single'])[1]"));
            scrollToElement(withdrawBtn);
            withdrawBtn.click();
            System.out.println(" Clicked on Withdraw");
        } catch (Exception e) {
            System.out.println("Could not click Withdraw: " + e.getMessage());
        }
    }

    public void confirmWithdrawInModal() {
        try {
            WebElement confirmBtn = waitToBeClickable(By.xpath("//button[normalize-space()='Withdraw' and not(@data-view-name)]"));
            confirmBtn.click();
            System.out.println(" Confirmed Withdraw in modal");
        } catch (Exception e) {
            System.out.println(" Could not confirm Withdraw in modal: " + e.getMessage());
        }
    }

    public boolean isWithdrawSuccessMessageVisible() {
        try {
            WebElement message = waitForElement(By.xpath("//*[contains(text(),'Invitation to') and contains(text(),'withdrawn')]"));
            System.out.println(" Success message displayed: " + message.getText());
            return true;
        } catch (Exception e) {
            System.out.println(" Success message not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isRequestRemoved() {
        try {
            Thread.sleep(2000);
            return driver.findElements(By.xpath("(//button[@data-view-name='sent-invitations-withdraw-single'])[1]")).isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    // ===================== Received Invitations =====================

    public void clickAcceptFirstRequest() {
        try {
            List<WebElement> acceptButtons = driver.findElements(By.xpath("//button[contains(@aria-label,'Accept')]"));
            if (!acceptButtons.isEmpty()) {
                WebElement firstAccept = acceptButtons.get(0);
                scrollToElement(firstAccept);
                wait.until(ExpectedConditions.elementToBeClickable(firstAccept)).click();
                System.out.println(" Clicked Accept on first request");
            } else {
                System.out.println(" No Accept buttons found");
            }
        } catch (Exception e) {
            System.out.println(" Could not click Accept: " + e.getMessage());
        }
    }

    public void clickIgnoreLastRequest() {
        try {
            List<WebElement> ignoreButtons = driver.findElements(By.xpath("//button[contains(@aria-label,'Ignore')]"));
            if (!ignoreButtons.isEmpty()) {
                WebElement lastIgnore = ignoreButtons.get(ignoreButtons.size() - 1);
                scrollToElement(lastIgnore);
                wait.until(ExpectedConditions.elementToBeClickable(lastIgnore)).click();
                System.out.println("Clicked Ignore on last request");
            } else {
                System.out.println("No Ignore buttons found");
            }
        } catch (Exception e) {
            System.out.println(" Could not click Ignore: " + e.getMessage());
        }
    }
}