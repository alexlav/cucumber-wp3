package runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@Test
@CucumberOptions(
		features = {"src/test/resources/test.feature"},
		glue = {"glue"},
		format = {"pretty"}		
		)
public class LoginRunner extends AbstractTestNGCucumberTests{		
	
}
