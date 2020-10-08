import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Generic/userInitials'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Enterprise profile']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/newToken'))

description = java.time.LocalDate.now().toString()

WebUI.sendKeys(findTestObject('Input/newTokenDescription'), description)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/create'))

List<WebElement> listOfServiceKeys = WebUiCommonHelper.findWebElements(findTestObject('GenericII/serviceKeyList'), 5)

assert listOfServiceKeys.get(0).getText().contentEquals(description) == true

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/deleteServiceKey', [('index') : 1]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/expire'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Expired']))

List<WebElement> listOfExpiredServiceKeys = WebUiCommonHelper.findWebElements(findTestObject('GenericII/serviceKeyList'), 
    5)

assert listOfExpiredServiceKeys.get(0).getText().contentEquals(description) == true