package com.Util;

import java.io.File;
import java.io.IOException;

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
	
	
}
