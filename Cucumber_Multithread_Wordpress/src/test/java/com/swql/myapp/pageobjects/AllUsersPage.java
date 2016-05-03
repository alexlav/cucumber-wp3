package com.swql.myapp.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AllUsersPage {
	private WebDriver driver;

	public void AllUserPage(WebDriver driver) {
		this.driver = driver;
		// Verification All User Page
		Assert.assertTrue(driver.getTitle().contains("Users"), "All User Page not found ");
	}

	@FindBy(how = How.XPATH, using = ".//li[@id='menu-users']//ul[@class='wp-submenu wp-submenu-wrap']//a[@href='users.php']")
	private WebElement menuAllUsers;	
	@FindBy(how = How.XPATH, using=".//*[@class='tablenav bottom']//select")
	private WebElement ddAction; // Drop down element: Bulk Actions and Delete
	@FindBy(how = How.XPATH, using = ".//table[@class='wp-list-table widefat fixed striped users']//tbody[@id='the-list']//td[@class='username column-username']//a")
	private WebElement lnkUsername;
	@FindBy(how = How.XPATH, using = ".//table[@class='wp-list-table widefat fixed striped users']//tbody[@id='the-list']//tr/td[1]/strong/a")
	private List<WebElement> tblUsers;	
	//@FindBy(how = How.XPATH, using = ".//table[@class='wp-list-table widefat fixed users']//tbody[@id='the-list']//tr/td[1]/strong/a/parent::strong/parent::td/parent::tr/th[@class='check-column']/input")
	@FindBy(how = How.XPATH, using = ".//parent::th[@class='check-column']/input")
    private WebElement checkboxUser;	
	@FindBy(how=How.XPATH, using = ".//parent::strong/parent::td/parent::tr/th[@class='check-column']/label")
	private List<WebElement> tblLblCheckboxUser;
	@FindBy(how = How.XPATH, using = ".//*[@class='tablenav bottom']//input[@value='Apply']")
	private WebElement btnApply;
	
	public void clickApply(){
		btnApply.click();
	}
	
	public void selectDeleteUser(){
		Select action = new Select(ddAction);
		action.selectByValue("delete");
	}	
	
	public void clickAllUsers() {
		menuAllUsers.click();
	}
	
	public void verificationlnkUsername(String userCreated) {
		System.out.println("There are  " + tblUsers.size() + " users in wordpress");
		System.out.println("Last user created is  " + userCreated);
		int i = 0;
		for (WebElement user:tblUsers) {			
			if (user.getAttribute("innerHTML").toString().equals(userCreated)){
				System.out.println("User " + user.getAttribute("innerHTML").toString() + " exists");
				i++;
			}			
		}
		Assert.assertEquals(i, 1, "There are more identical usernames in Web application - Verification");
	}
	
	public void clickCheckBoxUser(String userCreated){
		String userToSelect="Select "+userCreated;
		System.out.println("user created: " + userCreated);		
		for (WebElement user:tblUsers){
			for (WebElement lblCheckboxUser:tblLblCheckboxUser){
				if(user.getAttribute("innerHTML").toString().equals(userCreated)
						&& lblCheckboxUser.getText().toString().equals(userToSelect)){				
					System.out.println("user to check: " + user.getAttribute("innerHTML").toString());					
					System.out.println("Clicking checkbox label: "+ lblCheckboxUser.getText().toString());					
					lblCheckboxUser.findElement(By.xpath(".//parent::th[@class='check-column']/input")).click();
				}	
			}
		}
	}
}
