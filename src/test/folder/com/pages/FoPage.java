package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@id='lastPrice']")
	protected WebElement Last_Price;
	
	@FindBy(xpath="//div[@id='dayHigh']")
	protected WebElement Day_High;
	
	@FindBy(xpath="//span[@id='impliedVolatility']")
	protected WebElement IV_info;
	
	public FoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}
	

}
