package com.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.base.BaseClass;

public class ExcelSheetUtils extends BaseClass{
	
	//***************Excelsheet reading by Sheet name and returning 2D array of string*************
	
	public static String[][] readExcelSheetAndReturnTwoDimensionalArray(String sheetName) throws Exception{
		log.info("Reading excel sheet for Testcase expected data");
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("OfflineWebsiteTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet(sheetName);
		int rows =sh.getLastRowNum();
		int cols =sh.getRow(0).getLastCellNum();
		
		
		String[][] expArray = new String[rows+1][cols];
		for (int i = 0; i < rows+1 ; i++) 
		{
			int colss = sh.getRow(i).getLastCellNum();
			
             for (int j = 0; j <colss; j++) 
             {
             		Cell cell = sh.getRow(i).getCell(j);	
             		String cellValue = df.formatCellValue(cell);
             		expArray[i][j] = cellValue;
			 }	
         
		}
		log.info("Excel sheet data read successfully.");

		return expArray;
	}
	
	
	
	
	//***************Excelsheet reading by Sheet name and returning Arraylist*************
     public static ArrayList<String>  readExcelSheetAndReturnArrayList(String sheetName) throws Exception{
 		log.info("Reading excel sheet for Testcase expected data");
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("OfflineWebsiteTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet(sheetName);
		int rows =sh.getLastRowNum();

		ArrayList<String> expArrayList = new ArrayList<String>();
		for (int i = 0; i <= rows ; i++) 
		{
			int cols = sh.getRow(i).getLastCellNum();
			
             for (int j = 0; j <cols; j++) 
             {
             		Cell cell = sh.getRow(i).getCell(j);	
             		String cellValue = df.formatCellValue(cell);
             		expArrayList.add(cellValue);
			 }	
         
		}
		log.info("Excel sheet data read successfully.");

		return expArrayList;
	}
	
     //***************Excelsheet reading specific data by Sheet name and returning Arraylist*************
     public static ArrayList<String>  readSpecificExcelSheetDataAndReturnArrayList(String filePath , String sheetName , int cols) throws Exception{
 		 
    	 log.info("Reading excel sheet for Testcase expected data");
    	 DataFormatter df = new DataFormatter();
    	 FileInputStream fis = new FileInputStream(filePath);
    	 Workbook wb = WorkbookFactory.create(fis);
    	 Sheet sh =wb.getSheet(sheetName);
    	 int rows =sh.getLastRowNum();
    	 
    	 ArrayList<String> expArrayList = new ArrayList<String>();
    	 for (int i = 0; i <= rows ; i++) 
    	 {
    		 for (int j = cols; j <=cols; j++) 
    		 {
    			 Cell cell = sh.getRow(i).getCell(j);	
    			 String cellValue = df.formatCellValue(cell);
    			 expArrayList.add(cellValue);
    		 }	
    	
    	 }
 		log.info("Excel sheet data read successfully.");

    	 return expArrayList;
     }
     
     //***************Excelsheet reading specific data by Sheet name and returning HashMap*************
     
     public static HashMap<String, String>  readSpecificExcelSheetDataUsingHashMap(String filePath , String sheetName , int cols , int nextcols) throws Exception{
 		
    	 log.info("Reading excel sheet for Testcase expected data");

    	 DataFormatter df = new DataFormatter();
    	 
    	 FileInputStream fis = new FileInputStream(filePath);
    	 
    	 Workbook wb = WorkbookFactory.create(fis);
    	 
    	 Sheet sh =wb.getSheet(sheetName);
    	 
    	 int rows =sh.getLastRowNum();
	 
    	 HashMap<String , String> map = new HashMap<String, String>();
    	 for (int i = 0; i <= rows ; i++) {
    		 
    	 Cell firstcell = sh.getRow(i).getCell(cols);
    	 
    	 String key = df.formatCellValue(firstcell);
    	 
    	 Cell secondcell = sh.getRow(i).getCell(nextcols);
    	 
    	 String value = df.formatCellValue(secondcell);
    
    	 map.put(key, value);
    		
    	 }
 		log.info("Excel sheet data read successfully.");

    	 return map;
     }
     
     //***************Excelsheet reading Jagged data returning 2D String Array*************

     public String[][] readExcelSheetWithJaggedArray(String filepath , String sheetname) throws Exception{
 		log.info("Reading excel sheet for Testcase expected data");
    	DataFormatter df = new DataFormatter();
 		FileInputStream fis = new FileInputStream(filepath);
 		Workbook wb = WorkbookFactory.create(fis);
 		Sheet sh = wb.getSheet(sheetname);
 		int rows = sh.getLastRowNum();
 		//System.out.println(rows);
 		String[][] array = new String[rows+1][];
 		for (int i = 0; i <=rows; i++) {
 			int cols = sh.getRow(i).getLastCellNum();
 			System.out.println(cols);
 	/*Size of coloum must declared with respect row index in jagged Array*/		
 			array[i]= new String[cols]; 
 			
 			for (int j = 0; j <cols; j++) {
 				Cell cell = sh.getRow(i).getCell(j);
 				String cellValue = df.formatCellValue(cell);
 				array[i][j]=cellValue;
 			}
 		}
 		for (String[] strings : array) {
 			System.out.println();
 			for (String strings2 : strings) {
 				System.out.print(strings2.toString()+" ");
 			}
 		}
		log.info("Excel sheet data read successfully.");

		return array;

 	}
  
     
}
