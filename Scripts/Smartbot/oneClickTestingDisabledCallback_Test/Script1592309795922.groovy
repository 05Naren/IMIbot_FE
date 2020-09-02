import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Smart bots', GlobalVariable.SMART_BOT)*/

WebUI.waitForElementPresent(findTestObject('Generic/oneClickTest'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

TestData testData = findTestData('Data Files/testData_OneClickTesting')

//verify callback option
WebUI.verifyElementPresent(findTestObject('Toggle/oneClickCallback'), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Message', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Reset previous context', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, uploadSmartTestCases //kept as variable to run against different test cases set
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/updateBtn'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

WebUI.waitForElementPresent(findTestObject('Button/btnExecute'), 20, FailureHandling.STOP_ON_FAILURE)

//Execution starts from here and there after verify the test status post execution
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnExecute'))

WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-completed']), 90, FailureHandling.STOP_ON_FAILURE)

/*List<Object> testResults = CustomKeywords.'platform.Utility.storeTestCaseStatus'()

for (int count = 0; count < testResults.size(); count++) {
	assert testResults.get(count).toString().contentEquals(testData.getValue(testDataColumn, count + 1)) == true

	KeywordUtil.markPassed('**** PASSED ****')
}*/

//Verify execute table column header
WebUI.verifyTextPresent('Status', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Utterance', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Actual template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Room ID', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Actions', false, FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 5]) // hardcoded the action on test case
)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Transaction details']))

WebUI.verifyElementPresent(findTestObject('NewRepo2/sessionWindow'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

WebUI.waitForElementPresent(findTestObject('Generic/logic'), 20, FailureHandling.OPTIONAL)
