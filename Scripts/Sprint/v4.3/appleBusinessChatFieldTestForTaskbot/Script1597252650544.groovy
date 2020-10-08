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

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

// setting up stable environment
CustomKeywords.'platform.Method.navigateToBot'('Task bots', botName)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/response'))

CustomKeywords.'platform.Response.createRichResponse'('apple business chat', 'ignore text')*/

CustomKeywords.'platform.ResponseDesigner.addChannelToResponse'(' Apple Business Chat')

assert CustomKeywords.'platform.AppleBusinessChat.verifyListpickerOnTemplate'() == true

CustomKeywords.'platform.ResponseDesigner.addListpickerResponse'()

assert CustomKeywords.'platform.AppleBusinessChat.verifyListpickerOnAddition'(findTestObject('WEB_OBJECTS/templateHeader', 
        [('index') : 2])) == true

//Inline alert test for title on listpicker configuration section
CustomKeywords.'platform.AppleBusinessChat.setListPickerTitle'('')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/title'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerTitle'(' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/title'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerTitle'(testData)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertMaxCharacter'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerTitle'('dummy data')

//Inline alert test for reply title on listpicker configuration section
CustomKeywords.'platform.AppleBusinessChat.setListPickerReplyTitle'('')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/replyTitle'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerReplyTitle'(' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/replyTitle'))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerReplyTitle'(testData)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertMaxCharacter'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListPickerTitle'('dummy reply title')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('AppleBusinessChat/listSection' //user navigates to list section
        ))

//Inline alert test for list title on listpicker List sections
CustomKeywords.'platform.AppleBusinessChat.setListTitle'('1', '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/listTitle', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListTitle'('1', ' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/listTitle', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListTitle'('1', testData)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertMaxCharacter'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListTitle'('1', 'dummy list title')

//Inline alert test for list item title on listpicker List sections
CustomKeywords.'platform.AppleBusinessChat.setListItemTitle'('1', '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/itemTitle', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListItemTitle'('1', ' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/itemTitle', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListItemTitle'('1', testData)

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertMaxCharacter'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setListItemTitle'('1', 'dummy list item title')

assert WebUiCommonHelper.findWebElement(findTestObject('AppleBusinessChat/itemTitleHeader', [('index') : '1']), 20).getText().contains(
    'dummy list item title') == true

//Inline alert test for list item identfier on listpicker List sections
CustomKeywords.'platform.AppleBusinessChat.setItemIdentifier'('1', '')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/listItemIdentifier', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setItemIdentifier'('1', ' ')

CustomKeywords.'platform.Method.removeFocus'(findTestObject('AppleBusinessChat/listItemIdentifier', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertInvalidData'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.AppleBusinessChat.setItemIdentifier'('1', 'dummy list item title')