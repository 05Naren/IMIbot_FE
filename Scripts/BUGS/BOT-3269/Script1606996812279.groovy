import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * Perform bot card preview once attaining stable state
 */
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 15, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Preview.startBotCardPreview'('Q&A bots', user_defined_bot)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 15, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

WebUI.waitForElementClickable(findTestObject('Button/createBot'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('FAQ_SSO/botCreation_Test'), [('nameOfTheBot') : 'BOT-3269'], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/chatWidget'))

WebUI.verifyElementNotPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 15, FailureHandling.CONTINUE_ON_FAILURE)