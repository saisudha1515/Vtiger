// Write the data into Existing Sheet and Existing Row
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

public class WriteDataIntoExcelSheet_ExistingSheet_And_ExistingRow {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step2: Create a workbook
		Workbook book = WorkbookFactory.create(fis);
		
		// Step3: Navigate to required Sheet(Existing sheet so call getSheet()method notcreateRow()method)
		Sheet sh = book.getSheet("Contacts");
		
		// Step4: Navigate to required Row
		Row rw = sh.getRow(4);
		
		// Step5: Create a Cell (here i am writing the data into new cell so, use createCell()method)
		Cell ce = rw.createCell(5);
		
		// Step6: Provide the data to be written
		ce.setCellValue("Core Java");
		
		// Step7: Open the document in Java Write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		// Step8: Write the data
		book.write(fos);
		System.out.println("Data added/written successfully..");
		// Step8: Close the workbook  ..... in order to avoid memory leakage..
		book.close();

	}
}
