import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('TASK_SSO/botCreation_Test'), [('nameOfTheBot') : GlobalVariable.NONE_INTENT], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Default fallback intent']), 20, 
    FailureHandling.STOP_ON_FAILURE // hard coded intent name
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Default fallback intent']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'Default fallback intent', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Input/intentName'), 'readonly', 'true', 10, FailureHandling.STOP_ON_FAILURE // verify state of intent name field
    )

WebUI.verifyElementAttributeValue(findTestObject('Input/finalTempKey'), 'readonly', 'true', 10, FailureHandling.STOP_ON_FAILURE // verify state of template key field
    )

TestData testData = findTestData('Data Files/testData_Task')

for (int count = 1; count < testData.getRowNumbers(); count++) {
    if (testData.getValue('default_intent_utterance', count) == '') {
        break
    } else {
        WebUI.sendKeys(findTestObject('Input/utterance'), testData.getValue('default_intent_utterance', count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addUtterance'))

        WebUI.waitForElementHasAttribute(findTestObject('Button/addUtterance'), 'disabled', 20)
    }
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 6 // setting comment value from test data
        ))

/*if (WebUI.getText(findTestObject('Generic/modelState'), FailureHandling.OPTIONAL).contains('Training')) {
    WebUI.delay(10)
} else {
    KeywordUtil.logInfo('BOT IS READY!')
}*/
WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('default test utterance', Keys.ENTER))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE // verify bot response
    )

ArrayList roomID = new ArrayList()

roomID = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

//WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID.get(0).toString( // filter by room id
//))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/filterByIntentOnCuration'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Default fallback intent']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyTextNotPresent(roomID.get(0).toString(), false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/settingsOnCuration'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/noneIntent'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateSettings'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('default_intent_utterance', 1), Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 15, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE // verify bot response
    )

ArrayList newRoomID = new ArrayList()

newRoomID = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

WebUI.verifyTextPresent(newRoomID.get(0).toString(), false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Default fallback intent']))

List<StringBuilder> utterance = WebUiCommonHelper.findWebElements(findTestObject('Slots/listOfUtterance'), 10)

// Delete all utterance from intent
for (int count = 0; count < utterance.size(); count++) {
    WebUI.mouseOver(WebUI.convertWebElementToTestObject(utterance.get(count)))

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/trashIconOnUtterance'))

    WebUI.delay(1)
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.sendKeys(findTestObject('Input/searchUtterance'), '0')

WebUI.verifyElementText(findTestObject('Generic/listOfIntents'), 'Default fallback intent', FailureHandling.STOP_ON_FAILURE)

