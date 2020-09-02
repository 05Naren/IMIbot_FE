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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : 'lil.zakk@gmail.com', ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

// Verify if newly created bot user account has any bot 
try {
    WebUI.verifyTextPresent('There are no Q&A bots in your account', false, FailureHandling.OPTIONAL)
}
catch (Exception e) {
    KeywordUtil.logInfo('Test')
} 

CustomKeywords.'platform.Method.logOut'()

WebUI.waitForElementVisible(findTestObject('Input/username'), 30, FailureHandling.OPTIONAL)

// Configure newly created bot user account with auto bot addition
WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Dashboard.newBotAdditionToUser'('narendra')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 45, FailureHandling.OPTIONAL)

// Create a new bot using api, logout and see if it visible in the alternate user account

