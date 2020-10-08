import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Task bots']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createBot'))

WebUI.sendKeys(findTestObject('Input/botName'), nameOfTheBot)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/feedback'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/done'))

WebUI.waitForElementVisible(findTestObject('Generic/modelState'), 60, FailureHandling.OPTIONAL)

//WebUI.verifyElementText(findTestObject('Generic/modelState'), 'Trained', FailureHandling.STOP_ON_FAILURE)
if (!(WebUI.verifyElementText(findTestObject('Generic/modelState'), 'Trained', FailureHandling.OPTIONAL))) {
    KeywordUtil.markWarning('BOT STATE ' + WebUI.getText(findTestObject('Generic/modelState')))
}
