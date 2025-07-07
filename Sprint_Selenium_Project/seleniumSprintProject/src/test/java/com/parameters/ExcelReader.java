package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private Workbook workbook;
	private Sheet sheet;
	
	
	//Constructor
	public ExcelReader(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			workbook =new XSSFWorkbook(fis);
		}catch(IOException e){
			System.out.println("Failed to load Excel file"+ e.getMessage());
		}
	}
	
	//Row Data as a Map (heading -> value)
	public Map<String,String> getRowData(String sheetName,int rowNum){
		Map<String,String>rowData = new HashMap<>();
		sheet = workbook.getSheet(sheetName);
		Row headerRow = sheet.getRow(0);
		Row dataRow = sheet.getRow(rowNum);
		
		DataFormatter formatter = new DataFormatter();
		
		int totalColumns = headerRow.getLastCellNum();
		
		for(int i=0;i<totalColumns;i++) {
			String header = formatter.formatCellValue(headerRow.getCell(i)).trim();
			String value = formatter.formatCellValue(dataRow.getCell(i)).trim();
			rowData.put(header,value);
		}
		
		return rowData;		
	}
	
	
}
