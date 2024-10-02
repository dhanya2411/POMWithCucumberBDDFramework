package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginStepDefinition {

	TestBase tb = new TestBase();

// LoginTest - Scenario 1 starts here

	@Given("User is able to navigate to Google Login Page URL and verify title")
	public void LoginPage() throws InterruptedException, IOException {

		tb.OpenBrowser();
		tb.OpenUrl();
		LoginPage lp = new LoginPage(tb.driver);
		Assert.assertEquals(lp.Title(), "Sign in - Google Accounts");

	}

	@Then("User enters ID")
	public void IDEntered() throws InterruptedException {
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(tb.driver);
		lp.LoginEmail(tb.prop.getProperty("email"));
	}

	@Then("User clicks on Next button")
	public void NextButtonClicked() throws InterruptedException {
		LoginPage lp = new LoginPage(tb.driver);
		lp.ClickNextButton();
		Thread.sleep(8000);
	}

	@Then("User enters Password")
	public void PassworEntered() throws InterruptedException {
		LoginPage lp = new LoginPage(tb.driver);
		Thread.sleep(3000);
		lp.LoginPassword(tb.prop.getProperty("password"));
		Thread.sleep(3000);
	}

	@Then("User is on Home Page")
	public void HomePageOpened() {
		LoginPage lp = new LoginPage(tb.driver);
		lp.Title();

	}

	@And("Browser is closed for Login Test")
	public void CloseBrowser() {
		tb.CloseBrowser();
	}

// LoginTest - Scenario 2 starts here

	@Then("Click on Forgot Email link")
	public void ForgotEmailLink() throws InterruptedException {
		LoginPage lp = new LoginPage(tb.driver);
		lp.ForgotEmailLink();
		Thread.sleep(3000);

	}

	@Then("Enter Recovery Email")
	public void RecoveryEmail() throws InterruptedException {
		LoginPage lp = new LoginPage(tb.driver);
		lp.RecoveryEmail(tb.prop.getProperty("RecoveryEmail"));
		Thread.sleep(3000);

	}

	@Then("Enter Recovery Email Details")
	public void RecoveryEmailDetails() {
		LoginPage lp = new LoginPage(tb.driver);

		lp.RecoveryEmailDetails(tb.prop.getProperty("FirstName"), tb.prop.getProperty("LastName"));
	}

// LoginTest - Scenario 3 starts here

	@Then("Verify Learn More link text")
	public void VerifyLearnMoreLinkText() {
		LoginPage lp = new LoginPage(tb.driver);
		Assert.assertEquals(lp.LearnMoreLinkTextVerification(),
				"Not your computer? Use a Private Window to sign in. Learn more about using Guest mode");
	}

	@Then("Click on Learn more about using Guest mode link")
	public void LearnMoreLink() throws InterruptedException {
		LoginPage lp = new LoginPage(tb.driver);
		lp.LearnMoreLink();
		Thread.sleep(3000);
		Assert.assertEquals(lp.Title(), "Sign in on a device that's not yours - Computer - Google Account Help");
	}

}
