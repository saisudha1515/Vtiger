package Assertions_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.BaseClass;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationsPage;

public class CreateOrganizationTest_ByUsing_Assertions_Scenario2 extends BaseClass{
	@Test
	public void createOrganizationTest() throws Throwable {
		
		// Step1 : First read all the required data from external resources
		/* Read test data form Excel File (not common data it is test data) */
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 1, 2) + jUtil.getRandomNumber();

		// Step2 : Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();

		// Step3 : Click on Create organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		// Step4 : Create Organization will all Mandatory Fields
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrganization(ORGNAME);

		// Step5 : Validate Organization Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		
//		if (orgHeader.contains(ORGNAME)) {
//			System.out.println("Organization is created Successfully.");
//			System.out.println("Organization name : " + ORGNAME);
//		} else {
//			System.out.println("Fail");
//		}
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println("orgHeader : "+orgHeader);
	}
}
