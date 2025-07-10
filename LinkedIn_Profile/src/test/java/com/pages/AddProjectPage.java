package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {
    WebDriver driver;
    Actions action;
    JavascriptExecutor js;

    @FindBy(css = ".artdeco-text-input--input")
    WebElement projectNameField;

    @FindBy(xpath = "//label[text()='Description']")
    WebElement descriptionField;

    @FindBy(xpath = "//button[@class='artdeco-button artdeco-button--2 artdeco-button--secondary ember-view typeahead-cta__button']")
    WebElement skillsField;

    @FindBy(xpath = "//input[@class='basic-input  typeahead-cta__input']")
    WebElement typeSkillsField;

    @FindBy(id = "media-dropdown-trigger")
    WebElement mediaField;

    @FindBy(css = ".pe-treasury-link__input")
    WebElement linkField;

    @FindBy(css = ".artdeco-button.pe-treasury-link__add-button.artdeco-button--muted.artdeco-button--2.artdeco-button--tertiary.ember-view")
    WebElement addButton;

    @FindBy(id = "single-line-text-form-component-profileEditFormElement-TREASURY-title")
    WebElement titleField;

    @FindBy(xpath = "//textarea[@id='multiline-text-form-component-profileEditFormElement-TREASURY-description']")
    WebElement linkDescriptionField;

    @FindBy(xpath = "//button[@class='artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")
    WebElement applyButton;

    @FindBy(className = "fb-form-element__checkbox")
    WebElement currentlyWorkingField;

    @FindBy(xpath = "//*[@value='7']")
    WebElement month;

    @FindBy(xpath = "//input[@aria-label='Add contributor']")
    WebElement contributorsField;

    @FindBy(xpath = "//select[@class='fb-dash-form-element__select-dropdown']")
    WebElement associatedWithField;

    @FindBy(xpath = "//button[@class='artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")
    WebElement save;

    public AddProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void addValidDetails(String projectName, String description, String skills, String title, String linkDescription, String contributors) {    	
    	waitUntilElementIsClickable(projectNameField);
    	projectNameField.sendKeys(projectName);
    	descriptionField.click();
    	action.sendKeys(description).build().perform();
    	waitUntilElementIsClickable(skillsField);
    	action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(skills).build().perform();
    	action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mediaField);
    	mediaField.click();
    	 try {
 			Thread.sleep(2000);
 		} catch (InterruptedException e1) {
 			e1.printStackTrace();
 		}
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        waitUntilWebElementIsVisible(linkField);
        linkField.sendKeys("https://www.linkedin.com");
        addButton.click();
        waitUntilWebElementIsVisible(titleField);
        titleField.clear();
        titleField.sendKeys(title);
        linkDescriptionField.sendKeys(linkDescription);
        applyButton.click();
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        month.click();
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(contributors).build().perform();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        save.click();
        
    }
}
