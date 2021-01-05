import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver

import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class IMIbot_Test_Listener {

	/*
	 * Setting up test link before test cases, display environment on which test cases are to run 
	 */

	/*@BeforeTestCase
	 def setUp(){
	 WebUI.openBrowser(GlobalVariable.URL)
	 WebUI.maximizeWindow()
	 }*/



	/*@BeforeTestSuite
	def setUpEnvironment(){
		//		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.maximizeWindow()
		WebUI.sendKeys(findTestObject('Input/username'), GlobalVariable.USERNAME)
		WebUI.sendKeys(findTestObject('Input/password'), GlobalVariable.PASSWORD)
		WebUI.click(findTestObject('Button/signIn'))
		if (!(WebUI.waitForElementPresent(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL))) {
			WebUI.waitForPageLoad(10)
		}
	}*/

	@BeforeTestSuite
	def botBuilderSetUp(){
		//		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.openBrowser(GlobalVariable.CONNECT_URL)
		WebUI.maximizeWindow()
	}

	@AfterTestSuite
	def displayExecutionInfo(){
		WebDriver driver = DriverFactory.getWebDriver()
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities()

		FileWriter fw=new FileWriter("D:\\IMIbot.ai-Project\\SuiteRunDetails.txt");
		fw.write('ENVIRONMENT: '+ RunConfiguration.executionProfile+'\n')
		fw.write('URL: '+ GlobalVariable.URL+'\n')
		fw.write('RUN DATE: '+ java.time.LocalDate.now()+'\n')
		fw.write('MACHINE NAME: ' + RunConfiguration.getHostName()+'\n')
		fw.write('0S: ' + RunConfiguration.getOS()+'\n')
		fw.write('BROWSER NAME: ' + cap.getBrowserName().toString().toUpperCase()+'\n')
		fw.write("BROWSER VERSION: "+ cap.getVersion().toString())
		fw.close();
	}
}
