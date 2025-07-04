package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddAboutPage extends BasePage{
	
	WebDriver driver;
	Actions action = new Actions(driver);
	@FindBy(xpath ="//textarea[@class='fb-gai-text__textarea  artdeco-text-input--input artdeco-text-input__textarea artdeco-text-input__textarea--align-top']")
	WebElement about;
	
	@FindBy(xpath ="//button[@id='form-component__typeahead-cta-ember72-button']")
	WebElement skills;
	
	@FindBy(xpath ="//input[@aria-label='Add skill']")
	WebElement typeSkills;

	public AddAboutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addAbout() {
		waitUntilElementIsClickable(about);
		about.sendKeys("I’m a passionate and curious tech enthusiast currently working at **Capgemini**, with a strong foundation in **Java, Python, and data science**. I thrive on building real-world solutions, from web applications to machine learning models, and I’m always exploring new ways to merge creativity with code.\r\n"
				+ "\r\n"
				+ "With hands-on experience in **automation testing (V\\&V), software development**, and **data-driven projects**, I enjoy collaborating across teams to solve complex problems and deliver impactful results. I've also taken part in hackathons and built projects like a **personalized healthcare system** that combines **ML models with FastAPI and Streamlit dashboards**, showcasing my ability to blend backend logic with user-facing design.\r\n"
				+ "\r\n"
				+ "🔧 **Tech Stack**: Java | Python | SQL | FastAPI | Streamlit | Pandas | NumPy | Scikit-learn | Git | VS Code\r\n"
				+ "\r\n"
				+ "🌱 **Currently Exploring**: AI/ML, system design, and cloud-based deployment\r\n"
				+ "\r\n"
				+ "🎯 **Career Goal**: To grow into a full-stack or AI engineer role where I can lead impactful projects, drive innovation, and continuously learn.\r\n"
				+ "\r\n"
				+ "Let’s connect and create something meaningful together!");
		
	}
	
	public void addSkills() {
		waitUntilElementIsClickable(skills);
		skills.click();
		waitUntilElementIsClickable(typeSkills);
		action.sendKeys("Software Development").sendKeys(Keys.TAB).build().perform();
	}

}
