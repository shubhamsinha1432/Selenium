package NewTours_Registration_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import NewTours_BaseTest.BaseTest;

public class NewTours_Registration_Test extends BaseTest{
	
	NewTours_Registration.NewTours_RegistrationPage NewTours_RegistrationPage=null;
	@Test(priority=1)
	public void register_button()
	{
		NewTours_RegistrationPage=PageFactory.initElements(driver, NewTours_Registration.NewTours_RegistrationPage.class);
		NewTours_RegistrationPage.register_button();
	}
	
	@Test(priority=2)
	public void register() throws IOException
	{   
		FileInputStream file=new FileInputStream("C://Users//Dell//Desktop//POM//src//ApplicationTestDataFiles//RegistrationTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			
		NewTours_RegistrationPage=PageFactory.initElements(driver, NewTours_Registration.NewTours_RegistrationPage.class);
		
		//Type Casting
		double d=row.getCell(2).getNumericCellValue();
		long l=(long)d;
		String phone=Long.toString(l);
		
		double r=row.getCell(7).getNumericCellValue();
		long x=(long)r;
		String PostalCode=Long.toString(x);
		
		NewTours_RegistrationPage.register(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), phone, row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(), row.getCell(6).getStringCellValue(), PostalCode, row.getCell(8).getStringCellValue(), row.getCell(9).getStringCellValue(), row.getCell(10).getStringCellValue(), row.getCell(11).getStringCellValue());
		
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
		
		FileOutputStream file1=new FileOutputStream("C://Users//Dell//Desktop//Tutorial//Tutorial//src//ApplicationTestDataResult//NewTours_NewRegistrationTestResults.xlsx");
		workbook.write(file1);
		driver.navigate().back();
		
	}

}
}