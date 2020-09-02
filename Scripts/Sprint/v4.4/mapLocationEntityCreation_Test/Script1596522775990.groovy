import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.openBrowser(GlobalVariable.URL)

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)
*/
// repeated steps, can be customized to a funtion for reuse
CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

//CustomKeywords.'platform.Method.navigateToBot'('Task bots', 'file_text_attachment_bot')
TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

CustomKeywords.'platform.Training.createEntity'(testData.getValue('map_entity', 1), ' Map location ', null // setting default name as map will be changed to 'map loc' after update
    )

WebElement mapElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 5).get(0)

assert mapElement.getText().contentEquals('map') == true // check if the entity is successfully created or not

mapElement.click()

WebUI.setText(findTestObject('Input/entityName'), testData.getValue('map_entity', 2))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/entityPageSaveButton'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

mapElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 5).get(0)

assert mapElement.getText().contentEquals('new map') == true //check if the entity name is successfully updated

/*
* create a new response now to feed to map entity in next test case
*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Response.createRichResponse'(testData.getValue('rich_template', 6), testData.getValue('rich_template_value',
	6))
