import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))


CustomKeywords.'platform.Training.addMultipleUtterance'(findTestData('Data Files/testData_Task'), 'first_intent_utterance' // data file has been hardcoded
    )

WebUI.sendKeys(findTestObject('Input/intentName'), findTestData('Data Files/testData_Task').getValue('intent_name', 1))

WebUI.check(findTestObject('Slots/checkbox', [('rowValue') : 1]))

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : 1]), '2' // retry value has been hardcoded
    )

WebUI.setText(findTestObject('Slots/templateKey', [('rowValue') : 1]), findTestData('Data Files/testData_Task').getValue(
        'missing_entity', 1 // missing entity name has been taken from the data file
        ))

CustomKeywords.'platform.Training.createInstantResponse'(findTestData('Data Files/testData_Task').getValue('missing_entity', 
        1), findTestData('Data Files/testData_Task').getValue('missing_entity_default_text', 1 // creating response from intent, template key and value taken fron test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'city_not_found' // template key selected has been hardcoded
        ]))

//CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/slotReset'))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), findTestData('Data Files/testData_Task').getValue('final_template', 
        1 // final template value set from test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'delivery_info', FailureHandling.STOP_ON_FAILURE // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'(findTestData('Data Files/testData_Task').getValue('comment', 1 // setting comment value from test data
        ))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

int count

for (count = 1; count <= 3; count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

    WebUI.delay(1)

    if (count == 3) {
        break
    }
    
    WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : count + 1]), findTestData('Data Files/testData_Task').getValue(
            'missing_entity_default_text', 1), FailureHandling.STOP_ON_FAILURE)
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))