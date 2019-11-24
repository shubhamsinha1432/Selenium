package OHRM_Login_With_Multipledata;

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

public class OHRM_Login_With_Multipledata {
	    
	  WebDriver driver=null;
	  String url="https://opensource-demo.orangehrmlive.com/";

		@Given("^Open Chrome and Navigate to OrangeHRM$")
		public void Open_Chrome_and_Navigate_to_OrangeHRM() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get(url);
	        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
 
		}

		@When("^User Enters a valid \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
		public void User_Enters_a_valid_and_and_click_on_login_button(String useraname, String password) throws Throwable {
			driver.findElement(By.id("txtUsername")).sendKeys(useraname);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();    
		}

		@Then("^User should be able to Login to the Application Successfully and Close the Browser$")
		public void User_should_be_able_to_Login_to_the_Application_Successfully_and_Close_the_Browser() throws Throwable {
		    int count=0;
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
			{   ++count;
				System.out.println("Login Unsuccessfull - Fail");
				
				File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("C://Users//Dell//Desktop//Cucumber Framework//Screenshots//OHRM_Loginfailed_test"+count+".png"));
				
			}
			driver.quit();

}
}