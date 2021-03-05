package pages;

import org.openqa.selenium.By;
import cucumber.api.java.en.When;

public class SaveReportPage extends BaseClass{

	String nameident;
	
	@When("Enter Report Name as YourName")
	public SaveReportPage enterReportName() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='reportName']")).sendKeys("Shruthi");
		return this;
	}
	
	@When("Enter Report Unique Name as YourName_anyNumber")
	public SaveReportPage enterReportNumber() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='reportDevName']")).sendKeys("Shruthi_123");;
		Thread.sleep(1000);
		return this;
		
	}
	
	@When("Enter Report Discussion as Reported updated by YourName")
	public SaveReportPage enterReportDiscussion() throws InterruptedException {
		driver.findElement(By.name("reportDescription")).sendKeys("Report updated by Shruthi");
		Thread.sleep(1000);
		return this;
	}

	@When("Select Report Folder as Unfiled Public Reports")
	public SaveReportPage selectReport_Folder() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='saveReportDlg_folderFinder']//following-sibling::img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Unfiled Public Reports']")).click();
		Thread.sleep(1000);
		return this;
	}

	@When("Click on Save")
	public Reports clickSaveFromReport() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='x-window-footer x-panel-btns']//button[text()='Save']")).click();
		Thread.sleep(10000);
		return new Reports();
	}
	
}
