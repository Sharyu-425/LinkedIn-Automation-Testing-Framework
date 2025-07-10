package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	
	public static String captureScreenshot(WebDriver driver,String scenarioName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("dd-MM-yy_HH-mm-ss").format(new Date());
		String folderPath = ExtentManager.getReportFolderPath();
		String filePath = folderPath+"/Screenshots/"+scenarioName+"_"+timestamp+".png";
		File dest = new File(filePath);
		dest.getParentFile().mkdir(); // autogenerates the screenshots folder 
		FileUtils.copyFile(src, dest);		
		return filePath;
	}
}
