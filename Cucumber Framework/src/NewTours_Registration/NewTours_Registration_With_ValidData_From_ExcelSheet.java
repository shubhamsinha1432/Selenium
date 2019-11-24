package NewTours_Registration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewTours_Registration_With_ValidData_From_ExcelSheet {
	
	 WebDriver driver=null;
	 String url="http://newtours.demoaut.com/";
	  
	@Given("^Open Chrome and Navigate to NewTours$")
	public void Open_Chrome_and_Navigate_to_NewTours() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get(url);
	        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);    
	}

	@When("^User Enters a valid data from excel sheet and click on Submit Button$")
	public void User_Enters_a_valid_data_from_excel_sheet_and_click_on_Submit_Button() throws Throwable {
		FileInputStream file= new FileInputStream("C://Users//Dell//Desktop//Cucumber Framework//ApplicationTestDataFiles//RegistrationTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		System.out.println("The Total no. of rows are:"+rowCount);
		
		for(int i=1;i<=rowCount;i++)
		{ 
		  Row row=sheet.getRow(i);
		 driver.findElement(By.linkText("REGISTER")).click();
		WebElement firstName=driver.findElement(By.name("firstName"));
		firstName.clear();
		firstName.sendKeys(row.getCell(0).getStringCellValue());
		
		WebElement lastName=driver.findElement(By.name("lastName"));
		lastName.clear();
		lastName.sendKeys(row.getCell(1).getStringCellValue());
		
        // Type Casting
		double d=row.getCell(2).getNumericCellValue();
		long x=(long)d;
		String phoneNumber=Long.toString(x);
		
		WebElement phone=driver.findElement(By.name("phone"));
		phone.clear();
		phone.sendKeys(phoneNumber);
		
		WebElement email=driver.findElement(By.name("userName"));
		email.clear();
		email.sendKeys(row.getCell(3).getStringCellValue());
		
		WebElement address1=driver.findElement(By.name("address1"));
		address1.clear();
		address1.sendKeys(row.getCell(4).getStringCellValue());
		
		WebElement city=driver.findElement(By.name("city"));
		city.clear();
		city.sendKeys(row.getCell(5).getStringCellValue());
		
		WebElement state=driver.findElement(By.name("state"));
		state.clear();
		state.sendKeys(row.getCell(6).getStringCellValue());
		
		double r=row.getCell(7).getNumericCellValue();
		long z=(long)r;
		String postal=Long.toString(z);
		
		WebElement postalCode=driver.findElement(By.name("postalCode"));
		postalCode.clear();
		postalCode.sendKeys(postal);
		
		WebElement country=driver.findElement(By.name("country"));
		country.sendKeys(row.getCell(8).getStringCellValue());
		
		WebElement userName=driver.findElement(By.name("email"));
		userName.clear();
		userName.sendKeys(row.getCell(9).getStringCellValue());
		
		WebElement password=driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(row.getCell(10).getStringCellValue());
		
		WebElement confirmPassword=driver.findElement(By.name("confirmPassword"));
		confirmPassword.clear();
		confirmPassword.sendKeys(row.getCell(11).getStringCellValue());
		
		WebElement register=driver.findElement(By.name("register"));
		register.click();
		System.out.println("registration Successfull");
		
		String expected_Username=row.getCell(9).getStringCellValue();
		System.out.println("The expected userName is :"+expected_Username);
		
		//<b> Note: Your user name is shubh.</b>
		String actual_RegisteredUsername=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		System.out.println("The actual Registered userName is :"+actual_RegisteredUsername);
		
		if(actual_RegisteredUsername.contains(expected_Username))
		{
			System.out.println("Registration Sucessfull-PASS");
			row.createCell(12).setCellValue("Registration Sucessfull-PASS");
		 }
		else 
		{
			System.out.println("Registration Unucessfull-FAIL");
			row.getCell(12).setCellValue("Registration Unucessfull-FAIL");	
		}
		FileOutputStream file1=new FileOutputStream("C://Users//Dell//Desktop//Cucumber Framework//ApplicationTestDataResultFiles//NewTours_NewRegistrationTestResults.xlsx");
		workbook.write(file1);
		
		driver.navigate().back();

		}
		
	}

	@Then("^User should be able to Registered to the Application Successfully and Close the Browser$")
	public void User_should_be_able_to_Registered_to_the_Application_Successfully_and_Close_the_Browser() throws Throwable {
		driver.quit();	
	}



}
