package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	// Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLoopUpImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrgLoopUpImg() {
		return createOrgLoopUpImg;
	}
	
	/**
	 * This method will click on Create organization look up Image
	 */
	//Business Library
	public void clickOnCreateOrgLookUpImage() {
		createOrgLoopUpImg.click();
	}
}
