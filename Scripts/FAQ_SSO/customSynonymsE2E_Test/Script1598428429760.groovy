import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : GlobalVariable.PREVIEW_BOT]))

WebUI.waitForElementVisible(findTestObject('Generic/articles'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

WebUI.sendKeys(findTestObject('Input/searchForQuestion'), 'Hello there')

if (WebUI.waitForElementVisible(findTestObject('Generic/searchResult'), 10, FailureHandling.OPTIONAL)) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/searchResult'))

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/delete'))

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/deleteArticleBtn'))

    CustomKeywords.'platform.Method.trainAndComment'('Small talk article deleted')

    WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)
} else {
    KeywordUtil.logInfo('Hello there article not present')
}

//Delete Hello there article from smalltalk category
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('[स्वावलंबी] भारतवर्ष', Keys.ENTER))

//WebUI.delay(5)
WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), fallback, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Custom synonyms']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/rootword'))

/*TestObject saveBtn = WebUI.modifyObjectProperty(findTestObject('Button/save', [('value') : 'Save']), 'xpath', 'equals', 
    '//span[text()=\' Save \']//ancestor::button', true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementHasAttribute(saveBtn, 'disabled', 10, FailureHandling.STOP_ON_FAILURE)*/
TestData testData = findTestData('Data Files/testData_FAQ')

WebUI.setText(findTestObject('Input/valueOfSynonym'), Keys.chord(testData.getValue('custom_syn_value', 1), Keys.ENTER))

for (int count = 1; count <= testData.getRowNumbers(); count++) {
    if (testData.getValue('synonyms', count) != '') {
        WebUI.setText(findTestObject('Input/synonyms', [('index') : 1]), Keys.chord(testData.getValue('synonyms', count), 
                Keys.ENTER //hardcoded synonym row with index
                ))
    } else {
        break
    }
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/importIcon'))

CustomKeywords.'platform.Method.uploadCsvFile'(false, 'faqSynonyms.csv')

WebUI.delay(2)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnDeleteChipOrRow', [('chipValue') : ' \\@unwell '
            , ('option') : 'cancel ' // hardcoded value for to be deleted 
        ]))

WebUI.setText(findTestObject('Input/searchCustomSyn'), 'FEELING GOOD' //used uppercase to verify search result
    )

WebUI.verifyElementPresent(findTestObject('ICONS/matChip', [('chipValue') : ' un-happy ']), 10, FailureHandling.STOP_ON_FAILURE)

//Object getValue = WebUI.executeJavaScript("document.getElementsByTagName('input')[5].value", null)
//assert getValue.toString().toLowerCase().contains('not feeling good') == true
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save']))

WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Saved', FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.trainAndComment'(testData.getValue('comment', 8))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('आत्मावलम्बी भारतवर्ष अभियान से जुड़े लाभ क्या हैं', Keys.ENTER //hardcoded question
        ))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), testData.getValue('bot_answer', 1), 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('سحب خدمة الإخطار', Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 3]), testData.getValue('bot_answer', 2), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('नमस्ते,', Keys.ENTER //hardcoded question
        ))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 4]), testData.getValue('bot_answer', 3), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord('show me some re@l-est@ate', Keys.ENTER //hardcoded question
        ))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('NewRepo/bannerTitle', [('index') : 2]), 'Residential serviced apartment', FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/clearSearch' // clear search result
        ))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/btnDeleteChipOrRow', [('chipValue') : ' आन्दोलन '
            , ('option') : ' close ']))

WebUI.setText(findTestObject('Input/synonyms', [('index') : 2]), Keys.chord('help7less', Keys.ENTER //hardcoded synonym row with index
        ))

WebUI.setText(findTestObject('Input/searchCustomSyn'), '7LeSS' //used uppercase to verify search result
    )

WebUI.verifyElementPresent(findTestObject('ICONS/matChip', [('chipValue') : ' help7less ']), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : 'Save']))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)