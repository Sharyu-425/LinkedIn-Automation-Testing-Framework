package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class ScreenshotTest {
	public static void captureScreen(WebDriver driver,String filename) throws IOException {
//		1st way
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+filename+".png");
		FileUtils.copyFile(src, dest);
		
//		2nd way
		TakesScreenshot screen1 = (TakesScreenshot) driver;
		File src1 = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./Screenshot/"+filename+".png"));
		
//		3rd way
		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("./Screenshot/"+filename+".png"));
		
		
	}
	
	public static String takeScreen(WebDriver driver, String filename) throws IOException {
		TakesScreenshot screen1 = (TakesScreenshot)driver;
		File src1 = screen1.getScreenshotAs(OutputType.FILE);
		String screens ="C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\Screenshot\\"+filename+".png";
		File dest = new File(screens);
		FileUtils.copyFile(src1, dest);
		return screens;
	}
	
	/*public static void takeScreen(WebDriver driver) throws IOException {
		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("./Screenshot/"+timestamp()+" "+".png"));
		
	}
	*/
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	
}