import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/training'))

if (WebUI.verifyElementText(findTestObject('Generic/modelState'), 'Live', FailureHandling.OPTIONAL)) {
    WebUI.comment('BOT IS LIVE!')
} else {
    CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/makeLive'))
}

CustomKeywords.'platform.Preview.doShareablePreview'()

//WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('Dinner reservation for two in mumbai', Keys.ENTER))

CustomKeywords.'platform.Preview.verifyBotResponse'(stringToCheck)

