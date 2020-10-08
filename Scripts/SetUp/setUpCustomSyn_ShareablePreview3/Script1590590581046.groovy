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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/imiLogo'))

WebUI.waitForElementVisible(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.PREVIEW_BOT)
*/
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

TestData testData = findTestData('Data Files/testData_Dummy')

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('article_default_question', 3))

//CustomKeywords.'platform.Response.addQuickReplies'(false, testData.getValue('quick_reply', 1))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/quickReply'))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

CustomKeywords.'platform.ResponseDesigner.configureQuickReplyResponse'(testData.getValue('quick_reply', 1))

for (int count = 1; count <= testData.getRowNumbers(); count++) {
    /*  CustomKeywords.'platform.Response.quickRepliesPayload'(testData.getValue('quick_reply_title', count), testData.getValue(
            'carousel_question', count))*/
    CustomKeywords.'platform.ResponseDesigner.addQuickReplyButton'()

    CustomKeywords.'platform.ResponseDesigner.configureBtnPopUp'('faq', testData.getValue('quick_reply_title', count), testData.getValue(
            'carousel_question', count))

    if (testData.getValue('quick_reply_title', count + 1) == '') {
        break
    }
}

CustomKeywords.'platform.Articles.saveAndTrainArticleToNewCategory'(testData.getValue('category', 3))

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(testData, 'मैं कुछ सुखदायक संगीत सुनना चाहता हूं')

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('audio', 'https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_700KB.mp3')

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

//CustomKeywords.'platform.Response.addAudio'(false)
CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(testData, 'عرض فيديو مثير للاهتمام')

CustomKeywords.'platform.ResponseDesigner.configureMediaResponse'('video', 'https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4')

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

//CustomKeywords.'platform.Response.addVideo'(false)
CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.selectFromKebabMenu'(findTestObject('Button/importIcon'), 'Import From CSV')

CustomKeywords.'platform.Method.uploadCsvFile'(false, 'faq_CS.csv')

CustomKeywords.'platform.Method.trainAndComment'('imported hindi arabic article')