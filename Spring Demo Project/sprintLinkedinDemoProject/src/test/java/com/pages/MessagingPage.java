package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MessagingPage {
 WebDriver driver;
 WebDriverWait wait;

	//xpath for icon visibility and clicking
	@FindBy(xpath="//a[contains(@href,'/messaging')]")
	WebElement messagingIcon;
	
	//xpath for messaging window visibility
	@FindBy(xpath="//div[contains(@class,'msg-conversations-container')]")
	WebElement messagingWindow;
	
	//xpath to click compose message icon
	@FindBy(css="button.msg-conversations-container__compose-btn")
	WebElement newMessageButton;
	
	//xpath for searchinng connection
	@FindBy(xpath="//div[contains(@class,'msg-connections-typeahead')]/input")
	WebElement searchInput;
	
	
	//xpath for clicking focusedDropdown
	@FindBy(xpath="//button[contains(., 'Focused') and contains(@class, 'artdeco-dropdown')]")
	WebElement focusedDropdown;
 
  
	//Xpath for clicking three dots menu
	@FindBy(xpath="//button[@aria-label='See more messaging options' and @type='button']")
    WebElement threeDotsMenu;
    
    //xpath to search message on messaging panel
    @FindBy(xpath="//input[@placeholder='Search messages']")
	WebElement messageSearchBox;
    
    //xpath to click minimized messaging window
    @FindBy(xpath="//div[contains(@class,'msg-overlay-bubble-header')]")
    WebElement minimizedMessagingButton;
    
    
	
	public MessagingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
//-------------------Messaging icon visibility---------------------------------------------------//	
	public boolean isMessagingIconVisible() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(messagingIcon));
		return messagingIcon.isDisplayed();
	}
	
//-----------------------send message to connection---------------------------------------------------//
	public void clickMessagingIcon() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(messagingIcon)).click();
		wait.until(ExpectedConditions.visibilityOf(messagingWindow));
	}
	
	public boolean isMessagingWindowVisible() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(messagingIcon));
		return messagingWindow.isDisplayed();
    }
	
	public void clickNewMessageButton() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(newMessageButton));
		newMessageButton.click();
		
	}
	
	public void searchForConnection(String name) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchInput));
		searchInput.clear();
		searchInput.sendKeys(name);
		try {Thread.sleep(1000);} catch(InterruptedException e) {}
		searchInput.sendKeys(Keys.ENTER);
	}

	public void enterMessage(String msg) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement messageInputBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'msg-form__contenteditable') and @role='textbox']")));
		messageInputBox.click();
		messageInputBox.sendKeys(msg);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
	}
	
	
	public void clickSendButton() {
		try {
			Robot robot=new Robot();
			robot.delay(1000);
			
			for(int i=0;i<6;i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(500);
			
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Sent message using tab and enter");
			
			
		}catch(Exception e) {
			System.out.println("Error clicking send button:"+e.getMessage());
		}
	}
	
	public void verifyMessageSent() {
		System.out.println(" Message sent successfully");
	}
	
//------------------------------Click Archived from Focused Drop-down--------------------------------------------//	
	public void clickFocusedDropdown() 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(focusedDropdown)).click();
	}

	
	public void pressArchivedWithRobot() throws Exception {
		Robot robot=new Robot();
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
	public void selectArchivedUsingRobot() throws Exception{
		
		pressArchivedWithRobot();
	}
	
	public boolean isArchivedVisible() {
		try {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement archiveHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Archived')]")));
		return archiveHeader.isDisplayed();
		
		}catch(Exception e) {
			System.out.println("Archived verification failed:"+e.getMessage());
		return false;
	}
}

//--------------------Select Manage Settings from Three dots menu----------------------------------------//
	
	//Method to click on three dots
	public void clickThreeDots() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(threeDotsMenu)).click();
	}
	
	
	//method to check visibility of drop-down options
	public void selectOptionFromThreeDotsMenu(String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[@role='menu']//span[contains(text(),'" + optionText + "')]")));
	    option.click();
	}

  // here we used robots to select manage setting option from drop-down
	public void clickManageSettings() throws Exception {
		
		Robot robot=new Robot();
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}
	public void openManageSettingsWithRobots() throws Exception {
		clickManageSettings();
	}
//---------------------------Search messages with connection name----------------------------------------//
	

	//here we are searching messages with names and names passed from data table from excel sheet
	public void searchMessage(String name) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(messageSearchBox)).clear();
		messageSearchBox.sendKeys(name + Keys.ENTER);
		Thread.sleep(1000);
	}
	
	

//-----------------------------Click minimized messaging panel------------------------------------------//	
	
	//This method is used to click the minimized messaging icon which is located at bottom right on screen
	 public void clickMinimizedMessagingPanel(WebDriver driver) throws AWTException {
	
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(minimizedMessagingButton));
		    wait.until(ExpectedConditions.elementToBeClickable(minimizedMessagingButton));

		    Actions actions = new Actions(driver);
		    actions.moveToElement(minimizedMessagingButton).click().perform();

		    System.out.println("Clicked messaging panel using Actions.");
		}

	

}

