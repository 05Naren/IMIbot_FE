import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.FAQ_BOT_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Modify']))

List<WebElement> categories = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfCategory'), 10)

int index

for (int i = 2; i < categories.size(); i++) {
    if (categories.get(i).getAttribute('value').contains('Benefits')) {
        index = (i - 1)

//        return index
        
        break
    }
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/editCategory', [('index') : index]))

WebUI.setText(findTestObject('Input/nameOfTheCategory'), newCategoryName, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/save', [('value') : ' Save ']))

WebUI.delay(1)

WebUI.verifyTextPresent(newCategoryName, false, FailureHandling.STOP_ON_FAILURE)