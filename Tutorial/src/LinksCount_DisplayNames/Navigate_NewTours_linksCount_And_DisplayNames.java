package LinksCount_DisplayNames;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_NewTours_linksCount_And_DisplayNames {

	public static void main(String[] args) throws IOException {
        String url="http://newtours.demoaut.com/";
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        
        //<a href="mercurysignon.php?osCsid=df16bf106159a726cd3a4caa6fb28207">SIGN-ON</a>
        List<WebElement>links=driver.findElements(By.tagName("a"));
        int linkCount=links.size();
        System.out.println("The total no. of links on the Newtours login page are :"+linkCount);
        
        for(int i=0;i<linkCount;i++)
        {
        	String linkName=links.get(i).getText();
        	System.out.println(i+" "+linkName);
        	links.get(i).click();
        	
        	System.out.println(driver.getCurrentUrl());
        	System.out.println(driver.getTitle());
        	
        	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(screenshot, new File("C://Users//Dell//Desktop//Tutorial//Screenshots//link"+i+".png"));
        	
        	driver.navigate().back();
        	links=driver.findElements(By.tagName("a"));
        	
        }
        
	}

}
