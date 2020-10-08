import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

/*
 * initiate a shareable preview by opening on a new link 
 */
WebUI.openBrowser((((((((domain + 'bot_unique_name=') + bot_unique_name) + '&enterprise_unique_name=') + enterprise_unique_name) + 
    '&root=') + root) + '&phoneCasing=') + phoneCasing)

WebUI.maximizeWindow()

// verify text response; check bot's text response for user query
CustomKeywords.'platform.AssertPreview.sendUserMessage'('Hello')

assert CustomKeywords.'platform.AssertPreview.verifyTextInResponse'(2, 'Hi, I\'m good. What brings you here today?') == 
true

// verify quick reply; check if bot responds with a quick reply
CustomKeywords.'platform.AssertPreview.sendUserMessage'('quick replies')

assert CustomKeywords.'platform.AssertPreview.verifyQuickReplyBtnInResponse'() == true

assert CustomKeywords.'platform.AssertPreview.verifyUrlButtonOnQR'() == true



// verify button text on bot preview
TestObject testObject = WebUI.modifyObjectProperty(findTestObject('WEB_OBJECTS/qrBtn'), 'xpath', 'not equals', update_xpath + 
    '2]', true)

CustomKeywords.'platform.Method.clickOnElement'(testObject)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/getText', [('value') : 'Help']), 10, FailureHandling.STOP_ON_FAILURE)