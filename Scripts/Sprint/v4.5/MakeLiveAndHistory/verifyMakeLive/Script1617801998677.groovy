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

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

boolean isMakeLivePresent = WebUI.verifyElementPresent(findTestObject('Button/makeLive'), 20, FailureHandling.OPTIONAL)

if (isMakeLivePresent) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/makeLive'))

    WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS2/makeLiveModal'), 20, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/makeLiveModal'), modal_title, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/label'), 'Description (optional)', FailureHandling.CONTINUE_ON_FAILURE)

    TestObject makeLive = WebUI.modifyObjectProperty(findTestObject('Button/makeLive'), 'xpath', 'not equals ', newXpath, 
        true, FailureHandling.OPTIONAL)

    WebUI.verifyElementClickable(makeLive, FailureHandling.CONTINUE_ON_FAILURE)
}