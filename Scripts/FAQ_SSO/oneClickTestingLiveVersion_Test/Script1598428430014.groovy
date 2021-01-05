import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

TestData testData = findTestData('Data Files/testData_OneClickTesting')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

//verify execute table column header
WebUI.verifyTextPresent('Status', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Utterance', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected article', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Actual article', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Room ID', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Actions', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/testCasesTab'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, uploadFAQTestCases //kept as variable to run against different test cases set
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/updateBtn'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

CustomKeywords.'platform.Method.runOneClickTestOnLiveData'(false)

//Abort running test case, verify summary status, pending cases and also the action button
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abortRun'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abort'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-aborted']), 20, FailureHandling.STOP_ON_FAILURE)

//Verify the status with test data post execution
CustomKeywords.'platform.Method.runOneClickTestOnLiveData'(true)

/*List<Object> testResults = CustomKeywords.'platform.Utility.storeTestCaseStatus'()

for (int count = 0; count < testResults.size(); count++) {
    assert testResults.get(count).toString().contentEquals(testData.getValue(testDataColumn, count + 1)) == true

    KeywordUtil.markPassed('**** PASSED ****')
}*/

//Verify the options available
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 3]) //hardcoded the action on test case
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Copy transaction ID']))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 4]) // hardcoded the action on test case
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Transaction details']))

WebUI.verifyElementPresent(findTestObject('NewRepo2/sessionWindow'), 20, FailureHandling.STOP_ON_FAILURE)