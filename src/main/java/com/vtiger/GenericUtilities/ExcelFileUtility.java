//Selenium just a tool it is working with the help of Java..
// All methods which are related to Excel File you can drop all those methods in the ExcelFileUtility Class..
package com.vtiger.GenericUtilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**This class consists of reusable methods related to Excel File
 * @author Saisudha D
 */
public class ExcelFileUtility {
	/**
	 * This method will read the data from Excel sheet and return the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return data                         // if you wish you can write the return value..
	 * @throws Throwable                    // all run time exceptions are throwing to the JVM..
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue(); // method chaining use instead of storing all in a variables...this data i have captured from the specified sheet, specified row and from specified cell..if i return this data the caller method can use this data..
		wb.close();                                                            // if you close your workbook there is no memory leakage will happen. or there is no performance hindrance..
		return data;
	}
	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    wb.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);  // write is an Operation.. it is just writing and coming back. It is just doing the operation(i.e, writing the data into cell)but it is not holding any data..when the method is not holding any data you no need to return it..so the return type is "void"
	    FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
	    wb.write(fos);
	    wb.close();     // or wb.flush();
	}
	
	/**
	 * This method will read multiple data from excel file for the sheet provided. 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	//********// EVEN IF ONE DATASET GOT FAILED THE NEXT WILL NOT GET AFFECTED HERE, IN DATA PROVIDER COMPLETELY THE DATA IS INDEPENDENT.. EVEN IF THE SCRIPT GOT FAILED WITH ONE SET OF DATA again the next set of data  will be taken by the data provider and passed to the @Test/ TestMethod..

	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh =  wb.getSheet(sheetName); // We need to put condition or limitation for upto what extent the loop has to iterate..so for that get lastRow and lastCell
    int lastRow = sh.getLastRowNum(); // we can directly get the last row with the reference of sheet
    int lastCell = sh.getRow(0).getLastCellNum();// to get last cell we need to take the reference of row(0). 0th row always be header generally.make sure this header row should not be empty.any row you can take header row mostly..
    Object [][] data = new Object[lastRow][lastCell];  // here provide the limitation/ condition/size of the array..
    for(int i = 0;i<lastRow;i++) {    // here 0th row is header so start loop from 1st row i.e, i = 1 or i+1(here i = 0 so,0+1=1,1+1=2,2+1=3 etc..)
    	for(int j = 0;j<lastCell;j++) {
    		data [i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
    	  }
       }
      return data;
    }
}
