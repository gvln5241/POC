package com.testcases;
import com.Util.ScreenShot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.pages.HomePage;

public class ImportN50data {

	WebDriver driver;
	String ProjectPath;

	HomePage homepage;
	ScreenShot screenshot;

	@BeforeTest
	public void setup() {
		ProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPath+"\\Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");

		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://nseindia.com/");
		homepage = new HomePage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority=1, groups= {"Ready"},enabled = false)
	public void test_Import_N50_data() throws IOException, AWTException {

		homepage.Navigate_to_Equity_Stocks();	

		screenshot = new ScreenShot();

		screenshot.take_snap(driver, ProjectPath+"\\Screens\\S1.png");

		screenshot.take_PrintScreen(ProjectPath+"\\Screens\\S1prtsc.png");

		screenshot.crop_WebElement(driver, driver.findElement(By.xpath("//div[@class='logo']//a//img")), ProjectPath+"\\Screens\\elementscreen2.png");

	}


	@Test(priority=0, groups= {"WIP"},enabled = false)
	public void Import_Script_data() throws IOException, InterruptedException{

		homepage.Enter_Script_Name("SBIN");
		Thread.sleep(2000);

		screenshot.take_snap(driver, ProjectPath+"\\Screens\\Script1.png");
	}

	@Test(priority=2, groups= {"WIP"},enabled=true)
	public void FO_Page() throws IOException {
		homepage.Navigate_to_FO_stocks();
		homepage.Open_Excel_and_write_FO_data();
		//homepage.Open_Script_In_New_Window();
	}


}
