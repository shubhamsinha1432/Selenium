package MultiBrowser;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class MultiBrowser_Using_parameter {
	WebDriver driver=null;
	String url="http://www.store.demoqa.com";
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser)
	{
	 if(browser.equalsIgnoreCase("firefox"))
	 {
		 System.setProperty("webdriver.gecko.driver","C://Users//Dell//Desktop//Tutorial//Driver Files//geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
	 }
	 else
	 {    
		 System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
	 }
	}
	
	@Test
	public void logIn()
	{   
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		 
	    driver.findElement(By.id("log")).sendKeys("testuser_1");
	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	 
	    driver.findElement(By.id("login")).click();
	 
	}
	
	 @AfterTest 
	 public void afterTest() 
	 {
		driver.quit(); 
	 }

}
