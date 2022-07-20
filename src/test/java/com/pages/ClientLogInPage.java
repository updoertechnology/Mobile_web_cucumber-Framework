package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.ClientLogInPageFactory;

public class ClientLogInPage extends ClientLogInPageFactory{

	public ClientLogInPage() {

		PageFactory.initElements(getDriver(), this);
		
	}

	
	public void userNavigatesToClientLoginPage() throws InterruptedException, Throwable{
		Thread.sleep(5000);
		waitVisibilityOfElement(clientloginPage);
	}

	public void enterClientLoginEmail(String username) throws InterruptedException {
		waitVisibilityOfElement(clientEmailTextField);
		clientEmailTextField.clear();
		clientEmailTextField.sendKeys(username);
	}

	public void enterClientLoginPassword(String passwrd) throws InterruptedException {
		waitVisibilityOfElement(clientPasswordTextField);
		clientPasswordTextField.clear();
		clientPasswordTextField.sendKeys(passwrd);
	}

	public void clickOnClientLoginButton() throws InterruptedException{
		clickButton(clientLoginButton);
	}
	
	public void ClientLoginEmail(String email) throws InterruptedException {
		waitVisibilityOfElement(clientEmailTextField);
		clientEmailTextField.clear();
		clientEmailTextField.sendKeys(email);
	}
	
	public void ClientLoginPassword(String password) throws InterruptedException {
		waitVisibilityOfElement(clientPasswordTextField);
		clientPasswordTextField.clear();
		clientPasswordTextField.sendKeys(password);
	}

		

}
