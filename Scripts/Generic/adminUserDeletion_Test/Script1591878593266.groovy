import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/enterpriseDropdown'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Enterprise profile']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Users']))

boolean flag = false

int index

while (flag != true) {
    List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfUserName'), 10)

    for (index = 0; index < listElement.size(); index++) {
        if (listElement.get(index).getText().contentEquals(username)) {
            flag = true

            index++

            break
        }
    }
    
    WebUI.waitForElementPresent(findTestObject('Generic/nextPage'), 15)

    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/nextPage'))
}

WebUI.verifyElementPresent(findTestObject('GenericII/unverifiedUserIcon', [('email') : email]), 5, FailureHandling.STOP_ON_FAILURE)

List<WebElement> listOfUsers = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfUserName'), 5)

int sizeOfOriginalList = listOfUsers.size()

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/deleteUserBtn', [('index') : index]))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/remove'))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.OPTIONAL)

List<WebElement> newListOfUsers = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfUserName'), 5)

assert newListOfUsers.size() < sizeOfOriginalList