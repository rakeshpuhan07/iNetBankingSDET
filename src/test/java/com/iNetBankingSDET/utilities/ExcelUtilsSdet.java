package com.iNetBankingSDET.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsSdet {
	
	public static Object[][] readExcel(String filePath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);  //FIle path is the location of excel file which is coming from DataProviders class
        Workbook workbook = new XSSFWorkbook(fis); 
        Sheet sheet = workbook.getSheet(sheetName); //opens the excel sheet and started reading

        int rowCount = sheet.getPhysicalNumberOfRows(); 
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];  // excluding header

        for (int i = 1; i < rowCount; i++) {   // start from row 1 (skip header)
            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

}
