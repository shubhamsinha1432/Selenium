package OrangeHRM_Login_Functionality_Multipledata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM_Login_Functionality_Multipledata {
	
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
	
	@Test(priority=1)
	public void logIn() throws IOException
	{
		FileInputStream file = new FileInputStream("C://Users//Dell//Desktop//Tutorial//Testdata//OrangeHRM_Login_TestData1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			
			WebElement username=driver.findElement(By.id("txtUsername"));
			username.clear();
			username.sendKeys(row.getCell(0).getStringCellValue());
			
			WebElement password=driver.findElement(By.id("txtPassword"));
			password.clear();
			password.sendKeys(row.getCell(1).getStringCellValue());
			
			WebElement login=driver.findElement(By.name("Submit"));
			password.click();
			
			String actual_WelcomeAdminText=driver.findElement(By.linkText("Welcome Admin")).getText();
            System.out.println("The Actual Welcome Admin Text is :"+actual_WelcomeAdminText);
            
            String expected_WelcomeAdminText="Welcome Admin";
            System.out.println("The Excpected Welcome Admin Text is :"+expected_WelcomeAdminText);
            
            if(actual_WelcomeAdminText.equalsIgnoreCase(expected_WelcomeAdminText))
            {
            	System.out.println("Login Successfull - Pass");
            	row.createCell(2).setCellValue("Login Successfull - Pass");
            }
            else
            {
            	System.out.println("Login Unsuccessfull - Fail");
            	row.createCell(2).setCellValue("Login Unsuccessfull - Fail");
            }
            
            FileOutputStream file1=new FileOutputStream("C://Users//Dell//Desktop//Tutorial//src//TestDataResults//OHRMLoginResult.xlsx");
            workbook.write(file1);
            
            driver.navigate().back();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
