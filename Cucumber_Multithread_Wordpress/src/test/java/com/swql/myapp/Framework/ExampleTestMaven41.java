package com.swql.myapp.Framework;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.swql.myapp.dataprovider.DataProviderClass;
import com.swql.myapp.pageobjects.AddNewUserPage;
import com.swql.myapp.pageobjects.AllUsersPage;
import com.swql.myapp.pageobjects.DeleteUsersPage;
import com.swql.myapp.pageobjects.HomePage;
import com.swql.myapp.pageobjects.LoginPage;

import utils.NameGenerator;
import validations.DatabaseValidation;

/**
 * The test class
 * @author SWQL - Lavado
 *
 */
public class ExampleTestMaven41 extends BaseTestScript {
	/**
	 * the test script
	 *  @throws Exception  
	 */		
	@Test(dataProvider="getDataFromCSV", dataProviderClass=DataProviderClass.class ,
			description="Test and validation for Wordpress.")
	public void testExample1(String username, String password) 
				throws Exception {
		LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);		
		loginPage.setUsername(username);
		loginPage.setUserpass(password);
		loginPage.clickLogin();
		
		HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);		
		homePage.AddUser();			
		
		AddNewUserPage addNewUserPage = PageFactory.initElements(getDriver(), AddNewUserPage.class);
		NameGenerator user = new NameGenerator();
		String usernameNew = user.getUsername();
		String firstnameNew = user.getName();
		String lastnameNew = user.getName();
		String websiteNew = user.getWebsite();		
		String emailNew = user.getEmail(firstnameNew, lastnameNew, websiteNew);
		String passwordNew = user.getName();
		String displayname = firstnameNew + " "+ lastnameNew;
		addNewUserPage.setUserName(usernameNew);
		addNewUserPage.setEmail(emailNew);
		addNewUserPage.setFirstName(firstnameNew);
		addNewUserPage.setLastNamel(lastnameNew);
		addNewUserPage.setWebsite(websiteNew);
		//addNewUserPage.setPassword(passwordNew);
		//addNewUserPage.setRepeatPassword(passwordNew);
		addNewUserPage.selectRoleContributor();			
		addNewUserPage.clickAddNewUser();
		
		AllUsersPage allUsersPage = PageFactory.initElements(getDriver(), AllUsersPage.class);
		allUsersPage.clickAllUsers();		
		allUsersPage.verificationlnkUsername(usernameNew);
		
		DatabaseValidation dbValidation = new DatabaseValidation();
		dbValidation.mySQLGetUser(usernameNew, websiteNew, displayname);
		
		allUsersPage.clickCheckBoxUser(usernameNew);
		allUsersPage.selectDeleteUser();
		allUsersPage.clickApply();
		
		DeleteUsersPage deleteUsersPage = PageFactory.initElements(getDriver(), DeleteUsersPage.class);
		//deleteUsersPage.clickDeleteAllPosts();
		deleteUsersPage.clickConfirmDeletion();
		dbValidation.mySQlGetUserNull(usernameNew);
	}	
}
