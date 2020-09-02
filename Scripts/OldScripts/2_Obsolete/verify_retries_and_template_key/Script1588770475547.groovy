import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Training.addSingleUtterance'(testUtterance)

WebUI.sendKeys(findTestObject('Input/intentName'), intentName)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Slots/linkEntity'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'city name']))

//CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Slots/checkbox', [('rowValue') : 2]))
WebUI.check(findTestObject('Slots/checkbox', [('rowValue') : 2]))

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : 2]), retryValue)

WebUI.setText(findTestObject('Slots/templateKey', [('rowValue') : 2]), templateKey)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : templateKey]))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), finalResponse)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : (' ' + 
            finalResponse) + ' ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/slotReset'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'('retry test')

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery2, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), botResponse, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery3, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 4]), fallbackResponse, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(cityName, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), finalBotResponse, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/upvote'))

