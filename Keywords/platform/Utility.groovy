package platform

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class Utility extends Method {

	public final String nameOfTheFile = RunConfiguration.getProjectDir()+'/IMIbot_TestData.xlsx'

	/*
	 * This method will write data to file which could be further reused
	 * @Parameter: sheetName-> Name of the sheet where correction needs to be made
	 * rowNumber-> Number of the row on workbook, cellNumber-> Number of the cell on workbook
	 * cellValue-> The data with which the cell needs to be updated with 
	 */
	@Keyword
	def overWriteTestData(String sheetName, int rowNumber, int cellNumber, String cellValue){
		FileInputStream file = new FileInputStream (nameOfTheFile)
		Workbook  workbook = WorkbookFactory.create(file)
		Sheet sheet = workbook.getSheet(sheetName)
		Cell cell = sheet.getRow(rowNumber).getCell(cellNumber)
		if(cell==null)
			cell=sheet.getRow(rowNumber).createCell(cellNumber)
		cell.setCellValue(cellValue)
		file.close();
		FileOutputStream outFile =new FileOutputStream(nameOfTheFile);
		workbook.write(outFile);
		outFile.close();
	}

	/*
	 * Method to extract list of room id for a bot conversation
	 */
	@Keyword
	def getRoomID(){
		//		clickOnElement
		clickOnElement(findTestObject('Button/goToRoomList'))
		List<WebElement> listOfRoomId = WebUiCommonHelper.findWebElements(findTestObject('GenericII/getRoomIDList'), 10)
		return extractRoomIdNumber(listOfRoomId)
	}

	/*
	 * This method extracts digit from the string, which could later used to identify transactions
	 */
	def List<StringBuilder> extractRoomIdNumber(List<WebElement> getList){
		List<StringBuilder> roomId = new ArrayList<>()

		for(int count=0; count<getList.size(); count++){
			StringBuilder buildString = new StringBuilder()
			char[] charArray = getList.get(count).getText().toCharArray()
			for(int index=0; index<charArray.length; index++){
				if(Character.isDigit(charArray[index])){
					buildString.append(charArray[index])
				}
			}
			roomId.add(buildString)
		}

		return roomId
	}

	@Keyword
	def List storeTestCaseStatus(){
		List<Object> allValues = new ArrayList()
		for(int index=0;index< WebUiCommonHelper.findWebElements(findTestObject('Button/testStatus'), 10).size();index++){
			allValues.add(WebUiCommonHelper.findWebElements(findTestObject('Button/testStatus'), 10).get(index).getText())
		}

		return allValues
	}
}
