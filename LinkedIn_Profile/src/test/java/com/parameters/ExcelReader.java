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


	public String[] provideAbout(String filename) {
	    String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\"+filename;
		String userAbout[]=new String[4];
		File file=new File(path);
		FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
 
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet excel= workbook.getSheetAt(0);
			userAbout[0]= excel.getRow(4).getCell(0).getStringCellValue();
			userAbout[1]= excel.getRow(6).getCell(0).getStringCellValue();
			userAbout[2]= excel.getRow(5).getCell(0).getStringCellValue();
			userAbout[3]= excel.getRow(6).getCell(0).getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAbout;
	}
 
	
	public String[] getProjectDetails(String filename) {
		String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\"+filename;
		String userProject[]=new String[6];
		File file=new File(path);
		FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
 
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet excel= workbook.getSheetAt(0);
			userProject[0]= excel.getRow(7).getCell(0).getStringCellValue();
			userProject[1]= excel.getRow(8).getCell(0).getStringCellValue();
			userProject[2]= excel.getRow(6).getCell(0).getStringCellValue();
			userProject[3]= excel.getRow(9).getCell(0).getStringCellValue();
			userProject[4]= excel.getRow(9).getCell(1).getStringCellValue();
			userProject[5]= excel.getRow(9).getCell(2).getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userProject;		
}
	public String[] getVolunteerExperienceDetails(String filename) {
		String path = "C:\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\LinkedInAutomation\\src\\test\\resource\\ExcelData\\"+filename;
		String userExperience[]=new String[3];
		File file=new File(path);
		FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
 
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet excel= workbook.getSheetAt(0);
			userExperience[0]= excel.getRow(0).getCell(3).getStringCellValue();
			userExperience[1]= excel.getRow(1).getCell(3).getStringCellValue();
			userExperience[2]= excel.getRow(2).getCell(3).getStringCellValue();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userExperience;		
}
}

