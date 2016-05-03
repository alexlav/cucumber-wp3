package glue;

import com.swql.myapp.Framework.ParentScenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat; 

public class StepDefinitions extends ParentScenario{
	@Before
	public void beforeSceneario(){
		startBrowser();
	}
	
	@Given ("^I am on the Wordpress Loginpage")
	public void I_am_on_thé_Wordpress_loginpage(){		
		navigateTo();
	}
		
	@When("^I authenticate as admin")
	public void I_authenticate_as_admin(){
		
		loginPage.setUsername("administrator");
		loginPage.setUserpass("administrator");
		loginPage.clickLogin();
	}
	
	@Then("^I shoudl see title of Homepage")
	public void I_showul_see_title_on_homepage(){
		homePage.AddUser();
	}
	
	@After
	public void afterScenario(){
		closeBrowser();
	}
}
