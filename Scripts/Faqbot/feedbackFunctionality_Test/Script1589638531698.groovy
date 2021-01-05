import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'('feedback verification' // incase bot is not trained
    )

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('Button/preview'))

WebUI.waitForElementPresent(findTestObject('Input/chatInput'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('How do I report suspected fraud?', Keys.ENTER // query hardcoded
        ))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), botResponse, FailureHandling.OPTIONAL // verify response
    )

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/upvote'))

WebUI.verifyTextPresent('Upvoted', false, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('How do I register for a secure card?', Keys.ENTER // query hardcoded
        ))

WebUI.delay(3)

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Response.clickOnElement'(findTestObject('ICONS/chatWidget'))

WebUI.verifyElementPresent(findTestObject('Button/downvote'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Button/upvote'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Preview.downvoteResponseWithoutComment'()

WebUI.verifyTextPresent('Downvoted ', false, FailureHandling.STOP_ON_FAILURE)

