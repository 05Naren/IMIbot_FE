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

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Training.addMultipleUtterance'(testData, 'handover_utterance' //column name has been hardcoded
    )

WebUI.sendKeys(findTestObject('Input/intentName'), testData.getValue('intent_name', 5 // intent name fetched from test data sheet
        ))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), 'Agent handover' // final template value hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Agent handover']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'agent_handover', FailureHandling.STOP_ON_FAILURE // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 5 // setting comment value from test data
        ))

/*if (WebUI.getText(findTestObject('Generic/modelState'), FailureHandling.OPTIONAL).contains('Training')) {
    WebUI.delay(10)
} else {
    KeywordUtil.logInfo('BOT IS READY!')
}
*/
WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('connect me to agent', Keys.ENTER))

//WebUI.delay(3)
WebUI.verifyElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE // verify bot response
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

for (int count = 1; count < 3; count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('Could you please help me', Keys.ENTER))

    WebUI.verifyElementPresent(findTestObject('GenericII/getBotResponse', [('index') : count + 1]), 20, FailureHandling.OPTIONAL)
}

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 4]), botResponse, FailureHandling.STOP_ON_FAILURE // verify bot response
    )

ArrayList roomID = new ArrayList()

roomID = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Agent handover']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID.get(0).toString( // filter by room id
        ))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/filter'))

WebUI.verifyTextPresent(roomID.get(0).toString(), false, FailureHandling.STOP_ON_FAILURE)