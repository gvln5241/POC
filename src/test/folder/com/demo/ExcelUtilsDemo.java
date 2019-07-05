package com.demo;

import com.Util.ExcelUtils;

public class ExcelUtilsDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		String projectPath= System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/DB/Excel1.xlsx","Main");
		
		System.out.println(excel.getRowCount());
		excel.getCellDataString(1, 0);
		//excel.getCellDataNumber(1, 0);
	}

}
