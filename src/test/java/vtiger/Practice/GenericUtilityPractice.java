// i created this class only to check whether the created generic methods in Generic Utility class are actually working or not..
//You should not write @Test or main() in src/main/java..we should not run from src/main/java
// re usable methods are used to reduce the length of code /optimism the code..
//****** Generic Utilities will always optimism your Scripts   *******//

/*  DATE CLASS 
Date is an in built class in java present in java.util package.. Date class will hold the current date and this current date will be passed to format()method..
Date class is used to capture the current/ System date.
In SimpleDateFormat class you can pass your required date format..
SimpleDateFormat class will have a method called format()which will convert the Current date into your required date format (i.e, text format)and give you String
Date is getting converted into String
Current date you can use for ScreenShot and for Reports
*/

package vtiger.Practice;

import com.vtiger.GenericUtilities.JavaUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws Throwable {
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		String BROWSER = pUtil.readFromDataFromPropertyFile("browser");
//		System.out.println(BROWSER);
//		String USERNAME = pUtil.readFromDataFromPropertyFile("username");
//		System.out.println(USERNAME);
//		
//		ExcelFileUtility efUtil = new ExcelFileUtility();
//		String data = efUtil.readDataFromExcelFile("Contacts", 1, 2); // whole excel file read operation is doing in a single line..
//		System.out.println(data);
//		efUtil.writeDataIntoExcel("TrailNow1", 3, 4, "Hariporter");
//		System.out.println("Data added successfully..");  // it is an intimation message..whether the data is getting added or not in the ExcelSheet..
//		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemDate());
	}

}
