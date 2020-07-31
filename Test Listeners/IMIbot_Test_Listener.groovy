import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class IMIbot_Test_Listener {

	/*
	 * Setting up test link before test cases, display environment on which test cases are to run 
	 */

	@BeforeTestCase
	def setUp(){
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.maximizeWindow()
	}

	/*@BeforeTestSuite
	def testSetUp(){
		WebUI.openBrowser(GlobalVariable.URL)

		WebUI.maximizeWindow()

		WebUI.sendKeys(findTestObject('Input/username'), GlobalVariable.USERNAME)

		WebUI.sendKeys(findTestObject('Input/password'), GlobalVariable.PASSWORD)

		WebUI.click(findTestObject('Button/signIn'))

		if (!(WebUI.waitForElementPresent(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL))) {
			WebUI.waitForPageLoad(10)
		}
	}*/
}
