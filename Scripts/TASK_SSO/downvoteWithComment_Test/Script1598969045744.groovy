import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

try {
    WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)
}
catch (Exception e) {
    KeywordUtil.logInfo('BOT IS TRAINED!')
} 

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('Generic/botReponse', [('index') : 2]), 10, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 2]), botResponse, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Preview.downvoteResponseWithComment'(findTestData('Data Files/testData_Task').getValue('comment', 
        3))

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

CustomKeywords.'platform.Utility.overWriteTestData'('Task bot', 1, 0, roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

WebUI.waitForElementClickable(findTestObject('Input/roomID', [('value') : 'id']), 20, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Input/roomID', [('value') : 'id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/submitSession'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.mouseOver(findTestObject('Generic/webObjectWithText', [('textValue') : 'Downvoted with comment']))

WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Downvoted with comment']), 10, 
    FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))