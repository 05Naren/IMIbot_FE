import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
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

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

/*CustomKeywords.'platform.Method.trainAndComment'(comment)

try {
    WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 10)
}
catch (Exception e) {
    KeywordUtil.logInfo('BOT IS TRAINED')
} */
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementPresent(findTestObject('Input/chatInput'), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 2]), botResponse, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Preview.downvoteResponseWithComment'(downvoteComment)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

CustomKeywords.'platform.Utility.overWriteTestData'(sheetName, rowNumber, cellNumber, roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

WebUI.waitForElementClickable(findTestObject('Input/roomID', [('value') : 'id']), 20, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Input/roomID', [('value') : 'id']), roomID, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/submitSession'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 10)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.mouseOver(findTestObject('Generic/webObjectWithText', [('textValue') : 'Downvoted with comment']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Downvoted with comment']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))