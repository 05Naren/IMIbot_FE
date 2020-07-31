import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), testData.getValue('room_id', 1 // fetching room id saved from last fallback message to filter value in curation issues
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyElementPresent(findTestObject('ICONS/downvote'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addToNewIntent'))

WebUI.verifyElementText(findTestObject('Generic/header'), 'Create intent', FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/intentName'), testData.getValue('intent_name', 4))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Slots/linkEntity'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'order_id' // hardcoded entity to link
        ]))

WebUI.check(findTestObject('Slots/checkbox', [('rowValue') : 1]))

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : 1]), '2' // retries value is hardcoded
    )

WebUI.setText(findTestObject('Slots/templateKey', [('rowValue') : 1]), testData.getValue('missing_entity', 2))

CustomKeywords.'platform.Training.createInstantResponse'(findTestData('Data Files/testData_Task').getValue('missing_entity', 
        2), testData.getValue('missing_entity_default_text', 2 // creating response from intent, template key and value taken fron test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                'missing_entity', 2)]))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), testData.getValue('final_template', 2 // final template value set from test data which will be updated to dynamic type
        ))

CustomKeywords.'platform.Training.createInstantResponse'(findTestData('Data Files/testData_Task').getValue('missing_entity', 
        3), testData.getValue('missing_entity_default_text', 3 // creating response from intent, template key and value taken fron test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 4 // setting comment value from test data
        ))

/*if (WebUI.getText(findTestObject('Generic/modelState'), FailureHandling.OPTIONAL).contains('Training')) {
    WebUI.delay(10)
} else {
    KeywordUtil.logInfo('BOT IS READY!')
}*/

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), testData.getValue('missing_entity_default_text', 
        2), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('00001234', Keys.ENTER))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), testData.getValue('missing_entity_default_text', 
        3), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))