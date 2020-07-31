import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities']))

TestData testData = findTestData('Data Files/testData_Task' // fetching test data
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

CustomKeywords.'platform.Training.createEntity'('city name', 'Custom', 'mumbai' // creating entity with default value hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

CustomKeywords.'platform.Training.createEntity'('date', ' Date ', null)

for (int count = 2; count <= testData.getRowNumbers(); count++) {
    if (testData.getValue('entity_name', count) != '') {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

        CustomKeywords.'platform.Training.createEntity'(testData.getValue('entity_name', count), testData.getValue('entity_type', 
                count), testData.getValue('entity_value', count // entity name: fetched from test data along with entity type
                ))
    } else {
        KeywordUtil.logInfo('No more entity present!!')

        break
    }
}

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText',['textValue':'city name']), 15, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Training.editEntity'('city name')

TestObject testObject = WebUI.modifyObjectProperty(findTestObject('Input/entityName'), 'formcontrolname', 'equals', 'name', 
    true, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(testObject, testData.getValue('entity_name', 1))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(true, testData.getValue('custom_entity_file', 1))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 15, FailureHandling.STOP_ON_FAILURE)

assert WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 10).get(0).getText().contentEquals(
    'store_name') == true

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 2))

//WebUI.verifyElementText(findTestObject('Generic/modelState'), 'Trained', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 15, FailureHandling.OPTIONAL)

