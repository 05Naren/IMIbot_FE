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
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.CHILD_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByConsumerID'(consumerID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : consumerID]))

WebUI.verifyTextPresent(mgrRoomID, false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/dashboard'))

WebUI.delay(5)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', 'BankBot 2020')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByConsumerID'(consumerID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : consumerID]))

WebUI.verifyTextPresent(mgrRoomID, false, FailureHandling.STOP_ON_FAILURE)

