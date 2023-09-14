package testNG;

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
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryTest_Scenario3_After_BaseClass_Creation extends BaseClass {
	@Test(groups = "RegerssionSuite")
	public void createOrgWithIndustryTest() throws Throwable {
		// Step1: First read all the required data
		/* read data from Excel data */
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcelFile("Organizations", 4, 3);

		// Step2 : Navigate to Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();

		// Step3 : Click on create organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		Thread.sleep(3000);
		op.clickOnCreateOrgLookUpImage();

		// Step4 : Create organization with mandatory Information
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createNewOrganization(ORGNAME, INDUSTRYTYPE);

		// Step5 : Validation of Organization Header text
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("CreateOrganization with Industry Scenario is PASSED");
			System.out.println("OrgHeader : " + orgHeader);
		} else {
			System.out.println("CreateOrganization with Industry Scenario is FAILED");
		}
	}

	@Test // these @Test will not be included in the Regression Suite so this will not be executed in the Regression Suite since Groups is not there..
	public void demo1() {
		System.out.println("Demo1");
	}

	@Test // these @Test will not be included in the Regression Suite so this will not be executed in the Regression Suite since " groups " is not there..
	public void demo2() {
		System.out.println("Demo2");
	}

	@Test(groups = "RegerssionSuite")
	public void Demo3() {
		System.out.println("Regerssion");

	}
}
