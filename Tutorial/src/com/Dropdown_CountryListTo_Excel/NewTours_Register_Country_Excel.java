package com.Dropdown_CountryListTo_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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

public class NewTours_Register_Country_Excel {
	
	String url="http://newtours.demoaut.com/";
	WebDriver driver=null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get(url);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        
	}
	
	@Test(priority=1)
	public void register()
	{
		WebElement register=driver.findElement(By.linkText("REGISTER"));
		register.click();
	}
    
	@Test(priority=2)
	public void country() throws IOException
	{
	  FileInputStream file=new FileInputStream("C://Users//Dell//Desktop//Tutorial//src//com//Dropdown_CountryListTo_Excel//Book1.xlsx");
	  XSSFWorkbook workbook=new XSSFWorkbook(file);
	  XSSFSheet sheet=workbook.getSheet("sheet1");
	  
	  WebElement country=driver.findElement(By.name("country"));
	  List<WebElement>countries=driver.findElements(By.tagName("option"));
	  int countries_Count=countries.size();
	  System.out.println("The number of Countries are :"+countries_Count);
	  
	  for(int i=0;i<countries_Count;i++)
	  {
		  Row row=sheet.getRow(i);
		  Cell cell=row.getCell(0);
		 
		 String countryName=countries.get(i).getText();
		 System.out.println(countryName);
		 cell.setCellValue(countryName);
		  
		}
		
	  FileOutputStream file1=new FileOutputStream("./Tutorial/src/TestDataResults/countriesList.xlsx");
	  workbook.write(file1);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
