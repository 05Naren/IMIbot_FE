import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/history'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Audit Logs']))

List<WebElement> updatedAt = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/updatedAtValue'), 20)

assert updatedAt.get(0).getText().compareTo(updatedAt.get(1).getText()) > 0 //assertion point compare date

List<WebElement> fieldColumnData = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/fieldValue'), 20)

ArrayList<String> fieldColumnDataText = new ArrayList<String>()

for (WebElement element : fieldColumnData) {
    fieldColumnDataText.add(element.getText())
}

Collections.sort(fieldColumnDataText // sort in ascending order
    )

CustomKeywords.'platform.AuditLog.sortByAscendingOrder'('Field')

fieldColumnData = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/fieldValue'), 20)

ArrayList<String> sortedFieldColumnDataText = new ArrayList<String>()

for (WebElement element : fieldColumnData) {
    sortedFieldColumnDataText.add(element.getText())
}

assert fieldColumnDataText.equals(sortedFieldColumnDataText) == true //assertion column data on sort

WebUI.setText(findTestObject('WEB_OBJECTS2/auditLogSearch', [('holder_value') : 'Updated by']), searchData)

fieldColumnData = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/fieldValue'), 20)

assert fieldColumnData.size() > 0

String userName = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/updatedByValue'), 20).get(0).getText()

assert userName.contentEquals(user_name) == true //search updated by field

WebElement updatedAtObject = WebUiCommonHelper.findWebElement(findTestObject('WEB_OBJECTS2/auditLogSearch', [('holder_value') : 'Updated by']), 
    20)

updatedAtObject.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

updatedAtObject.sendKeys(Keys.chord(Keys.CONTROL, 'x'))

WebUI.setText(findTestObject('WEB_OBJECTS2/auditLogSearch', [('holder_value') : 'Field']), fieldValue)

assert WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/fieldValue'), 20).size() > 0

String fValue = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/fieldValue'), 20).get(0).getText()

assert fValue.contentEquals('Decrypt_audit')