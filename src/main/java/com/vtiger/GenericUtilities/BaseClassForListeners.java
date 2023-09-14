package com.vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.vtiger.ObjectRepositiry_OR_ElementRepository.HomePage;
import com.vtiger.ObjectRepositiry_OR_ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClassForListeners {
	public static JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public  WebDriver driver = null; // initialize driver value as null since we are using if else statement..
    public static WebDriver sdriver; // This sdriver is not holding null at any point if time. it is holding driver reference after browser is getting launched. so it is always holding the updated driver reference..
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("=========== DataBase connection is successful ==========");
	}
	
    @BeforeClass(alwaysRun = true)    
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
		sdriver = driver; /// reinitialize the driver..
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
