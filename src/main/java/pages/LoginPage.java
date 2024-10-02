package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver driver;
	
	@FindBy(id="identifierId")
	public WebElement Email;
	
	@FindBy(xpath="//span[text()='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement Password;
	
	@FindBy(xpath="//button[text()='Forgot email?']")
	public WebElement ForgotEmail;
	
	@FindBy(xpath="//input[@id='recoveryIdentifierId']")
	public WebElement RecoveryEmail;
	
	@FindBy(id="firstName")
	public WebElement FirstName;
	
	@FindBy(id="lastName")
	public WebElement LastName;
	
	@FindBy(xpath="(//div[@class='dMNVAe'])[3]")
	public WebElement LearnMoreLinkText;
	
	@FindBy(xpath="//a[text()='Learn more about using Guest mode']")
	public WebElement LearnMoreLink;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void LoginEmail(String a ) {
		Email.clear();
		Email.sendKeys(a);
		
	}
	public void LoginPassword(String b) {
		Password.sendKeys(b);
		
	}
	
	public void ClickNextButton() {
		NextButton.click();
	}
	
	public String Title() {
		String ActualTitle = driver.getTitle();
		return ActualTitle;
		
	}
	public void ForgotEmailLink() {
		ForgotEmail.click();
		
	}
	
	public void RecoveryEmail(String c) {
		RecoveryEmail.sendKeys(c);
	}
	
	public void RecoveryEmailDetails(String d, String e) {
		FirstName.sendKeys(d);
		LastName.sendKeys(e);
		
	}
	
	public String LearnMoreLinkTextVerification() {
		 String a = LearnMoreLinkText.getText();
		 return a;
	}
	
	public void LearnMoreLink() throws InterruptedException {		
		LearnMoreLink.click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iter = allWindows.iterator();
		iter.next();
		String ChildWindow = iter.next();
		driver.switchTo().window(ChildWindow);

	}
	
	public void CloseBrowser() {
		driver.quit();
		
	} 
	
}



