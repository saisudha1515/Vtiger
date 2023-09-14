package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericUtilities.BaseClassForListeners;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;

@Listeners(listeners.ListenersImplementation.class) // LIsteners is having the Extent reports so make sure when ever we want to use extent reports we have to use listeners in that particular class..
public class CreateContactTest_Scenario1_After_BaseClass_Creation_For_Listeners extends BaseClassForListeners {
	@Test
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
		// Assert.fail();

		// Step5 : Validate for Contact header
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
//		if (contactHeader.contains(LASTNAME)) {
//			System.out.println("Contact created Successfully.");
//			System.out.println("Contact Header : " + contactHeader);
//		} else {
//			System.out.println("Fail");
//		}
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println("ContactHeader : " + contactHeader);
	}

	@Test
	public void demmo1() {
		System.out.println("demo1");
	}

	@Test
	public void demo2() {
		Assert.fail();
		System.out.println("demo2");
	}

	@Test
	public void demmo3() {
		System.out.println("demo3");
	}

}
