package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		String title = loginPage.getTitle();
		Assert.assertEquals(title, "BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool");
	}
	
	@Test
	public void homePage() {
		
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		webDriver.quit();
	}

}
