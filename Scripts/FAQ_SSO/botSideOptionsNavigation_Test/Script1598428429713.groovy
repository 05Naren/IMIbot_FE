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

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
//CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/sidebarSettings'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot configuration']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Management']))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot status']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Security']))

WebUI.verifyElementPresent(findTestObject('NewRepo/inputConsentDisclaimer'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Handover and Inference']))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Inference']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Integrations']))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Chat Agent Platforms']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nlp'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Input recognition']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Knowledge base']))

WebUI.verifyElementPresent(findTestObject('NewRepo/newConceptBtn'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Knowledge base']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Curation']))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Unresolved issues']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Conversations']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']), 10, FailureHandling.STOP_ON_FAILURE)