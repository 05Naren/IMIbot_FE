import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('NewRepo2/settingsOnCuration'))

CustomKeywords.'platform.CurationSettings.disableFallback'(true)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/updateSettings'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Issues']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 20)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), fallbackMessage, FailureHandling.STOP_ON_FAILURE)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('NewRepo/refresh'))

roomID = getRoomIdAt.get(0).toString()

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/filter'))

WebUI.verifyTextNotPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)

