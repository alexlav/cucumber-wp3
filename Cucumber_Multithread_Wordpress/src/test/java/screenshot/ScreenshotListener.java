package screenshot;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.LogStatus;

import report.ExtentTestManager;

public class ScreenshotListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		ITestContext iTestContext = iTestResult.getTestContext();
		String screenshotFile = Snapshot.takeScreenShot(iTestContext);

		ExtentTestManager.getTest().log(LogStatus.FAIL,
				"Failure Screenshot below: " + ExtentTestManager.getTest()
					.addScreenCapture(screenshotFile));		
	}
}
