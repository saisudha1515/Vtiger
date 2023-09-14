package com.vtiger.ObjectRepositiry_OR_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// If you want to do any changes in locators we have to do in it's POM class only.. not every where

public class LoginPage { //Rule 1 : Create a separate POM class for every web page.
//Rule 2 : Identify the web element using @FindBy, @FindBys, @FindAll annotations.. These are only annotations which are coming from Selenium these are seleenium annotations not TestNg annotations ..
	
	//This is Declaration:: 
	
	@FindBy(name = "user_name")      // textField short cut is : Edt
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;     // login button shortcut is : Btn

	//Rule 3 : Create a constructor to initialize the web elements
	//Initialization of WebElements ::
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 : Provide getters for accessing the web elements(return type of the getters is dataType.. here the return type is WebElement.. for generate getters we have a shortcut in Eclips..)You are allowed only to call getters and use them but not allowed to edit the web elements.. here you don'y have setters()option..as per POM class..
    // Utilization ::
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5 : Provide business logic    (here we no need to use getters we can directly make use of WebElements)
	   //Business Library is a generic method created using web elements present only in the Current page.. 
	/**
	 * This method will login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public  void loginToApplication(String USERNAME, String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
