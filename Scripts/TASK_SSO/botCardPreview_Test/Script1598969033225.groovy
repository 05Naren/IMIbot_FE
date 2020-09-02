import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Task bots']))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Preview.startBotCardPreview'('Task bots', GlobalVariable.TASK_BOT)

WebUI.waitForElementPresent(findTestObject('Input/chatInput'), 5, FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'platform.Preview.verifyBotResponse'(stringToCheck)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

