package Log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logger_Log4j {
	
	static WebDriver driver=null;
	static Logger logger=Logger.getLogger("logger_Log4j");
	
	public static void main(String[] args) {
     		
	PropertyConfigurator.configure("Log4j.properties");
	
	System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
    driver=new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	logger.info("Implicit wait applied on the driver for 10 seconds");
	 
    //Launch the Online Store Website

    driver.get("https://opensource-demo.orangehrmlive.com/");

    logger.info("Web application launched");

    // Find the element that's ID attribute is 'log' (Username)

    // Enter Username on the element found by above desc.

   driver.findElement(By.name("txtUsername")).sendKeys("admin");;

    logger.info("Username entered in the Username text box");

    // Find the element that's ID attribute is 'pwd' (Password)

    // Enter Password on the element found by the above desc.

    driver.findElement(By.name("txtPassword")).sendKeys("admin123");

    logger.info("Password entered in the Password text box");

    // Now submit the form. WebDriver will find the form for us from the element

    driver.findElement(By.id("btnLogin")).click();

    logger.info("Click action performed on Submit button");

    // Print a Log In message to the screen

    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

     // Find the element that's ID attribute is 'account_logout' (Log Out)

   /* driver.findElement(By.id("account_logout"));

    logger.info("Click action performed on Log out link");
*/
    // Close the driver

    driver.quit();

    logger.info("Browser closed");
		
		
		
		
	}
}
