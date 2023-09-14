package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.ExcelFileUtility;
import com.vtiger.GenericUtilities.JavaUtility;
import com.vtiger.GenericUtilities.PropertyFileUtility;
import com.vtiger.GenericUtilities.WebDriverUtility;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest_Scenario5 {
	@Test
	public void createContactWithOrganizationTest() throws Throwable {
		// Create objects of all utility classes
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
		String ORGNAME = eutil.readDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 3);

		// step2: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name ");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step3 : Login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);

		// Step4 : Navigate to Organizations Link ** 65 to 88 is my precondition.**
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();

		// Step5 : Click on Create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		// Step6 : Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		// Step7 : Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("Organization is created");
			System.out.println(orgHeader);
		} else {
			System.out.println("Organization is not created");
		}

		// Step8 : Click on Contacts Link
		hp.clickOnContactsLnk();

		// Step9 : Click on Create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step10 : create contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, driver, ORGNAME);

		// Step11 : Validate for Contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(contactHeader);
		} else {
			System.out.println("FAIL");
		}

		// Step12 : Logout of the application
		hp.logOutOfApplication(driver);

		// Step13 : Close the browser
		driver.quit();
	}
}
