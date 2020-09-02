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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)
CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', 'file template test')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Articles.createNewArticle'(null, 'test alert on articles template')

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/textArea'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), 'default value')

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('image', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), image_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert',['alert_value':'Needs to end with .jpg/.png/.jpeg']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('audio', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), audio_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert',['alert_value':'Needs to end with .mp3/.aac']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('video', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), video_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert',['alert_value':'Needs to end with .mp4']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)



