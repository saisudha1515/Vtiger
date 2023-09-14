package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vtiger.GenericUtilities.ExcelFileUtility;
import com.vtiger.GenericUtilities.JavaUtility;
import com.vtiger.GenericUtilities.PropertyFileUtility;
import com.vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationUsingGenericUtility {
	public static void main(String[] args) throws Throwable {
		// Create objects for all Utility classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		//Step1 : Read all the Data required  
		/* read data from property file */
		String BROWSER = pUtil.readFromDataFromPropertyFile("browser");
		String USERNAME = pUtil.readFromDataFromPropertyFile("username");
		String PASSWORD = pUtil.readFromDataFromPropertyFile("password");
		String URL = pUtil.readFromDataFromPropertyFile("url");

		/* read data from excel file */
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3);
		
		
		// Step 2: Launch The Browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Please check the browser once, invalid browser has been provided ");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 3: Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 4: click on contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 5: click on create contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step 6: create contact using mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 7: click on Organizations look Up image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();

		// Step 8: Switch the control to child window
		wUtil.switchToWindow("ndex.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&f", driver);
		
		// Step 9: search for Organization
		Thread.sleep(3000);
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		System.out.println("Org name : "+ORGNAME);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();

		// Step 10: Switch the control back to main window
		wUtil.switchToWindow("tion=EditView&return_action=DetailView&parenttab=Marketing", driver);    // don't use switchToDefaultContent() method here 
		
		// Step 11 : save
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 12: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(contactHeader);
		} else {
			System.out.println("FAIL");
		}

		// step 13: logout
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, mouseHover);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");

		// Step 14: Close the browser
		driver.quit();
	}
}

