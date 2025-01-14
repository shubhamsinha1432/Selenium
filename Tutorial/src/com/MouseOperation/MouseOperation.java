package com.MouseOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperation {

	public static void main(String[] args) {
        String url="http://amazon.com/";
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
		
		//id- nav-link-accountList
        WebElement hellosignIn=driver.findElement(By.id("nav-link-accountList"));
        
        Actions action=new Actions(driver);
        action.moveToElement(hellosignIn).perform();
        
        WebElement YourOrder=driver.findElement(By.linkText("Your Orders"));
        YourOrder.click();

	}

}
