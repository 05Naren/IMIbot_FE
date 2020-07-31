import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/enterpriseDropdown'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Enterprise profile']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Roles']))

List<WebElement> role = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfAllRoleName'), 5)

int count

for (count = 0; count < role.size(); count++) {
    if (role.get(count).getText().contentEquals(GlobalVariable.ROLE_NAME)) {
        count++

        KeywordUtil.markPassed('ROLE FOUND IN THE LIST')

        break
    }
}

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('GenericII/modifyRole', [('index') : count]))

WebUI.verifyTextPresent('Edit role', false, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/delete'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/remove'))

WebUI.verifyTextNotPresent(GlobalVariable.ROLE_NAME, false, FailureHandling.STOP_ON_FAILURE)