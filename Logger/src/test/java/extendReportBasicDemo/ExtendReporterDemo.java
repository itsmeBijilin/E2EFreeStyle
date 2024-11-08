package extendReportBasicDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterDemo {
	public static void main(String[] args) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extendReports.html");

		// create Extend Reports and attach reporters
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(sparkReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extend.createTest("Google search test", "Google search functionality");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		test1.log(Status.INFO, "Starting test case");
		test1.pass("Navigated to google.com");

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cricket"+Keys.ENTER);
		test1.pass("Enter text in searchbox");

		
		test1.pass("Pressed Keyboard enter key");

		driver.close();
		driver.quit();
		test1.pass("Closed the window");
		test1.info("Test completed");

		extend.flush(); // only logs will be entered
	}
}
