package com.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

    public void loadProperties() {
        try {
            prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("PropertyFiles/profile.properties");
            if (input == null) {
                throw new FileNotFoundException("profile.properties not found in classpath");
            }
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeBrowser() {
        loadProperties();
        String browser = prop.getProperty("browser");
        boolean maximize = Boolean.parseBoolean(prop.getProperty("maximize"));

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Boolean.parseBoolean(prop.getProperty("disableNotifications"))) {
                    chromeOptions.addArguments("--disable-notifications");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Browser not supported");
                break;
        }

        if (maximize) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void loadPage() {
        driver.get(prop.getProperty("url"));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}