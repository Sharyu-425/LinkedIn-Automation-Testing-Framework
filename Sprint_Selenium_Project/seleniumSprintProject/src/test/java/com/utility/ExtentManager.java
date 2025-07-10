package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFolderPath;
	
	public static ExtentReports getInstance() {
		//if extent exists then just return it , 
		//after first scenario it will not be null when called for 2nd
		//because it is static , it belongs to the class 
		//no matter how many objects of extentMananger is created
		if(extent==null) {
			String timeStamp = new SimpleDateFormat("dd-MM-yy_HH-mm-ss").format(new Date());
			reportFolderPath = System.getProperty("user.dir")+"/Reports/LogData_" + timeStamp;
			
			String reportPath = reportFolderPath+"/LinkedIn_Automation_Report.html";
			extent = new ExtentReports(reportPath,true);
			extent.addSystemInfo("User","Raghav")
				  .addSystemInfo("Platform","Windows")
				  .addSystemInfo("Project","LinkedIn Automation");
		}
		return extent;
	}
	
	public static String getReportFolderPath() {
		return reportFolderPath;
	}
}
