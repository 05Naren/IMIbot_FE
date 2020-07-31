import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Generic/userInitials'), GlobalVariable.USER_INITIALS, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/enterpriseDropdown'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/eProfile'))

WebUI.verifyElementPresent(findTestObject('Generic/updateBtn'), 15, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/enterpriseDropdown'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/signOut'))

WebUI.verifyElementText(findTestObject('Generic/textOnLoginPage'), testValue, FailureHandling.STOP_ON_FAILURE)

