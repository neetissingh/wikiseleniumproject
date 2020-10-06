package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {

	public String baseUrl = "https://en.wikipedia.org/wiki/Metis_(mythology)";  
	public WebDriver driver ;   
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();  		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		Reporter.log("Test Started Browser Opened", true);
	}
	
	
	@AfterMethod
	public void closeApplication()
	{
	driver.quit();
	Reporter.log("Test Finished Browser Closed", true);
	}     
	
	
	
	
}
