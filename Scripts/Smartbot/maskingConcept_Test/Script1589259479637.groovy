import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Smart bots', GlobalVariable.SMART_BOT)*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nlp'))

String PATH = RunConfiguration.getProjectDir() + '/Collection/'

TestData testData = findTestData('testData_Smart')

//add concept [single match, regex]
CustomKeywords.'platform.NLP.createConceptType'('Regex', true, testData.getValue('concept_name', 2), testData.getValue('file_name', 
        2 // hardcoded column name for both file path and concept name
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/conceptBackBtn'))

CustomKeywords.'platform.NLP.createConceptType'('Single Match', true, testData.getValue('concept_name', 3), testData.getValue(
        'file_name', 3 // hardcoded column name for both file path and concept name
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/logic' //add logic
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/fork'))

WebUI.sendKeys(findTestObject('Input/forkComment'), 'Masked concept V2 created' // hardcoded comment
    )

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createNewFork'))

//CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Toggle/version'))
//CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Forked from v1 ']))
for (int count = 1; count <= findTestData('testData_Smart').getRowNumbers(); count++) {
    if (count == 1) {
        WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + testData.getValue('masked_logic_file', count // hardcoded column name
                ))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save' // hardcoded column name
                    // hardcoded column name
                ]))
    } else {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : testData.getValue(
                        'logic_section', count)]))

        WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH + findTestData('testData_Smart').getValue('masked_logic_file', 
                count))

        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save']))

        if (count == 4) {
            break
        }
    }
}

if (WebUI.verifyElementText(findTestObject('Generic/versionStatus'), 'Inactive', FailureHandling.OPTIONAL)) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/activate'))
} else {
    KeywordUtil.logInfo('Version is Active')
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

for (int count = 1; count < testData.getRowNumbers(); count++) {
    WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('userQuery', count), Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2)

    WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : count+1]), testData.getValue('botResponse', 
            count), FailureHandling.CONTINUE_ON_FAILURE)

    if (testData.getValue('userQuery', count + 1) == '') {
        break
    }
}

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

roomID = getRoomIdAt.get(0).toString()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Session.searchByRoomID'(roomID)

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))

WebUI.verifyElementText(findTestObject('NewRepo2/messageInSession', [('index') : 1]), '4**************4', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('NewRepo2/messageInSession', [('index') : 3]), 'o*e', FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/closePopup'))

