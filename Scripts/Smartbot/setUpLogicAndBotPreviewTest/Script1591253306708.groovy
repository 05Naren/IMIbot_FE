import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Smart bots', GlobalVariable.SMART_BOT)*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/logic'))

String PATH = RunConfiguration.getProjectDir() + '/Collection/'

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Generation Template']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/code'))

WebUI.waitForElementPresent(findTestObject('NewRepo/editCodeBtn'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/editCodeBtn'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('WEB_OBJECTS/confirm'))

WebUI.waitForElementClickable(findTestObject('Button/save', [('value') : 'Save']), 15, FailureHandling.OPTIONAL)

for (int count = 1; count <= findTestData('testData_Smart').getRowNumbers(); count++) {
    if (count == 1) {
        WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + findTestData('testData_Smart').getValue(fileColumn, 
                count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save']))
    } else {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : findTestData(
                        'testData_Smart').getValue(section, count)]))

        WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + findTestData('testData_Smart').getValue(fileColumn, 
                count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save']))
    }
    
    if (count == 4) {
        break
    }
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

CustomKeywords.'platform.Preview.verifyBotResponse'(java.time.LocalDate.now().toString())

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

