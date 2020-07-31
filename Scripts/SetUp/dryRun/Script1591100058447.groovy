import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot configuration']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Bot configuration', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Management']))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot status']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Bot status', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Security']))

//WebUI.delay(3)
WebUI.verifyElementPresent(findTestObject('NewRepo/inputConsentDisclaimer'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Handover and Inference']))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Inference']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Inference', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Integrations']))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Chat Agent Platforms']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Chat Agent Platforms', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/nlp'))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Input recognition']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Input recognition', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Knowledge base']))

//WebUI.delay(3)
WebUI.verifyElementPresent(findTestObject('NewRepo/newConceptBtn'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/articles'))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Knowledge base']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Knowledge base', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Curation']))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Unresolved issues']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Unresolved issues', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/session'))

//WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Conversations']), 10, FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyTextPresent('Conversations', false, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']))

//WebUI.delay(3)
//WebUI.verifyTextPresent('History', false, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'History']), 10, FailureHandling.STOP_ON_FAILURE)

