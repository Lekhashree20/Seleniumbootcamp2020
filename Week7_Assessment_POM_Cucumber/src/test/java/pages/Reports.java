package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Reports extends BaseClass{

	String nameident;
	
	@Then("Verify Report has been created successfully")
	public Reports verifyReportcreatedSuccessfully() {
		driver.switchTo().defaultContent();
		List<WebElement> iframe = driver
				.findElements(By.xpath("//iframe[contains(@class,'isEdit reportsReportBuilder')]"));
		for (WebElement webElement : iframe) {
			if (webElement.isDisplayed()) {
				driver.switchTo().frame(webElement);
			}
		}
		String reportType = driver.findElement(By.xpath("//h1[@class='pageType']")).getText().trim();
		System.out.println(reportType);
		assertTrue(reportType.contains("Report Type: Leads"));
		String reportDescription = driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText().trim();
		assertTrue(reportDescription.contains("Shruthi"));
		return this;
	}

	@When("Click on Run report")
	public Reports clickRunReport() throws InterruptedException {
		List<WebElement> runReport = driver.findElements(By.xpath("//button[text()='Run Report']"));
		System.out.println(runReport.size());
		for (WebElement webElement : runReport) {
			if (webElement.isDisplayed()) {
				webElement.click();
			}
		}
		Thread.sleep(3000);
		return this;
	}

	@Then("Get the total Number of records")
	public Reports totalNumberofRecords() throws InterruptedException {
		List<WebElement> records = driver
				.findElements(By.xpath("//div[text()='Total Records']//following-sibling::div"));
		System.out.println(records.size());
		for (WebElement webElement : records) {
			if (webElement.isDisplayed()) {
				webElement.click();
			}
		}
		Thread.sleep(10000);
		return this;
	}

	@Then("Click on Edit")
	public Reports click_on_Edit() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((driver.findElement(By.xpath("//iframe[@class='isView reportsReportBuilder']"))));
		List<WebElement> edit = driver.findElements(By.xpath("//button[text()='Edit']"));
		System.out.println(edit.size());
		for (WebElement webElement : edit) {
			if (webElement.isDisplayed()) {
				webElement.click();
			}
		}
		Thread.sleep(10000);
		return this;
	}

	@Then("click on close")
	public Reports click_on_Close() throws InterruptedException {
		driver.switchTo().defaultContent();
		List<WebElement> iframe = driver
				.findElements(By.xpath("//iframe[contains(@class,'isEdit reportsReportBuilder')]"));
		for (WebElement webElement : iframe) {
			if (webElement.isDisplayed()) {
				driver.switchTo().frame(webElement);
			}
		}
		
		Thread.sleep(50000);
		driver.findElement(By.xpath(("//button[text()='Close']"))).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(("//button[text()='Close']"))).click();
		Thread.sleep(10000);
		return this;
	}

	@Then("Get the text of Report name")
	public Reports getReportName() throws InterruptedException {
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@class,'search-text-field')]")).sendKeys("Shruthi");
		Thread.sleep(3000);
		List<WebElement> names = driver.findElements(By.xpath("//th[@data-label='Report Name']"));
		for (WebElement webElement : names) {
			if (webElement.getText().trim().contains("Shruthi")) {
				System.out.println("Report Present");
			} else {
				System.out.println("Report Not Present");
			}

		}
		return this;
	}

	@Then("check the report name")
	public Reports verify_the_Report_Name() {
		return this;
	}

	@Then("Date and Time when the report is created on")
	public Reports get_the_Date_and_Time_When_the_Report_is_Created_On() {
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-label='Created On']"));
		for (WebElement webElement : dates) {
			System.out.println(webElement.getText());
		}
		return this;
	}
	
}
