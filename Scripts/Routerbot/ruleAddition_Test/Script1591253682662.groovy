import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Router bots', GlobalVariable.ROUTER_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/logic'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/addRule'))

WebUI.setText(findTestObject('NewRepo/leftVariable', [('index') : 2]), leftVariable)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'string']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : ' boolean ']))

WebUI.setText(findTestObject('NewRepo/rightVariable', [('index') : 2]), rightVariable)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/destinationBot', [('index') : 2]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : childBotName]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateRules'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('GenericII/getBotResponse', [('index') : 2]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery2, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('GenericII/getBotResponse', [('index') : 3]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), botResponse2, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))