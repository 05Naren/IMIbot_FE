import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities'])) // entity page

WebUI.comment(' *** SCENARIO 1 STARTED ***')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

CustomKeywords.'platform.Training.createEntity'(testData.getValue('freeform_entity', 1), ' Free form ', null // setting default name as map will be changed to 'map loc' after update
    )

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** VALIDATION --> ENTITY CREATION CHECK ***')

WebElement mapElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 5).get(0)

assert mapElement.getText().contentEquals('freeform org') == true // check if the entity is successfully created or not

WebUI.comment(' *** SCENARIO 2 STARTED ***')

CustomKeywords.'platform.Method.clickOnElement'(WebUI.convertWebElementToTestObject(mapElement))

//mapElement.click()

WebUI.setText(findTestObject('Input/entityName'), testData.getValue('freeform_entity', 2))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/entityPageSaveButton'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment(' *** VALIDATION --> ENTITY NAME UPDATE CHECK ***')

mapElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 5).get(0)

assert mapElement.getText().contentEquals('updated freeform') == true //check if the entity name is successfully updated

/*
* create a new response now to feed to map entity in next test case
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 7), testData.getValue('rich_template_value', 
        7))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 8), testData.getValue('rich_template_value',
	8))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)