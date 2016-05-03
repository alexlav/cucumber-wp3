package BDDTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class StepDefs {
	private SeleniumTest script;
	public void setupWebDriver() throws Exception{
		script = new SeleniumTest();
		script.setUp();
		script.gotoHomePage();	
	}
	
	public void tidyUp(){
		script.tearDown();		
	}
	
	@Given("^I am on the login_page")
	public void i_am_on_the_login_page() throws Throwable{
		//throw new PendingException();
		setupWebDriver();
	}
}
