// When ever we use data driven testing for your script developing, you first we need to read all required data it may be Property file and Excel file, Json file etc..JVM will read it first and keep it ready for usage..  
// If you do the changes/modifications outside the changes(i.e, inside external resources) will reflect inside the project
package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryUsingDDT { // for this scenario we require Organization name and Industry name
	public static void main(String[] args) throws IOException, InterruptedException {
		Random r = new Random();
		int random = r.nextInt(1000);
		
		WebDriver driver = null; // declare and initialize the driver. Why we have to initialize the browser ? ->to avoid compile time errors..
		
		// Step1: First read all the required data
		/* read data from Property file */
		FileInputStream fisprop = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisprop);
		
		// we can use CAPITAL LETTERS for data. here all the data are variable.. to avoid the confusion among variable name and key..
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		System.out.println("USERNAME : "+USERNAME);
		String PASSWORD = p.getProperty("password");
		System.out.println("PASSWORD : "+PASSWORD);
		
		/* read data from Excel data */
		FileInputStream fisexcel = new FileInputStream(".\\src\\test\\resources\\ApplicationConfig\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fisexcel);
		Sheet sh = book.getSheet("Organizations");
		String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue() + random; // append the random class to organization name to make the organization name as unique because organization ..... use method chaining. don't store all the things in a variable.. try to optimize the code where ever possible/as much as you can do....
		String INDUSTRYNAME = sh.getRow(4).getCell(3).getStringCellValue();

		// step2: Launch the browser
		/*
		 * we had an if-else condition where based on data that is present in my
		 * property files we use to launch the browsers so, driver is getting
		 * re-initialized based on the run time data present in my Property file. here
		 * if else ladder is best example for Runtime Polymorphism..
		 */
		if (BROWSER.equalsIgnoreCase("chrome")) { // if browser is equal to chrome then launch the chrome browser..
			WebDriverManager.chromedriver().setup(); // if the condition is true the browser value get reinitialized..if not the driver value will be null..
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
		//	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
		} else { // here the driver is not initialized so we may get compile time errors so, to avoid compile time error you initialize the driver at the time of declaration..
			System.out.println("Invalid Browser name ");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// Step3 : Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);      // don't provide USERNAME in string.... 
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();

		// Step3 : Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step5 : Click on Create Organization look up Image
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();

		// Step6 : Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		System.out.println("organizationName : " + ORGNAME);

		// Step7 : Select "Chemicals" in the industry drop down     (don't take Random class for Industry because we need to select industry from the dropdown..)
		WebElement dropdown1 = driver.findElement(By.name("industry"));
		Select ss = new Select(dropdown1);
		ss.selectByValue(INDUSTRYNAME);

		// Step8 : Save and validate
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(orgHeader);
			System.out.println("OrgName : " + orgHeader);
		}
		// Step7 : Logout of Application
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout done successfully");
				
		// Step11 : Close the Browser
		driver.quit();
	}
}
