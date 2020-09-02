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

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Smart bots', GlobalVariable.SMART_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/sidebarSettings'))

CustomKeywords.'platform.Method.enableCloseCallback'(true)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(70)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByRoomID'(roomID)

WebUI.verifyElementPresent(findTestObject('NewRepo2/errorIcon'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.verifyTextPresent('error_outline', false, FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('NewRepo2/inputSessionSearch'), searchText)

WebUI.verifyElementText(findTestObject('NewRepo2/textHighlight'), searchText, FailureHandling.STOP_ON_FAILURE)

