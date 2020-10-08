import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
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
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser(GlobalVariable.URL)

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [('username') : GlobalVariable.USERNAME, ('password') : GlobalVariable.PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Task bots', 'file_text_attachment_bot')

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/training'))

//WebUI.callTestCase(findTestCase('Sprint/v4.4/mapLocationEntityCreation_Test'), [:], FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Sprint/v4.4/mapLocationEntityTaggingInIntent_Test'), [:], FailureHandling.CONTINUE_ON_FAILURE)

/*WebUI.callTestCase(findTestCase('Sprint/v4.4/mapLocationLinkToSlots_Test'), [('newXpath') : '//tbody[2]/tr[1]/td[3]/mat-checkbox//div/input'
        , ('image_title') : 'map_loc.jpg'], FailureHandling.CONTINUE_ON_FAILURE)*/

