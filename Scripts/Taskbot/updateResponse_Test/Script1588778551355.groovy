import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Training.addMultipleUtterance'(testData, 'stock_check_utterance' // data file has been hardcoded
    )

WebUI.sendKeys(findTestObject('Input/intentName'), testData.getValue('intent_name', 2))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), testData.getValue('dynamic_template', 3 // final template value set from test data which will be updated to dynamic type  
        ))

CustomKeywords.'platform.Training.createInstantResponse'(testData.getValue('dynamic_template', 3), 'Setting default value. Will be converted to dynamic type' // setting default value at instant creation
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'stock_check', FailureHandling.OPTIONAL // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'stock_check_template ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Rich']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/dynamic'))

WebUI.uploadFile(findTestObject('Input/uploadFile'), (RunConfiguration.getProjectDir() + '/Collection/') + testData.getValue(
        'dynamic_template_file', 3 // uploading file from test data, location path provided is hardcoded
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))