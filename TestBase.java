package com.practice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.practice.util.WebEventListener;

public class TestBase {
	
	public static WebDriver webDriver;
	public static Properties properties;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;
	
	public TestBase() {
		
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Selenium\\pageobjectmodel\\src\\main\\java\\com\\practice\\config\\config.properties");
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browser = properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Gecko Driver\\geckodriver.exe");
			webDriver = new FirefoxDriver();
		}
		
		eventFiringWebDriver = new EventFiringWebDriver(webDriver);
		webEventListener = new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		webDriver = eventFiringWebDriver;
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(com.practice.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(com.practice.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		webDriver.get(properties.getProperty("url"));
	}

}
