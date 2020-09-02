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

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Router bots', GlobalVariable.ROUTER_BOT)*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nlp'))

CustomKeywords.'platform.NLP.addCustom_NER'()

CustomKeywords.'platform.NLP.createConcept'(conceptName, fileName)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/conceptBackBtn'))

WebUI.verifyTextPresent(conceptName, false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.NLP.createConcept'(conceptName2, fileName2)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/conceptBackBtn'))

WebUI.verifyTextPresent(conceptName2, false, FailureHandling.STOP_ON_FAILURE)