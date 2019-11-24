package Facebook_LoginTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Facebook_BaseTest.BaseTest;
import Facebook_Login.Facebook_Login;

public class LoginTest extends BaseTest{
	
	Facebook_Login Facebook_login=null;
	
	@Test()
	public void login() throws IOException
	{
		FileInputStream file=new FileInputStream("C://Users//Dell//Desktop//POM//src//ApplicationTestDataFiles//Facebook_LoginTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			
			Facebook_login=PageFactory.initElements(driver, Facebook_Login.class);
			Facebook_login.login(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
			
			driver.navigate().back();
		
	}

}
}
