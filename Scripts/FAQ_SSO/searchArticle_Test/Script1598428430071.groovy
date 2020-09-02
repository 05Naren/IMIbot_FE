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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)*/

WebUI.sendKeys(findTestObject('Input/searchForQuestion'), searchQuestion)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/searchResult'))

firstQuestion = WebUiCommonHelper.findWebElement(findTestObject('Generic/header'), 10).getText()

WebUI.setText(findTestObject('Input/searchForQuestion'), newSearchQuestion)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/searchResult'))

newFirstQuestion = WebUiCommonHelper.findWebElement(findTestObject('Generic/header'), 10).getText()

assert firstQuestion.equalsIgnoreCase(newFirstQuestion) == false

WebUI.clearText(findTestObject('Input/searchForQuestion'))

