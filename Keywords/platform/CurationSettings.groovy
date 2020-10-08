package platform
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CurationSettings extends Method{

	@Keyword
	def disableCuration(boolean disable){
		if(disable){
			//			clickOnElement(null)
			clickOnElement(findTestObject('Toggle/curation'))
		}else{
			clickOnElement(findTestObject('Toggle/curation'))
			KeywordUtil.logInfo('CURATION ENABLED')
		}
	}

	@Keyword
	def disableFallback(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/fallback'))
		}else{
			clickOnElement(findTestObject('Toggle/fallback'))
			KeywordUtil.logInfo('FALLBACK ENABLED')
		}
	}

	@Keyword
	def disablePartialMatch(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/partialMatch'))
		}else{
			clickOnElement(findTestObject('Toggle/partialMatch'))
			KeywordUtil.logInfo('PARTIAL MATCH ENABLED')
		}
	}

	@Keyword
	def disableAgentHandover(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/agentHandover'))
		}else{
			clickOnElement(findTestObject('Toggle/agentHandover'))
			KeywordUtil.logInfo('AGENT HANDOVER ENABLED')
		}
	}

	@Keyword
	def disableDownvoted(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/downvoted'))
		}else{
			clickOnElement(findTestObject('Toggle/downvoted'))
			KeywordUtil.logInfo('DOWNVOTE ENABLED')
		}
	}

	@Keyword
	def disableAddFromSession(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/addFromSession'))
		}else{
			clickOnElement(findTestObject('Toggle/addFromSession'))
			KeywordUtil.logInfo('ADD FROM SESSION ENABLED')
		}
	}

	@Keyword
	def disableLowConfidence(boolean disable){
		if(disable){
			clickOnElement(findTestObject('Toggle/lowConfidence'))
		}else{
			clickOnElement(findTestObject('Toggle/lowConfidence'))
			WebUI.setText(findTestObject('Input/lowConfidenceValue'), GlobalVariable.LOW_CONFIDENCE_SCORE)
			KeywordUtil.logInfo('LOW CONFIDENCE ENABLED')
		}
	}

	@Keyword
	def filterRuleTriggered(String filterBy){
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Rule triggered']))
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':' '+filterBy+' ']))
		clickOnElement(findTestObject('Button/filter'))
	}
}
