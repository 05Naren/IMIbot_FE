import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.StaleElementReferenceException as StaleElementReferenceException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : ' Fallback ']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

try {
    WebUI.verifyElementPresent(findTestObject('Button/addToExistingArticle'), 20, FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addToExistingArticle'))
}
catch (StaleElementReferenceException ex) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/addToExistingArticle'))
} 

WebUI.sendKeys(findTestObject('Input/searchQuestion'), searchQuestion)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/searchResult'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/linkAndSave'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/trainCuration'))

WebUI.sendKeys(findTestObject('Input/comment'), comment)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/continue'))

WebUI.waitForElementVisible(findTestObject('Generic/webObjectWithText',['textValue':'Trained corpus']), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/refresh'))

WebUI.verifyTextPresent('Trained corpus', false, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

WebUI.delay(1)

CustomKeywords.'platform.Preview.verifyBotResponse'(botResponse)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/curation'))

WebUI.waitForElementVisible(findTestObject('Generic/webObjectWithText', [('textValue') : 'Resolved']), 20, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Resolved']))

WebUI.sendKeys(findTestObject('Input/roomID', [('value') : 'room_id']), roomID)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/filter'))

WebUI.verifyTextPresent(roomID, false, FailureHandling.STOP_ON_FAILURE)