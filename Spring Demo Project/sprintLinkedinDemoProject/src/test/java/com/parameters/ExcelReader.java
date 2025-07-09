package com.parameters;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String getCellValue(String sheetName, int rowNum, int colNum) {
        String value = null;

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Exceldata/Data.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            value = sheet.getRow(rowNum).getCell(colNum).toString();
            workbook.close();
        } catch (Exception e) {
            System.out.println("Error reading Excel: " + e.getMessage());
        }

        return value;
    }
}
