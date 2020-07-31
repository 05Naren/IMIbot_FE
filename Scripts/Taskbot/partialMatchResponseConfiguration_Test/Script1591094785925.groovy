import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

TestData testData = findTestData('Data Files/testData_Task' // fetching test data
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Partial match ']))

WebUI.setText(findTestObject('Input/textResponse'), testData.getValue('partial_match_message', 1), FailureHandling.STOP_ON_FAILURE // configured partial match message
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'report_complain']), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'report_complain']))

WebUI.sendKeys(findTestObject('Input/utterance'), 'how can you help' //hardcoded question to generate partial match text
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addUtterance'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'(findTestData('Data Files/testData_Task').getValue('comment', 7 // setting comment value from test data
        ))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 60, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), testData.getValue('partial_match_message', 
        1), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))