package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;

	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	// Business Library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateContactLookUpImg() {
		createContactLookUpImg.click();
	}

}
