package com.CapturingTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingTitle {

	public static void main(String[] args) {
		
		String google_url="http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get(google_url);
        
        String google_HomepageTitle=driver.getTitle();
        System.out.println("The Title of Google Homepage is :"+google_HomepageTitle);
	}

}
