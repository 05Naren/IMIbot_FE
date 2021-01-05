import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', 'file template test')

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

WebUI.waitForElementPresent(findTestObject('Button/createArticle'), 30, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(null, 'test alert on articles template')

//WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), '')
// Updated this next set of code where users cut paste the default value and removes focus from the field  
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('WEB_OBJECTS/textArea'), 5)

element.click()

element.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

element.sendKeys(Keys.chord(Keys.CONTROL, 'x'))

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/textArea'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), 'default value')

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('image', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), image_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : 'Needs to end with .jpg/.png/.jpeg']), 
    20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('audio', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), audio_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : 'Needs to end with .mp3/.aac']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('video', 'default text')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidURL'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), video_url)

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/mediaURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : 'Needs to end with .mp4']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), ' ')

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(2)