import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', GlobalVariable.TASK_BOT)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/training'))

CustomKeywords.'platform.Training.addSingleUtterance'(testValue)

List<WebElement> allMarkedUpEntitiesValues = WebUiCommonHelper.findWebElements(findTestObject('Slots/markedUpEntity'), 5)

allMarkedUpEntitiesValues.containsAll(markedUpEntitiesTestValue)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Slots/trashIcon', [('rowValue') : 1]))

WebUI.verifyElementText(findTestObject('Slots/markedUpEntity'), markedUpTestValue, FailureHandling.STOP_ON_FAILURE)

