import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Response.createDynamicResponse'(testData.getValue('dynamic_template', 4), testData.getValue('dynamic_template_file', 
        4))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Welcome message ']))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 4), testData.getValue('rich_template_value', 
        4))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Workflows']))

WebUI.uploadFile(findTestObject('Input/uploadFile'), (RunConfiguration.getProjectDir() + '/Collection/') + 'workflow.txt')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Training.addMultipleUtterance'(testData, 'callback_utterance' // data file has been hardcoded
    )

WebUI.sendKeys(findTestObject('Input/intentName'), 'callback')

WebUI.sendKeys(findTestObject('Input/finalTempKey'), 'fire callback' // final template value hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'callback', FailureHandling.STOP_ON_FAILURE // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 8 // setting comment value from test data
        ))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 60, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 3]), 60, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), callbackResponse, FailureHandling.STOP_ON_FAILURE)

