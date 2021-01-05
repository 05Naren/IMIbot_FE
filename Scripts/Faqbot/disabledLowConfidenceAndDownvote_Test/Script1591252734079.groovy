import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

ArrayList oldRoomIdList = new ArrayList()

oldRoomIdList = CustomKeywords.'platform.Utility.getRoomID'()

String oldRoomID = oldRoomIdList.get(0).toString()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.CurationSettings.filterRuleTriggered'('Low confidence')

WebUI.verifyTextPresent(oldRoomID, false, FailureHandling.STOP_ON_FAILURE)

TestObject clearBtn = WebUI.modifyObjectProperty(findTestObject('Button/clear'), 'xpath', 'not equals', '//button[text()=\'Clear\']', 
    true, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(clearBtn)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/settingsOnCuration'))

CustomKeywords.'platform.CurationSettings.disableDownvoted'(true)

CustomKeywords.'platform.CurationSettings.disableLowConfidence'(true)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateSettings'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(1)

CustomKeywords.'platform.Preview.downvoteResponseWithoutComment'()

List<Object> newRoomIdList = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

newRoomID = newRoomIdList.get(0).toString()

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), newRoomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyTextNotPresent(newRoomID, false, FailureHandling.STOP_ON_FAILURE)

