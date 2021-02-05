package testng_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S20_02_CreateOpportunity_TestNG extends GeneralMethods{
	
	
	@Test
	public void opportunity() throws InterruptedException {
		
		String str = "Salesforce Automation by Lekhashree";
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//Click View All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		
		//Click on the Opportunity tab
		WebElement Oppdropdown = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Oppdropdown);
		Thread.sleep(5000);
		
        //Click on the New button
		driver.findElement(By.xpath("//div[@title='New']")).click();

		//Enter Opportunity name as 'Salesforce Automation by Your Name, Get the text and Store it
		driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input)[1]")).sendKeys(str);

		//Choose close date as Today
		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(5000);
		
		//Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		Thread.sleep(2000);
		
		WebElement dropdownclick = driver.findElement(By.xpath("(//ul[@class='scrollable' and @role='presentation']/li/a)[4]"));
		executor.executeScript("arguments[0].scrollIntoView();", dropdownclick);
		executor.executeScript("arguments[0].click();", dropdownclick);
		Thread.sleep(3000);

		//click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);

        //Verifying the opportunity name
		String actualName = driver.findElement(By.xpath("//slot[@slot='primaryField']")).getText().trim();

		if (str.equalsIgnoreCase(actualName))
			System.out.println("As expected,Entered and actual opportunity created are same");
		else
			System.out.println("Entered and actual opportunity created are different");

	

	}

}