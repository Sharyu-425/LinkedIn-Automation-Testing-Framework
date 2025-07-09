package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAboutPage extends BasePage {
    WebDriver driver;
    Actions action;
    
    @FindBy(xpath ="//textarea[@id='gai-text-form-component-profileEditFormElement-SUMMARY-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-summary']")
    WebElement aboutField;

    @FindBy(xpath ="//button[@class='artdeco-button artdeco-button--2 artdeco-button--secondary ember-view typeahead-cta__button']")
    WebElement skillsField;

    @FindBy(xpath ="//input[@placeholder='Skill (ex: Project Management)']")
    WebElement typeSkills;
    
    @FindBy(className ="artdeco-inline-feedback__message")
    WebElement errorMessage;
    
    @FindBy(xpath = "//div[@class='artdeco-modal artdeco-modal--layer-default pe-edit-form-page__modal']")
    WebElement updated;
    

    public AddAboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
    }
    
    public void addAboutValid(String about) {
    	waitUntilElementIsClickable(aboutField);
    	
        String aboutText = about;

        // Send text in chunks
        for (String chunk : aboutText.split("\r\n")) {
            aboutField.sendKeys(chunk);
            aboutField.sendKeys(Keys.RETURN);
        }
    }

    public void addAboutInvalid(String about) {
        waitUntilElementIsClickable(aboutField);
        String aboutText = about;
//          String aboutText = "I’m a passionate and curious tech enthusiast currently working at Capgemini, with a strong foundation in Java, Python, and data science. My journey in the tech world has been driven by an insatiable curiosity and a relentless desire to solve real-world problems through innovative solutions. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n"
//          		+ "\r\n"
//          		+ "Professional Experience and Skills\r\n"
//          		+ "\r\n"
//          		+ "With hands-on experience in automation testing (V&amp;V), software development, and data-driven projects, I have developed a robust skill set that allows me to tackle complex challenges and deliver impactful results. My role at Capgemini has provided me with numerous opportunities to work on diverse projects, each contributing to my growth as a versatile and skilled professional.\r\n"
//          		+ "\r\n"
//          		+ "Automation Testing (V&amp;V)\r\n"
//          		+ "\r\n"
//          		+ "In the realm of automation testing, I have honed my skills in verifying and validating software systems to ensure they meet the highest standards of quality and performance. My expertise in this area includes designing and implementing automated test scripts, conducting thorough testing cycles, and identifying and resolving defects. This meticulous approach ensures that the software products I work on are reliable, efficient, and user-friendly.\r\n"
//          		+ "\r\n"
//          		+ "Software Development\r\n"
//          		+ "\r\n"
//          		+ "As a software developer, I have been involved in the entire software development lifecycle, from conceptualization and design to implementation and maintenance. My proficiency in Java and Python has enabled me to build robust and scalable applications that meet the specific needs of clients and end-users. I am adept at writing clean, efficient, and maintainable code, and I continuously strive to improve my coding practices through regular learning and experimentation.\r\n"
//          		+ "\r\n"
//          		+ "Data-Driven Projects\r\n"
//          		+ "\r\n"
//          		+ "Data science is another area where I have made significant contributions. By leveraging my knowledge of data analysis, machine learning, and statistical modeling, I have been able to extract valuable insights from complex datasets. This has involved using tools like Pandas, NumPy, and Scikit-learn to preprocess data, build predictive models, and visualize results. My work in this field has not only enhanced my analytical skills but also demonstrated the transformative power of data in driving business decisions.\r\n"
//          		+ "\r\n"
//          		+ "One of the standout projects I have worked on is a personalized healthcare system that combines ML models with FastAPI and Streamlit dashboards. This project involved developing machine learning models to predict patient outcomes and integrating these models into a user-friendly web application. The use of FastAPI for the backend and Streamlit for the frontend allowed us to create a seamless and interactive experience for users. This project not only showcased my ability to blend backend logic with user-facing design but also highlighted the potential of technology to improve healthcare outcomes.\r\n"
//          		+ "\r\n"
//          		+ "Tech Stack and Tools\r\n"
//          		+ "\r\n"
//          		+ "My technical toolkit includes a diverse range of technologies and tools that I use to build and optimize solutions. Here are some of the key components of my tech stack:\r\n"
//          		+ "\r\n"
//          		+ "Java: My go-to language for building robust and scalable applications.\r\n"
//          		+ "Python: A versatile language that I use for everything from scripting to data analysis and machine learning.\r\n"
//          		+ "SQL: Essential for managing and querying relational databases.\r\n"
//          		+ "FastAPI: A modern web framework for building APIs with Python.\r\n"
//          		+ "Streamlit: A powerful tool for creating interactive web applications for data science projects.\r\n"
//          		+ "Pandas: A library for data manipulation and analysis.\r\n"
//          		+ "NumPy: A fundamental package for scientific computing with Python.\r\n"
//          		+ "Scikit-learn: A machine learning library for building and evaluating models.\r\n"
//          		+ "Git: A version control system that I use to manage code repositories and collaborate with other developers.\r\n"
//          		+ "VS Code: My preferred code editor, known for its versatility and extensive range of extensions.";      
        // Send text in chunks
        for (String chunk : aboutText.split("\r\n")) {
            aboutField.sendKeys(chunk);
            aboutField.sendKeys(Keys.RETURN);
        }
    }

    public void addSkills(String skills) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", skillsField);
        skillsField.click();
        typeSkills.click();
        action.sendKeys(skills).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    
    public boolean alert() {
    	if(errorMessage.isDisplayed()) {
    		return true;
    	}else {
    	return false;
    	}
    }
    
    public boolean successfulUpdate() {
    	waitUntilWebElementIsVisible(updated);
    	if(updated.isDisplayed()) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
