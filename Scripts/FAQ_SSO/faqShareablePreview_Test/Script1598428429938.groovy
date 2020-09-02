import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.PREVIEW_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

TestData testData = findTestData('Data Files/testData_QueryResponse')

if (WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Trained', FailureHandling.OPTIONAL)) {
    CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/makeLive'))

    WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 15, FailureHandling.STOP_ON_FAILURE //        WebUI.verifyElementText(findTestObject('Generic/articleState'), 'Live', FailureHandling.OPTIONAL)
        )
} else {
    KeywordUtil.logInfo('*** CORPUS IS LIVE ***')
}

CustomKeywords.'platform.Preview.doShareablePreview'()

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('faq_sp_query', 1), Keys.ENTER))

WebUI.verifyElementAttributeValue(findTestObject('NewRepo2/imgResponse'), 'src', testData.getValue('faq_sp_response', 1), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('NewRepo2/linkResponse'), 10)

WebUI.verifyElementPresent(findTestObject('NewRepo2/linkResponse'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/linkResponse'))

WebUI.switchToWindowTitle(GlobalVariable.PREVIEW_BOT)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('faq_sp_query', 2), Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('NewRepo2/audioResponse'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('faq_sp_query', 3), Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('NewRepo2/videoResponse'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(testData.getValue('faq_sp_query', 4), Keys.ENTER))

WebUI.delay(2)

WebUI.verifyElementClickable(findTestObject('NewRepo2/btnQuickReply', [('value') : 'Flat']), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/btnQuickReply', [('value') : 'Studio apartment' // hardcode the button to click on studi apartment
        ]))

WebUI.verifyElementText(findTestObject('NewRepo/bannerTitle', [('index') : 2]), 'Residential serviced apartment', FailureHandling.STOP_ON_FAILURE // hardcoded banner value to 2 to verify text
    )

//verify side nav functionality on preview
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/carouselSliderOnPreview', [('value') : 'fa fa-angle-right']))

WebUI.verifyElementVisible(findTestObject('NewRepo2/btnCarouselResponse', [('value') : 'Book now!']), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/carouselSliderOnPreview', [('value') : 'fa fa-angle-left']))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo2/btnCarouselResponse', [('value') : 'Contact here!']))

WebUI.verifyElementText(findTestObject('GenericII/getBotResponse', [('index') : 4]), testData.getValue('faq_sp_response', 
        3), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Button/upvote'))