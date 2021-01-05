import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'map_intent']))

WebUI.comment(' *** SCENARIO 1 STARTED ***')

WebUI.verifyElementPresent(findTestObject('Slots/linkEntity'), 10, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Slots/linkEntity'))

List<WebElement> listOfEntities = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/entityList'), 20)

boolean flag = false

Iterator<WebElement> listOfElement = listOfEntities.iterator()

while (listOfElement.hasNext()) {
    WebElement object = listOfElement.next()

    if (object.getText().contentEquals('demo map test')) //check on hardcoded value
    {
        flag = true

        if (flag == true) {
            KeywordUtil.markPassed(' *** Map Location entity found *** ')

            object.click()
        }
        
        break
    }
}

if (flag == false) {
    KeywordUtil.markFailed(' *** Map Location entity not found *** ')
}

WebUI.comment(' *** VALIDATION --> ENTITY NAME IS PRESENT ON SLOTS ***')

WebUI.verifyElementText(findTestObject('Slots/entityValue', [('rowValue') : 1]), 'demo map test', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** SCENARIO 2 STARTED ***')

TestObject testObject = WebUI.modifyObjectProperty(findTestObject('Slots/checkbox'), 'xpath', 'not equals', newXpath, true, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment(' *** VALIDATION --> CHECKBOX FIELD SHOULD HAVE ATTRIBUTE *DISABLED* ***')

WebUI.verifyElementHasAttribute(testObject, 'disabled', 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** SCENARIO 3 STARTED ***')

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : '1']), '6', FailureHandling.OPTIONAL // set value
    )

//WebUI.takeScreenshot((RunConfiguration.getProjectDir() + '/Screenshot/') + image_title)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.verifyTextPresent('Training data', false, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'map_intent']))

String retryValue = WebUI.executeJavaScript(getValue, null) 

assert retryValue.toString().contentEquals('6') == true

WebUI.comment(' *** Navigate out of intent ***')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))