//package com.pages;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//
//public class AddAboutPage extends BasePage{
//	WebDriver driver;
//	Actions action;
//	@FindBy(xpath ="//textarea[@class='fb-gai-text__textarea  artdeco-text-input--input artdeco-text-input__textarea artdeco-text-input__textarea--align-top']")
//	WebElement about;
//	
//	@FindBy(xpath ="//button[@id='form-component__typeahead-cta-ember72-button']")
//	WebElement skills;
//	
//	@FindBy(xpath ="//input[@aria-label='Add skill']")
//	WebElement typeSkills;
//
//	public AddAboutPage(WebDriver driver) {
//		super(driver);
//		this.action = new Actions(driver); 
//		// TODO Auto-generated constructor stub
//	}
//	
//	public void addAbout() {
//		waitUntilElementIsClickable(about);
//
//		String aboutText = "I’m a passionate and curious tech enthusiast currently working at Capgemini, with a strong foundation in Java, Python, and data science. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n" + "\r\n"
//                + "With hands-on experience in automation
//
//		
//	}
//	
//	public void addSkills() {
//		waitUntilElementIsClickable(skills);
//		skills.click();
//		waitUntilElementIsClickable(typeSkills);
//		action.sendKeys("Software Development").sendKeys(Keys.TAB).build().perform();
//	}
//}

//package com.pages;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//
//public class AddAboutPage extends BasePage {
//    WebDriver driver;
//    Actions action;
//
//    @FindBy(xpath ="//textarea[@class='fb-gai-text__textarea  artdeco-text-input--input artdeco-text-input__textarea artdeco-text-input__textarea--align-top']")
//    WebElement about;
//
//    @FindBy(xpath ="//button[@id='form-component__typeahead-cta-ember72-button']")
//    WebElement skills;
//
//    @FindBy(xpath ="//input[@aria-label='Add skill']")
//    WebElement typeSkills;
//
//    public AddAboutPage(WebDriver driver) {
//        super(driver);
//        this.driver = driver;
//        this.action = new Actions(driver); // Initialize Actions with the driver
//    }
//
//    public void addAbout() {
//        waitUntilElementIsClickable(about);
//        String aboutText = "I’m a passionate and curious tech enthusiast currently working at Capgemini, with a strong foundation in Java, Python, and data science. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n"
//                + "\r\n"
//                + "With hands-on experience in automation testing (V&V), software development, and data-driven projects, I enjoy collaborating across teams to solve complex problems and deliver impactful results. I've also taken part in hackathons and built projects like a personalized healthcare system that combines ML models with FastAPI and Streamlit dashboards, showcasing my ability to blend backend logic with user-facing design.\r\n"
//                + "\r\n"
//                + "Tech Stack: Java | Python | SQL | FastAPI | Streamlit | Pandas | NumPy | Scikit-learn | Git | VS Code\r\n"
//                + "\r\n"
//                + "Currently Exploring: AI/ML, system design, and cloud-based deployment\r\n"
//                + "\r\n"
//                + "Career Goal: To grow into a full-stack or AI engineer role where I can lead impactful projects, drive innovation, and continuously learn.\r\n"
//                + "\r\n"
//                + "Let’s connect and create something meaningful together!";
//        
//        // Send text in chunks
//        for (String chunk : aboutText.split("\r\n")) {
//            about.sendKeys(chunk);
//            about.sendKeys(Keys.RETURN);
//        }
//    }
//
//    public void addSkills() {
//        waitUntilElementIsClickable(skills);
//        skills.click();
//        waitUntilElementIsClickable(typeSkills);
//        action.sendKeys("Software Development").sendKeys(Keys.TAB).build().perform();
//    }
//}

//package com.pages;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class AddAboutPage extends BasePage {
//    WebDriver driver;
//    Actions action;
//    WebDriverWait wait;
//    @FindBy(xpath ="//textarea[@class='fb-gai-text__textarea  artdeco-text-input--input artdeco-text-input__textarea artdeco-text-input__textarea--align-top']")
//    WebElement about;
//
//    @FindBy(xpath ="//button[@id='form-component__typeahead-cta-ember72-button']")
//    WebElement skills;
//
//    @FindBy(xpath ="//input[@aria-label='Add skill']")
//    WebElement typeSkills;
//
//    public AddAboutPage(WebDriver driver) {
//        super(driver);
//        this.driver = driver;
//        this.action = new Actions(driver); // Initialize Actions with the driver
//    }
//
//    public void addAbout() {
//        waitUntilElementIsClickable(about);
//        String aboutText = "I’m a passionate and curious tech enthusiast currently working at Capgemini, with a strong foundation in Java, Python, and data science. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n"
//                + "\r\n"
//                + "With hands-on experience in automation testing (V&V), software development, and data-driven projects, I enjoy collaborating across teams to solve complex problems and deliver impactful results. I've also taken part in hackathons and built projects like a personalized healthcare system that combines ML models with FastAPI and Streamlit dashboards, showcasing my ability to blend backend logic with user-facing design.\r\n"
//                + "\r\n"
//                + "Tech Stack: Java | Python | SQL | FastAPI | Streamlit | Pandas | NumPy | Scikit-learn | Git | VS Code\r\n"
//                + "\r\n"
//                + "Currently Exploring: AI/ML, system design, and cloud-based deployment\r\n"
//                + "\r\n"
//                + "Career Goal: To grow into a full-stack or AI engineer role where I can lead impactful projects, drive innovation, and continuously learn.\r\n"
//                + "\r\n"
//                + "Let’s connect and create something meaningful together!";
//        
//        // Send text in chunks
//        for (String chunk : aboutText.split("\r\n")) {
//            about.sendKeys(chunk);
//            about.sendKeys(Keys.RETURN);
//        }
//    }
//
//    public void addSkills() {
//        wait = new WebDriverWait(driver, 20); // Increase wait time
//        wait.until(ExpectedConditions.elementToBeClickable(skills));
//        skills.click();
//        wait.until(ExpectedConditions.elementToBeClickable(typeSkills));
//        action.sendKeys("Software Development").sendKeys(Keys.TAB).build().perform();
//    }
//}


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
import org.testng.Assert;

public class AddAboutPage extends BasePage {
    WebDriver driver;
    Actions action;
    
    @FindBy(xpath ="//textarea[@id='gai-text-form-component-profileEditFormElement-SUMMARY-profile-ACoAAD-ezrEBBg2rc9JVoInotAHvukqigQez-tE-summary']")
    WebElement about;

    @FindBy(xpath ="//button[@id='form-component__typeahead-cta-ember72-button']")
    WebElement skills;

    @FindBy(xpath ="//input[@sria-label='Add skill']")
    WebElement typeSkills;
    
    @FindBy(className ="artdeco-inline-feedback__message")
    WebElement errorMessage;
    

    public AddAboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver); // Initialize Actions with the driver
    }

    public void addAbout() {
        waitUntilElementIsClickable(about);
        String aboutText = "I’m a passionate and curious tech enthusiast currently working at Capgemini, with a strong foundation in Java, Python, and data science. My journey in the tech world has been driven by an insatiable curiosity and a relentless desire to solve real-world problems through innovative solutions. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n"
                + "\r\n"
                + "Professional Experience and Skills\r\n"
                + "\r\n"
                + "With hands-on experience in automation testing (V&V), software development, and data-driven projects, I have developed a robust skill set that allows me to tackle complex challenges and deliver impactful results. My role at Capgemini has provided me with numerous opportunities to work on diverse projects, each contributing to my growth as a versatile and skilled professional.\r\n"
                + "\r\n"
                + "Automation Testing (V&V)\r\n"
                + "\r\n"
                + "In the realm of automation testing, I have honed my skills in verifying and validating software systems to ensure they meet the highest standards of quality and performance. My expertise in this area includes designing and implementing automated test scripts, conducting thorough testing cycles, and identifying and resolving defects. This meticulous approach ensures that the software products I work on are reliable, efficient, and user-friendly.\r\n"
                + "\r\n"
                + "Software Development\r\n"
                + "\r\n"
                + "As a software developer, I have been involved in the entire software development lifecycle, from conceptualization and design to implementation and maintenance. My proficiency in Java and Python has enabled me to build robust and scalable applications that meet the specific needs of clients and end-users. I am adept at writing clean, efficient, and maintainable code, and I continuously strive to improve my coding practices through regular learning and experimentation.\r\n"
                + "\r\n"
                + "Data-Driven Projects\r\n"
                + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff\r\n";
 //               + "\r\n"
 //               + "Data science is another area where I have made significant contributions. By leveraging my knowledge of data analysis, machine learning, and statistical modeling, I have been able to extract valuable insights from complex datasets. This has involved using tools like Pandas, NumPy, and Scikit-learn to preprocess data, build predictive models, and visualize results. My work in this field has not only enhanced my analytical skills but also demonstrated the transformative power of data in driving business decisions.\r\n"
                
//                + "\r\n"
//                + "One of the standout projects I have worked on is a personalized healthcare system that combines ML models with FastAPI and Streamlit dashboards. This project involved developing machine learning models to predict patient outcomes and integrating these models into a user-friendly web application. The use of FastAPI for the backend and Streamlit for the frontend allowed us to create a seamless and interactive experience for users. This project not only showcased my ability to blend backend logic with user-facing design but also highlighted the potential of technology to improve healthcare outcomes.\r\n"
//                + "\r\n"
//                + "Tech Stack and Tools\r\n"
//                + "\r\n"
//                + "My technical toolkit includes a diverse range of technologies and tools that I use to build and optimize solutions. Here are some of the key components of my tech stack:\r\n"
//                + "\r\n"
//                + "Java: My go-to language for building robust and scalable applications.\r\n"
//                + "Python: A versatile language that I use for everything from scripting to data analysis and machine learning.\r\n"
//                + "SQL: Essential for managing and querying relational databases."
//                + "FastAPI: A modern web framework for building APIs with Python."
//                + "Streamlit: A powerful tool for creating interactive web applications for data science projects.\r\n"
//                + "Pandas: A library for data manipulation and analysis.\r\n"
//                + "NumPy: A fundamental package for scientific computing with Python.\r\n"
//                + "Scikit-learn: A machine learning library for building and evaluating models.\r\n"
//                + "Git: A version control system that I use to manage code repositories and collaborate with other developers.\r\n"
//                + "VS Code: My preferred code editor, known for its versatility and extensive range of extensions.\r\n";
                
                
                
                
        // Send text in chunks
        for (String chunk : aboutText.split("\r\n")) {
            about.sendKeys(chunk);
            about.sendKeys(Keys.RETURN);
        }
    }

    public void addSkills() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Correct usage of WebDriverWait
//        wait.until(ExpectedConditions.elementToBeClickable(skills));
//        skills.click();
//        wait.until(ExpectedConditions.elementToBeClickable(typeSkills));
//        action.sendKeys("Software Development").sendKeys(Keys.TAB).build().perform();
    	JavascriptExecutor js =(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,300)");
    }
    
    public boolean alert() {
    	if(errorMessage.isDisplayed()) {
    		return true;
    	}else {
    	return false;
    	}
    }
}
