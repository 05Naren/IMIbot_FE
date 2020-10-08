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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createBot'))

WebUI.sendKeys(findTestObject('Input/botName'), nameOfTheBot)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/feedback'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/done'))

WebUI.waitForElementVisible(findTestObject('Generic/articleState'), 60, FailureHandling.OPTIONAL)

if (!(WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Trained', FailureHandling.OPTIONAL))) {
    KeywordUtil.markWarning('BOT STATE ' + WebUI.getText(findTestObject('Generic/articleState')))
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))