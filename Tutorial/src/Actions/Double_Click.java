package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Double_Click {
	String url="http://demoqa.com/tooltip-and-double-click/";
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
	
	@Test()
	public void double_click() throws InterruptedException
	{   
		WebElement doubleClickBtn=driver.findElement(By.id("doubleClickBtn"));
		Actions action=new Actions(driver);
		action.doubleClick(doubleClickBtn).perform();
		System.out.println("Double Click Performed");
		Thread.sleep(5000);
		
		String alert_msg=driver.switchTo().alert().getText();
		System.out.println(alert_msg);
		
		driver.switchTo().alert().accept();
		System.out.println("Alert Popup Accepted");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
