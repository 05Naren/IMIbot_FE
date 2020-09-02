import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/sidebarSettings'))

WebUI.waitForElementPresent(findTestObject('Button/updateBot'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.enableADP'(true)

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

WebUI.verifyElementPresent(findTestObject('NewRepo2/adpLock'), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(GlobalVariable.ADP_TEXT_VALUE, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(testData.getValue('room_id', 1), false, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Session.decryptSession'(testData.getValue('room_id', 1))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

TestObject inputKey = WebUI.modifyObjectProperty(findTestObject('Input/key'), 'xpath', 'not equals', '//input[@name=\'qtext\']', 
    true)

WebUI.setText(inputKey, 'test')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/unlock'))

TestObject trainBtn = WebUI.modifyObjectProperty(findTestObject('Button/train'), 'xpath', 'not equals', '//span[text()=\'Train\']', 
    true)

if (WebUI.verifyTextPresent('Saved corpus', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(trainBtn, 10, FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.verifyTextPresent('Trained corpus', false, FailureHandling.STOP_ON_FAILURE)
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/dashboard'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/userOptions'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/signOut'))

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByRoomID'(testData.getValue('room_id', 1))

WebUI.verifyElementNotPresent(findTestObject('NewRepo2/unlockIcon'), 10, FailureHandling.STOP_ON_FAILURE)

