package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage extends BaseClass {

	@Then("Home page is displayed")
	public HomePage homePageIsDisplayed() {

		String actual = driver.getTitle();
		String expected = "Home | Salesforce";
		if (expected.equalsIgnoreCase(actual)) {

			System.out.println("User is Navigated to Home screen");
		}
		else 
			System.out.println("User is not Navigated to Home screen");
		return this;

	}

	@When("Click on App launcher")
	public HomePage ClickOnApplauncher() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		return this;
	}

	@When("Click on view All")
	public HomePage clickOnViewAll() {

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;

	}

	@When("Click on Service")
	public HomePage clickOnService() {

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;

	}

	@When("Click on Reports")
	public SalesForceReportPage clickOnReports() {
		
		WebElement report = driver.findElement(By.xpath("//span[@class='slds-truncate' and text() = 'Reports']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", report);
		return new SalesForceReportPage();
	}

}
