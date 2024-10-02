package pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PersonalInfoPage  {
	
	WebDriver driver;
	

	@FindBy(xpath="//header[@class='hrNQqb']/h1")
	public WebElement PersonalInfoHeader;
	
	@FindBy(xpath="//div[@class='mPKYhd']")
	public WebElement PersonalInfoHeaderText;
	
	@FindBy(xpath="(//h2[@class='PdgnBc'])[1]")
	public WebElement PersonalInfoHeader2;
	
	@FindBy(xpath="(//p[@class='fyjRne'])[1]")
	public WebElement PersonalInfoHeaderText2;
	
	@FindBy(xpath="//h2[text()='Basic info']")
	public WebElement PersonalInfoHeader3;
	
	@FindBy(xpath="(//div[@class='sieBfb']/div)[6]")
	public WebElement PersonalInfoHeaderText3;  
	
	@FindBy(xpath="(//div[@class='WzaSad'])[1]")
	public WebElement ClickProfilePictureLink;
	
	@FindBy(xpath="//body[@id='yDmH0d']/iframe[4]")
	public WebElement Frame;
	
 /*   @FindBy(xpath="(//div[@class='pYTkkf-Bz112c-RLmnJb'])[1]")
    public WebElement CloseButton; */
    
    @FindBy(xpath="//button[@aria-label='Close profile picture']")
    public WebElement CloseButton;
    
    @FindBy(xpath="//div[@class='wJpH8c']//h2[text()='Contact info']")
    public WebElement ContactInfo;
	
	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void BasicInfo() throws InterruptedException {
		Thread.sleep(3000);
		ClickProfilePictureLink.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click", CloseButton);
		  Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
			}
	
		
	public void ContactInfo() throws InterruptedException {
		Thread.sleep(6000);
  ((JavascriptExecutor) driver).executeScript("arguments[0].click", ContactInfo); //(JavascriptExecutor) driver) is used when 'WebDriver driver' is used
  ContactInfo.getText();
  
  	} 
	}


