package DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider_Login {
	WebDriver driver=null;
	String url="http://newtours.demoaut.com/";
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          
	}
	
	@DataProvider()
	public Object[][] getData()
	{
	  Object[][] data=new Object[2][2];
	  data[0][0]="tutorial";
	  data[0][1]="tutorial";
	  
	  data[1][0]="tutorial";
	  data[1][1]="tutorial";
	  
	  return data;
		
	}
	
	@Test(dataProvider="getData")
	public void login(String username,String password)
	{
	  WebElement Username=driver.findElement(By.name("userName"));
	  Username.clear();
	  Username.sendKeys(username);
	  
	  WebElement Password=driver.findElement(By.name("password"));
	  Password.clear();
	  Password.sendKeys(password);
	  
	  WebElement signIn=driver.findElement(By.name("login"));
	  signIn.click();
	  
	  driver.navigate().back();
	 
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
