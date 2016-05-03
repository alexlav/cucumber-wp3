package com.swql.myapp.Framework;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.swql.myapp.Framework.DriverThread.getDriverThread;
import static com.swql.myapp.Framework.DriverThread.setUpThread;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import report.ExtentManager;
import report.ExtentTestManager;

public class BaseTestScript {

	public static ExtentReports extent;
	public ExtentTest test;
	public WebDriver driver;
	private static final int PASS = 1;
	private static final int FAIL = 2;
	private static final int SKIP = 3;

	private static final Map<Thread, WebDriver> DRIVERTHREADS = new HashMap<Thread, WebDriver>();

	public static WebDriver getDriver() {
		return DRIVERTHREADS.get(Thread.currentThread());
	}
	
	@BeforeSuite
	public void extentSetup(ITestContext context) {
		ExtentManager.setOutPutDirectory(context);
		extent = ExtentManager.getInstance();
	}

	/**
	 * set up runs before every test method runs
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void setUp(ITestContext context, Method method) throws Exception {
		setUpThread(context);
		ExtentTestManager.startTest(method.getName(), getMethodDesc(method));

		// Test categories assigned
		if (getMethodGroups(method) != null) {
			ExtentTestManager.getTest().assignCategory(getMethodGroups(method));
		}	

		DRIVERTHREADS.put(Thread.currentThread(), getDriverThread());

		// set the implicit time out to find elements
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String browser = context.getCurrentXmlTest().getParameter("browser");
		getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		String url = context.getCurrentXmlTest().getParameter("url");
		// get the web site URL
		getDriver().get(url);
	}

	@AfterMethod
	public void afterEachTestMethod(ITestResult iTestResult) {
		getDriver().close();

		ExtentTestManager.getTest().getTest()
			.setStartedTime(getTime(iTestResult.getStartMillis()));
		ExtentTestManager.getTest().getTest()
			.setEndedTime(getTime(iTestResult.getEndMillis()));

		switch (iTestResult.getStatus()) {
		case PASS:
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
			break;
		case FAIL:			
			ExtentTestManager.getTest().log(LogStatus.FAIL, 
					iTestResult.getThrowable());
			break;
		case SKIP:
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
			break;

		default:
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		}
		ExtentTestManager.closeTest();
	}

	/**
	 * tear down runs after every test runs
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() {
		// close the browser and WebDriver
		getDriver().quit();
	}

	/**
	 * After suite will be responsible to close the report properly at the end.
	 * You an have another afterSuite as well in the derived class and this one
	 * will be called in the end making it the last method to be called in test
	 * exe
	 */
	@AfterSuite
	public void generateReport() {
		ExtentManager.writeReport();
		ExtentManager.closeReport();
	}

	protected synchronized String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	private synchronized String getMethodNameDesc(Method method) {
		Test test = method.getAnnotation(Test.class);
		return test.testName().trim();
	}

	private synchronized String getMethodDesc(Method method) {
		Test test = method.getAnnotation(Test.class);
		return test.description().trim();
	}

	private synchronized String[] getMethodGroups(Method method) {
		Test test = method.getAnnotation(Test.class);
		return test.groups().length > 0 ? removeDuplicatedArrayItem(test.groups()) : null;
	}

	private synchronized String[] removeDuplicatedArrayItem(String[] array) {
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(array));
		// TODO Remove duplicated item in ignore-case
		return set.toArray(new String[0]);
	}

	private synchronized Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
