package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage{
	
	
	public WebDriver driver; 
	
	
	@FindBy(xpath = "//h1[@class='XY0ASe']")
	public WebElement WelcomeText;
	
	@FindBy(xpath="//div[@class='WXMuEd']")
	public WebElement manageInforText;
	
	@FindBy(xpath="//a[@aria-label='Add recovery phone']")
	public WebElement AddRecoveryPhone;
	
	@FindBy(xpath="(//div[@class='h0PAh'])[1]")
	public WebElement RecoveryInfoText;
	
	@FindBy(xpath="//input[@aria-label='Your recovery phone']")
	public WebElement AddPhone;
	
	@FindBy(xpath="//a[@aria-label='Set home address']")
	public WebElement AddRecoveryAddress;
	
	@FindBy(xpath="//input[@aria-label='Address input field']")
	public WebElement AddAddress;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement SaveButton;
	
	@FindBy(xpath="(//span[text()='Cancel'])[1]")
	public WebElement CancelButton;
	
	@FindBy(xpath="//div[@class='btFaIb']/p[1]")
	public WebElement RecoveryOptionsText1;
	
/*	@FindBy(xpath="//div[@class='btFaIb']/p[2]")
	public WebElement RecoveryOptionsText2;   */
	
	@FindBy(xpath="(//div[@aria-label='Back'])[1]")
	public WebElement BackArrow;
	
	@FindBy(xpath="(//div[text()='Personal info'])[2]")
    public WebElement ClickOnPersonalInfo;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 
	PageFactory.initElements(driver, this);
	
	    }
	
	
		public void AddRecoveryPhone(String a) throws InterruptedException {
		Thread.sleep(3000);
		AddRecoveryPhone.click();
		RecoveryInfoText.getText();
        AddPhone.sendKeys(a);
        Thread.sleep(3000);
   //     CancelButton.click();

        
//     SaveButton.click();
       
	}
	
	
	public void AddRecoveryAddress(String a) throws InterruptedException {
		Thread.sleep(3000);
		AddRecoveryAddress.click();
		AddAddress.sendKeys(a);
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
			
		}
		driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();

	//	BackArrow.click();
		
	}
	public void ClickonPersonalInfo() throws InterruptedException {
		Thread.sleep(6000);
		ClickOnPersonalInfo.click();
		
	}
	
	}
	

    

	
	
	


