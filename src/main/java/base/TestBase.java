package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;




public class TestBase {

	public  WebDriver driver;
	public Properties prop = new Properties();
	
	public void OpenBrowser() throws IOException {

		FileInputStream fi = new FileInputStream("C:\\Users\\dhany\\OneDrive\\Desktop\\Java-Practice\\JavaPractice\\CucumberWithPOMGoogle\\src\\main\\java\\config\\Google.properties");
		
		prop.load(fi);
		String Browser = prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if(Browser.equalsIgnoreCase("Chrome"))  {
			driver = new ChromeDriver();
		} else {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public void OpenUrl() {
		driver.get(prop.getProperty("url"));	
	}
	
	public void CloseBrowser() {
		driver.quit();
		
	}
}
