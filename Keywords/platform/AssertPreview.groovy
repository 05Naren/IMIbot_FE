package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class AssertPreview {

	static int index;

	@Keyword
	def sendUserMessage(String userMessage){
		WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userMessage, Keys.ENTER))
	}

	@Keyword
	def boolean verifyTextInResponse(int botMessageIndex, String textToMatch){
		return WebUI.verifyElementText(findTestObject('GenericII/getBotResponse',['index': botMessageIndex]), textToMatch, FailureHandling.OPTIONAL)
	}

	@Keyword
	def boolean verifyTextLinkInResponse(String urlToMatch){
		return WebUI.verifyElementText(findTestObject('WEB_OBJECTS/textLink'), urlToMatch, FailureHandling.OPTIONAL)
	}

	@Keyword
	def boolean verifyImageInResponse(String url){
		if(WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/imageRes'), 20, FailureHandling.OPTIONAL)) {
			return WebUI.verifyElementAttributeValue(findTestObject('WEB_OBJECTS/imageRes'), 'src', url, 20)
		}
	}


	@Keyword
	def boolean verifyAudioInResponse(String url){
		if(WebUI.verifyElementPresent(findTestObject('NewRepo2/audioResponse'), 20, FailureHandling.OPTIONAL)) {
			TestObject testObject = WebUI.modifyObjectProperty(findTestObject('NewRepo2/audioResponse'), 'xpath', 'not equals', "//audio/source", true)
			return WebUI.verifyElementAttributeValue(testObject, 'src', url, 20)
		}
	}

	@Keyword
	def boolean verifyVideoInResponse(String url){
		if(WebUI.verifyElementPresent(findTestObject('NewRepo2/videoResponse'), 20, FailureHandling.OPTIONAL)) {
			TestObject testObject = WebUI.modifyObjectProperty(findTestObject('NewRepo2/videoResponse'), 'xpath', 'not equals', "//video/source", true)
			return WebUI.verifyElementAttributeValue(testObject, 'src', url, 20)
		}
	}

	@Keyword
	def boolean verifyQuickReplyBtnInResponse(){
		return WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS/resQR'), 20, FailureHandling.OPTIONAL)
	}

	@Keyword
	def boolean verifyUrlButtonOnQR(){
		List<WebElement> button=WebUiCommonHelper.findWebElements(findTestObject('WEB_OBJECTS/qrBtn'), 20)
		for(int count=0; count<button.size(); count++){
			if(button.get(count). getAttribute("data-payload")==null){
				this.index=count++;
				return true
			}
		}
		return false
	}
}
