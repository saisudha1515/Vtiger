package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.GenericUtilities.ExcelFileUtility;
import com.vtiger.GenericUtilities.JavaUtility;
import com.vtiger.GenericUtilities.PropertyFileUtility;
import com.vtiger.GenericUtilities.WebDriverUtility;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization_POM_Class {
	public static void main(String[] args) throws Throwable {
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		WebDriver driver = null;

		// Step1: First read all the required data
		/* read data from Property file */
		String BROWSER = pUtil.readFromDataFromPropertyFile("browser");
		String USERNAME = pUtil.readFromDataFromPropertyFile("username");
		String PASSWORD = pUtil.readFromDataFromPropertyFile("password");
		String URL = pUtil.readFromDataFromPropertyFile("url");

		/* read data from Excel data */
		String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 3);

		// step2: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name ");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step3 : Login to application with valid credentials

		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);

		// Step4 : Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		// Step5 : Click on create contact look up image
		
		// Step6 : Create new contact will all mandatory fields
		
		// Step7 : Validate the contact info header text
	}
}
