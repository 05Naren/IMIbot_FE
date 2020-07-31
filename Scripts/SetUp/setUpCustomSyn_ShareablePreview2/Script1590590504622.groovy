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

WebUI.callTestCase(findTestCase('Generic/successfulLogin_Test'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Method.navigateToBot'('Q&A bots', GlobalVariable.PREVIEW_BOT)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/articles'))

TestData testData = findTestData('Data Files/testData_Dummy')

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('carousel_question', 1))

//CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('carousel_question', 1))
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/carousel'))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

//CustomKeywords.'platform.Response.addCarousel'(false)
for (int count = 1; count <= testData.getRowNumbers(); count++) {
    /*CustomKeywords.'platform.Response.carouselPayload'(count, testData.getValue('service_carousel_header', count), testData.getValue(
            'service_carousel_url', count), testData.getValue('carousel_payload_label', count), testData.getValue('carousel_payload_question', 
            count))*/
    CustomKeywords.'platform.ResponseDesigner.configureCarouselResponse'(count, null, testData.getValue('service_carousel_url', 
            count), testData.getValue('service_carousel_header', count), testData.getValue('carousel_payload_label', count), 
        testData.getValue('carousel_payload_question', count))

    if (testData.getValue('service_carousel_header', count + 1) == '') {
        break
    } else {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/addCarousel'))
    }
}

CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.verifyElementPresent(findTestObject('ICONS/toastMsg'), 30, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('carousel_question', 2))

//CustomKeywords.'platform.Response.addCarousel'(false)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/carousel'))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

for (int count = 1; count <= testData.getRowNumbers(); count++) {
    /*CustomKeywords.'platform.Response.carouselPayload'(count, testData.getValue('indp_carousel_header', count), testData.getValue(
            'indp_carousel_url', count), testData.getValue('carousel_payload_label', count), testData.getValue('carousel_payload_question', 
            count))*/
    CustomKeywords.'platform.ResponseDesigner.configureCarouselResponse'(count, null, testData.getValue('indp_carousel_url', 
            count), testData.getValue('indp_carousel_header', count), testData.getValue('carousel_payload_label', count), 
        testData.getValue('carousel_payload_question', count))

    if (testData.getValue('indp_carousel_header', count + 1) == '') {
        break
    } else {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/addCarousel'))
    }
}

CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'platform.Articles.createNewArticle'(testData, testData.getValue('carousel_question', 3))

//CustomKeywords.'platform.Response.addCarousel'(false)
CustomKeywords.'platform.Method.clickOnElement'(findTestObject('NewRepo/carousel'))

CustomKeywords.'platform.ResponseDesigner.deleteDefaultTextTemplate'()

for (int count = 1; count <= testData.getRowNumbers(); count++) {
    /* CustomKeywords.'platform.Response.carouselPayload'(count, testData.getValue('bhk_carousel_header', count), testData.getValue(
            'bhk_carousel_url', count), testData.getValue('carousel_payload_label', count), testData.getValue('carousel_payload_question', 
            count))*/
    CustomKeywords.'platform.ResponseDesigner.configureCarouselResponse'(count, null, testData.getValue('bhk_carousel_url', 
            count), testData.getValue('bhk_carousel_header', count), testData.getValue('carousel_payload_label', count), 
        testData.getValue('carousel_payload_question', count))

    if (testData.getValue('bhk_carousel_header', count + 1) == '') {
        break
    } else {
        CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/addCarousel'))
    }
}

CustomKeywords.'platform.Articles.saveAndTrainArticleToExistingCategory'(' Unassigned ')

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)