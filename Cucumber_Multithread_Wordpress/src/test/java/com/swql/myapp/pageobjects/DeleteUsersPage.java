package com.swql.myapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DeleteUsersPage {
	private WebDriver driver;
	
	public DeleteUsersPage(WebDriver driver){
		this.driver = driver;
		// Verification Delete Users Page
		Assert.assertTrue(driver.getTitle().contains("Users"), "User Page not found");
	}
	
	@FindBy(how = How.XPATH, using=".//*[@id='updateusers']/div/fieldset/ul/li[1]/label")
	private WebElement lblDeleteAllPosts;
	public void clickDeleteAllPosts(){
		lblDeleteAllPosts.click();
	}
	@FindBy(how=How.XPATH, using = ".//*[@id='submit' and @value='Confirm Deletion']")
	private WebElement btnConfirmDeletion;
	public void clickConfirmDeletion(){
		btnConfirmDeletion.click();
	}
	
	
}
