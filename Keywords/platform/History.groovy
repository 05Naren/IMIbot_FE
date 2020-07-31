package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class History extends Method {

	@Keyword
	def makeLive(String description){
		List<WebElement> listOfComment = WebUiCommonHelper.findWebElements(findTestObject('NewRepo2/kbDescription'), 10)
		for(int count=0;count<listOfComment.size();count++){
			if(listOfComment.get(count).getText().contains(description)){
				WebUI.mouseOver(findTestObject('NewRepo2/action',['index': count+1]))
				clickOnElement(findTestObject('NewRepo2/goLive'))
				break
			}
		}
	}

	@Keyword
	def startPreview(String description){
		List<WebElement> listOfComment = WebUiCommonHelper.findWebElements(findTestObject('NewRepo2/kbDescription'), 10)
		for(int count=0;count<listOfComment.size();count++){
			if(listOfComment.get(count).getText().contains(description)){
				WebUI.mouseOver(findTestObject('NewRepo2/action',['index': count+1]))
				clickOnElement(findTestObject('NewRepo2/previewFromHistory'))
				break
			}
		}
	}
	
	@Keyword
	def loadCorpus(String description){
		List<WebElement> listOfComment = WebUiCommonHelper.findWebElements(findTestObject('NewRepo2/kbDescription'), 10)
		for(int count=0;count<listOfComment.size();count++){
			if(listOfComment.get(count).getText().contains(description)){
				WebUI.mouseOver(findTestObject('NewRepo2/action',['index': count+1]))
				clickOnElement(findTestObject('NewRepo2/loadCorpus'))
				break
			}
		}
	}
}
