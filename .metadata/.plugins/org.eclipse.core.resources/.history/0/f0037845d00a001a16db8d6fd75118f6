package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Right_Click {
	String url="http://demoqa.com/tooltip-and-double-click/";
	WebDriver driver=null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          
	}
	
	@Test()
	public void right_Click() throws InterruptedException
	{
		WebElement rightClickBtn=driver.findElement(By.id("rightClickBtn"));
		
		Actions action=new Actions(driver);
		action.contextClick(rightClickBtn).perform();
		System.out.println("Right Click Operation Performed");
		
		WebElement Copy_Me=driver.findElement(By.xpath(".//div[@id='rightclickItem']/div[1]"));
		Copy_Me.click();
		Thread.sleep(5000);
		
		String alert_Msg=driver.switchTo().alert().getText();
		System.out.println(alert_Msg);
		
		driver.switchTo().alert().accept();
		System.out.println("Alert Popup Accepted");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
