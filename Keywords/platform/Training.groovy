package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Training extends Method {

	/*
	 * This method will be used to add single line utterance,
	 * specifically designed for entity regression test cases
	 * @Parameters: value-> text value for utterance 
	 */
	@Keyword
	def addSingleUtterance(String value){
		clickOnElement(findTestObject('Button/createIntent'))
		WebUI.sendKeys(findTestObject('Input/utterance'), value)
		clickOnElement(findTestObject('Button/addUtterance'))
	}

	/*
	 * This method will be used to add multiple utterances
	 * @Parameters: testData-> external source from where data will be read
	 */

	@Keyword
	def addMultipleUtterance(TestData testData, String columnName){
		clickOnElement(findTestObject('Button/createIntent'))
		for(int count=1;count<=testData.getRowNumbers();count++){
			if(testData.getValue(columnName, count)!=''){
				WebUI.sendKeys(findTestObject('Input/utterance'), testData.getValue(columnName, count))
				clickOnElement(findTestObject('Button/addUtterance'))
				WebUI.delay(5)
			}
		}
	}

	/*
	 * This function is used to manually tag a text to an entity
	 */
	@Keyword
	def tagEntityManually(String entityValue){
		clickOnElement(findTestObject('Generic/entitySelection'))
		WebUI.comment('Entity Value Selected: '+ entityValue)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':entityValue]))
		clickOnElement(findTestObject('Button/saveEntityManually'))
	}

	/*
	 * This function is used to manually remove a text from an tagged entity
	 */
	@Keyword
	def removeTaggedEntity(){
		clickOnElement(findTestObject('Slots/markedUpEntity'))
		WebUI.comment('Removing Entity')
		clickOnElement(findTestObject('Button/removeEntity'))
	}

	/*
	 * This function is to create new entity manually from intent page or curation issues page
	 */
	@Keyword
	def createNewEntityManually(String nameOfTheEntity, String typeOfEntity, String defValue){
		clickOnElement(findTestObject('Button/createNewEntity'))
		createEntity(nameOfTheEntity, typeOfEntity, defValue)
	}

	/*
	 * This method is used to create entity of various kind like custom, date and many more to help fulfil intent
	 * @Parameters: nameOfTheEntity-> entity name,
	 * typeOfEntity-> entity type(custom, regex or date), defValue-> Default value for custom/regex type
	 */

	@Keyword
	def createEntity(String nameOfTheEntity, String typeOfEntity, String defValue){
		WebUI.sendKeys(findTestObject('Input/entityName'), nameOfTheEntity)
		clickOnElement(findTestObject('Generic/listOfEntity'))
		WebUI.comment('Entity Type: '+ typeOfEntity)
		clickOnElement(findTestObject('Generic/webObjectWithText', ['textValue': typeOfEntity]))
		if(typeOfEntity.toLowerCase().contentEquals('custom') || typeOfEntity.toLowerCase().contentEquals('regex')){
			WebUI.sendKeys(findTestObject('Input/defValueOfEntity'), defValue)
		}
		clickOnElement(findTestObject('Button/entityPageSaveButton'))
	}

	/*
	 * This method will select an entity from the entity table and edit it
	 * @Parameters: entityName-> name of the entity that needs to be updated
	 */
	@Keyword
	def editEntity(String entityName){
		List<WebElement> getEntities = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfEntityNames'), 5)
		for(int count=0; count<getEntities.size(); count++){
			if(getEntities.get(count).getText().toLowerCase().contains(entityName)){
				clickOnElement(findTestObject('GenericII/editEntityWithName',['number':count+1]))
				break
			}
		}
	}


	@Keyword
	def createInstantResponse(String templateKeyName, String templateKeyValue){
		clickOnElement(findTestObject('NewRepo2/createNewTemplate'))
		WebUI.sendKeys(findTestObject('NewRepo2/templateKeyPopUp'), templateKeyName)
		WebUI.sendKeys(findTestObject('NewRepo2/templateResponsePopUp'), templateKeyValue)
		clickOnElement(findTestObject('Button/create'))
	}
}