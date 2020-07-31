import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Router bots', GlobalVariable.ROUTER_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery1, Keys.ENTER))

WebUI.delay(2)

CustomKeywords.'platform.Preview.downvoteResponseWithComment'(comment)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery2, Keys.ENTER))

WebUI.delay(2)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))

List<StringBuilder> getSession = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getSession.get(0).toString()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByRoomMetaData'('Downvoted')

WebUI.setText(findTestObject('Input/roomID', [('value') : 'id']), roomID)

CustomKeywords.'platform.Utility.overWriteTestData'('Router bot', 1, 1, roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/submitSession'))

WebUI.waitForElementVisible(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.verifyTextPresent('Downvoted with comment', false, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Generic/webObjectWithText', [('textValue') : 'Upvoted']), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Upvoted', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

CustomKeywords.'platform.Utility.overWriteTestData'('Router bot', 1, 2, WebUI.getText(findTestObject('NewRepo2/extractConsumerID')))