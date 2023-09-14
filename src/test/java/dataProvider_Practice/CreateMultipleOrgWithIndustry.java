package dataProvider_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustry {
	ExcelFileUtility eUtil = new ExcelFileUtility();
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORGNAME, String INDUSTRYTYPE) throws Throwable {
     // System.out.println(ORGNAME+" - "+INDUSTRYTYPE);   write the logic here inside @Test
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
				
				// step2: Launch the browser 
				if (BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					// WebDriverManager.firefoxdriver().setup();
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

				// Step4 : Navigate to Organization Link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLnk();

				// Step5 : Click on create organization look up Image
				OrganizationsPage op = new OrganizationsPage(driver);
				Thread.sleep(3000);
				op.clickOnCreateOrgLookUpImage();

				// Step6 : Create organization with mandatory Information
				CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
				cno.createNewOrganization(ORGNAME+jUtil.getRandomNumber(), INDUSTRYTYPE);

				// Step7 : Validation of Organization Header text
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrgHeader();
				if (orgHeader.contains(ORGNAME)) {
					System.out.println("CreateOrganization with Industry Scenario is PASSED");
					System.out.println("OrgHeader : " + orgHeader);
				} else {
					System.out.println("CreateOrganization with Industry Scenario is FAILED");
				}
				
				//Step8 : Logout of the application
				hp.logOutOfApplication(driver);
				
				//Step9 : Close the browser
				driver.close();
	}
	
	@DataProvider()
	public Object[][]getData() throws EncryptedDocumentException, IOException{
	Object[][] data	= eUtil.readMultipleDataFromExcel("MultipleOrganizations");  // readMultipleDataFromExcel() will returnn you the Object[][] i.e, data[][]
	return data;
	}
}
