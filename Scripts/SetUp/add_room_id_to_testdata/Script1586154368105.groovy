import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'(botType, botName)

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.toClickOnWebElement'(findTestObject('Button/preview'))

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))

List<StringBuilder> getRoomIdAt = CustomKeywords.'platform.Utility.getRoomID'()

CustomKeywords.'platform.Utility.overWriteTestData'(sheetName, rowNumber, cellNumber, getRoomIdAt.get(0).toString())