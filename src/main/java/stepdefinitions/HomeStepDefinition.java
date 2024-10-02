package stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.ExcelReader;


public class HomeStepDefinition {
		
	LoginStepDefinition lt = new LoginStepDefinition();
	 
//HomeTest - Scenario 1 starts here		
	
	@Given("Login and Navigate to Home Page")
	public void HomePage() throws InterruptedException, IOException {

		lt.LoginPage(); 
		lt.IDEntered();
		lt.NextButtonClicked();
		lt.PassworEntered();
		lt.NextButtonClicked();
		lt.tb.driver.getTitle();

	}

	@Then("Home Page Welcome texts are verified")
	public void HomePageTextsVerification() throws InterruptedException {

		HomePage hp = new HomePage(lt.tb.driver);
		lt.tb.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		Assert.assertEquals(hp.WelcomeText.getText(), "Welcome, Dhanya Iyer");
		Assert.assertEquals(hp.manageInforText.getText(),
				"Manage your info, privacy, and security to make Google work better for you. Learn more");
	}

	@And("Browser is closed for Home Test")
	public void CloseBrowser() {

		lt.CloseBrowser();
	}

//HomeTest - Scenario 2 starts here		

	@Then("Add Recovery Details as Phone Number equals to {string} and Address equals to {string}")
	public void AddRecoveryDetails(String Phone, String Address) throws InterruptedException {

		HomePage hp = new HomePage(lt.tb.driver);

		Thread.sleep(3000);
		hp.AddRecoveryPhone(Phone);
		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		Thread.sleep(3000);
		hp.AddRecoveryAddress(Address);
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
	}

// HomeTest - Scenario 3 starts here

	@Then("Add Recovery Details using Property file")
	public void AddRecoveryDetailsPropertiesFile() throws InterruptedException {

		HomePage hp = new HomePage(lt.tb.driver);

		Thread.sleep(3000);
		hp.AddRecoveryPhone(lt.tb.prop.getProperty("PhoneNumber"));
		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		hp.AddRecoveryAddress(lt.tb.prop.getProperty("Address"));
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
	}

//HomeTest - Scenario 4 starts here	

	@Then("Add Recovery Details using Examples as Phone Number equals to {string} and Address equals to {string}")
	public void AddRecoveryDetailsUsingExamples(String Phone, String Address) throws InterruptedException {

		HomePage hp = new HomePage(lt.tb.driver);
		Thread.sleep(3000);
		hp.AddRecoveryPhone(Phone);
		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		hp.AddRecoveryAddress(Address);
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
	}

//HomeTest - Scenario 5 starts here		

	@Then("Add Recovery Details using Data Table")
	public void AddRecoveryDetailsUsingDataTable(DataTable RecoveryInputs) throws InterruptedException {

		List<List<String>> data = RecoveryInputs.asLists();

// Data 1 -
		
		HomePage hp = new HomePage(lt.tb.driver);
		Thread.sleep(3000);
		hp.AddRecoveryPhone.click();
		hp.RecoveryInfoText.getText();
		hp.AddPhone.sendKeys(data.get(0).get(0));

		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		hp.AddRecoveryAddress(data.get(0).get(1));
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		hp.CancelButton.click();

// Data 2 -

		Thread.sleep(3000);
		hp.AddRecoveryPhone.click();
		hp.RecoveryInfoText.getText();
		hp.AddPhone.sendKeys(data.get(1).get(0));

		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		hp.AddRecoveryAddress(data.get(1).get(1));
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		hp.CancelButton.click();
		
// Data 3 -

		Thread.sleep(3000);
		hp.AddRecoveryPhone.click();
		hp.RecoveryInfoText.getText();
		hp.AddPhone.sendKeys(data.get(2).get(0));
		Assert.assertEquals(hp.RecoveryInfoText.getText(),
				"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		hp.CancelButton.click();
		Thread.sleep(3000);
		hp.BackArrow.click();
		hp.AddRecoveryAddress(data.get(2).get(1));
		Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
				"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		hp.CancelButton.click();
	}

//HomeTest - Scenario 6 starts here	

	@Then("Add Recovery Details using Maps")
	public void AddRecoveryDetailsUsingMaps(DataTable RecoveryInputs) throws InterruptedException {

		for (Map<String, String> data : RecoveryInputs.asMaps(String.class, String.class)) {

			HomePage hp = new HomePage(lt.tb.driver);
			Thread.sleep(3000);
			hp.AddRecoveryPhone.click();
			hp.RecoveryInfoText.getText();
			hp.AddPhone.sendKeys(data.get("Phone"));
			Assert.assertEquals(hp.RecoveryInfoText.getText(),
					"Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
			hp.CancelButton.click();
			Thread.sleep(3000);
			hp.BackArrow.click();
			hp.AddRecoveryAddress(data.get("Address"));
			Assert.assertEquals(hp.RecoveryOptionsText1.getText(),
					"Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
			hp.CancelButton.click();

		}
	}

	


}
	
	
