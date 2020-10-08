package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Method {

	static String CLOSE_TIME='1'
	static String SET_VALUE='2'
	static String PATH= RunConfiguration.getProjectDir() + '/Collection/'

	WebDriver driver= DriverFactory.getWebDriver()
	Actions action= new Actions(driver)

	@Keyword
	def clickOnElement(TestObject testObject){
		JavascriptExecutor js = (JavascriptExecutor)driver
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 5)
		js.executeScript("arguments[0].click();", element)
	}


	@Keyword
	def logOut(){
		//		action.moveToElement(WebUiCommonHelper.findWebElement(findTestObject('Generic/userInitials'), 20)).build().perform()
		WebUI.mouseOver(findTestObject('Generic/userInitials'))
		clickOnElement(findTestObject('Button/signOut'))
	}

	/*
	 * Performs a click action on element which cannot be done by regular default click
	 * //Arrays.asList(element)
	 */
	@Keyword
	def toClickOnWebElement(TestObject testObject){
		try{
			WebUI.click(testObject)
		}catch(Exception e){
			WebElement element = WebUiCommonHelper.findWebElements(testObject, 5)
			WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element), FailureHandling.STOP_ON_FAILURE)
		}
	}

	/*
	 * Navigation to desired bot is a mundane and recursive process, this method would reduce user effort
	 * @Parameters: botType-> Type of bot like task or faq bot,
	 *  botName-> Name of the bot to navigate to 
	 */
	@Keyword
	def navigateToBot(String botType, String botName){
		if(!WebUI.verifyElementPresent(findTestObject('Button/createBot'), 30, FailureHandling.OPTIONAL)){
			WebUI.waitForPageLoad(3)
		}
		TestObject testObject = findTestObject('Generic/webObjectWithText',['textValue': botType])
		clickOnElement(testObject)
		WebUI.comment('Performing click action on bot')
		testObject = findTestObject('Generic/webObjectWithText',['textValue': botName])
		clickOnElement(testObject)
	}

	/*
	 * This method will be used to select a file for any kind of bot
	 * @Paramteres: fileName-> name of the csv file 
	 */
	@Keyword
	def uploadCsvFile(boolean override,String fileName){

		if(override){
			clickOnElement(findTestObject('Toggle/override'))
		}else{
			KeywordUtil.logInfo('PREVIOUS DATA NOT BE OVERRIDDEN')
		}

		WebUI.uploadFile(findTestObject('Input/uploadFile'), PATH+fileName)
		clickOnElement(findTestObject('Button/import'))
	}

	/*
	 * This is method is used to perform to train a bot with saved data to check preview
	 * @Paramters: comment-> user comment to train
	 */
	@Keyword
	def trainAndComment(String comment){
		try{
			if(WebUiCommonHelper.findWebElement(findTestObject('Button/train'), 5).isEnabled()){
				clickOnElement(findTestObject('Button/train'))
				WebUI.sendKeys(findTestObject('Input/comment'), comment)
				clickOnElement(findTestObject('Button/continue'))
			}else{
				println('********')
			}
		}catch(Exception e){
			KeywordUtil.logInfo('BOT STATE IS TRAINED')
		}
	}

	/*
	 * Hamburger menu on bot configuration page have options like delete bot
	 * or sharable preview or copy bot token for further purpose
	 * selectedOption-> value of option selected
	 */
	@Keyword
	def selectFromHamburgerMenu(String selectedOption){
		clickOnElement(findTestObject('Button/burgerMenu'))
		KeywordUtil.logInfo('Selected value: '+ selectedOption)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue': selectedOption]))
	}

	/*
	 * This method is used to find index of an element from list of element and used it index to select value
	 * @Parameters: testObject-> To identify the element from the list,
	 * textToFind-> find the text of the object from the list 
	 */
	@Keyword
	def int getIndexFromTheList(TestObject testObject, String textToFind){
		List<WebElement> webElements = WebUiCommonHelper.findWebElements(testObject, 5)
		int count
		for(count=0 ; count< webElements.size(); count++){
			if(webElements.get(count).getText().contains(textToFind)){
				count++
				break;
			}
		}
		return count
	}

	/*@Keyword
	 def selectFromTheList(TestObject testObject, String textToFind){
	 List<WebElement> webElements = WebUiCommonHelper.findWebElements(testObject, 5)
	 int count
	 for(count=0 ; count< webElements.size(); count++){
	 if(webElements.get(count).getText().contains(textToFind)){
	 webElements.get(count+1).click()
	 }
	 }
	 }*/

	@Keyword
	def removeFocus(TestObject testObject){
		WebUiCommonHelper.findWebElement(testObject, 20).sendKeys(Keys.TAB)
	}

	@Keyword
	def List verifyBotCardMenu(String botType, String botName){
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':botType]))
		List<WebElement> webElements = WebUiCommonHelper.findWebElements(findTestObject('Generic/getBotName'), 5)
		for(int count=0;count<webElements.size();count++){
			if(webElements.get(count).getText().contains(botName)){
				WebUI.verifyElementPresent(findTestObject('Button/botCardPreview',['number':count+1]), 5, FailureHandling.STOP_ON_FAILURE)
				WebUI.mouseOver(findTestObject('Button/botCardMenu',['index': count+1]))
				clickOnElement(findTestObject('Button/botCardMenu',['index': count+1]))
				List<String> getValue = new ArrayList();
				List<WebElement> getBotCardMenuOptions= WebUiCommonHelper.findWebElements(findTestObject('GenericII/botCardMenuList'), 5)
				for(int index=0;index < getBotCardMenuOptions.size(); index++){
					getValue.add(getBotCardMenuOptions.get(index).getText())
				}

				return getValue
			}
		}
	}

	@Keyword
	def enableADP(boolean enable){
		WebUI.waitForElementVisible(findTestObject('Button/updateBot'), 30, FailureHandling.STOP_ON_FAILURE)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Security']))
		//		toClickOnWebElement(findTestObject('Generic/webObjectWithText',['textValue':'Security']))
		if(enable){
			clickOnElement(findTestObject('Toggle/adp'))
			clickOnElement(findTestObject('Button/updateBot'))
		}

		WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def enableCloseCallback(boolean enable){
		WebUI.waitForElementVisible(findTestObject('Button/updateBot'), 30, FailureHandling.STOP_ON_FAILURE)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Management']))
		if(enable){
			clickOnElement(findTestObject('Toggle/callback'))
			WebUI.setText(findTestObject('Input/sessionCloseTime'), CLOSE_TIME)
			clickOnElement(findTestObject('Button/updateBot'))
		}
	}

	@Keyword
	def enableAgentHandover(boolean enable, int number){
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Handover and Inference']))
		if(enable){
			clickOnElement(findTestObject('Toggle/enableAgentHandover'))
			clickOnElement(findTestObject('Button/continue'))

			switch(number) {
				case 1:
					clickOnElement(findTestObject('Toggle/enableFallback'))
					WebUI.setText(findTestObject('Input/fallback'), SET_VALUE)
					break
				case 2:
					clickOnElement(findTestObject('Toggle/enablePartialMatch'))
					WebUI.setText(findTestObject('Input/partialMatch'), SET_VALUE)
					break
				case 3:
					action.moveToElement(WebUiCommonHelper.findWebElement(findTestObject('Toggle/enableConsecutiveCount'), 5)).build().perform()
					clickOnElement(findTestObject('Toggle/enableConsecutiveCount'))
					WebUI.setText(findTestObject('Input/consecutiveMessage'), SET_VALUE)
					break
			}
			clickOnElement(findTestObject('Button/updateBot'))
			WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.STOP_ON_FAILURE)
		}
	}

	@Keyword
	def disableBot(String botType, String botName){
		navigateToBot(botType, botName)
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':'Management']))
		clickOnElement(findTestObject('Toggle/disableBot'))
		clickOnElement(findTestObject('Button/updateBot'))
		clickOnElement(findTestObject('Button/disable'))
	}

	@Keyword
	def runOneClickTestOnLiveData(boolean isLive){
		WebUI.waitForElementPresent(findTestObject('Button/btnExecute'), 10, FailureHandling.STOP_ON_FAILURE)
		clickOnElement(findTestObject('Button/btnExecute'))
		if(isLive){
			clickOnElement(findTestObject('Button/btnLiveVersion'))
		}else{
			KeywordUtil.logInfo('TEST ON TRAINED VERSION')
		}
		clickOnElement(findTestObject('Button/continue'))
	}
	
}
