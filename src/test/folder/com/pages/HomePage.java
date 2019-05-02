package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	
}
