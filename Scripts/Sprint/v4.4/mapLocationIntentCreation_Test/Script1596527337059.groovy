import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

TestData testData = findTestData('Data Files/testData_Task')

CustomKeywords.'platform.Training.addSingleUtterance'(testData.getValue('map_utterance', 1))

/*
 * Following set of code is to check if user can manually tag an utterance to map location entity
 */
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Slots/listOfUtterance'), 5)

element.click()

element.sendKeys(Keys.chord(Keys.CONTROL, 'a'))

element.click()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/entitySelection'))

ArrayList<WebElement> entityOptions = WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/getOptions'), 20)

//assert entityOptions.contains(testData.getValue('map_entity', 2)) == false
for (WebElement value : entityOptions) {
    assert value.getText().contentEquals(testData.getValue('map_entity', 2)) == false
}

KeywordUtil.markPassed('*** Map location entity not found ***')

/*
 * Following lines of code is to check if, new map location entity can be created from intent, tags the utterance
 */

WebUI.executeJavaScript('document.getElementsByClassName(\'cdk-overlay-pane\')[1].hidden = true;', null)

//CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/removeEntity'))

CustomKeywords.'platform.Training.createNewEntityManually'(testData.getValue('map_entity', 3), ' Map location ', null)

WebUI.executeJavaScript("document.getElementsByClassName('utter')[0].blur();", null)

WebUI.verifyElementNotPresent(findTestObject('Slots/markedUpEntity'), 20, FailureHandling.STOP_ON_FAILURE)