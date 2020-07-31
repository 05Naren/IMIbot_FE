import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Smart bots', GlobalVariable.SMART_BOT)

TestData testData = findTestData('Data Files/testData_OneClickTesting')

String PATH = RunConfiguration.getProjectDir() + '/Collection/'

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/logic'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/version'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Default version']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/activate'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

//Updating new generation rules files for 
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'DF Rules']))

WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + 'df_rules callback.py' // hardcoded file name
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save' // hardcoded column name
            // hardcoded column name
        ]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Generation Rules']))

WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + 'generation_rules_callback.py' // hardcoded file name
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save' // hardcoded column name
            // hardcoded column name
        ]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Generation Template']))

WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + 'generation_templates_callback.py')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save' // hardcoded column name
            // hardcoded column name
        ]))

//Verify changes in handson table after callback is enabled
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/oneClickCallback'))

WebUI.verifyTextPresent('Callback in flow', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected callback template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Callback timeout (in secs)', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, uploadSmartTestCases //kept as variable to run against different test cases set
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/updateBtn'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnExecute'))

//Verify abort function
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abortRun'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abort'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

//Verify new table
WebUI.verifyTextPresent('Callback expected template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Callback actual template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-aborted']), 60, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnExecute'))

WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-completed']), 90, FailureHandling.STOP_ON_FAILURE)

//verify test result of callback
List<Object> testResults = CustomKeywords.'platform.Utility.storeTestCaseStatus'()

for (int count = 0; count < testResults.size(); count++) {
    assert testResults.get(count).toString().contentEquals(testData.getValue(testDataColumn, count + 1)) == true

    KeywordUtil.markPassed('**** PASSED ****')
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 3] //hardcoded the action on test case
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Copy transaction ID']))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 9] //hardcoded the action on test case
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Test in preview']))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 1]), 'default template--else', FailureHandling.STOP_ON_FAILURE)

