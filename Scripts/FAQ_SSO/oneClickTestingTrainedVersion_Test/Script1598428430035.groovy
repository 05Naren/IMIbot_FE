import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

if (WebUI.verifyElementVisible(findTestObject('Button/makeLive'), FailureHandling.OPTIONAL)) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/makeLive'))

    if (!(WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Live', FailureHandling.OPTIONAL))) {
        WebUI.delay(1)
    } else {
        KeywordUtil.logInfo('Your corpus is live!')
    }
}

TestData testData = findTestData('Data Files/testData_OneClickTesting')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/oneClickTest'))

WebUI.verifyTextPresent('Message', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Expected article', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Reset previous context', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, uploadFAQTestCases //kept as variable to run against different test cases set
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/updateBtn'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/execution'))

CustomKeywords.'platform.Method.runOneClickTestOnLiveData'(false)

/*
List<Object> testResults = CustomKeywords.'platform.Utility.storeTestCaseStatus'()

for (int count = 0; count < testResults.size(); count++) {
    assert testResults.get(count).toString().contentEquals(testData.getValue(testDataColumn, count + 1)) == true

    KeywordUtil.markPassed('**** PASSED ****')
}
*/
WebUI.waitForElementVisible(findTestObject('Generic/testSummary', [('status') : 'summery-status-completed']), 90, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/action', [('index') : 2]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnOptionsInOneClickTesting', [('btnValue') : 'Test in preview']))

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByRoomID'(roomID)

WebUI.verifyTextPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.sendKeys(findTestObject('NewRepo2/inputSessionSearch'), toBeSearched)

WebUI.verifyElementText(findTestObject('NewRepo2/textHighlight'), 'card abroad charges?', FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

