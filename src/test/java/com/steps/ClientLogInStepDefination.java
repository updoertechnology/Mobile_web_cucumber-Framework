package com.steps;

import com.pages.ClientLogInPage;
import com.utils.GenericWrappers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ClientLogInStepDefination extends ClientLogInPage {

	@Given("^User is on Client Log In Page Of Demo Website")
	public void userNavigatesToClientLoginPage() throws Throwable {
		new ClientLogInPage().userNavigatesToClientLoginPage();
	}

	@Then("^User is Logged in with Valid Credentials \"([^\"]*)\" and \"([^\"]*)\"")
	public void userEntersValidCredentials(String username, String passwrd) throws InterruptedException {
		new ClientLogInPage().enterClientLoginEmail(username);
		new ClientLogInPage().enterClientLoginPassword(passwrd);
		new ClientLogInPage().clickOnClientLoginButton();
	}
}
