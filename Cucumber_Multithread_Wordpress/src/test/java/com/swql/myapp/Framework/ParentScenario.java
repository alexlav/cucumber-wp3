package com.swql.myapp.Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;

import com.swql.myapp.pageobjects.HomePage;
import com.swql.myapp.pageobjects.LoginPage;

public class ParentScenario {
	private WebDriver driver;
	protected LoginPage loginPage;
	protected HomePage homePage;

	protected void startBrowser() {
		driver = new FirefoxDriver();

		// set the implicit time out to find elements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
	}

	protected void navigateTo() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.get("http://localhost/wordpress/wp-login.php");
		
	}

	protected void closeBrowser() {
		driver.quit();
	}

}
