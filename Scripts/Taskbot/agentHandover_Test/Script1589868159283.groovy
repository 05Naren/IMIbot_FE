import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Handover and Inference' // navigating to handover & inference
        ]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/enableFallback' // fallback
        ))

WebUI.setText(findTestObject('Input/fallback'), testData.getValue('handover_value', 1 // setting values from the test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/enablePartialMatch' // partial match
        ))

WebUI.setText(findTestObject('Input/partialMatch'), testData.getValue('handover_value', 1 // setting values from the test data
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/retries' // retries
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateBot' // update bot
        ))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

// fallback handover test
for (int count = 1; count <= Integer.parseInt(testData.getValue('handover_value', 1)); count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

    //    WebUI.delay(1)
    WebUI.verifyElementPresent(findTestObject('GenericII/getBotResponse', [('index') : count + 1]), 15, FailureHandling.OPTIONAL)
}

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 4]), agentHandover, FailureHandling.STOP_ON_FAILURE)

ArrayList roomID = new ArrayList()

roomID = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Session.searchByRoomMetaData'('Agent handover happened')

WebUI.verifyTextPresent(roomID.get(0).toString(), false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/clear' // clear all filter
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

// retry handover test
for (int count = 1; count <= (Integer.parseInt(testData.getValue('handover_value', 1)) + 1); count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(retry, Keys.ENTER))

    //    WebUI.delay(3)
    WebUI.verifyElementPresent(findTestObject('GenericII/getBotResponse', [('index') : count + 1]), 15, FailureHandling.OPTIONAL)

    if (count == 3) {
        break
    }
    
    WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : count + 1]), testData.getValue('missing_entity_default_text', 
            1), FailureHandling.STOP_ON_FAILURE // verify retry bot message
        )
}

ArrayList newRoomID = new ArrayList()

newRoomID = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Session.searchByRoomID'(newRoomID.get(0).toString( // fetching room id using method
        ))

WebUI.verifyElementPresent(findTestObject('ICONS/sendToAgent'), 10, FailureHandling.STOP_ON_FAILURE)