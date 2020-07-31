import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', 'QA_Template_Test')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

WebUI.uploadFile(findTestObject('Input/uploadFile'), filePath)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/import'))

