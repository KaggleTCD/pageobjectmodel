package com.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText = "Dashboard")
	WebElement openSlideShow;
	
	public HomePage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	public void clickOpenSlideShow(){
		
		openSlideShow.click();
	}

}
