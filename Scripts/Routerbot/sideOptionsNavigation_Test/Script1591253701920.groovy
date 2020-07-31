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

CustomKeywords.'platform.Method.navigateToBot'('Router bots', GlobalVariable.ROUTER_BOT)

WebUI.delay(1)

WebUI.verifyTextPresent('Bot configuration', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/nlp'))

WebUI.delay(1)

WebUI.verifyTextPresent('Input recognition', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/logic'))

WebUI.delay(1)

WebUI.verifyTextPresent('Logic', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/session'))

WebUI.delay(1)

WebUI.verifyTextPresent('Conversations', false, FailureHandling.STOP_ON_FAILURE)