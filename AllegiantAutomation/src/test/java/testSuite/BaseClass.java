package testSuite;

import java.io.FileInputStream;
import java.net.SocketException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

import utilities.ExtendReports;

public class BaseClass {
	public static Logger logger; // log4j
	public static WebDriver driver;

	public String getUserProperties(String input) throws Exception {
		Properties prop = new Properties();
		FileInputStream FIS = new FileInputStream(System.getProperty("user.dir")+"\\user.properties");
		String url = null;
		prop.load(FIS);
		url = prop.getProperty(input);
		return url;
	}
	
	public void reportsLogs(String input,String log) throws Exception {
		ExtendReports.test=ExtendReports.extent.createTest(input);
		Status status=ExtendReports.test.getStatus();
		String stat=status.toString();
		if(stat.equals("Pass")) {
			ExtendReports.test.log(Status.PASS, log);
		}
		else if(stat.equals("Fail")) {
			ExtendReports.test.log(Status.FAIL, log);
		}
	}
	
	@BeforeClass
	public void beforeClass() throws Exception {
		logger=LogManager.getLogger(this.getClass());
		
		
		ChromeOptions capability = new ChromeOptions();
		capability.setAcceptInsecureCerts(true);
		
		if(getUserProperties("browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(capability);
		}
		else if(getUserProperties("browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(getUserProperties("browser").equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(getUserProperties("allegiantUrl"));
	}
	
	@AfterClass
	public void afterClass() throws SocketException {
		driver.quit();
		BaseClass.logger.info("Session Terminated");
	}
}
