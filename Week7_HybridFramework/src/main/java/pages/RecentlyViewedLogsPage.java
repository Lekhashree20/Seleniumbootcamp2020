package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class RecentlyViewedLogsPage extends ProjectSpecificMethods {

	public RecentlyViewedLogsPage clickNewbutton() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(5000);
		return this;
	}

	public RecentlyViewedLogsPage selectInteractionType() throws InterruptedException {

		driver.findElement(By.xpath(
				"(//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following::a[text()='--None--'])[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Authorization']")).click();

		return this;

	}

	public RecentlyViewedLogsPage selectStatus() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"(//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following::a[text()='--None--'])[4]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='No Operation']")).click();
		Thread.sleep(5000);
		return this;

	}
	
	public RecentlyViewedLogsPage selectDropdownList() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@title='Select List View']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='All']")).click();
		Thread.sleep(5000);
		return this;
		
	}
	
	public RecentlyViewedLogsPage clickSettingsDropdown() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@title='List View Controls']")).click();
		Thread.sleep(5000);
		return this;

	}
	
	public RecentlyViewedLogsPage clickTheValue() throws InterruptedException {
		
        driver.findElement(By.xpath("//span[text()='Select Fields to Display']")).click();
        Thread.sleep(5000);
        return this;
		
	}

	
	public RecentlyViewedLogsPage selectingFieldsToDisplay() throws InterruptedException {
		
		WebElement selectField = driver.findElement(By.xpath("//span[text()='Payment Gateway Log ID']"));
		
		JavascriptExecutor executer = (JavascriptExecutor) driver; 
		executer.executeScript("arguments[0].scrollIntoView(true);", selectField);
		executer.executeScript("arguments[0].click();", selectField);
		Thread.sleep(5000);
        return this;
		
		
	}
	
	public RecentlyViewedLogsPage movingToVisibleField() throws InterruptedException {

		driver.findElement(By.xpath("//button[@title='Move selection to Visible Fields']")).click();
		Thread.sleep(5000);
		return this;
		
	}
	
	
	public RecentlyViewedLogsPage clickSaveButton() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral test-confirmButton uiButton--default uiButton--brand uiButton']")).click();
		Thread.sleep(5000);
		return this;
	
	}
	
}
