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

public class CreateContactWithOrganizationTest_Scenario5_After_BaseClass_Creation_Reports extends BaseClass{
	@Test(groups = "RegerssionSuite")
	public void createContactWithOrganizationTest() throws Throwable {
		// Step1 : First read all required data
		/* read data from Excel data */
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3);

		// Step2 : Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		Reporter.log("Clicked on Organizations Link ");// Here we are trying to log each and every step..

		// Step3 : Click on Create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();
		Reporter.log("Clicked on Create Organizations look up Inage");

		// Step4 : Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("Organization is created");

		// Step5 : Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("Organization is created");
			System.out.println(orgHeader);
		} else {
			System.out.println("Organization is not created");
		}
		Assert.fail();

		// Step6 : Click on Contacts Link
		hp.clickOnContactsLnk();
		Reporter.log("Clicked on contacts link ");

		// Step7 : Click on Create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Clicked on create contact lookup Image");

		// Step8 : create contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, driver, ORGNAME);
		Reporter.log("Contact created ");

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
}
// Just by looking at the report only i can tell that after organization created only (and i am not even gone through the script and not even gone through the exception in the report) the script is getting failed do after organization step i can start my debugging so that it is reducing my debugging time..


