package platform
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class AppleBusinessChat extends Method {


	@Keyword
	def boolean verifyListpickerOnTemplate(){
		return WebUI.verifyElementVisible(findTestObject('ICONS/listPickerABC'), FailureHandling.STOP_ON_FAILURE)
	}


	@Keyword
	def boolean verifyListpickerOnAddition(TestObject testObject){
		WebUI.verifyElementText(testObject, 'List Picker')
	}

	@Keyword
	def setListPickerTitle(String value){
		clickOnElement(findTestObject('AppleBusinessChat/title'))
		WebUI.setText(findTestObject('AppleBusinessChat/title'), value)
	}

	@Keyword
	def removeListPickerTitle(){
		WebUI.clearText(findTestObject('AppleBusinessChat/title'), FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def setListPickerReplyTitle(String value){
		clickOnElement(findTestObject('AppleBusinessChat/replyTitle'))
		WebUI.setText(findTestObject('AppleBusinessChat/replyTitle'), value)
	}

	@Keyword
	def setListTitle(String num, String value){
		clickOnElement(findTestObject('AppleBusinessChat/listTitle',['index': num]))
		WebUI.setText(findTestObject('AppleBusinessChat/listTitle',['index': num]), value)
	}

	@Keyword
	def setListItemTitle(String num, String value){
		clickOnElement(findTestObject('AppleBusinessChat/itemTitle',['index': num]))
		WebUI.setText(findTestObject('AppleBusinessChat/itemTitle',['index': num]), value)
	}

	@Keyword
	def setItemIdentifier(String num, String value){
		clickOnElement(findTestObject('AppleBusinessChat/listItemIdentifier',['index': num]))
		WebUI.setText(findTestObject('AppleBusinessChat/listItemIdentifier',['index': num]), value)
	}
}
