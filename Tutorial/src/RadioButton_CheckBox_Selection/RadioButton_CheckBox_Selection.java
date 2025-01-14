package RadioButton_CheckBox_Selection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButton_CheckBox_Selection {
	
	WebDriver driver=null;
	String url="https://learn.letskodeit.com/p/practice";
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          
	}
	
	@Test(priority=1)
	public void radiobutton() throws InterruptedException
	{   
		WebElement bmw_Radio=driver.findElement(By.id("bmwradio"));
		bmw_Radio.click();
		
		Thread.sleep(5000);
		
		WebElement benz_Radio=driver.findElement(By.id("benzradio"));
		benz_Radio.click();
		
	}
	
	@Test(priority=2)
	public void checkBox() throws InterruptedException
	{   
		WebElement bmw_Check=driver.findElement(By.id("bmwcheck"));
		bmw_Check.click();
		
		Thread.sleep(5000);
		
		
		WebElement benz_Check=driver.findElement(By.id("benzcheck"));
		benz_Check.click();
		
	
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{   Thread.sleep(5000);
		driver.quit();
	}

}
