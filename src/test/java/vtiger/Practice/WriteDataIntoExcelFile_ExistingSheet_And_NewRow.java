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

public class WriteDataIntoExcelFile_ExistingSheet_And_NewRow {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step2: Create a workbook
		Workbook book = WorkbookFactory.create(fis);
		
		// Step3: Navigate to required Sheet
		Sheet sh = book.getSheet("Contacts");
		
		// Step4: Create a row   // here we are using new row so call createRow()method not getRow()method.. no rows are there in Excel so, we can't get the row so, we have to create a row
		Row rw = sh.createRow(6);
		
		// Step5: Create a cell
		Cell ce = rw.createCell(6);
		
		// Step6: Provide data to be written
		ce.setCellValue("Selenium"); // return type of setCellValue()method is void..
		
		// Step7: Open the document in Java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step8: Write the data into cell/workbook
		book.write(fos);
		System.out.println("Data added successfully");
		
		// Stap9: Close the workbook
		book.close();
	}
}
