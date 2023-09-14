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
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest_Scenario2Test {
	@Test
	public void createOrganizationTest() throws Throwable {
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
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 1, 2) + jUtil.getRandomNumber();

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
		lp.loginToApplication(USERNAME, PASSWORD);

		// Step5 : Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();

		// Step6 : Click on Create organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		// Step7 : Create Organization will all Mandatory Fields
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrganization(ORGNAME);

		// Step8 : Validate Organization Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("Organization is created Successfully.");
			System.out.println("Organization name : " + ORGNAME);
		} else {
			System.out.println("Fail");
		}

		// Step9 : Logout of the Application
		hp.logOutOfApplication(driver);

		// Step10 : Close the browser
		driver.quit();
	}
}
