package Alert_Popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TSRTC_Alert {
	
	String url="https://www.tsrtconline.in/";
	WebDriver driver=null;
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          
	}
	
	@Test
	public void alert()
	{
		WebElement checkAvailability=driver.findElement(By.className("chkavailabilityBtn"));
		checkAvailability.click();
		
		Alert alert=driver.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println(alertmsg);
		alert.accept();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
