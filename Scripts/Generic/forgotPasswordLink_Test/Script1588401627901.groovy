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

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/changePasswordLink'))

WebUI.verifyElementText(findTestObject('GenericII/forgetHeader'), 'Forgot password?', FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/email'), GlobalVariable.USERNAME)

WebUI.verifyElementClickable(findTestObject('GenericII/resetEmailBtn'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/resetEmailBtn'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('GenericII/emailSentIcon'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementClickable(findTestObject('GenericII/continueToSignInBtn'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/continueToSignInBtn'))

