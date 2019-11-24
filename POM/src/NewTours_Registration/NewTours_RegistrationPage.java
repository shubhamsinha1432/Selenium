package NewTours_Registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTours_RegistrationPage {
	
	@FindBy(linkText="REGISTER")
	WebElement register;
	
	public void register_button()
	{
		register.click();
	}
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="register")
	WebElement submit_button;
	
	public void register(String FirstName,String LastName,String Phone,String Email,String Address,String City,String State,String PostalCode,String Country,String UserName,String Password,String ConfirmPassword)
	{
	  firstName.sendKeys(FirstName);
	  lastName.sendKeys(LastName);
	  phone.sendKeys(Phone);
	  email.sendKeys(Email);
	  address.sendKeys(Address);
	  city.sendKeys(City);
	  state.sendKeys(State);
	  postalCode.sendKeys(PostalCode);
	  country.sendKeys(Country);
	  userName.sendKeys(UserName);
	  password.sendKeys(Password);
	  confirmPassword.sendKeys(ConfirmPassword);
	  submit_button.click();
	}
}
