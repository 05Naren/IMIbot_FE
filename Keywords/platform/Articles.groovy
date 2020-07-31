package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Articles extends Method {

	/*
	 * Kebab menu on articles module for faq bot has serveral options likes extract from external link,
	 * import csv and many more. This method will reduce the manual effort of doing this task over and 
	 * again
	 * @Paramters: testObject-> web object of the option from the menu,
	 *  selectedOption-> value of option selected 
	 */
	@Keyword
	def selectFromKebabMenu(TestObject testObject, String selectedOption){

		WebUI.waitForElementClickable(findTestObject('Button/kebabMenu'), 30)
		clickOnElement(findTestObject('Button/kebabMenu'))

		KeywordUtil.logInfo('Selected value: '+ selectedOption)

		clickOnElement(testObject)
	}

	/*
	 * This method would be used to create article of multiple question or single question
	 * @Parameters: testData-> Test data from which value will be read
	 * for question, defaultQuestion-> default question
	 * variant, addVariant-> one question that user wants to add
	 */
	@Keyword
	def createNewArticle(TestData testData, String defaultQuestion){
		clickOnElement(findTestObject('Button/createArticle'))
		if(testData!=null){
			WebUI.sendKeys(findTestObject('Input/defaultQuestion'), defaultQuestion)
		}
	}

	/*
	 * To save an article to existing category
	 * @Parameters: categoryName-> Name of the existing category
	 */
	@Keyword
	def saveAndTrainArticleToExistingCategory(String categoryName){
		clickOnElement(findTestObject('Button/saveAndTrain'))
		clickOnElement(findTestObject('Generic/existingCategory'))
		clickOnElement(findTestObject('NewRepo/saveToArticleList',['value': categoryName]))
		clickOnElement(findTestObject('Button/changeAndSave'))
	}

	/*
	 * To save an article to existing category
	 * @Parameters: newCategoryName-> Name of the new category to be created
	 */
	@Keyword
	def saveAndTrainArticleToNewCategory(String newCategoryName){
		clickOnElement(findTestObject('Button/saveAndTrain'))
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue': 'Add to new category']))
		WebUI.sendKeys(findTestObject('Input/newCategoryName'), newCategoryName)
		clickOnElement(findTestObject('Button/changeAndSave'))
	}
}
