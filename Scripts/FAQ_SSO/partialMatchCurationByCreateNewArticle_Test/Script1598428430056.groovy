import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.StaleElementReferenceException as StaleElementReferenceException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.trainAndComment'(comment)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), stringToCheck, FailureHandling.OPTIONAL)

ArrayList getRoomIdAt = new ArrayList()

getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

/*
CustomKeywords.'platform.Preview.downvoteResponseWithComment'(feedback)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

TestObject downvote = WebUI.modifyObjectProperty(findTestObject('ICONS/downvote'), 'xpath', 'not equals', '//mat-icon[text()=\'thumb_down\']', 
    true, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(downvote)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : ' Partial match ']))

WebUI.verifyTextPresent('Partial match', false, FailureHandling.STOP_ON_FAILURE)

roomID = getRoomIdAt.get(0).toString()

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

try {
    WebUI.waitForElementPresent(findTestObject('Button/addToNewArticle'), 20, FailureHandling.OPTIONAL)

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addToNewArticle'))
}
catch (StaleElementReferenceException ex) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addToNewArticle'))
} 

WebUI.setText(findTestObject('Input/textResponse'), newArticleResponse)

CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'((' ' + saveArticleTo) + ' ')

/*if (WebUI.getText(findTestObject('Generic/articleState'), FailureHandling.OPTIONAL).contains('Training')) {
    WebUI.delay(10 //    CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('NewRepo/refresh'))
        )
} else {
    KeywordUtil.logInfo('BOT IS READY!')
}
*/
try {
    WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
    KeywordUtil.logInfo('BOT IS READY!')
} 

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse', [('index') : 2]), 10)

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 2]), newArticleResponse, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/minimize'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Resolved']), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Resolved']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyTextPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)