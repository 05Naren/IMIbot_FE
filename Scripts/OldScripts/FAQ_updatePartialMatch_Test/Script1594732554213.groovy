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

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

//CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/articles'))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

if (WebUI.verifyElementPresent(findTestObject('Generic/nextPage'), 5, FailureHandling.OPTIONAL)) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nextPage'))
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Partial match']))

WebUI.setText(findTestObject('Input/textResponse'), customMessage)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementNotPresent(findTestObject('Button/train'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Thank you')

