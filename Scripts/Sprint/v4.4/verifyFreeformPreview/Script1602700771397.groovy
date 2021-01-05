import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.trainAndComment'('Freeform intent trained')

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.OPTIONAL)

WebUI.comment('*** SCENARIO 1 STARTED ***')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementVisible(findTestObject('Input/chatInput'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('Generic/botReponse', [('index') : 2]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 2]), expected_value, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(freeform_text, Keys.ENTER))

WebUI.comment('*** VALIDATION CHECK FOR BOT RESPONSE ***')

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 3]), final_value, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('*** SCENARIO 2 STARTED ***')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementVisible(findTestObject('Input/chatInput'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('Generic/botReponse', [('index') : 2]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 2]), expected_value, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(new_intent_value, Keys.ENTER))

WebUI.comment('*** VALIDATION CHECK FOR BOT RESPONSE ***')

WebUI.verifyElementText(findTestObject('Generic/botReponse', [('index') : 3]), final_value, FailureHandling.CONTINUE_ON_FAILURE)