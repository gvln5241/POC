package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 **/

	WebDriver driver;

	@FindBy(id="main_menu")
	WebElement Home_Link_image_in_Header;

	@FindBy(id="main_livemkt")
	WebElement Live_Market_Link_in_Header;

	@FindBy(xpath="//a[contains(text(),'Equity Stock')]")
	WebElement Equity_Stocks;

	@FindBy(xpath="//input[@id='keyword']")
	WebElement HomePage_Search_Box;

	@FindBy(xpath="//span[@id='ajax_response']//li[@class='selected']")
	WebElement First_search_result;

	@FindBy(xpath="//select[@id='bankNiftySelect']")
	WebElement Stock_Category_DropDown;

	@FindBy(xpath="//div[@id='tabContent']")
	WebElement  FO_Table;

	String projectPath = System.getProperty("user.dir");

	public HomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void Navigate_to_Equity_Stocks() {

		Home_Link_image_in_Header.click();

		Live_Market_Link_in_Header.click();

		Equity_Stocks.click();		
	}

	public void Enter_Script_Name(String Script_ID) {
		HomePage_Search_Box.sendKeys(Script_ID);
		First_search_result.click();

	}

	public void Navigate_to_FO_stocks() {
		Navigate_to_Equity_Stocks();	

		Select Select_Stock_Category_DropDown = new Select(Stock_Category_DropDown);
		Select_Stock_Category_DropDown.selectByValue("foSec");

		//List <WebElement> Stock_Category_DropDown_Count = Select_Stock_Category_DropDown.getOptions();
		//System.out.println(Stock_Category_DropDown_Count.size());

		//System.out.println(FO_Table);

		//driver.findElement(By.xpath("//a[contains(text(),'Symbol')]")).click();
		//System.out.println(driver.findElement(By.xpath("//tr[3]//td[1]")).getText());

	}

	public void Open_Excel_and_write_FO_data() throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();


		FileInputStream fis = new FileInputStream(projectPath+"/DB/Excel2.xlsx");
		Workbook excel = new XSSFWorkbook(fis);
		Sheet sheet = excel.getSheet("FO_Data");
		int excel_Last_Row = sheet.getPhysicalNumberOfRows();
		Cell cell = null;

		for (int i=3; i<161 ;i++) {

			cell = sheet.createRow(excel_Last_Row+i-3).createCell(0);
			cell.setCellValue(dateFormat.format(date));


			for (int j=1; j<18;j++) {
				String data = driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]")).getText();
			
				cell = sheet.getRow(excel_Last_Row+i-3).createCell(j);
				cell.setCellValue(data);

			}
			//System.out.println(" ");
		}


		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(projectPath+"/DB/Excel2.xlsx");
			excel.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void Open_Script_In_New_Window() {
		
		System.out.println(driver.getTitle());
		String URL_in_New_Window = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//tr[3]//td[1]")).sendKeys(URL_in_New_Window);
		System.out.println(driver.getTitle());
		
	}
	
	
}
