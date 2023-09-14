//Apache poi library is having some predefined methods and WorkBookFactory abstract class. and this class is having one Static method called create()which will accept fileInputStream and return type of create()is Workbook
//By using workbook reference we call the getSheet() which will accept the sheet name and it will return the Sheet Interface
//By using Sheet Interface reference we call the getRow() which will accept the int and it will return the Row Interface
//By using Row Interface reference we call the getCell() which will accept the int and it will return the Cell Interface
//By using Cell Interface reference we call the getStringCellValue() which will return you the data that is present inside the cell..store this variable in a variable and then display it
// Finally close the workbook when you working with large programs to avoid memory leakage..

package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		
		// Step2: Create a Workbook  //to create workbook use WorkBookFactory abstract classs and call its static method called create()method and take this workbook reference to get the required sheet.. 
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Organization");
		
		// Step4: Navigate to required Row
		Row r = sh.getRow(7);
		
		// Step5: Navigate to required Cell
		Cell c = r.getCell(3);
		
		// Step6: Read the data inside the cell
		String data = c.getStringCellValue();
		System.out.println(data);
		
		// Step7: Close the Workbook
		book.close();

	}
}
