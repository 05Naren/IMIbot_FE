import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

TestData testData = findTestData('Data Files/testData_FAQ')

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('default_question', 1))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/carousel'))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

//CustomKeywords.'platform.Response.addCarousel'(true, testData, variable_1, variable_2)

CustomKeywords.'platform.ResponseDesigner.configureCarouselResponse'(1, null, testData.getValue('carousel_url', 1), testData.getValue('label_value', 1), 'default', 'how can you help')

CustomKeywords.'platform.Articles.saveAndTrainArticleToNewCategory'(categoryName)

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 15, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('NewRepo/bannerTitle', [('index') : 1]), expectedValue, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))