package Vaildating_Image_and_Text_OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Vaildating_Image_and_Text_OrangeHRM {
	
	String url="https://opensource-demo.orangehrmlive.com/";
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
	public void validation()
	{
		String actual_loginPanelText=driver.findElement(By.id("logInPanelHeading")).getText();
		System.out.println("The actual Text on the login Panel is :"+actual_loginPanelText);
		
		String expected_loginPanelText="LOGIN Panel";
		System.out.println("The expected Text on the login Panel is :"+expected_loginPanelText);
		
		Assert.assertEquals(actual_loginPanelText,expected_loginPanelText,"String Not Found");
        
		////*[@id="divLogo"]/img
		WebElement orangeHRMLogo=driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		boolean flag = orangeHRMLogo.isDisplayed();
		System.out.println(flag);
		
		Assert.assertTrue(flag);
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
