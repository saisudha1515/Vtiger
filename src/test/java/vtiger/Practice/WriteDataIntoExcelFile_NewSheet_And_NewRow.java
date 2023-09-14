// You bound to get "IllegalArgumentException" exception when you to create sheet with same name for more than one time.. 
// For (already existing data )use/fetch the data which is already available in the excel sheet then, use "get" related methods like getSheet(),getRow()method,getCell()method
// For creating/write new data in the excel file use "create" related methods like createSheet(),createRow(),createCell()methods..
package vtiger.Practice;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile_NewSheet_And_NewRow {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step2: Create a workbook
		Workbook book = WorkbookFactory.create(fis);
		
		// Step3: Create a New Sheet   // for creating new sheet use createSheet()method not getSheet()method..
		Sheet sh = book.createSheet("Trail");
		
		// Step4: Create a New Row
		Row rw = sh.createRow(5);
		
		// Step5: Create a cell
		Cell ce = rw.createCell(5);
		
		// Step6: Provide the data to be written
		ce.setCellValue("AdvancedSelenium");
		
		// Step7: Open the document in Java Write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step8: Write the data
		book.write(fos);
		System.out.println("Data added successfully");
		
		// Step9: Close the workbook
		book.close();
	}
}
