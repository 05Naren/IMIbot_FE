import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/history'))

CustomKeywords.'platform.History.makeLive'(description)

WebUI.verifyElementPresent(findTestObject('NewRepo2/liveIcon'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.History.startPreview'('retry test')

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.History.loadCorpus'('recognition test')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/continue'))

WebUI.verifyTextPresent('Training data', false, FailureHandling.STOP_ON_FAILURE)

