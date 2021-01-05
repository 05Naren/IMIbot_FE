import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

WebUI.waitForElementVisible(findTestObject('NewRepo2/addNewResponse'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Response.createRichResponse'('media_abc', 'My abc validation')

//Verify if text with attachment is present on abc channel
CustomKeywords.'platform.ResponseDesigner.addChannelToResponse'(' Apple Business Chat')

WebUI.verifyElementPresent(findTestObject('ICONS/textWithAttachment'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/textWithAttachment'))

//Verify textarea inline alert validation (Required, Invalid data)
CustomKeywords.'platform.ResponseDesigner.deleteSecondaryTemplate'(1)

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/textArea'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), ' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/textArea'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), 'Please find the attachment')

//Verify url input alert validation (Required, Invalid data, Type specific alert)
WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), userValue, false)

WebUI.setText(findTestObject('WEB_OBJECTS/fileURL'), '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/fileURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('WEB_OBJECTS/fileURL'), ' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('WEB_OBJECTS/fileURL'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

TestData testData = findTestData('Data Files/testData_OneClickTesting' // testdata stored in file name - OneClickTesting
    )

for (int i = 1; i <= testData.getRowNumbers(); i++) {
    WebUI.selectOptionByValue(findTestObject('WEB_OBJECTS/type'), testData.getValue('attachment_type', i), false)

    WebUI.setText(findTestObject('WEB_OBJECTS/fileURL'), testData.getValue('attachment_data', i))

    WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alert', [('alert_value') : testData.getValue('alert_msg', i)]), 
        20, FailureHandling.CONTINUE_ON_FAILURE)

    if (testData.getValue('attachment_type', i + 1) == '') {
        break
    }
}

//Verify if default attachment cannot deleted and additional attachment can be deleted
WebUI.verifyElementNotPresent(findTestObject('ICONS/deleteAttachmentIcon'), 10, FailureHandling.CONTINUE_ON_FAILURE)

for (int j = 0; j < 9; j++ //loop exit is hardcoded, since we support only 10 attachments
) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addAttachments'))
}

//Verify if max number of attachment can be added 10
List<WebElement> allAttachment = WebUiCommonHelper.findWebElements(findTestObject('ICONS/deleteAttachmentIcon'), 10)

assert allAttachment.size() == 10

WebUI.verifyElementNotPresent(findTestObject('Button/addAttachments'), 20, FailureHandling.CONTINUE_ON_FAILURE)

allAttachment.get(0).click( //Hardcoded attachment to be deleted
    )

allAttachment.get(8).click( //Hardcoded attachment to be deleted
    )

WebUI.verifyElementVisible(findTestObject('Button/addAttachments'), FailureHandling.CONTINUE_ON_FAILURE)

assert WebUiCommonHelper.findWebElements(findTestObject('ICONS/deleteAttachmentIcon'), 10).size() == 8

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))