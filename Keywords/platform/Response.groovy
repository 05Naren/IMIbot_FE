package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Response extends Method {

	WebDriver driver = DriverFactory.getWebDriver()

	/*
	 * Method to click on independent object
	 */
	@Keyword
	def clickOnElement(TestObject testObject){
		JavascriptExecutor js = (JavascriptExecutor)driver
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 5)
		js.executeScript("arguments[0].click();", element)
	}

	/*
	 * Specifically designed to add carousel type response to an article or template key
	 * @Parameters: isFirst-> boolean true or false to delete default text response
	 * labelValue-> to enter text to carousel label, carouselURL-> to add picture to carousel if any,
	 * labelName-> name to displayed on button, payloadQuestion->question associated to be with carousel 
	 */
	@Keyword
	def addCarousel(boolean isFirst, TestData testData, String labelValue, String carouselURL){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		toClickOnWebElement(findTestObject('NewRepo/carousel'))
		WebUI.setText(findTestObject('NewRepo/carouselLabel',['index': 1]), testData.getValue(labelValue, 1))
		WebUI.setText(findTestObject('NewRepo/carouselURL',['index': 1]), testData.getValue(carouselURL, 1))
		toClickOnWebElement(findTestObject('NewRepo/renewBtn',['index': 1]))
		toClickOnWebElement(findTestObject('Generic/webObjectWithText',['textValue':'Delete']))
	}

	@Keyword
	def addCarousel(boolean isFirst){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('NewRepo/carousel'))
	}

	@Keyword
	def carouselPayload(int index, String header, String url, String payloadLabel, String payloadQuestion){
		WebUI.setText(findTestObject('NewRepo/carouselLabel',['index': index]), header)
		WebUI.setText(findTestObject('NewRepo/carouselURL',['index': index]), url)
		clickOnElement(findTestObject('Button/btnRenewCarousel'))
		WebUI.setText(findTestObject('NewRepo/labelInput'), payloadLabel)
		WebUI.sendKeys(findTestObject('NewRepo/payloadQuestionInput'), payloadQuestion)
		clickOnElement(findTestObject('Generic/searchResult'))
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Done']))
	}

	def updateCarouselData(TestData testData, String labelName, String payloadQuestion){
		if(WebUI.verifyElementPresent(findTestObject('NewRepo/renewBtn',['index': 1]), 5)){
			toClickOnWebElement(findTestObject('NewRepo/renewBtn',['index': 1]))
		}else if(WebUI.verifyElementPresent(findTestObject('NewRepo/addNewCarouselBtn',['index': 1]), 5)){
			toClickOnWebElement(findTestObject('NewRepo/addNewCarouselBtn',['index': 1]))
		}
		WebUI.setText(findTestObject('NewRepo/labelInput'), testData.getValue(labelName, 1))
		WebUI.sendKeys(findTestObject('NewRepo/payloadQuestionInput'), testData.getValue(payloadQuestion, 1))
		toClickOnWebElement(findTestObject('Generic/searchResult'))
		toClickOnWebElement(findTestObject('Generic/webObjectWithText',['textValue':'Done']))

		WebUI.comment('******')
	}

	@Keyword
	def createDynamicResponse(String templateKeyName, String fileName){
		clickOnElement(findTestObject('NewRepo2/addNewResponse'))
		WebUI.setText(findTestObject('NewRepo2/templateKeyName'), templateKeyName)
		clickOnElement(findTestObject('Button/create'))
		WebUI.delay(2)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Rich']))
		clickOnElement(findTestObject('NewRepo2/dynamic'))
		WebUI.uploadFile(findTestObject('Input/uploadFile'), Method.PATH+fileName)
		clickOnElement(findTestObject('NewRepo/refresh'))
	}

	@Keyword
	def createRichResponse(String templateKeyName, String value){
		clickOnElement(findTestObject('NewRepo2/addNewResponse'))
		WebUI.setText(findTestObject('NewRepo2/templateKeyName'), templateKeyName)
		clickOnElement(findTestObject('Button/create'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Input/textResponse'), value)
		clickOnElement(findTestObject('NewRepo/refresh'))
	}

	@Keyword
	def addImage(boolean isFirst, String value){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('ICONS/image'))
		WebUI.setText(findTestObject('Input/imageURL'), value)
	}

	@Keyword
	def addText(String textValue){
		clickOnElement(findTestObject('ICONS/text'))
		WebUI.setText(findTestObject('Input/textResponse'), textValue)
	}

	@Keyword
	def addCodeFunction(boolean isFirst, String fileName){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('ICONS/code'))
		clickOnElement(findTestObject('ICONS/importIcon'))
		WebUI.uploadFile(findTestObject('Input/uploadFile'), RunConfiguration.getProjectDir()+'/Collection/' + fileName)
	}


	@Keyword
	def addQuickReplies(boolean isFirst, String header){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('ICONS/quickReply'))
		WebUI.setText(findTestObject('Input/quickReplyHeader'), header)
	}

	@Keyword
	def quickRepliesPayload(String title, String searchQuestion){
		clickOnElement(findTestObject('Button/addReplies'))
		clickOnElement(findTestObject('Button/btnNewReply'))
		WebUI.setText(findTestObject('Input/titlePayload'), title)
		WebUI.sendKeys(findTestObject('NewRepo/payloadQuestionInput'), searchQuestion)
		clickOnElement(findTestObject('Generic/searchResult'))
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Done']))
	}

	@Keyword
	def addAudio(boolean isFirst){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('ICONS/audio'))
		WebUI.setText(findTestObject('Input/mediaURL'), 'https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_700KB.mp3')
	}

	@Keyword
	def addVideo(boolean isFirst){
		if(isFirst){
			clickOnElement(findTestObject('GenericII/trashIcon'))
		}
		clickOnElement(findTestObject('ICONS/video'))
		WebUI.setText(findTestObject('Input/mediaURL'), 'https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4')
	}
}
