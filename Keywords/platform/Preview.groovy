package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Preview extends Method {

	/*
	 * This method will perform downvote action on bot response with comment
	 */
	@Keyword
	def downvoteResponseWithComment(String feedbackComment){
		toClickOnWebElement(findTestObject('Button/downvote'))
		WebUI.sendKeys(findTestObject('Input/downvoteComment'), feedbackComment)
		clickOnElement(findTestObject('Button/submit'))
	}

	/*
	 * This method will perform downvote action on bot response without comment
	 */
	@Keyword
	def downvoteResponseWithoutComment(){
		toClickOnWebElement(findTestObject('Button/downvote'))
		clickOnElement(findTestObject('Button/skip'))
	}

	/*
	 * This method will intiate preview from the bot card
	 * @Parameters: botType-> Type of the bot like task, faq
	 * botName-> Name of the bot
	 */
	@Keyword
	def startBotCardPreview(String botType, String botName){
		clickOnElement(findTestObject('Generic/webObjectWithText',['textValue':botType]))
		List<WebElement> webElements = WebUiCommonHelper.findWebElements(findTestObject('Generic/getBotName'), 5)
		for(int count=0;count<webElements.size();count++){
			if(webElements.get(count).getText().contains(botName)){
				toClickOnWebElement(findTestObject('Button/botCardPreview',['number':count+1]))
			}
		}
	}

	/*
	 * This method will check user defined value in bot response
	 * @Parameters: responseToCheck-> Text user wants to search on bot response
	 */
	@Keyword
	def verifyBotResponse(String responseToCheck){
		WebUI.delay(3)
		int count
		List<WebElement> allResponse= WebUiCommonHelper.findWebElements(findTestObject('GenericII/listOfBotResponse'), 5)
		for(count=0; count< allResponse.size(); count++){
			if(allResponse.get(count).getText().contains(responseToCheck)){
				KeywordUtil.markPassed('YOUR TEXT HAS A MATCH')
				break
			}
			else if(count==allResponse.size()-1 && !allResponse.get(count).getText().contains(responseToCheck)){
				KeywordUtil.markFailed('EXPECTED ANSWER NOT FOUND IN BOT RESPONSE')
			}
		}
	}

	/*
	 *This method will perform shareable preview of all bot where it is use	d 
	 */
	@Keyword
	def doShareablePreview(){
		selectFromHamburgerMenu('Copy Preview Link')
		println('PREVIEW LINK COPIED')
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
		String shareablePreviewLink = null
		shareablePreviewLink = ((clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor)) as String)
		println(shareablePreviewLink)
		WebUI.navigateToUrl(shareablePreviewLink)
	}

	@Keyword
	def verifyBotTextResponse(String userQuery, int index, String expectedResponse){
		WebUI.sendKeys(findTestObject('Input/chatInput'), Keys.chord(userQuery, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('GenericII/getBotResponse',['index': index]), 10)
		WebUI.verifyElementText(findTestObject('GenericII/getBotResponse',['index': index]), expectedResponse, FailureHandling.STOP_ON_FAILURE)
	}
}
