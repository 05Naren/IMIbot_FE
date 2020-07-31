import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Training.addSingleUtterance'(testValue)

WebUI.sendKeys(findTestObject('Input/intentName'), intentName)

WebUI.verifyElementText(findTestObject('Slots/entityValue', [('rowValue') : 2]), entityTestValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/finalTempKey'), response)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/webObjectWithText', [('textValue') : (' ' + 
            response) + ' ']))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.trainAndComment'('recognition test')

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Preview.verifyBotResponse'(stringToCheck)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/upvote'))

