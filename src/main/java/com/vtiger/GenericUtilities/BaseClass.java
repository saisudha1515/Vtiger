package com.vtiger.GenericUtilities;

// Annotations are used to create BaseClass and Annotations will help to create Base Class.. 
// BaseClass is for all repetative tasks. we keep all the common actions in the BaseClass and it is like Super class all Individual TestScripts will extend this BaseClass for DB connection, Browser Launching, Login to the application , logout from the application, Close the browser, Close the DB connection. these are all required for each and every TestScript so all will extend this BaseClass.
// When you write "alwaysRun = true", then irrespective of the groups it is gonna run the Scenarios always
/**
 * This is a generic class consisting of all basic configuration annotations of TestNG
 * @author : Saisudha D
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
////////////@Test(alwaysRun = true)    need to check this once whether can we write like this or not..
public class BaseClass {
	public static JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public  WebDriver driver = null; // initialize driver value as null since we are using if else statement..
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("=========== DataBase connection is successful ==========");
	}
    //@BeforeTest()                       //:  it is optional for Distributed parallel and mandatory for Cross Browser Execution.. It is for Distributed Parallel Execution : when we go for parallel execution then we can make use of "@BeforeTest() and @AfterTest()" in place of "@BeforeClass and @AfterClass" for Browser launching and Browser Closing actions because multiple threads are there. If you launch the Browser in @BeforeTest you can run multiple classes.. otherwise we can keep as it is. It is optional.. ****** we have to use "@BeforeTest() and @AfterTest()" when we go for Parallel Execution..no where else we use "@BeforeTest() and @AfterTest()" annotations. we use only in Parallel Execution..
	//@Parameters("browser")              // it is for Cross Browser Execution..
	@BeforeClass(alwaysRun = true)    // Write Browser Launching // declare WebDriver globally so that no where you have to declare.. and declare BROWSER AND URL as local variable since they are used only in before class only. if you use these variables more than one time then make it as Global variables..
    	public void bcConfig() throws Throwable {
		String BROWSER = pUtil.readFromDataFromPropertyFile("browser");  //since we are passing if from @Parameters annotation not from Properties file so commenting this while running the Scripts in Cross Browser Execution.
		String URL = pUtil.readFromDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name ");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		System.out.println(BROWSER+"========== Browser Launched ===========");
	}
	
    //@AfterTest() //: It is for Distributed Parallel Execution(optional) 
	@AfterClass(alwaysRun = true)       // Write Browser closing logic
	public void acConfig() {
		driver.quit();
		System.out.println("========== Browser closed ===========");
	}
	
	@BeforeMethod(alwaysRun = true)       // Write login to the Application logic
	public void bmConfig() throws Throwable {
		String USERNAME = pUtil.readFromDataFromPropertyFile("username");
		String PASSWORD = pUtil.readFromDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("========== Login Successful ===========");
	}

	@AfterMethod(alwaysRun = true)        // Write logic for logout from the application..
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logOutOfApplication(driver);
		System.out.println("========== Logout Successful  ===========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void csConfig() {
		System.out.println("============ DataBase connection closed ===========");
	}
}
