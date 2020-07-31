import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Router bots', GlobalVariable.ROUTER_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/logic'))

TestData testData = findTestData('Data Files/testData_Router')

WebUI.setText(findTestObject('NewRepo/leftVariable', [('index') : 1]), testData.getValue('left_variable', 1))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Exists']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Equals to']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Reply with message']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Route to child bot']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/destinationBot', [('index') : 1]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'BankBot 2020']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/updateRules'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('How do I report a suspected fraud?', Keys.ENTER // hardcoded question
        ))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 1]), testData.getValue('bankbot_answer', 
        1), FailureHandling.STOP_ON_FAILURE)