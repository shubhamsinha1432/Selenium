package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewTours_LoginTest extends BaseTest {
	
	@Test(priority=1)
	public void logIn() throws IOException
	{
	FileInputStream file=new FileInputStream("C://Users//Dell//Desktop//OrangeHRM_Login_TestData1.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("sheet1");
	int rowCount=sheet.getLastRowNum();
	
	for(int i=1;i<=rowCount;i++)
	{   
		Row row=sheet.getRow(i);
		
		WebElement username=driver.findElement(By.name("userName"));
		username.clear();
		username.sendKeys(row.getCell(0).getStringCellValue());
		
		WebElement password=driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(row.getCell(1).getStringCellValue());
		
		WebElement signIn=driver.findElement(By.name("login"));
		signIn.click();
		

	    String expected_HomepageTitle="Mercury Tours";
	    System.out.println("The Expected Title of Homeapage is :"+expected_HomepageTitle);
	
	    String actual_HomepageTitle=driver.getTitle();
	    System.out.println("The Actual Title of Homeapage is :"+actual_HomepageTitle);
		
	    if(actual_HomepageTitle.contains(expected_HomepageTitle))
	    {
	    	System.out.println("LogIN Successfull - PASS");
	    	row.createCell(2).setCellValue("LogIN Successfull - PASS");
	    }
	    else
	    {
	    	System.out.println("LogIN Unsuccessfull - FAIL");
	    	row.createCell(2).setCellValue("LogIN Unsuccessfull - FAIL");
	    }
	    
	    FileOutputStream file1=new FileOutputStream("C://Users//Dell//Desktop//Tutorial/src/TestDataResults/LoginTestDataResult.xlsx");
	    workbook.write(file1);
	    driver.navigate().back();
	
}
}
}
