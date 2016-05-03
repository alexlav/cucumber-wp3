package com.swql.myapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import mx4j.tools.config.DefaultConfigurationBuilder.New;
import utils.WaitPageLoad;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;		
		//Assert title displayed		
		//Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Home Page incorrect!");		
	}
	
	@FindBy(how = How.CSS, using = "#menu-users .wp-menu-name")
	private WebElement lnkUser;
	@FindBy(how = How.XPATH, using = ".//li[@id='menu-users']//a[@href='user-new.php']")
	private WebElement lnkAddUser;

	public void AddUser() {
		Actions action = new Actions(driver);
		action.moveToElement(lnkUser).build().perform();
		WebElement lnkAddUser2 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(lnkAddUser));
		lnkAddUser2.click();		
	}	
}
