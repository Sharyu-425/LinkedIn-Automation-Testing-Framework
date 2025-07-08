package com.parameters;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
	public String[] provideIntroData(String firstname, String lastname) {
	    String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\FormData.xlsx";
	    String name[] = firstname.split("");
	    String sirname[] = lastname.split("");
 
	    int nameRow = Integer.parseInt(name[0]);
	    int nameCell = Integer.parseInt(name[1]);
 
	    int sirnameRow = Integer.parseInt(sirname[0]);
	    int sirnameCell = Integer.parseInt(sirname[1]);
 
	    String[] data = new String[2];
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
 
	    try {
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        Sheet excel = workbook.getSheetAt(0);
	        data[0] = excel.getRow(nameRow).getCell(nameCell).getStringCellValue();
	        data[1] = excel.getRow(sirnameRow).getCell(sirnameCell).getStringCellValue();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (fis != null) {
	                fis.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
 
	    return data;
	}
 
	public String[] provideAbout(String about, String skills) {
	    String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\FormData.xlsx";
	    String[] aboutCoords = about.split(",");
	    String[] skillsCoords = skills.split(",");

	    int userAboutRow = Integer.parseInt(aboutCoords[0].trim());
	    int userAboutCell = Integer.parseInt(aboutCoords[1].trim());

	    int userSkillsRow = Integer.parseInt(skillsCoords[0].trim());
	    int userSkillsCell = Integer.parseInt(skillsCoords[1].trim());

	    String[] data = new String[2];
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;

	    try {
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        Sheet excel = workbook.getSheetAt(0);

	        Row aboutRow = excel.getRow(userAboutRow);
	        Row skillsRow = excel.getRow(userSkillsRow);

	        if (aboutRow != null && aboutRow.getCell(userAboutCell) != null) {
	            data[0] = aboutRow.getCell(userAboutCell).getStringCellValue();
	        } else {
	            data[0] = ""; // or throw an exception or log a warning
	        }

	        if (skillsRow != null && skillsRow.getCell(userSkillsCell) != null) {
	            data[1] = skillsRow.getCell(userSkillsCell).getStringCellValue();
	        } else {
	            data[1] = ""; // or throw an exception or log a warning
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (workbook != null) workbook.close();
	            if (fis != null) fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return data;
	}


//	public String[] provideAbout(String about, String skills) {
//	    String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\FormData.xlsx";
//	    String[] userAbout = about.split("");
//	    String[] userSkills = skills.split("");
//	    
// 
//	    int userAboutRow = Integer.parseInt(userAbout[0]);
//	    int userAboutCell = Integer.parseInt(userAbout[1]);
//	    
//	    int userSkillsRow = Integer.parseInt(userSkills[0]);
//	    int userSkillsCell = Integer.parseInt(userSkills[1]);
// 
//	    String[] data = new String[2];
//	    FileInputStream fis = null;
//	    XSSFWorkbook workbook = null;
// 
//	    try {
//	        fis = new FileInputStream(path);
//	        workbook = new XSSFWorkbook(fis);
//	        Sheet excel = workbook.getSheetAt(0);
//	        data[0] = excel.getRow(userAboutRow).getCell(userAboutCell).getStringCellValue();
//	        data[1] = excel.getRow(userSkillsRow).getCell(userSkillsCell).getStringCellValue();
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            if (workbook != null) {
//	                workbook.close();
//	            }
//	            if (fis != null) {
//	                fis.close();
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
// 
//	    return data;
//	}
 
	
	public String[] userDetailsReader(String projectName, String description, String skills, String title, String linkDescription, String contributors) {
		String path="C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\FormData.xlsx";
		String[] userProjectName = projectName.split("");
	    String[] projectDescription = description.split("");
	    String[] skillsUsed = skills.split("");
	    String[] projectTitle = title.split("");
	    String[] describeLink = linkDescription.split("");
	    String[] projectContributors = contributors.split("");

 
	    int userProjectNameRow = Integer.parseInt(userProjectName[0]);
	    int userProjectNameCell = Integer.parseInt(userProjectName[1]);
	    
	    int projectDescriptionRow = Integer.parseInt(projectDescription[0]);
	    int projectDescriptionCell = Integer.parseInt(projectDescription[1]);
	    
	    int skillsUsedRow = Integer.parseInt(skillsUsed[0]);
	    int skillsUsedCell = Integer.parseInt(skillsUsed[1]);
	    
	    int projectTitleRow = Integer.parseInt(projectTitle[0]);
	    int projectTitleCell = Integer.parseInt(projectTitle[1]);
	    
	    int describeLinkRow = Integer.parseInt(describeLink[0]);
	    int describeLinkCell = Integer.parseInt(describeLink[1]);
	    
	    int projectContributorsRow = Integer.parseInt(projectContributors[0]);
	    int projectContributorsCell = Integer.parseInt(projectContributors[1]);
 
	    String[] data = new String[6];
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
 
	    try {
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        Sheet excel = workbook.getSheetAt(0);
	        data[0] = excel.getRow(userProjectNameRow).getCell(userProjectNameCell).getStringCellValue();
	        data[1] = excel.getRow(projectDescriptionRow).getCell(projectDescriptionCell).getStringCellValue();
	        data[2] = excel.getRow(skillsUsedRow).getCell(skillsUsedCell).getStringCellValue();
	        data[3] = excel.getRow(projectTitleRow).getCell(projectTitleCell).getStringCellValue();
	        data[4] = excel.getRow(describeLinkRow).getCell(describeLinkCell).getStringCellValue();
	        data[5] = excel.getRow(projectContributorsRow).getCell(projectContributorsCell).getStringCellValue();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (fis != null) {
	                fis.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
 
	    return data;
}
}