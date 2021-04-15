import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('WEB_OBJECTS/getText', [('value') : 'Articles']))

WebUI.comment(' *** THIS IS TO CHECK TEST SCENARIO BACKGROUND *** ')

String corpusState = WebUI.getText(findTestObject('Generic/articleState'), FailureHandling.OPTIONAL)

if (corpusState.contains('Trained')) {
    KeywordUtil.logInfo('BOT IS READY FOR PREVIEW')
} else {
    CustomKeywords.'platform.Method.trainAndComment'('TEST FOR LINK ON SESSION & CURATION')
}

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** EXECUTING GIVEN STEP *** ')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord("I'm not feeling good", Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/textLink'), 20, FailureHandling.CONTINUE_ON_FAILURE)

/*
 * Following code will downvote response, and extract session id for further use
 */
CustomKeywords.'platform.Preview.downvoteResponseWithoutComment'()

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

WebUI.comment(' *** EXECUTING WHEN STEP *** ')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

WebUI.waitForElementVisible(findTestObject('Input/roomID', [('value') : 'id']), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Session.searchByRoomID'(roomID)

WebUI.comment(' *** EXECUTING THEN STEP *** ')

WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 30, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

TestObject testObject = WebUI.modifyObjectProperty(findTestObject('WEB_OBJECTS/textLink'), 'xpath', 'not equals', newXpath, 
    true, FailureHandling.OPTIONAL) //The modified xpath will likely change;

WebUI.verifyElementPresent(testObject, 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

WebUI.comment(' *** VERFIY IN CURATION CONSOLE ***')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Unresolved issues']), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

testObject = WebUI.modifyObjectProperty(findTestObject('WEB_OBJECTS/textLink'), 'xpath', 'not equals', curXpath,
	true, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(testObject, 20, FailureHandling.CONTINUE_ON_FAILURE)