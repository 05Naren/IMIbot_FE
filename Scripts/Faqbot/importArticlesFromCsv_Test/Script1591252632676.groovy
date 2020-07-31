import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Articles.selectFromKebabMenu'(findTestObject('Button/importIcon'), 'Import From CSV')

CustomKeywords.'platform.Method.uploadCsvFile'(false, fileName)

CustomKeywords.'platform.Method.trainAndComment'(comment)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementPresent(findTestObject('Input/chatInput'), 5, FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(1)

CustomKeywords.'platform.Preview.verifyBotResponse'(stringToCheck)

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('GenericII/minimize'))

