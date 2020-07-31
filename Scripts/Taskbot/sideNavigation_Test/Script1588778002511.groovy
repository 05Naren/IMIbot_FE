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

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

//WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot configuration']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Bot configuration', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nlp'))

//WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Input recognition']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

//WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Training data']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Training data', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

//WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Responses']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Responses', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

//WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Unresolved issues']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Unresolved issues', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Conversations']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Conversations', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']), 10, FailureHandling.STOP_ON_FAILURE)