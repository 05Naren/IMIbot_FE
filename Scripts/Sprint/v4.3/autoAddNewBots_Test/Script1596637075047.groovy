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

/*WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

CustomKeywords.'platform.Method.logOut'()

// Part 1 begins here
WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : 'naren.n@yopmail.com', ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.CONTINUE_ON_FAILURE)

// Verify if newly created bot user account has any bot
try {
    WebUI.verifyTextPresent('There are no Q&A bots in your account', false, FailureHandling.CONTINUE_ON_FAILURE)
}
catch (Exception e) {
    KeywordUtil.logInfo('Test')
} 

CustomKeywords.'platform.Method.logOut'()

// Part 1 ends, Part 2 begins
WebUI.waitForElementVisible(findTestObject('Input/username'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Dashboard.newBotAdditionToUser'('naren')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('FAQ_SSO/botCreation_Test'), [('nameOfTheBot') : 'new_bot_agent'], FailureHandling.STOP_ON_FAILURE)

// Part 2 ends, Part 3 begins
CustomKeywords.'platform.Method.logOut'()

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : 'naren.n@yopmail.com', ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : ' new_bot_agent ']), 20, FailureHandling.STOP_ON_FAILURE)

