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

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Task bots']))

WebUI.waitForElementVisible(findTestObject('Generic/webObjectWithText', [('textValue') : testBot]), 45, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testBot]))

WebUI.waitForElementVisible(findTestObject('Generic/training'), 45, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

CustomKeywords.'platform.Training.createEntity'('pin-code', 'Regex', regex_value)

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'pin-code']), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Response.createRichResponse'(temp_key, key_value)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Response.createRichResponse'(missing_key, new_key_value)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

WebUI.waitForElementVisible(findTestObject('Button/createIntent'), 30, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Training.addSingleUtterance'('do you deliver?')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Slots/linkEntity'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'pin-code']))

WebUI.check(findTestObject('Slots/checkbox', [('rowValue') : 1]))

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : 1]), '2' // retries value is hardcoded
	)

WebUI.setText(findTestObject('Slots/templateKey', [('rowValue') : 1]), missing_key)

WebUI.setText(findTestObject('Input/finalTempKey'), temp_key)

WebUI.setText(findTestObject('Input/intentName'), 'service')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.verifyTextPresent('Training data', false, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.trainAndComment'('service intent added')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.CONTINUE_ON_FAILURE)