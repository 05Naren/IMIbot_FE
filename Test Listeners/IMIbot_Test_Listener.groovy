import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class IMIbot_Test_Listener {

	/*
	 * Setting up test link before test cases, display environment on which test cases are to run 
	 */

	@BeforeTestCase
	def setUp(){
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.maximizeWindow()
	}

	@AfterTestSuite
	def displayExecutionInfo(){
		WebDriver driver = DriverFactory.getWebDriver()
		KeywordUtil.logInfo('BROWSER NAME:' + DriverFactory.getExecutedBrowser().getName())
		KeywordUtil.logInfo('BROWSER VERSION:' + DriverFactory.getBrowserVersion(driver))
		KeywordUtil.logInfo('ENVIRONMENT:' + RunConfiguration.getExecutionProfile())
		KeywordUtil.logInfo('0S:' + RunConfiguration.getOS())
		KeywordUtil.logInfo('ENVIRONMENT:' + RunConfiguration.getHostName())
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities()
		KeywordUtil.logInfo(cap.getBrowserName().toString()+' :'+ cap.getVersion().toString())
	}
}
