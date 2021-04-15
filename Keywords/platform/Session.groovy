package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Session  extends Method {

	static String KEY_VALUE="TEST"

	@Keyword
	def searchByRoomID(String getRoomID){
		WebUI.waitForElementClickable(findTestObject('Input/roomID', [('value') : 'id']), 30, FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Input/roomID', [('value') : 'id']), getRoomID)
		clickOnElement(findTestObject('Button/submitSession'))
	}

	@Keyword
	def searchByConsumerID(String getConsumerID){
		WebUI.setText(findTestObject('Input/consumerID'), getConsumerID)
		clickOnElement(findTestObject('Button/submitSession'))
	}

	@Keyword
	def searchByMaxMinMessage(String min, String max){
		WebUI.setText(findTestObject('Input/minMessage'), min)
		WebUI.setText(findTestObject('Input/maxMessage'), max)
		clickOnElement(findTestObject('Button/submitSession'))
	}

	@Keyword
	def searchByChannels(String channelName){
		List<WebElement> allChannels = WebUiCommonHelper.findWebElements(findTestObject('NewRepo/channelName'), 5)
		for(int count=0; count<allChannels.size();count++){
			if(allChannels.get(count).getAttribute('alt').contains(channelName)){
				clickOnElement(findTestObject('NewRepo/channelCheckbox',['channelName':channelName]))
				break
			}
		}
		clickOnElement(findTestObject('Button/submitSession'))
	}

	@Keyword
	def searchByRoomMetaData(String metaDataName){
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue': metaDataName]))
		clickOnElement(findTestObject('Button/submitSession'))
	}

	@Keyword
	def decryptSession(String roomID){
		searchByRoomID(roomID)
		WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]), 30, FailureHandling.OPTIONAL)
		clickOnElement(findTestObject('Generic/webObjectWithText', [('textValue') : roomID]))
		WebUI.sendKeys(findTestObject('Input/key'), KEY_VALUE)
		clickOnElement(findTestObject('Button/decrypt'))
	}
}
