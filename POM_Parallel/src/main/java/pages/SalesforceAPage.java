package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class SalesforceAPage extends ProjectSpecificMethods{
	
	public SalesforceAPage(WebDriver driver) {

		this.driver=driver;
	}
	
	String str = "SalesforceA";
	
	public SalesforceAPage verifyButton() {
	
	String actualName = driver.findElement(By.xpath("//span[text()='SalesforceA']")).getText();
	if (str.equalsIgnoreCase(actualName))
		System.out.println("SalesForceA is displayed");
	else
		System.out.println("SalesForceA is not displayed");
	
	boolean button = driver.findElement(By.xpath("//button[text()='Install']")).isEnabled();
	System.out.println(button);
    return this;
	
	}
}
