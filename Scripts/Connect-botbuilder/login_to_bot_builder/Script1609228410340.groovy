import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.openBrowser(GlobalVariable.CONNECT_URL)

WebUI.sendKeys(findTestObject('BOTBUILDER/inputUserName'), GlobalVariable.CONNECT_USERNAME)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('BOTBUILDER/btnNext'))

WebUI.sendKeys(findTestObject('BOTBUILDER/inputPassword'), GlobalVariable.CONNECT_PASSWORD)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('BOTBUILDER/btnLogin'))

String currentWindow = DriverFactory.getWebDriver().getWindowHandle()

WebUI.mouseOver(findTestObject('BOTBUILDER/iconAppTray'), FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('BOTBUILDER/linkBotBuilder'))

Set<String> allTabTitle = DriverFactory.getWebDriver().getWindowHandles()

Iterator<String> windowIterator = allTabTitle.iterator()

while (windowIterator.hasNext()) {
    String childwindow = windowIterator.next()

    if (!(childwindow.equalsIgnoreCase(currentWindow))) {
        DriverFactory.getWebDriver().switchTo().window(childwindow //        System.out.println('The child window is ' + childwindow)
            )
    }
}

assert DriverFactory.getWebDriver().getTitle().contentEquals('IMIbot.ai') == true

WebUI.verifyElementPresent(findTestObject('Button/createBot'), 30, FailureHandling.CONTINUE_ON_FAILURE)