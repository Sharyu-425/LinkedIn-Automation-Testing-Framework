package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String prefix) {
        try {
            // Create screenshots directory if it doesn't exist
//            File screenshotDir = new File("/screenshots");
//            if (!screenshotDir.exists()) {
//                screenshotDir.mkdirs();

// Save to project root /screenshot
        	String screenshotPath = System.getProperty("user.dir") + "/screenshot";
        	File screenshotDir = new File(screenshotPath);
        	if (!screenshotDir.exists()) {
        		screenshotDir.mkdirs();

            }

            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Generate filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = prefix + "_" + timestamp + ".png";
            File dest = new File(screenshotDir, fileName);

            // Save file
            FileUtils.copyFile(src, dest);
            System.out.println("📸 Screenshot saved at: " + dest.getAbsolutePath());
            return dest.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}