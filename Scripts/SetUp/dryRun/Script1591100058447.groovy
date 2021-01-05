import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser(GlobalVariable.URL)

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', 'Backend_automation')

WebUI.callTestCase(findTestCase('Sprint/v4.5/consumerSearchFAQBot_Test'), [('search_name') : 'narendra 05', ('user_email') : 'narendra.n@imimobile.com'
        , ('user_name') : 'john1'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint/v4.5/consumerADP_Test'), [('user_uid') : '2954', ('user_phone') : '7888145030'], 
    FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('BUGS/BOT-3269'), [('user_defined_bot') : 'JDY Scheme Bot', ('userQuery') : 'पीएमजेडीवाई क्या है?'], 
//    FailureHandling.CONTINUE_ON_FAILURE)

