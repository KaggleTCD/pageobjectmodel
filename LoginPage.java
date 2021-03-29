package com.practice.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "user_email_login")
	WebElement email;
	
	@FindBy(id = "user_password")
	WebElement password;
	
	@FindBy(xpath = "//*[@type = 'submit' and @value = 'Sign me in']")
	WebElement loginButton;
	
	
	public LoginPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle() throws InterruptedException {
		
		Thread.sleep(10000);
		String title = webDriver.getTitle();
		return title;
	}
	
	
	public HomePage login(String username,String passWord) {
		
		email.sendKeys(username);
		password.sendKeys(passWord);
		loginButton.sendKeys(Keys.ENTER);
		return new HomePage();
	}

}
