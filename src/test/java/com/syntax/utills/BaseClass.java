package com.syntax.utills;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import bsh.org.objectweb.asm.Constants;


public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
    public static ExtentReports report;
    public static ExtentTest logger;
	

	
	@BeforeMethod(alwaysRun=true)
	public static void setUp() {
		
		ConfigsReader.readProperties(Constance.Credentials_FilePath);
		String browser=ConfigsReader.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			// For mac
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(ConfigsReader.getProperty("url"));
	}
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		driver.quit();
	}

	@BeforeTest(alwaysRun=true)
    public void generateReport() {
		ConfigsReader.readProperties(Constance.Credentials_FilePath);
        //create an object of extentReport and htmlReporter
        htmlReport=new ExtentHtmlReporter(Constance.REPORT_FILEPATH);
        report = new ExtentReports();
        report.attachReporter(htmlReport);
        //provide some info (optional)
        report.setSystemInfo("OS", Constance.OS_NAME);
        report.setSystemInfo("Environment", "Test");
        report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
        report.setSystemInfo("QA Engineer", Constance.USER_NAME);
        
    }

@AfterTest(alwaysRun=true)
public void flushReport() {
	   report.flush();
}
}
