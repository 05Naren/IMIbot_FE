package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ResponseDesigner extends Method {

	//	boolean flag = true

	@Keyword
	def deleteDefaultTextTemplate(){
		WebUI.scrollToElement(findTestObject('WEB_OBJECTS/trashIcon',['index': 1]), 15)
		WebUI.waitForElementVisible(findTestObject('WEB_OBJECTS/trashIcon',['index': 1]), 15, FailureHandling.STOP_ON_FAILURE)
		clickOnElement(findTestObject('WEB_OBJECTS/trashIcon',['index': 1]))

	}

	@Keyword
	def deleteSecondaryTemplate(int number){
		WebUI.scrollToElement(findTestObject('WEB_OBJECTS/trashIcon',['index': number]), 15)
		WebUI.waitForElementVisible(findTestObject('WEB_OBJECTS/trashIcon',['index': number]), 15, FailureHandling.STOP_ON_FAILURE)
		clickOnElement(findTestObject('WEB_OBJECTS/trashIcon',['index': number]))

	}

	@Keyword
	def configureMediaResponse(String response, String url){

		switch (response) {

			case "audio":
				clickOnElement(findTestObject('ICONS/audio'))
			//				WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), url)
				break;
			case "video":
				clickOnElement(findTestObject('ICONS/video'))
			//				WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), url)
				break;
			case "image":
				clickOnElement(findTestObject('ICONS/image'))
			//				WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), url)
				break;

		}
		//		if(flag==true){}
		WebUI.setText(findTestObject('WEB_OBJECTS/mediaURL'), url)
	}

	@Keyword
	def configureTextResponse(String textValue){
		clickOnElement(findTestObject('ICONS/text'))
		WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), textValue)
	}

	@Keyword
	def configureCarouselResponse(int count, String bot, String url, String title, String buttonName, String payload){
		//		clickOnElement(findTestObject('NewRepo/carousel'))
		String modXpath = "//input[@formcontrolname='thumbnail_url']"
		/*
		 * Configuration of Carousel image
		 */
		clickOnElement(findTestObject('WEB_OBJECTS/configure',['index': count]))
		TestObject imageURL = WebUI.modifyObjectProperty(findTestObject('WEB_OBJECTS/mediaURL'), 'xpath', 'not equals', modXpath, true, FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(imageURL, url)
		clickOnElement(findTestObject('WEB_OBJECTS/view'))

		//Set Carousel title
		//		checkInlineAlertOnFields(findTestObject('WEB_OBJECTS/input'))
		WebUI.setText(findTestObject('WEB_OBJECTS/input',['index':count]), title)
		/*
		 * Default button configuration
		 */
		if(WebUI.waitForElementPresent(findTestObject('WEB_OBJECTS/button',['type':'primary','index':count]), 20, FailureHandling.OPTIONAL)){
			clickOnElement(findTestObject('WEB_OBJECTS/button',['type':'primary','index':count]))
		}else{
			clickOnElement(findTestObject('WEB_OBJECTS/button',['type':'secondary','index':count]))
		}

		WebUI.waitForElementPresent(findTestObject('WEB_OBJECTS/popUp'), 20, FailureHandling.STOP_ON_FAILURE)
		configureBtnPopUp(bot, buttonName, payload)//hardcoded
	}

	@Keyword
	def configureBtnPopUp(String bot, String buttonTitle, String payload){
		String modXpath = "//input[@formcontrolname='text']"
		TestObject inputForTitle = WebUI.modifyObjectProperty(findTestObject('WEB_OBJECTS/input'), 'xpath', 'not equals', modXpath, true, FailureHandling.STOP_ON_FAILURE)
		//		checkInlineAlertOnFields(inputForTitle)
		WebUI.setText(inputForTitle, buttonTitle)
		if(bot!=null && bot.contentEquals('faq')){
			WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/linkPayload'), 20, FailureHandling.STOP_ON_FAILURE)
			linkPayloadToArticle(payload)
		}else{
			WebUI.setText(findTestObject('WEB_OBJECTS/payload'), payload)
		}
		clickOnElement(findTestObject('WEB_OBJECTS/done'))
	}

	/*def modifyObjectXpath(TestObject testObject, String newXpath){
	 TestObject newObject = WebUI.modifyObjectProperty(testObject, 'xpath', 'not equals', newXpath, true)
	 clickOnElement(newObject)
	 }*/

	@Keyword
	def addQuickReplyButton(){
		//		modifyObjectXpath(findTestObject('WEB_OBJECTS/done'), "//button[text()='+ Add quick reply']")
		clickOnElement(findTestObject('WEB_OBJECTS/quickReplyBtn'))
	}

	@Keyword
	def checkInlineAlertOnFields(TestObject testObject){
		WebUI.waitForElementVisible(testObject, 20, FailureHandling.STOP_ON_FAILURE)
		try{
			WebElement field = WebUiCommonHelper.findWebElement(testObject, 10)
			if(!field.getAttribute('value').isEmpty()){
				field.clear()
			}else{
				field.clear()
			}
			/*	field.sendKeys(Keys.chord(Keys.DELETE))
			 WebUI.executeJavaScript("document.getElementByClass('title').reset();", null)
			 WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/alertRequired'), 20, FailureHandling.STOP_ON_FAILURE)*/
		}catch(Exception e){
			KeywordUtil.markFailed('Inline alert missing')
		}
	}

	def linkPayloadToArticle(String payload){
		clickOnElement(findTestObject('WEB_OBJECTS/linkPayload'))
		try{
			WebUI.verifyTextPresent('Article Search', false)
			WebUI.verifyTextPresent('Search and select the article to be configured as payload', false)
		}catch(Exception e){
			KeywordUtil.markFailed('Label Missing or Text missing')
		}
		WebUI.setText(findTestObject('WEB_OBJECTS/searchField'), payload)
		try{
			WebUI.verifyElementPresent(findTestObject('Generic/searchResult'), 20, FailureHandling.OPTIONAL)
			clickOnElement(findTestObject('Generic/searchResult'))
		}catch(Exception e){
			WebUI.verifyTextPresent('No questions found in all articles', false, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.logInfo('Verification Completed!')
		}

	}

	@Keyword
	def configureQuickReplyResponse(String value){
		WebUI.setText(findTestObject('WEB_OBJECTS/textArea'), value)
	}

	@Keyword
	def addCodeResponse(String fileName){
		clickOnElement(findTestObject('ICONS/code'))
		clickOnElement(findTestObject('ICONS/importIcon'))
		WebUI.uploadFile(findTestObject('Input/uploadFile'), RunConfiguration.getProjectDir()+'/Collection/' + fileName)

	}

	@Keyword
	def addChannelToResponse(String channelName){
		clickOnElement(findTestObject('WEB_OBJECTS/addChannelBtn'))
		//		selectFromTheList(findTestObject('WEB_OBJECTS/listOfChannels'), channelName)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':channelName]))
	}

	@Keyword
	def addListpickerResponse(){
		clickOnElement(findTestObject('ICONS/listPickerABC'))
	}

	/*
	 * File template function:
	 * 1. add template
	 * 2. set url
	 */

	@Keyword
	def addFileResponse(){
		clickOnElement(findTestObject('ICONS/file'))
	}

	@Keyword
	def setFileURL(){
		WebUI.setText(findTestObject('WEB_OBJECTS/fileURL'))
	}
}
