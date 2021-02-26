package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethods;

public class ViewOpportunity extends ProjectSpecificMethods{

	public ViewOpportunity(WebDriver driver) {

		this.driver=driver;
	}
	public void verifyOpportunityName(){
	
	
	String actualName = driver.findElement(By.xpath("//slot[@slot='primaryField']")).getText().trim();

	if (comparison.equalsIgnoreCase(actualName))
		System.out.println("As expected,Entered and actual opportunity created are same");
	else
		System.out.println("Entered and actual opportunity created are different");
	
	}
}
