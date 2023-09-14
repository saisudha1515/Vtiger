package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactInfoHeaderText() {
		return contactHeaderText;
	}
	
	//Business Library
	/**
	 * This method will return the contact header text
	 * @return
	 */
	public String getContactHeader() {
		return contactHeaderText.getText();
	}
}
