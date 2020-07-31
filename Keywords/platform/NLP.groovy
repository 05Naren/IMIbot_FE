package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class NLP extends Method {

	@Keyword
	def addCustom_NER(){
		WebUI.sendKeys(findTestObject('Input/librariesAndModules'), 'custom')
		clickOnElement(findTestObject('NewRepo/moduleResult'))
		clickOnElement(findTestObject('NewRepo/addModule',['index':1]))
		clickOnElement(findTestObject('Button/updatePipeline'))
		WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def createConcept(String conceptName, String fileName){
		if(WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText',['textValue':'Knowledge base']), 10, FailureHandling.OPTIONAL)){
			clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Knowledge base']))
		}else{
			KeywordUtil.logInfo('Knowledge base not found')
		}
		clickOnElement(findTestObject('Button/createConcept'))
		WebUI.sendKeys(findTestObject('Input/conceptName'), conceptName)
		WebUI.uploadFile(findTestObject('Input/uploadFile'), Method.PATH+fileName)
		toClickOnWebElement(findTestObject('NewRepo/createtBtn'))
	}

	@Keyword
	def createConceptType(String conceptType, boolean isMasked, String conceptName, String fileName){
		if(WebUI.verifyElementPresent(findTestObject('Generic/webObjectWithText',['textValue':'Knowledge base']), 10, FailureHandling.OPTIONAL)){
			clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Knowledge base']))
		}else{
			KeywordUtil.logInfo('Knowledge base not found')
		}
		clickOnElement(findTestObject('Button/createConcept'))
		if(conceptType.toLowerCase().contains('double match')){
			KeywordUtil.logInfo('****')
		}else{
			clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Double Match']))
			clickOnElement(findTestObject('NewRepo2/typeOfConcept',['value':conceptType]))
		}
		if(isMasked){
			clickOnElement(findTestObject('Toggle/masked'))
		}

		WebUI.sendKeys(findTestObject('Input/conceptName'), conceptName)
		WebUI.uploadFile(findTestObject('Input/uploadFile'), Method.PATH+fileName)
		clickOnElement(findTestObject('NewRepo/createtBtn'))
	}
}
