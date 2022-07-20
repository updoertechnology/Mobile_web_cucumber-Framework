package com.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.GenericWrappers;

public class ClientLogInPageFactory extends GenericWrappers{

	@FindBy (css = "login Page Title")
	public WebElement clientloginPage;

	@FindBy (css = "email field locator")
	public WebElement clientEmailTextField;

	@FindBy (css = "password field Locator")
	public WebElement clientPasswordTextField;

	@FindBy (css = "login Button Locator")
	public WebElement clientLoginButton;

}
