import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('FAQ_SSO/botCreation_Test'), [('nameOfTheBot') : GlobalVariable.PREVIEW_BOT], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText',['textValue':GlobalVariable.PREVIEW_BOT]))

TestData testData = findTestData('Data Files/testData_Dummy')

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('article_default_question', 1))

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), testData.getValue('text_response', 1))

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('image', testData.getValue('image_url', 1))

CustomKeywords.'platform.Articles.saveAndTrainArticleToNewCategory'(testData.getValue('category', 1))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('article_default_question', 2))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

CustomKeywords.'platform.ResponseDesigner.addCodeResponse'(testData.getValue('code_function', 1))

CustomKeywords.'platform.ResponseDesigner.configureTextResponse'(testData.getValue('text_response', 2))

//CustomKeywords.'platform.Response.addText'(testData.getValue('text_response', 2))
WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.saveAndTrainArticleToNewCategory'(testData.getValue('category', 2))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createArticle'))

WebUI.sendKeys(findTestObject('Input/defaultQuestion'), 'How can I contact this property?')

WebUI.sendKeys(findTestObject('WEB_OBJECTS/textArea'), 'Please drop an email at estateproperty@dealer.com or can call at ph: +9876543210')

CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

