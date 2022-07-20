package com.mobileSteps;
 
import com.mobilePages.DriverLoginPage;

import io.cucumber.java.en.Then;

public class DriverLoginStepDefination extends DriverLoginPage{
	
	@Then("^Driver get logged in sucessfully with valid credentials")
	public void logginInWithValidCredentialsInHiflowApp() throws InterruptedException {
		new DriverLoginPage().UserIsOnLoginPage();
		new DriverLoginPage().enteringEmailId();
		new DriverLoginPage().enteringPassword();
		new DriverLoginPage().clickingOnLoginButton();
	}

}
