package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

public class OpportunitiesPage extends ProjectSpecificMethods {
	
	public OpportunitiesPage(WebDriver driver) {

		this.driver=driver;
	}

	public OpportunitiesPage clickNewOpportunity() {

		driver.findElement(By.xpath("//div[@title='New']")).click();
		return this;
	}

	public OpportunitiesPage enterOpportunityName() {

		driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input)[1]"))
				.sendKeys(comparison);
		return this;
	}

	public OpportunitiesPage selectDate() throws InterruptedException {
		// Choose close date as Today
		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(5000);
		return this;
	}

	public OpportunitiesPage selectStage() throws InterruptedException {
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		Thread.sleep(2000);
		WebElement dropdownclick = driver
				.findElement(By.xpath("(//ul[@class='scrollable' and @role='presentation']/li/a)[4]"));
		executor.executeScript("arguments[0].scrollIntoView();", dropdownclick);
		executor.executeScript("arguments[0].click();", dropdownclick);
		Thread.sleep(3000);
		return this;
	}

	public ViewOpportunity clickSave() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		return new ViewOpportunity(driver);

	}

}
