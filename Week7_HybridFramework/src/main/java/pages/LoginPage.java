package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{


		public LoginPage enterUsername() {

			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("cypress@testleaf.com");
			return this;
			
		}
		public LoginPage enterPassword() {

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Bootcamp@123");
			return this;
			
		}
			
		public HomePage clickLoginButton() {

			driver.findElement(By.xpath("//input[@id='Login']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return new HomePage();
		}
	}

