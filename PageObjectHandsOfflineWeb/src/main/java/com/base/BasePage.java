package com.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public static Logger log = Logger.getLogger("BasePage");
	
	/************************* Click on Any WebElement *****************/

	public void clickOnWebElement(WebElement element) {

		element.isDisplayed();

		element.click();
	}

	/**************************** Submit the form **********************/

	public void submitByWebElement(WebElement element) {

		element.isDisplayed();

		element.submit();

	}

	/********************** Send Value to WebElement *******************/

	public void SendValue(WebElement element, String value) {

		element.clear();

		element.sendKeys(value);

	}

	/************ Select Radio Button By Attribute Value ***************/

	public void selectRadioButtonByValue(List<WebElement> elements, String value) {

		for (WebElement element : elements) {

			if (element.getAttribute("value").equals(value)) {

				element.click();

				break;
			}

		}
	}

	/******************* Select Radio Button By Text *******************/

	public void selectRadioButtonByText(List<WebElement> elements, String text) {

		for (WebElement element : elements) {

			if (element.getText().equals(text)) {

				element.click();

				break;
			}

		}
	}

	/************ Select Multiple CheckBoxes By Attribute Value ************/

	public void selectMultipleCheckBoxesByValue(List<WebElement> elements, List<String> values) {

		for (String value : values) {

			for (WebElement element : elements) {

				if (element.getAttribute("value").equals(value)) {

					element.click();

					break;
				}

			}
		}
	}

	/************ Select Single CheckBoxes By Attribute Value *************/

	public void selectSingleCheckBoxByValue(List<WebElement> elements, String value) {

		for (WebElement element : elements) {

			if (element.getAttribute("value").equals(value)) {

				element.click();

				break;
			}
		}
	}

	/*************** Select value By Visible in SelectTag *****************/

	public void selectByVisibleText(WebElement element, String value) {

		Select select = new Select(element);

		select.selectByVisibleText(value);
	}

	/************ Select Multiple Value By Visible in SelectTag ************/

	public void selectMultipleWebElementByVisibleText(WebElement element1, WebElement element2, WebElement element3,
			String value1, String value2, String value3) {

		selectByVisibleText(element1, value1);

		selectByVisibleText(element2, value2);

		selectByVisibleText(element3, value3);

	}

	/***************** Select value By Options in SelectTag ******************/

	public void selectByOptions(WebElement element, String value) {

		Select select = new Select(element);

		List<WebElement> list = select.getOptions();

		for (WebElement webElement : list) {

			if (webElement.getText().equals(value)) {

				webElement.click();
			}
		}

	}

	/***************** Select value From List Before Click *******************/

	public void clickAndSelectElementFromList(List<WebElement> list, WebElement element, String value) {

		element.click();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equals(value)) {

				list.get(i).click();

				break;
			}

		}

	}

	/********************* File Upload Using Robot Class **********************/

	public void uploadFileUsingRobotClass(WebElement element, String path) throws Exception {

		Robot robot = new Robot();

		element.click();

		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/********************* File Upload Using SendKeys **********************/

	public void uploadFileUsingSendKeys(WebElement element, String path) {

		element.sendKeys(path);
	}

	/*************** Retrive Specific Data from ExcelSheet *****************/

	public ArrayList<String> readSpecificValueFromExcelSheet(String filepath, String sheetname, int cols)
			throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filepath);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(sheetname);

		int rows = sh.getLastRowNum();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i <= rows; i++) {

			for (int j = cols; j <= cols; j++) {

				Cell c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				list.add(value);

			}

		}
		return list;
	}

	/***************** Get Webelement Text from Webpage ******************/

	public String getTextOfWebElement(WebElement element) {

		String text = element.getText();

		return text;
	}

	/**************** Retrive Data from ExcelSheet With 2D String Array*****************/

	public static String[][] readExcelSheetDataUsing2DArray(String filename, String Sheetname) throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filename);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(Sheetname);

		int row = sh.getLastRowNum();

		int col = sh.getRow(0).getLastCellNum();

		String[][] data = new String[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				Cell c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				data[i][j] = value;
			}
		}
		return data;
	}

	/**************** Retrive Data from ExcelSheet With 2D String Jagged Array*****************/

	public static String[][] readExcelSheetDataUsing2DJaggedArray(String filename, String Sheetname) throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filename);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(Sheetname);

		int row = sh.getLastRowNum();

		String[][] data = new String[row + 1][];

		for (int i = 0; i <= row; i++) {

			int col = sh.getRow(i).getLastCellNum();

			data[i] = new String[col];

			for (int j = 0; j < col; j++) {

				Cell c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				data[i][j] = value;
			}
		}
		return data;
	}

	/*************** Retrive Data from ExcelSheet With ArrayList *****************/
	
	public static ArrayList<String> readExcelSheetDataUsingArraylist(String filename, String Sheetname)
			throws Exception {
		
		DataFormatter df = new DataFormatter();
		
		FileInputStream fis = new FileInputStream(filename);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(Sheetname);
		
		int row = sh.getLastRowNum();
		
		int col = sh.getRow(0).getLastCellNum();

		ArrayList<String> data = new ArrayList<String>();

		for (int i = 0; i <= row; i++) {

			for (int j = 0; j < col; j++) {
				
				Cell c = sh.getRow(i).getCell(j);
				
				String value = df.formatCellValue(c);
				
				data.add(value);
			}
		}
		return data;
	}

	/**************** Retrive Specific Data from ExcelSheet With ArrayList*****************/

	public static ArrayList<String> readExcelSheetDataUsingArraylistSpecificData(String filename, String Sheetname,
			int coloum) throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filename);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(Sheetname);

		int row = sh.getLastRowNum();

		ArrayList<String> data = new ArrayList<String>();

		for (int i = 0; i <= row; i++) {

			for (int j = coloum; j <= coloum; j++) {

				Cell c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				data.add(value);
			}
		}
		return data;
	}

	/*************** Retrive Data from ExcelSheet With HashMap *****************/

	public static HashMap<String, String> readSpecificExcelSheetDataUsingHashMap(String filePath, String sheetName,
			int cols, int nextcols) throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filePath);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(sheetName);

		int rows = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i <= rows; i++) {

			Cell firstcell = sh.getRow(i).getCell(cols);

			String key = df.formatCellValue(firstcell);

			Cell secondcell = sh.getRow(i).getCell(nextcols);

			String value = df.formatCellValue(secondcell);

			map.put(key, value);

		}

		return map;
	}
	
	
	public String[][] readExcelsheet(String FileName, String SheetName) throws Exception, InvalidFormatException, IOException{
		DataFormatter df = new DataFormatter();
		FileInputStream fis;
		//String[][] data;
	
			fis =new FileInputStream(FileName);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			int row = sh.getLastRowNum();
			
			String[][] data = new String[row][];
			
			for (int i = 0; i < row; i++) {
				
				int cols = sh.getRow(i).getLastCellNum();
				data[i]=new String[cols];
				for (int j = 0; j < cols; j++) {
					
					Cell ch = sh.getRow(i).getCell(j);
					
					String value = df.formatCellValue(ch);
					
					data[i][j]=value;
				}
		
	}
			return data;
	}

}
