package com.swql.myapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.NameGenerator;

public class AddNewUserPage {
	private WebDriver driver;	
		
	public AddNewUserPage(WebDriver driver){
		this.driver = driver;
		//Page Verification
		Assert.assertTrue(driver.getTitle().contains("Add New User"), "New User Page incorrect!");		
	}
	
	@FindBy(how = How.ID, using = "user_login")
	private WebElement txtUserLogin;
	public void setUserName(String userLogin){
		txtUserLogin.clear();
		txtUserLogin.sendKeys(userLogin);
	}
	
	@FindBy(how = How.ID, using="email")
	private WebElement txtEmail;
	public void setEmail(String email){
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	@FindBy(how = How.ID, using="first_name")
	private WebElement txtFirstName;
	public void setFirstName(String firstName){
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}
	
	@FindBy(how = How.ID, using="last_name")
	private WebElement txtLastName;
	public void setLastNamel(String lastName){
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	
	@FindBy(how = How.ID, using = "url")
	private WebElement txtWebsite;
	public void setWebsite(String website){
		txtWebsite.clear();
		txtWebsite.sendKeys(website);
	}
	
	@FindBy(how = How.ID, using = "pass1")
	private WebElement txtPassword;
	public void setPassword(String password){
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	@FindBy(how = How.ID, using = "pass2")
	private WebElement txtRepeatPassword;
	public void setRepeatPassword(String repeatPassword){
		txtRepeatPassword.clear();
		txtRepeatPassword.sendKeys(repeatPassword);
	}
	
	@FindBy(how = How.ID, using="role")
	private WebElement ddRole; // Drop down element	
	public void selectRoleContributor(){		
		Select role = new Select(ddRole);		
		role.selectByValue("contributor");		
	}
	
	@FindBy(how = How.ID, using = "createusersub")
	private WebElement btnAddNewUser;
	public void clickAddNewUser(){
		btnAddNewUser.click();
	}	
	
}
