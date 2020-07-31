import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

TestData testData = findTestData('Data Files/testData_FAQ')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                'first_question', 1 // article to be updated
                )]))

WebElement defaultQuestionField = WebUiCommonHelper.findWebElement(findTestObject('Input/defaultQuestion'), 10)

defaultQuestionField.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

defaultQuestionField.sendKeys(Keys.chord(Keys.DELETE))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addVariant'))

WebUiCommonHelper.findWebElements(findTestObject('Input/defaultVariant'), 10).get(1).sendKeys('view my card statement' // sending variant question
    )

//WebUI.focus(findTestObject('Button/save', [('value') : ' Save ']))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementPresent(findTestObject('NewRepo2/alert'), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Input/defaultQuestion'), testData.getValue('new_default_question', 1), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/saveAndTrain'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Input/searchForQuestion'), searchQuestion)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/searchResult'))

assert true == WebUiCommonHelper.findWebElement(findTestObject('Generic/header'), 5).getText().contentEquals(testValue)