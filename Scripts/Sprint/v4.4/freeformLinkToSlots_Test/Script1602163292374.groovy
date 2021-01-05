import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'freeform_test']))

WebUI.comment(' *** SCENARIO 1 STARTED ***')

WebUI.verifyElementPresent(findTestObject('Slots/linkEntity'), 10, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Slots/linkEntity'))

List<WebElement> listOfEntities = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/entityList'), 20)

boolean flag = false

Iterator<WebElement> listOfElement = listOfEntities.iterator()

while (listOfElement.hasNext()) {
    WebElement object = listOfElement.next()

    if (object.getText().contentEquals('demo freeform')) //check on hardcoded value
    {
        flag = true

        if (flag == true) {
            KeywordUtil.markPassed(' *** Freeform entity found *** ')

            object.click()
        }
        
        break
    }
}

if (flag == false) {
    KeywordUtil.markFailed(' *** Freeform entity not found *** ')
}

WebUI.comment(' *** VALIDATION --> ENTITY NAME IS PRESENT ON SLOTS ***')

WebUI.verifyElementText(findTestObject('Slots/entityValue', [('rowValue') : 1]), 'demo freeform', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** SCENARIO 2 STARTED ***')

TestObject testObject = WebUI.modifyObjectProperty(findTestObject('Slots/checkbox'), 'xpath', 'not equals', newXpath, true, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment(' *** VALIDATION --> CHECKBOX FIELD SHOULD HAVE ATTRIBUTE *DISABLED* ***')

WebUI.verifyElementHasAttribute(testObject, 'disabled', 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Slots/retries', [('rowValue') : '1']), '2', FailureHandling.OPTIONAL // set value
    )

WebUI.setText(findTestObject('Slots/templateKey', [('rowValue') : 1]), findTestData('Data Files/testData_Task').getValue(
	'rich_template', 8 // missing entity name has been taken from the data file
	))

WebUI.takeScreenshot((RunConfiguration.getProjectDir() + '/Screenshot/') + image_title)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.verifyTextPresent('Training data', false, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'freeform_test']))

String retryValue = WebUI.executeJavaScript(getValue, null)

assert retryValue.toString().contentEquals('2') == true

WebUI.comment(' *** SCENARIO 3 STARTED ***')

WebUI.mouseOver(findTestObject('WEB_OBJECTS/mat-icon',['class_value':'freeform']), FailureHandling.OPTIONAL)

WebUI.comment(' *** VALIDATION CHECK FOR ELEMENT ATTRIBUTE ***')

WebUI.verifyElementAttributeValue(findTestObject('WEB_OBJECTS/mat-icon',['class_value':'freeform']), 'mattooltip', testValue, 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('Button/createIntent'), 40, FailureHandling.STOP_ON_FAILURE)