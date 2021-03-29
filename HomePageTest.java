package com.practice.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test
	public void test() throws InterruptedException {
		
		Thread.sleep(5000);
		homePage.clickOpenSlideShow();
	}
}
