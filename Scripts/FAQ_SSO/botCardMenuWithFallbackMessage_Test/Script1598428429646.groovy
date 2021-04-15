import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.OPTIONAL)

List<StringBuilder> botCardOptions = CustomKeywords.'platform.Method.verifyBotCardMenu'('Q&A bots', GlobalVariable.FAQ_BOT)

WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Copy Preview Link']), 5, FailureHandling.STOP_ON_FAILURE)

assert botCardOptions.containsAll(GlobalVariable.BOT_CARD_OPTION) == true

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : GlobalVariable.FAQ_BOT]))

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('Generic/botReponse', [('index') : 2]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 2]), botResponse, FailureHandling.OPTIONAL)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Utility.overWriteTestData'(sheetName, rowNumber, cellNumber, getRoomIdAt.get(0).toString())

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('GenericII/minimize'))