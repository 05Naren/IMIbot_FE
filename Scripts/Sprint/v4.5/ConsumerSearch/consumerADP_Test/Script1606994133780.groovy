import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('ICONS/sidebarSettings'))

WebUI.waitForElementPresent(findTestObject('Generic/webObjectWithText', [('textValue') : 'Bot configuration']), 10, FailureHandling.OPTIONAL)

CustomKeywords.'platform.Method.enableADP'(true)

WebUI.waitForElementPresent(findTestObject('ICONS/toastMsg'), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/session'))

CustomKeywords.'platform.Method.clickOnElement'(findTestObject('Generic/webObjectWithText', [('textValue') : 'Consumers']))

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS2/consumerActions'), 20, FailureHandling.CONTINUE_ON_FAILURE)

assert WebUiCommonHelper.findWebElements(findTestObject('ICONS/lock'), 20).size() > 0

CustomKeywords.'platform.Consumer.searchByName'('Narendra N' //hardcoded data
    )

WebUI.verifyElementPresent(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 1]), 20, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'platform.Consumer.decryptConsumerData'()

WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 2]), user_uid, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('WEB_OBJECTS2/consumerLogTable', [('index') : 4]), user_phone, FailureHandling.CONTINUE_ON_FAILURE)