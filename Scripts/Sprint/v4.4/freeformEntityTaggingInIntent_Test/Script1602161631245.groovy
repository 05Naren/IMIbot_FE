import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('Button/createIntent'), 40, FailureHandling.STOP_ON_FAILURE)

WebUI.comment(' *** SCENARIO 1 STARTED *** ')

CustomKeywords.'platform.Training.addSingleUtterance'(testData.getValue('freeform_utterance', 1))

/*
 * Following set of code is to check if user can manually tag an utterance to map location entity
 */
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Slots/listOfUtterance'), 5)

element.click()

element.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

element.click()

if (WebUI.verifyElementPresent(findTestObject('Generic/entitySelection'), 20, FailureHandling.OPTIONAL) == false) {
    WebUI.verifyTextPresent('No entities found', false, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/entitySelection'))

    ArrayList entityOptions = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/getOptions'), 20)

    for (WebElement value : entityOptions) {
        assert value.getText().contentEquals(testData.getValue('freeform_entity', 2)) == false
    }
    
    KeywordUtil.markPassed('*** Freeform entity not found ***')
}

WebUI.comment(' *** SCENARIO 2 STARTED *** ')

CustomKeywords.'platform.Training.createNewEntityManually'(testData.getValue('freeform_entity', 3), ' Free form ', null)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Slots/entityValue', [('rowValue') : 1]), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/intentName'), testData.getValue('intent_name', 8))

WebUI.sendKeys(findTestObject('Input/finalTempKey'), findTestData('Data Files/testData_Task').getValue('rich_template', 
        7 // final template value set from test data
        ))

WebUI.executeJavaScript('document.getElementsByClassName(\'bg-red\')[0].classList.remove(\'bg-red\');', null)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'freeform_test', FailureHandling.CONTINUE_ON_FAILURE // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                'intent_name', 8)]))

WebUI.comment(' *** VALIDATION: VERIFY FREEFORM ENTITY ON SLOT ***')

WebUI.verifyElementNotPresent(findTestObject('Slots/markedUpEntity'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

WebUI.verifyTextPresent('Training data', false, FailureHandling.CONTINUE_ON_FAILURE)