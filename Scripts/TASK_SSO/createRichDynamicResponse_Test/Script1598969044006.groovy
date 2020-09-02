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

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

TestData testData = findTestData('Data Files/testData_Task' // created path for test data
    )

/*
 * Rich & Dynamic response creation, all values fetched from test data where value is fetched from column row
 */
CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 1), testData.getValue('rich_template_value', 
        1))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 2), testData.getValue('rich_template_value', 
        2))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 3), testData.getValue('rich_template_value', 
        3))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 5), testData.getValue('rich_template_value', 
        5))

// creation of dynamic response
CustomKeywords.'platform.Response.createDynamicResponse'(testData.getValue('dynamic_template', 1), testData.getValue('dynamic_template_file', 
        1))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Welcome message ']), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Welcome message ']))

CustomKeywords.'platform.Response.createDynamicResponse'(testData.getValue('dynamic_template', 2), testData.getValue('dynamic_template_file', 
        2))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

