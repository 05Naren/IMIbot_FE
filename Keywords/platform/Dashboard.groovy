package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Dashboard extends Method {

	@Keyword
	def newBotAdditionToUser(username){
		WebUI.mouseOver(findTestObject('Generic/userInitials'))
		clickOnElement(findTestObject('Button/eProfile'))
		clickOnElement(findTestObject('WEB_OBJECTS/enterpriseUserTab'))
		WebUI.waitForElementVisible(findTestObject('WEB_OBJECTS/usertable'),45)
		clickOnElement(findTestObject('WEB_OBJECTS/sort',['placeholder':'Role','sortBy':'Sort descending']))// sort by role
		List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfUserName'), 10)
		for(int count=0; count<listElement.size(); count++){
			if (listElement.get(count).getText().contentEquals(username)){
				clickOnElement(findTestObject('GenericII/editUserBtn',['index': count+1]))
				break;
			}
		}
		clickOnElement(findTestObject('Toggle/autoAddBot'))
		clickOnElement(findTestObject('WEB_OBJECTS/modify'))
	}
}
	