package FontTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fontTest {
	
	String url="http://only-testing-blog.blogspot.in/2014/05/login.html";
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
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void readFontProperty()
	{
		//*[@id="post-body-4024384759750876807"]/div[1]/h1
		WebElement text=driver.findElement(By.xpath("//*[@id='post-body-4024384759750876807']/div[1]/h1"));
		
		//Read font-size property and print It In console.
		String text_size=text.getCssValue("font-size");
		System.out.println("Font Text Size ->"+text_size);
		
		 //Read color property and print It In console.
		String text_color=text.getCssValue("color");
		System.out.println("Font Text Color ->"+text_color);
		
		 //Read font-family property and print It In console.
		  String fontFamily = text.getCssValue("font-family");
		  System.out.println("Font Family -> "+fontFamily);
		  
		  //Read text-align property and print It In console.
		  String fonttxtAlign = text.getCssValue("text-align");
		  System.out.println("Font Text Alignment -> "+fonttxtAlign);
		
	}


}
