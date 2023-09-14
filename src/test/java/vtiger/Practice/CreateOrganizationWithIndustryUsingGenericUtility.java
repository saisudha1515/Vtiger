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
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryUsingGenericUtility {
	public static void main(String[] args) throws Throwable {
		/* When you don't write main() or @Test annotation then you won't get auto suggestions.. when you write the logic directly in class that time you will not get auto suggestions...*/
	    // Create objects of all utility classes (at the beginning it self when ever you are using Generic Utilities make a habit of it)
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
		/* read data from Excel data */
		String ORGNAME =  eutil.readDataFromExcelFile("Organizations", 4, 2)+jUtil.getRandomNumber(); // instead of storing in a variable i am directly apending the random number to this org.name to make it unique
		String INDUSTRYTYPE = eutil.readDataFromExcelFile("Organizations", 4, 3);
		
		
		// step2: Launch the browser     // Run time polymorphism -- driver
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name ");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		
		// Step3 : Login to application with valid credentials
        /* Performing login operation Using findyElements() i.e, in normal way */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();

		// Step4 : Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step5 : Click on Create Organization look up Image
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();

		// Step6 : Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		System.out.println("organizationName : " + ORGNAME);

		// Step7 : Select "Chemicals" in the industry drop down
		WebElement dropdown = driver.findElement(By.name("industry"));
		wUtil.handleDropdown(dropdown, INDUSTRYTYPE);
		
		
		// Step8 : Save and validate
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(orgHeader);
			System.out.println("OrgName : " + orgHeader);
		}
		
		
		// Step9 : Logout of Application
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, mouseHover);  // here mouseHoverAction() method will only mouseHover to the particular web element..but it will not perform click operation here we need perform click() operation here..
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout done successfully");

		// Step10 : Close the Browser
		driver.quit();
	}

	
	// when you implement Generic Utility class what are all things are happening in the program
	/**
	 *1. No need to remember the logic 
	 *2. To avoid visibility of code
	 * 
	 * 
	 */
}
