import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

String roomID = getRoomIdAt.get(0).toString()

//room id which will added from session will be stored in test data to help fetch it during curation
CustomKeywords.'platform.Utility.overWriteTestData'(sheetName, rowNumber, cellNumber, roomID)

WebUI.setText(findTestObject('Input/roomID', [('value') : 'id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/submitSession'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/addToCurationFlag', [('index') : 1]))

WebUI.verifyElementPresent(findTestObject('NewRepo/messageInCuration'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/closePopup'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : ' From sessions ']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

//WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.verifyTextPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)