package Stepdefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/";
	
	@Given("^Open the Chrome and launch the application$")
	public void Open_the_Chrome_and_launch_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}

	@When("^Enter the Username and Password$")
	public void Enter_the_Username_and_Password() throws Throwable {
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin1");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.id("btnLogin")).click();
	    
	}

	@Then("^Reset the credential$")
	public void Reset_the_credential() throws Throwable {
		try{
		String expected_text="Welcome Admin";
		System.out.println("The Expected text is :"+expected_text);
		 
		String actual_text=driver.findElement(By.id("welcome")).getText();
		System.out.println("The Actual text is :"+actual_text);
	    
		if(actual_text.contains(expected_text))
		{
			System.out.println("Login Successfull - Pass");
		}
		}
		catch(Exception e)
		{
			
		if(driver.findElement(By.id("spanMessage")).getText().contains("Invalid credentials"))
			{
			  System.out.println("Login UnSuccessfull - Fail");
			  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(file, new File("C://Users//Dell//Desktop//Cucumber Framework//Screenshots//OHRM_Loginfailed_test.png"));
			}
	}

          driver.quit();
	
}
}
