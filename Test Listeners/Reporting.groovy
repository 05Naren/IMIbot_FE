import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.codehaus.groovy.runtime.*
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ChartLocation
import com.aventstack.extentreports.reporter.configuration.Theme
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable


class Reporting {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;
	WebDriver driver;
	Capabilities cap;

	@BeforeTestSuite
	public void initiate(TestSuiteContext testSuiteContext){
		driver = DriverFactory.getWebDriver()
		cap = ((RemoteWebDriver)driver).getCapabilities()
		this.htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/testreport.html");
		this.extentReport = new ExtentReports();
		this.extentReport.attachReporter(htmlReporter);
		this.htmlReporter.config().setDocumentTitle(testSuiteContext.getTestSuiteId());
		this.htmlReporter.config().setReportName(testSuiteContext.getTestSuiteId());
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		this.extentReport.setSystemInfo("Browser Name", this.cap.getBrowserName().toString().toUpperCase());
		this.extentReport.setSystemInfo("Environment", RunConfiguration.executionProfile);
		this.extentReport.setSystemInfo("Test URL", GlobalVariable.URL);
	}

	@BeforeTestCase
	public void create(TestCaseContext testCaseContext){
		this.extentTest = extentReport.createTest(testCaseContext.getTestCaseId())
	}


	@AfterTestCase
	public void write(TestCaseContext testCaseContext){
		if(testCaseContext.getTestCaseStatus().contentEquals("PASSED")){
			this.extentTest.log(Status.PASS, MarkupHelper.createLabel(testCaseContext.getTestCaseId(), ExtentColor.GREEN));
		}else if(testCaseContext.getTestCaseStatus().contentEquals("FAILED")){
			this.extentTest.log(Status.FAIL, MarkupHelper.createLabel(testCaseContext.getTestCaseId(),
					ExtentColor.RED));
			this.extentTest.log(Status.INFO, testCaseContext.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(testCaseContext.getTestCaseId()+'.png').build())
		}else if(testCaseContext.getTestCaseStatus().contentEquals("ERROR")){
			this.extentTest.log(Status.ERROR, MarkupHelper.createLabel(testCaseContext.getTestCaseId(), ExtentColor.ORANGE))
			this.extentTest.log(Status.INFO, testCaseContext.getMessage())
		}
	}

	@AfterTestSuite
	public void generate(){
		this.extentReport.flush();
	}
}