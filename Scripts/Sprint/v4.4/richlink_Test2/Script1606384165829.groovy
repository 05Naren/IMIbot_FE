import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.comment('**SCENARIO 1 -- STARTS**')

CustomKeywords.'platform.ResponseDesigner.addChannelToResponse'(' Apple Business Chat')

WebUI.verifyElementPresent(findTestObject('ICONS/richlink'), 20, FailureHandling.CONTINUE_ON_FAILURE //Richlink template validation
    )

WebUI.comment('**VALIDATION COMPLETES**')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/richlink' //Richlink template added to response
        ))

CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(1)

List<WebElement> getFields = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/fileURL'), 20)

WebUI.comment('**SCENARIO 2 -- STARTS**')

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'Image url']), FailureHandling.CONTINUE_ON_FAILURE //Verify label name
    )

WebElement imageURL = getFields.get(0)

//TestObject imageURL = WebUI.convertWebElementToTestObject(getFields.get(0))
//WebUI.setText(imageURL, '')
imageURL.sendKeys('')

imageURL.sendKeys(Keys.chord(Keys.TAB))

//CustomKeywords.'platform.Method.removeFocus'(imageURL)
WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL required alert
    )

//WebUI.setText(imageURL, ' ')
imageURL.sendKeys(' ')

//CustomKeywords.'platform.Method.removeFocus'(imageURL)
imageURL.sendKeys(Keys.chord(Keys.TAB))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL invalid data
    )

WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), 'image/png', false)

//WebUI.setText(imageURL, img_url_value)
imageURL.clear()

imageURL.sendKeys(img_url_value)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : 'Needs to end with png']), 20, FailureHandling.CONTINUE_ON_FAILURE // Verify Image URL invalid format
    )

WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), 'image/jpeg', false)

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'Website url']), FailureHandling.CONTINUE_ON_FAILURE //Verify label name
    )

WebElement websiteURL = getFields.get(1)

websiteURL.sendKeys('')

websiteURL.sendKeys(Keys.chord(Keys.TAB))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL required alert
    )

websiteURL.sendKeys(' ')

websiteURL.sendKeys(Keys.chord(Keys.TAB))

//WebUI.setText(websiteURL, ' ')
//CustomKeywords.'platform.Method.removeFocus'(websiteURL)
WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL invalid data
    )

websiteURL.clear()

websiteURL.sendKeys(website_url)

WebUI.verifyElementVisible(findTestObject('WEB_OBJECTS/labelName', [('labelName') : 'URL title']), FailureHandling.CONTINUE_ON_FAILURE // Verify label name
    )

TestObject urlTitle = WebUI.modifyObjectProperty(findTestObject('AppleBusinessChat/title'), 'placeholder', 'not equals', 
    'Title comes here', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(urlTitle, '')

CustomKeywords.'platform.Method.removeFocus'(urlTitle)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL required alert
    )

WebUI.setText(urlTitle, ' ')

CustomKeywords.'platform.Method.removeFocus'(urlTitle)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE //Verify Image URL invalid data
    )

WebUI.setText(urlTitle, 'iPhone 12')

WebUI.comment('**VALIDATION COMPLETES**')