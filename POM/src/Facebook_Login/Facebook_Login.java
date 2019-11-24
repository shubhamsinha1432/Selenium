package Facebook_Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Facebook_Login {
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="u_0_b")
	WebElement logIn;
	
	public void login(String Username,String Password)
	{
		email.sendKeys(Username);
		email.clear();
		password.sendKeys(Password);
		password.clear();
		logIn.click();
	}
	

}
