import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.NONE_INTENT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities']))

TestData testData = findTestData('Data Files/testData_Task' // to read test data from file
    )

for (int count = 1; count <= testData.getRowNumbers(); count++) {
    if (testData.getValue('global_entity_name', count) != '') {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createEntity'))

        WebUI.sendKeys(findTestObject('Input/entityName'), testData.getValue('global_entity_name', count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/listOfEntity'))

        if (WebUI.verifyElementNotVisible(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                        'global_entity_type', count)]), FailureHandling.OPTIONAL)) {
            WebUI.scrollToElement(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue('global_entity_type', 
                            count)]), 10)
        }
        
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                        'global_entity_type', count)]))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/entityPageSaveButton'))

        WebUI.delay(1)
    } else {
        KeywordUtil.logInfo('You have reached at the end of the list.')

        break
    }
}

WebUI.sendKeys(findTestObject('Input/searchEntity'), 'ate')

WebUI.verifyElementText(findTestObject('GenericII/listOfEntityNames'), 'date', FailureHandling.STOP_ON_FAILURE)

WebElement searchForEntity = WebUiCommonHelper.findWebElement(findTestObject('Input/searchEntity'), 10)

searchForEntity.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

searchForEntity.sendKeys(Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('Input/searchEntityType'), 'non_')

WebUI.verifyElementText(findTestObject('GenericII/listOfEntityNames'), 'non_geo_location', FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Intents']))

TestData newData = findTestData('Data Files/testData_Dummy' // to read test data from file
    )

for (int count = 1; count <= newData.getRowNumbers(); count++) {
    if (newData.getValue('intent_name', count) != '') {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createIntent'))

        WebUI.sendKeys(findTestObject('Input/intentName'), newData.getValue('intent_name', count))

        WebUI.sendKeys(findTestObject('Input/utterance'), newData.getValue('single_utterance', count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addUtterance'))

        WebUI.sendKeys(findTestObject('Input/finalTempKey'), newData.getValue('final_template_key', count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

        WebUI.delay(1)
    } else {
        KeywordUtil.logInfo('You have reached at the end of the list.')

        break
    }
}

WebUI.sendKeys(findTestObject('Input/searchIntent'), '1231')

WebUI.verifyElementText(findTestObject('Generic/listOfIntents'), 'xcv1231', FailureHandling.STOP_ON_FAILURE)

WebElement searchForIntent = WebUiCommonHelper.findWebElement(findTestObject('Input/searchIntent'), 10)

searchForIntent.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

searchForIntent.sendKeys(Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('Input/searchUtterance'), '5')

WebUI.verifyTextPresent('Help message', false, FailureHandling.STOP_ON_FAILURE)