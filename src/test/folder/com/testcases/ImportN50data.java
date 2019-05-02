package com.testcases;
import com.Util.ScreenShot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
	}
	
	@Test
	public void test_Import_N50_data() throws IOException {
		homepage = new HomePage(driver);
		
		homepage.Navigate_to_Equity_Stocks();	
		
		screenshot = new ScreenShot();
			
		screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\S1.png");
		
	}
	
	@AfterTest
	
	public void teardown() {
		driver.quit();
	}
	
}
