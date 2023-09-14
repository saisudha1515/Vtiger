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
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactInfoPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.ContactsPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.CreateNewContactPage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest_Scenario1_After_BaseClass_CreationTest extends BaseClass {
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
	public void demo5() {
		System.out.println("Smoke and Regerssion");
	}

	@Test(groups = "RegerssionSuite")
	public void demo6() {
		System.out.println("Regerssion");

	}
}
