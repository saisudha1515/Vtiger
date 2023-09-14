//dot(.)represent current project .. when you use dot by default get to know that the file/document is present in the current project
package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		
		
		// Step:1 Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\CommonData.properties");
		// FileInputStream fis = new
		// FileInputStream("E:\\Automation_Selenium\\Qspiders_AdvancedSelenium_Vtiger\\src\\test\\resources\\ApplicationConfig\\CommonData.properties");
		
		
		
		// Step:2 Create an Object for Properties class which is coming from java.util package..
		Properties p = new Properties();
		
		
		// Step:3 Load the document into Properties class
		p.load(fis);
		
		
		// Step:4 Provide the key and read the value
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME = p.getProperty("username");
		System.out.println(USERNAME);
		String USERNAME1 = p.getProperty("name");
		System.out.println(USERNAME1);
	}
}

// path of the project : E:\Automation_Selenium\Qspiders_AdvancedSelenium_Vtiger    // or we can use dot(.) which represent current project it is shortcut for Jvm. jvm will understand..
// path of the file inside the project : \src\test\resources\ApplicationConfig\CommonData.properties