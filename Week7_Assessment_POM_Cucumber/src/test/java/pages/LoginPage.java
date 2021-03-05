package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;


public class LoginPage extends BaseClass{

	@Given("Enter the Username as (.*)")
	public LoginPage enter_the_username(String username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		return this;
	}

	@Given("Enter the Password as (.*)")
	public LoginPage enter_the_password(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		return this;
	}

	@Given("Click on Login button")
	public HomePage click_on_login_button() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new HomePage();
		
	}

	
	
}
