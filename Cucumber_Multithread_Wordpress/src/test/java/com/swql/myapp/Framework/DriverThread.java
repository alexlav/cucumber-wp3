package com.swql.myapp.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;

public class DriverThread {
	
	private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<WebDriver>();
	
	public static void setUpThread(ITestContext context) throws Exception{
		String browser = context.getCurrentXmlTest().getParameter("browser");
		WebDriver driver = null;
		if(browser.equals("firefox")){
			//load the Firefox Driver
			driver = new FirefoxDriver();			
		}
		else if(browser.equals("chrome")){
			String chromeDriverPath = context.getCurrentXmlTest().getParameter("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			//load the Google Chrome driver			
			driver = new ChromeDriver();
		}		
		setDriverThread(driver);		
	}
	
	private static void setDriverThread(WebDriver driver){
		THREAD_LOCAL.set(driver);
	}
	
	public static WebDriver getDriverThread(){
		return THREAD_LOCAL.get();
	}
}
