import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Training.addMultipleUtterance'(testData, 'track_order_utterance' // data file has been hardcoded
    )

WebUI.sendKeys(findTestObject('Input/intentName'), testData.getValue('intent_name', 3))

WebUI.verifyElementText(findTestObject('Slots/entityValue', [('rowValue') : 1]), 'order_id', FailureHandling.STOP_ON_FAILURE // hardcoded entity value to be tested
    )

WebUI.sendKeys(findTestObject('Input/finalTempKey'), 'order_status_template' // final template value hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.verifyElementText(findTestObject('Generic/header'), 'track_order', FailureHandling.STOP_ON_FAILURE // text to validate is hardcoded
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/intentGoBack'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Entities']))

CustomKeywords.'platform.Training.editEntity'('product_names')

WebUI.sendKeys(findTestObject('Input/synonyms', [('index') : 1]), Keys.chord('wooden chair', Keys.ENTER))

WebUI.sendKeys(findTestObject('Input/synonyms', [('index') : 1]), Keys.chord('plastic chair', Keys.ENTER))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, testData.getValue('custom_entity_file', 2))

//WebUiCommonHelper.findWebElement(findTestObject('Input/valueOfSynonym'), 10)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnDeleteChipOrRow', [('chipValue') : ' plastic chair '
            , ('option') : 'cancel'] // delete the synonym
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnDeleteChipOrRow', [('chipValue') : ' wooden chair '
            , ('option') : 'close '] // delete the rootword
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

