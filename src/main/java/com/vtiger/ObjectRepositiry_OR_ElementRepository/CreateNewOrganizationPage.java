package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	// Declaration
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(name = "industry")
	private WebElement industryDropDwn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return industryDropDwn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// Business Library
	// The below methods are the example for methodOverloading but it is specific to creation of organization.... And also don't create dependency between the methods
	/**
	 * This method will create organization using mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) { // creation of organization with out industry dropdown  because handling dropdown is not the mandatory field here..as per the scenario 
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}

	/**
	 * This method will create organization by handling industry dropdown
	 * @param ORGNAME
	 * @param IndustryName
	 */
	public void createNewOrganization(String ORGNAME, String Industry) { // creation of organization with industry dropdown
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(Industry, industryDropDwn);
		saveBtn.click();
	}

}
