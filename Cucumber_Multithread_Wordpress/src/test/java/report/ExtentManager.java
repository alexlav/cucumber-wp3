package report;

import java.io.File;

import org.testng.ITestContext;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	private static ITestContext iTestContext;

	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			File outPutDirectory = new File(iTestContext.getOutputDirectory());
			File resultDirectory = new File(outPutDirectory.getParentFile(), "ExtentReport");
			extent = new ExtentReports(resultDirectory + File.separator + 
						"ExtentReport.html", true, DisplayOrder.OLDEST_FIRST);
		}
		return extent;
	}
	public static void setOutPutDirectory(ITestContext iTestContext) {
		ExtentManager.iTestContext = iTestContext;
	}
	public static void writeReport() {
		if (extent != null) {
			extent.flush();
		}
	}
	public static void closeReport() {
		if (extent != null) {
			extent.close();
		}
	}
}