package com.mobilePages;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.mobilePageFactory.DriverLoginPageFactory;

public class DriverLoginPage extends DriverLoginPageFactory{
	
	public DriverLoginPage() {

		PageFactory.initElements(driver1, this);
		
	}


	public void UserIsOnLoginPage() throws InterruptedException {
		Thread.sleep(2000);
		waitForVisibility(logInPage);
		Assert.assertTrue(isElementPresent(logInPage));
		Assert.assertTrue(logInPage.getText().equalsIgnoreCase("Log in to access your assignments"));
	}


	public void enteringEmailId() throws InterruptedException {
		Assert.assertTrue(isElementPresent(enterEmail));
		enterEmail.clear();
		enterEmail.sendKeys(partnerEmailId);
	}


	public void enteringPassword() throws InterruptedException {
		Assert.assertTrue(isElementPresent(enterPassword));
		enterPassword.clear();
		enterPassword.sendKeys(partnerEmailPassword);
	}


	public void clickingOnLoginButton() throws InterruptedException {
		Assert.assertTrue(isElementPresent(loginButton));
		loginButton.click();
	}

}
