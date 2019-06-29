package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Util.ScreenShot;
import com.pages.HomePage;

public class ImportOptionPrices {
	
	WebDriver driver;
	
	HomePage homepage;
	ScreenShot screenshot;
	
	@BeforeTest
	public void setup() {
		
		String ProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPath+"\\Drivers\\chromedriver.exe");
        
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
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=0, groups= {"WIP"})
	public void Import_Option_Data(){

		driver.get("https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?underlying=SUNPHARMA&instrument=OPTSTK&strike=370.00&type=PE&expiry=27JUN2019");
		
		//screenshot = new ScreenShot();
		//screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\OptionPrice1.png");
		
		System.out.println(driver.findElement(By.xpath("//span[@id='lastPrice']")).getText());
			
	}
	
	
}
