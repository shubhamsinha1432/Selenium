package GRID;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Navigation_Using_GRID {
	
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	String nodeURL=" http://192.168.1.32:2222/wd/hub";
	DesiredCapabilities cap=null;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		cap=DesiredCapabilities.firefox();
	    cap.setBrowserName("firefox");
	    cap.setPlatform(Platform.WINDOWS);
	    driver=new RemoteWebDriver(new URL(nodeURL), cap);
	}
	
	@Test
	public void simpleTest()
	{
		driver.get(url);
		
	}
    
	@AfterTest
	public void tearDOwn()
	{
		driver.quit();
	}
}
