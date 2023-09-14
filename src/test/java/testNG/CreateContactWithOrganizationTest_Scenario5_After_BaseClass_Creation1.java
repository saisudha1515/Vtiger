// After cration of Base class come to TestScript then first extend Base Class,then remove all unwanted code.
// In Base class we have written all common actions code. and @BeforeMethod and @AfterMethod will going to applicable for all @Test methods..
package testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.BaseClass;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest_Scenario5_After_BaseClass_Creation1 extends BaseClass {
	@Test(groups = "RegerssionSuite")
	public void createContactWithOrganizationTest() throws Throwable {
		// Step1 : First read all required data
		/* read data from Excel data */
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3);

		// Step2 : Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();

		// Step3 : Click on Create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		// Step4 : Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		// Step5 : Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("Organization is created");
			System.out.println(orgHeader);
		} else {
			System.out.println("Organization is not created");
		}

		// Step6 : Click on Contacts Link
		hp.clickOnContactsLnk();

		// Step7 : Click on Create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step8 : create contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, driver, ORGNAME);

		// Step9 : Validate for Contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(contactHeader);
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(groups = "SmokeSuite")
	public void Demo4() {
		System.out.println("Smoke");

	}

	@Test(groups = { "RegerssionSuite", "SmokeSuite" })
	public void Demo5() {
		System.out.println("Smoke and Regerssion");
	}

	@Test(groups = "RegerssionSuite")
	public void Demo6() {
		System.out.println("Regerssion");

	}
}
