package com.mobilePageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.GenericWrappers;


public class DriverLoginPageFactory extends GenericWrappers{

	@FindBy(xpath = "Mobile Login Page locator")
	public WebElement logInPage;
	
	@FindBy(xpath = "email text filed")
	public WebElement enterEmail;
	
	@FindBy(xpath = "Password Text field")
	public WebElement enterPassword;
	
	@FindBy(xpath = "Login  button")
	public WebElement loginButton;
	
}
