package com.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_write_issue {

	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = new Date();
		
		
		FileInputStream fis = new FileInputStream(projectPath+"/DB/Excel2.xlsx");
		Workbook excel = new XSSFWorkbook(fis);
		Sheet sheet = excel.getSheet("FO_Data");
		int excel_Last_Row = sheet.getPhysicalNumberOfRows();
		//Cell cell = null;
		
			System.out.println(excel_Last_Row);
			System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		  Row row = sheet.createRow(excel_Last_Row);	
		    Cell cell= row.createCell(0);
			cell.setCellValue(dateFormat.format(date));

	}

}
