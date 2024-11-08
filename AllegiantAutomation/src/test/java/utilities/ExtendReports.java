package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReports implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of report
	public static ExtentReports extent; // populate common info on the report
	public static ExtentTest test; // creating test case entries in the report
	String repName;

	public void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);

		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "QA");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome");
	}
	/* Only once bfore the execution start */

	public void onTestStart(ITestResult result) {
		System.out.println("On test start started");

	}
	/* Before test method onTest start will be executed */

	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success ");
		//test = extent.createTest(result.getName()); // create a new enty in the report
		//test.log(Status.PASS, "Test case PASSED is: " + result.getName()); // update status p/f/s
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("On test failed");
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("On test skipped ");
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test execution completed");
		extent.flush(); // write the information in report
	}
}
