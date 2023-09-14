package testNG;

import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.BaseClassForCrossBrowsing;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;

public class CreateContactTest_Scenario1_After_BaseClass_Creation_ForCrossBrowsing extends BaseClassForCrossBrowsing{
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Throwable {

		// Step1 : First read all the required data (from external resources)
		/* Read test data form Excel File (not common data it is test data) */
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);

		// Step2 : Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();

		// Step3 : Click on Create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step4 : Create contact with all Mandatory fields
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);

		// Step5 : Validate for Contact header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println("Contact created Successfully.");
			System.out.println("Contact Header : " + contactHeader);
		} else {
			System.out.println("Fail");
		}
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
