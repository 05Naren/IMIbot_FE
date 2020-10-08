import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/userOptions'))
WebUI.verifyElementText(findTestObject('Generic/enterpriseName'), GlobalVariable.ENTERPRISE_NAME, FailureHandling.OPTIONAL)
WebUI.verifyElementText(findTestObject('Generic/userDesgination'), GlobalVariable.USER_DESIGNATION, FailureHandling.OPTIONAL)
*/
WebUI.verifyElementPresent(findTestObject('Generic/enterpriseIcon'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Generic/userInitials'), GlobalVariable.USER_INITIALS, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Generic/userInitials'))

//CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/userOptions'))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/eProfile'))

WebUI.verifyElementPresent(findTestObject('Generic/updateBtn'), 15, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.logOut'()

WebUI.verifyElementText(findTestObject('Generic/textOnLoginPage'), testValue, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

