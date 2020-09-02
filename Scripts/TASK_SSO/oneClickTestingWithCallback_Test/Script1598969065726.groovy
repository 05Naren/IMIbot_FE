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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

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

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

TestData testData = findTestData('Data Files/testData_OneClickTesting')

WebUI.waitForElementPresent(findTestObject('Generic/oneClickTest'), 20, FailureHandling.STOP_ON_FAILURE)

//Verify changes in handson table after callback is enabled
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/oneClickCallback'))

WebUI.verifyTextPresent('Callback in flow', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected callback template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Callback timeout (in secs)', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, uploadTaskTestCases //kept as variable to run against different test cases set
	)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/updateBtn'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnExecute'))

CustomKeywords.'platform.Method.runOneClickTestOnLiveData'(false)

WebUI.verifyElementPresent(findTestObject('Generic/testSummary', [('status') : 'summery-status-running']), 30, FailureHandling.STOP_ON_FAILURE)

//Verify abort function
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abortRun'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/abort'))

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

//Verify new table
WebUI.verifyTextPresent('Callback expected template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Callback actual template', false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-aborted']), 60, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnExecute'))

CustomKeywords.'platform.Method.runOneClickTestOnLiveData'(false)

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

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 7] //hardcoded the action on test case
		))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Test in preview']))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 1]), 'default template--else', FailureHandling.STOP_ON_FAILURE)

