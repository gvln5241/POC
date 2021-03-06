package com.testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Util.ScreenShot;
import com.pages.FoPage;
import com.pages.HomePage;

public class ImportOptionPrices {

	static String projectPath = System.getProperty("user.dir");

	WebDriver driver;

	HomePage homepage;
	FoPage fopage;
	ScreenShot screenshot;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");

		//https://www.built.io/blog/run-selenium-tests-in-headless-browser
		// headless browser setting are taken form above site

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://nseindia.com/");
		homepage = new HomePage(driver);
		fopage = new FoPage(driver);

		//FoPage foPage = PageFactory.initElements(driver, FoPage.class);
	}


	@AfterTest
	public void teardown() {
		driver.quit();
	}


	@Test(priority=0, groups= {"Ready"})
	public void Import_Option_Data() throws IOException{

		FileInputStream fis = new FileInputStream(projectPath+"/DB/Excel2.xlsx");
		Workbook excel = new XSSFWorkbook(fis);
		Sheet sheet = excel.getSheet("Main");

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());

			driver.get(sheet.getRow(i).getCell(0).getStringCellValue());

			//System.out.println("CMP - " + Last_Price.getText());
			System.out.println("CMP - " + driver.findElement(By.xpath("//span[@id='lastPrice']")).getText());
			System.out.println("Max - " + driver.findElement(By.xpath("//div[@id='dayHigh']")).getText());
			System.out.println("IV  - " + driver.findElement(By.xpath("//span[@id='impliedVolatility']")).getText());

			Cell cell = sheet.getRow(i).createCell(1);
			cell.setCellValue(driver.findElement(By.xpath("//span[@id='lastPrice']")).getText());

			cell = sheet.getRow(i).createCell(2);
			cell.setCellValue(driver.findElement(By.xpath("//div[@id='dayHigh']")).getText());

			cell = sheet.getRow(i).createCell(3);
			cell.setCellValue(driver.findElement(By.xpath("//span[@id='impliedVolatility']")).getText());


		}

		fis.close();

		FileOutputStream fio = new FileOutputStream(projectPath+"/DB/Excel2.xlsx");
		excel.write(fio);
		fio.close();

	}


}
