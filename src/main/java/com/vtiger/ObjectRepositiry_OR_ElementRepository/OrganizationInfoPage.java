package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business Library
	// Don't provide logic for header validation. Any where the validation is the user/programmer choice..he can implement the logic in his own prospective..
	// Never do validation process in your "src/main/java" package...means never write any validation logic in "Business Library" or in the "Generic Utility" because you can not compile your team to use this kind of validation only.. Validation is always coder prospective..what is necessary a/cly he will do validation.. 
	/**
	 * This method will return the organization header text
	 * @return
	 */
	public String getOrgHeader() {
		return orgHeaderText.getText();
	}
}
