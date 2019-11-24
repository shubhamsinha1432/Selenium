package GRID;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_LoginTest_Using_GRID {
	
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	String base_URL="http://192.168.1.32:3333/wd/hub";
	DesiredCapabilities cap=null;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{  
	   cap=DesiredCapabilities.chrome();
	   cap.setBrowserName("chrome");
	   cap.setPlatform(Platform.WINDOWS);
	   driver=new RemoteWebDriver(new URL(base_URL), cap);
	   
	}
	
	@Test
	public void login()
	{   
		driver.get(url);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
