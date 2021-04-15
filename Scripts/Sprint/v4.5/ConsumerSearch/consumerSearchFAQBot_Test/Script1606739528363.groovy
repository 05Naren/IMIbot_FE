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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Consumers']))

WebUI.verifyElementHasAttribute(findTestObject('WEB_OBJECTS2/consumerSearchBtn'), 'disabled', 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('WEB_OBJECTS2/consumerActions'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Consumer.searchByName'(search_name)

assert WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 1]), 20).size() > 
0

WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 5]), user_email, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Consumer.clearSearch'()

CustomKeywords.'platform.Consumer.multipleFieldSearchBy'('UID', 'Phone', '67833', '7888145030' //update phone number with pin
    )

WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 3]), user_name, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Consumer.clearSearch'()

CustomKeywords.'platform.Consumer.searchByName'('qwerty' //random search for no result
    )

WebUI.verifyTextPresent('No consumers found. Search again', false, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Consumer.clearSearch'()

