import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testBot]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

WebUI.waitForElementVisible(findTestObject('Button/createArticle'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(null, 'richlink configuration test')

CustomKeywords.'platform.ResponseDesigner.addChannelToResponse'(' Apple Business Chat')

WebUI.verifyElementPresent(findTestObject('ICONS/richlink'), 20, FailureHandling.CONTINUE_ON_FAILURE)// verify richlink template

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/richlink'))// add richlink to response

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(1)

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'Website url']), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'URL title']), FailureHandling.CONTINUE_ON_FAILURE)

List<WebElement> getFields = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/fileURL'), 20)

TestObject imageURL = WebUI.convertWebElementToTestObject(getFields.get(0))

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'Image url']), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(imageURL, '')

CustomKeywords.'platform.Method.removeFocus'(imageURL)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(imageURL, ' ')

CustomKeywords.'platform.Method.removeFocus'(imageURL)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), 'image/png', false)

WebUI.setText(imageURL, img_url_value)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : 'Needs to end with png']), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), 'image/jpeg', false)