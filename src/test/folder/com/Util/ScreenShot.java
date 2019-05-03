package com.Util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ScreenShot {

	@Test
	public void take_snap(WebDriver driver, String fileWithPath) throws IOException {
		
		//connect web driver object
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//move img to new destination
	    File DestFile = new File(fileWithPath);
		
	    //Copy file at destination
	    FileUtils.copyFile(scrFile,DestFile);
		
	}
	
	@Test
	//with robot class, we can take the screenshot like system print screen
	//This can be used in capturing the alerts / pop-ups
	public void take_PrintScreen(String fileWithPath) throws IOException, AWTException {
		//create object to robot
		Robot robot = new Robot();
		
		//create rectangle of desktop
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		//create screen of the desktop
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		
		//save the image to local
		ImageIO.write(screenFullImage, "png", new File(fileWithPath));
	}
	
}
