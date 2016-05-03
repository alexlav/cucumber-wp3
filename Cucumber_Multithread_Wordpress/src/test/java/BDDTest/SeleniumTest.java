package BDDTest;

import java.awt.print.Printable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SeleniumTest {
	private WebDriver driver;
	private String baseURL;
	private String browserName;
	private String browserVersion;
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		baseURL = "http://localhost/wordpress";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
		browserName = caps.getBrowserName();
		browserVersion = caps.getVersion();
		System.out.println("Automates tests running on " + browserName+ " " + browserVersion);
				
	}
	
	public void tearDown(){
		driver.quit();
	}
	
	public void gotoHomePage(){
		driver.get(baseURL);
	}
	
}
