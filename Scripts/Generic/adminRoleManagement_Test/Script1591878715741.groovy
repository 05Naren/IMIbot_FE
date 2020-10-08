import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/userOptions'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Enterprise profile']))*/

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Roles']))

WebUI.verifyElementClickable(findTestObject('Button/newRole'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/newRole'))

WebUI.sendKeys(findTestObject('Input/newRoleName'), GlobalVariable.ROLE_NAME)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Base role']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : typeOfUser]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : permissionToUser]))

List<WebElement> listOfPermissions = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfPermissions'), 5)

int index

for (index = 0; index < listOfPermissions.size(); index++) {
    listOfPermissions.get(index).getText().contains(nameOfThePermission)

    index++

    break
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/addPermissionBtn', [('index') : index]))

WebUI.verifyElementClickable(findTestObject('Button/createRole'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/createRole'))

//WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText',['textValue': GlobalVariable.ROLE_NAME]), 20, FailureHandling.OPTIONAL)

WebUI.verifyTextPresent(GlobalVariable.ROLE_NAME, false)

