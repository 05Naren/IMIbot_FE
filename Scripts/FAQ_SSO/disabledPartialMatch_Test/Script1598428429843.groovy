import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/settingsOnCuration'))

CustomKeywords.'platform.CurationSettings.disablePartialMatch'(true)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateSettings'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

/*WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), partialMatch, FailureHandling.STOP_ON_FAILURE)
*/
CustomKeywords.'platform.Preview.verifyBotTextResponse'(userQuery, 2, partialMatch)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

roomID = getRoomIdAt.get(0).toString()

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyTextNotPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)

