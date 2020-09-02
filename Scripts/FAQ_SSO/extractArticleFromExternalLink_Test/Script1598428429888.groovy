import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Articles.selectFromKebabMenu'(findTestObject('Button/extractExtLink'), 'Extract from external link')

WebUI.verifyElementHasAttribute(findTestObject('Button/extract'), 'disabled', 10, FailureHandling.STOP_ON_FAILURE // verify button state
    )

WebUI.sendKeys(findTestObject('Input/extractLink'), GlobalVariable.EXTERNAL_LINK)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/extract'))

// check article 1, 3 & 5; verify the count on detected FAQs 
WebUI.check(findTestObject('Generic/articleCheckbox', [('index') : 1]))

WebUI.check(findTestObject('Generic/articleCheckbox', [('index') : 3]))

WebUI.check(findTestObject('Generic/articleCheckbox', [('index') : 5]))

TestObject testObject = WebUI.modifyObjectProperty(findTestObject('Generic/header'), 'class', 'not equals', 'heading', true)

WebUiCommonHelper.findWebElement(testObject, 10).getText().contains('3')

WebUI.scrollToElement(findTestObject('Generic/webObjectWithText', [('textValue') : 'Import FAQs from link']), 10)

WebUI.check(findTestObject('Generic/allFaqCheckbox'))

WebUiCommonHelper.findWebElement(testObject, 10).getText().contains('10')

WebUI.scrollToElement(findTestObject('Generic/faqImportBtn'), 10)

TestObject override = WebUI.modifyObjectProperty(findTestObject('Toggle/override'), 'xpath', 'not equals', '//mat-slide-toggle[@formcontrolname=\'Override\']//label/div', 
    true, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(override)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/faqImportBtn'))

WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Saved', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Generic/nextPage'), 5, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.trainAndComment'(comment)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementPresent(findTestObject('Input/chatInput'), 10, FailureHandling.STOP_ON_FAILURE)

/*WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), strCheck, FailureHandling.STOP_ON_FAILURE)
*/
CustomKeywords.'platform.Preview.verifyBotTextResponse'(userQuery, 2, strCheck)

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('GenericII/minimize'))