package com.Util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	//https://www.youtube.com/watch?v=CV3SOorFydE
	//Selenium Framework for Beginners 18 | How to use Excel for getting data in Selenium Java Framework
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String sheetName) {


		try {
			//projectPath =System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args ) { 

		getCellDataString(0,0);
		getCellDataNumber(1,0);
	}

	public static void getRowCount() {

		try {

			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void getCellDataString(int rowNum, int colNum) {
		try {

			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {

			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

}
