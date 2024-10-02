package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.PersonalInfoPage;

public class PersonalInfoStepDefinition {

	LoginStepDefinition lt = new LoginStepDefinition();

//PersonalInfoTest - Scenario 1 starts here		

	@Given("Login and Land on Home Page")
	public void LoginAndNavigate() throws InterruptedException, IOException {

		lt.LoginPage(); 
		lt.IDEntered();
		lt.NextButtonClicked();
		lt.PassworEntered();
		lt.NextButtonClicked();
		lt.tb.driver.getTitle();

	}

	@Then("Click on Personal Info")
	public void PersonalInfo() throws InterruptedException {
		HomePage hp = new HomePage(lt.tb.driver);
		hp.ClickonPersonalInfo();

	}

	@Then("Personal Info Header texts are verified")
	public void HeaderTextVerification() throws InterruptedException {
		PersonalInfoPage pi = new PersonalInfoPage(lt.tb.driver);
		Thread.sleep(3000);

		Assert.assertEquals(pi.PersonalInfoHeader.getText(), "Personal info");
		Assert.assertEquals(pi.PersonalInfoHeaderText.getText(),
				"Info about you and your preferences across Google services");
		Assert.assertEquals(pi.PersonalInfoHeader2.getText(), "Your profile info in Google services");
		Assert.assertEquals(pi.PersonalInfoHeaderText2.getText(),
				"Personal info and options to manage it. You can make some of this info, like your contact details, visible to others so they can reach you easily. You can also see a summary of your profiles.");
		Assert.assertEquals(pi.PersonalInfoHeader3.getText(), "Basic info");
		Assert.assertEquals(pi.PersonalInfoHeaderText3.getText(),
				"Some info may be visible to other people using Google services. Learn more");

	}

	@And("Browser is closed for Personal Info Test")
	public void CloseBrowser() {
		lt.CloseBrowser();
	}

//PersonalInfoTest - Scenario 2 starts here		

	@Then("Verify Basic Info")
	public void VerifyBasicInfo() throws InterruptedException {
		PersonalInfoPage pi = new PersonalInfoPage(lt.tb.driver);
		pi.BasicInfo();

	}

//PersonalInfoTest - Scenario 3 starts here		

	@Then("Verify Contact Info")
	public void VerifyContactInfo() throws InterruptedException {
		PersonalInfoPage pi = new PersonalInfoPage(lt.tb.driver);
		pi.ContactInfo();
		Assert.assertEquals(pi.ContactInfo.getText(), "Contact info");
	}
		
	}
	
	