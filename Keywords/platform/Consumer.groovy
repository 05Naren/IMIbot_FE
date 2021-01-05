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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Consumer extends Method {

	static String KEY_VALUE="TEST"

	@Keyword
	def searchByID(String searchID){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':'ID']),searchID)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def searchByUID(String searchUID){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':'UID']),searchUID)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def searchByName(String name){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':'Name']),name)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def searchByPhoneNumber(String phoneNumber){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':'Phone']),phoneNumber)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def searchByIDEmailID(String emailID){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':'Email']),emailID)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def multipleFieldSearchBy(String field1, String field2, String fieldValue1, String fieldValue2){
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':field1]),fieldValue1)
		WebUI.setText(findTestObject('WEB_OBJECTS2/consumerSearchFieldInput',['value':field2]),fieldValue2)
		clickOnElement(findTestObject('WEB_OBJECTS2/consumerSearchBtn'))
	}

	@Keyword
	def clearSearch(){
		clickOnElement(findTestObject('Button/clear'))
	}

	@Keyword
	def decryptConsumerData(){
		clickOnElement(findTestObject('ICONS/lock'))
		WebUI.setText(findTestObject('Input/key'), KEY_VALUE)
		clickOnElement(findTestObject('Button/decrypt'))
	}
}
