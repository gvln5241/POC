package com.testcases;
import com.Util.ScreenShot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.pages.HomePage;

public class ImportN50data {
	
	WebDriver driver;
	
	HomePage homepage;
	ScreenShot screenshot;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Learn/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://nseindia.com/");
		homepage = new HomePage(driver);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1, groups= {"ready"})
	public void test_Import_N50_data() throws IOException, AWTException {
		
		homepage.Navigate_to_Equity_Stocks();	
		
		screenshot = new ScreenShot();
			
		screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\S1.png");
		
		screenshot.take_PrintScreen("D:\\Learn\\BitBucket\\GITPOC\\Screens\\S1prtsc.png");
		
		screenshot.crop_WebElement(driver, driver.findElement(By.xpath("//div[@class='logo']//a//img")), "D:\\Learn\\BitBucket\\GITPOC\\Screens\\elementscreen2.png");
				
	}
	
	@Test(priority=0, groups= {"WIP"})
	public void Import_Script_data() throws IOException, InterruptedException{

		homepage.Enter_Script_Name("SBIN");
		Thread.sleep(2000);
		
		screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\Script1.png");
	}
		
	
}
