package testNG;
// class name and method name should end with "Test" and each method in the class should have individual "@Test" annotation.. The method which is having "@Test" annotation is called "TestMethod". and  the class which is having atleast one TestMethos then the class is called as "TestClass"
//Method Should be "non static method" 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.BaseClass;
import com.vtiger.GenericUtilities.ExcelFileUtility;
import com.vtiger.GenericUtilities.JavaUtility;
import com.vtiger.GenericUtilities.PropertyFileUtility;
import com.vtiger.GenericUtilities.WebDriverUtility;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest_Scenario1Test {
	@Test
	public void createContactTest() throws Throwable {
		WebDriver driver = null;
		// Step1 : Create object for all Utility classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step2 : First read all the required data from external resources
		/* Read data from Property File (read common data ) */
		String USERNAME = pUtil.readFromDataFromPropertyFile("username");
		String PASSWORD = pUtil.readFromDataFromPropertyFile("password");
		String URL = pUtil.readFromDataFromPropertyFile("url");
		String BROWSER = pUtil.readFromDataFromPropertyFile("browser");

		/* Read test data form Excel File (not common data it is test data) */
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);

		// Step3 : Launch the Browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser selected ");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step4 : Login to the application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD); // this is Data only so we can do parameterize it..

		// Step5 : Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();

		// Step6 : Click on Create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step7 : Create contact with all Mandatory fields
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);

		// Step8 : Validate for Contact header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println("Contact created Successfully.");
			System.out.println("Contact Header : " + contactHeader);
		} else {
			System.out.println("Fail");
		}

		// Step9 : Logout of the application
		hp.logOutOfApplication(driver);

		// Step10 : Close the browser
		driver.quit();

	}
	
	@Test
	public void demo1() {
		System.out.println("DEMO1");
	}
	@Test
	public void demo2() {
		System.out.println("DEMO2");
	}
}
