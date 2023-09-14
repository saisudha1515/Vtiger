package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.GenericUtilities.WebDriverUtility;
/**
 * here in POM class we need to Inherit the WebDriverUtility class but here we do not create Object for WebDriverUtility because we create object in POM class for accessing the reusable methods again  we need to create object for WebDriverUtility in the testScript also which means for the single class we are creating object multiple times.. this is not recommended..Inherit the WebDriverUtility class in POM class don't create object..
 * In Property file, Excel File, Java Utility classes if you need any thing just do Parameterize.. since these are data only.. You can parameterize the data..ex:Login
 * The Beauty of POM class is Business Library.. and we can encapsulating the Locators and WebElements..
 * And in POM class we can see Hierarchical Inheritance. How? --> All POM classes are acquiring properties form WebDriverUtility class/ all POM classes are extending from WebDriverUtility class for access the reusable methods of WebDriverUtiity class.. 
 * Why WebDriverUtility is getting inheritance? --> Because in POM class is having all the WebElements of each web page (only webElements and Locators) for these we require only WebDriverUtility class.. so Inherit it..
 * We can write multiple Business Libraries in Single POM class.. and we can write Business Library for multiple actions also..
 * The beauty of POM class is writing Business Library (so that we can hide the action/operation that we are performing on the WebElements.. and also encapsulating the web elements and locators.
 */
public class HomePage extends WebDriverUtility{    // it is example for Hierarchical inheritance..since all Pom classes are sharing properties from WebDriverUtility class for accessing web elements 
	// Declaration

	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;    // Link ShortCut is Lnk..// textField short cut is : Edt..// login button shortcut is : Btn   .... //DropDown shortcut is : DropDwn
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationImg;  // Image shortCut is img..
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdministrationImg() {
		return administrationImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Business Library   (With the help of BUsiness Library we can hide the actions/Operations that are performing on the web Elements..so that the code can be optimized in the testScript.. you have to inherit WebDriverUtilty class ONLY (not other classes form ObjectRepository package) then we write business library when you don't write business library then no need to inherit WebDriverUtility class.. for code optimization in the test script.. )
	/**
	 * This method will logout of Application
	 * @param driver
	 */
	public void logOutOfApplication(WebDriver driver) {
		mouseHoverAction(driver, administrationImg);
		signOutLnk.click();
	}
	
	/**
	 * This method will click on Organization Link
	 */
	public void clickOnOrganizationLnk() {
		organizationLnk.click();
	}
	
	/**
	 * This method will click on Contacts Link
	 */
	public void clickOnContactsLnk() {
		contactsLnk.click();
	}
	
	/**
	 * This method will click on Products Link
	 */
	public void clickOnProductsLnk() {
		productsLnk.click();
	}
	
}
