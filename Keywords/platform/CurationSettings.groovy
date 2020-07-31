package platform

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CurationSettings extends Method{

	@Keyword
	def disableCuration(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/curation'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/curation'))
			KeywordUtil.logInfo('CURATION ENABLED')
		}
	}

	@Keyword
	def disableFallback(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/fallback'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/fallback'))
			KeywordUtil.logInfo('FALLBACK ENABLED')
		}
	}

	@Keyword
	def disablePartialMatch(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/partialMatch'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/partialMatch'))
			KeywordUtil.logInfo('PARTIAL MATCH ENABLED')
		}
	}

	@Keyword
	def disableAgentHandover(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/agentHandover'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/agentHandover'))
			KeywordUtil.logInfo('AGENT HANDOVER ENABLED')
		}
	}

	@Keyword
	def disableDownvoted(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/downvoted'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/downvoted'))
			KeywordUtil.logInfo('DOWNVOTE ENABLED')
		}
	}

	@Keyword
	def disableAddFromSession(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/addFromSession'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/addFromSession'))
			KeywordUtil.logInfo('ADD FROM SESSION ENABLED')
		}
	}

	@Keyword
	def disableLowConfidence(boolean disable){
		if(disable){
			toClickOnWebElement(findTestObject('Toggle/lowConfidence'))
		}else{
			toClickOnWebElement(findTestObject('Toggle/lowConfidence'))
			WebUI.setText(findTestObject('Input/lowConfidenceValue'), GlobalVariable.LOW_CONFIDENCE_SCORE)
			KeywordUtil.logInfo('LOW CONFIDENCE ENABLED')
		}
	}

	@Keyword
	def filterRuleTriggered(String filterBy){
		toClickOnWebElement(findTestObject('Generic/webObjectWithText',['textValue':'Rule triggered']))
		toClickOnWebElement(findTestObject('Generic/webObjectWithText',['textValue':' '+filterBy+' ']))
		toClickOnWebElement(findTestObject('Button/filter'))
	}
}
