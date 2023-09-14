package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.GenericUtilities.WebDriverUtility;

//CreateNewContactPage ::  first we have to create organization through application.. Then only the organization will be created and it will go and sit in Organizations Database..and you can see the created organizations list in the "CreateNewContacts" page after clicking Organization look up Image
// If i have to use any organizations i have create it first through the application.. Then only they will be visible in organizations DataBase..
public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// If you get any window or any frames and whose base page is inside your
	// current page then add the belongings also (window or frame belongings) into
	// the same page to avoid confusion..
	// The elements present in the window/frame should be written in the page where
	// the window/frames root element or base element is present.. here the
	// organization look up image is present in the create contact page but when you
	// click on this element only you get Organizations page, it is window.. this
	// window root element is present in the "create contact page" so we have to add
	// the organization window elements to the "create contact page" page..

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;

	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;

	@FindBy(name = "search")
	private WebElement orgSearchBtn;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getSearchBtn() {
		return orgSearchBtn;
	}

	// Business Library
	/**
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {   // call this method when you do not have the scenario of not having organization in the Create contact page..
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	/**
	 * This method will create contact using Organization
	 * @param LASTNAME
	 * @param driver
	 * @param ORGNAME
	 */
	public void createNewContact(String LASTNAME, WebDriver driver, String ORGNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");	 // switch the control to child window i.e, Organization page
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();  // Here  we have to use findElement() for dynamic element identification..we can't use @FindBy annotation..Dynamic X-path (here org name is dynamic data)is -->  inside ''-->""---> inside "" write ++--> in between ++ write the Dynamic Data..in case of any other attribute write the dynamic data within "DYNAMIC DATA" as attribute value..
		switchToWindow(driver, "Contacts");   // switch the control back to parent window i.e, Create new contact Page..
		saveBtn.click();
		
		//  driver.findElement(By.linkText(ORGNAME)); dynamic linkText
	}

}
