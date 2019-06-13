package com.pages;

import java.io.IOException;

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
	
	@FindBy(xpath="//input[@id='keyword']")
    WebElement HomePage_Search_Box;
	
	@FindBy(xpath="//span[@id='ajax_response']//li[@class='selected']")
    WebElement First_search_result;
	
	
	public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void Navigate_to_Equity_Stocks() throws IOException {
				
		Home_Link_image_in_Header.click();
				
		Live_Market_Link_in_Header.click();
		
		Equity_Stocks.click();		
	}

	public void Enter_Script_Name(String Script_ID) {
		HomePage_Search_Box.sendKeys(Script_ID);
		First_search_result.click();
		
	}
}
