import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
//import org.openqa.selenium.WebElement
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

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.enableAgentHandover'(true, 3)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

try {
    WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)
}
catch (Exception e) {
    KeywordUtil.logInfo('BOT IS TRAINED')
} 

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

for (int count = 1; count <= 3; count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

    WebUI.delay(1)
}

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 5]), agentHandover, FailureHandling.STOP_ON_FAILURE)

ArrayList handOverRoomID = new ArrayList()

handOverRoomID = CustomKeywords.'platform.Utility.getRoomID'()

String getHandOverID = handOverRoomID.get(0).toString()

CustomKeywords.'platform.Utility.overWriteTestData'(sheetName, rowNumber, cellNumber, getHandOverID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/settingsOnCuration'))

CustomKeywords.'platform.CurationSettings.disableAgentHandover'(true)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateSettings'))

//here we are on curation issues:
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

for (int count = 1; count <= 3; count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

    WebUI.delay(1)
}

ArrayList newRoomID = new ArrayList()

newRoomID = CustomKeywords.'platform.Utility.getRoomID'()

String roomID = newRoomID.get(0).toString()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyElementNotPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 20, FailureHandling.STOP_ON_FAILURE)

