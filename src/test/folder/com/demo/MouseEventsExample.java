package com.demo;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.Util.ScreenShot;

public class MouseEventsExample {
    
	static ScreenShot screenshot;
	
    public static void main(String[] args) throws IOException {
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.chrome.driver", "D:/Learn/Drivers/chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                driver.get(baseUrl);           
                WebElement link_Home = driver.findElement(By.linkText("Home"));
                WebElement td_Home = driver
                        .findElement(By
                        .xpath("//html/body/div"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr"));    
                 
                Actions builder = new Actions(driver);
                Action mouseOverHome = builder
                        .moveToElement(link_Home)
                        .build();
                 
                String bgColor = td_Home.getCssValue("background-color");
                System.out.println("Before hover: " + bgColor);        
                
                screenshot = new ScreenShot();
    			screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\M1.png");
        		
    			
                mouseOverHome.perform();        
                bgColor = td_Home.getCssValue("background-color");
                System.out.println("After hover: " + bgColor);
                
                screenshot = new ScreenShot();
    			screenshot.take_snap(driver, "D:\\Learn\\BitBucket\\GITPOC\\Screens\\M2.png");
        		
                
                driver.close();
        }
}
